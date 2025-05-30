package br.com.api_suporte.service;

import br.com.api_suporte.dto.Chamado.ChamadoStatusMesDto;
import br.com.api_suporte.model.Chamado;
import br.com.api_suporte.model.Nota;
import br.com.api_suporte.model.Usuario;
import br.com.api_suporte.model.enums.Prioridade;
import br.com.api_suporte.model.enums.Status;
import br.com.api_suporte.repository.ChamadoRepository;
import br.com.api_suporte.repository.NotaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChamadoService {

    Logger logger = LoggerFactory.getLogger(ChamadoService.class);

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ChamadoRepository chamadoRepository;

    @Autowired
    private NotaRepository notaRepository;

    @Transactional
    public Chamado salvar(Chamado chamado) {
        if (chamado.getPrioridade() == null) {
            chamado.setPrioridade(Prioridade.NORMAL);
        }

        logger.info("Chamado: {}", chamado.getDataCriacao());
        return chamadoRepository.save(chamado);
    }

    @Transactional(readOnly = true)
    public List<Chamado> buscarTodos() {
        return chamadoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public void verIp() throws UnknownHostException {
        String ip = InetAddress.getLocalHost().getHostAddress();
        System.out.println(ip);
    }

    @Transactional(readOnly = true)
    public Chamado buscarPorId(Long id) {
        try{
            verIp();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return chamadoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Chamado não encontrado!"));
    }

    @Transactional
    public Chamado editarStatusChamado(Long id, Status status) {
        Chamado chamado = buscarPorId(id);
        if (chamado.getStatus().equals(Status.CANCELADO)) {
            throw new RuntimeException("Chamado cancelado não permite alteração de status!");
        }
        chamado.setStatus(status);
        chamado.setResponsavel(null);
        chamado.setDataVersao(LocalDateTime.now());
        return chamado;
    }

    @Transactional
    public Chamado editarChamado(Long id) {
        Chamado chamado = buscarPorId(id);
        // TODO verificar o que será alterado antes de salvar
        if (chamado.getStatus() == Status.CANCELADO) {
            throw new RuntimeException("Não é possível editar chamado com status CANCELADO");
        }
        return chamado;
    }

    @Transactional
    public Chamado iniciarChamado(Long id, Chamado cham){
        Chamado chamado = buscarPorId(id);
        if(chamado.getStatus().equals(Status.CANCELADO)){
            throw new RuntimeException("Chamado cancelado não é possível iniciar");
        }
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String login = userDetails.getUsername(); // Obtém o login do usuário logado

        // Buscar o usuário logado no banco de dados (você pode precisar de um serviço de usuário para isso)
        Usuario usuarioLogado = usuarioService.buscarPorLogin(login);  // Supondo que você tenha um serviço de usuário
        // para buscar pelo login
        if (usuarioLogado == null) {
            throw new RuntimeException("Usuário logado não encontrado");
        }
        chamado.setResponsavel(usuarioLogado);
        chamado.setStatus(cham.getStatus());
        chamado.setDataVersao(LocalDateTime.now());
        return chamadoRepository.save(chamado);
    }

    @Transactional
    public Chamado finalizarChamado(Long id, Chamado cham){
        Chamado chamado = buscarPorId(id);
        if(chamado.getStatus().equals(Status.CANCELADO)){
            throw new RuntimeException("Chamado cancelado não é possível iniciar");
        }
        chamado.setStatus(cham.getStatus());
        chamado.setDataVersao(LocalDateTime.now());
        chamado.setDataConclusao(LocalDateTime.now());
        return chamadoRepository.save(chamado);
    }

    @Transactional
    public Chamado cancelarChamado(Long id) {
        Chamado chamado = buscarPorId(id);
        if (chamado.getStatus().equals(Status.CANCELADO)) {
            throw new RuntimeException("Chamado já está cancelado.");

        }
        System.out.println("Chamado cancelado");
        chamado.setStatus(Status.CANCELADO);
        chamado.setDataConclusao(LocalDateTime.now());
        return chamado;
    }

    public Nota adicionarNota(Long codigo, Nota nota) {
        // Busca o chamado pelo código
        Chamado chamado = chamadoRepository.getReferenceById(codigo);

        Nota note = new Nota();
        note.setAutor(nota.getAutor());
        note.setChamado(chamado);
        note.setConteudo(nota.getConteudo());
        note.setDataCriacao(LocalDateTime.now());
        // Salva o chamado atualizado no banco de dados
        return notaRepository.save(note);
    }

    public List<ChamadoStatusMesDto> contarChamadosPorStatusEMes() {
        List<Object[]> resultados = chamadoRepository.contarChamadosPorStatusEMesRaw();

        return resultados.stream().map(obj -> {
            String status = String.valueOf(obj[0]);
            String mesStr = String.valueOf(obj[1]); // Ex: "2025-05"
            Long total = ((Number) obj[2]).longValue();

            YearMonth mes = YearMonth.parse(mesStr); // Convertendo para YearMonth

            return new ChamadoStatusMesDto(status, mes, total);
        }).collect(Collectors.toList());
    }

    public List<ChamadoStatusMesDto> getContagemPorStatusEMes() {
        return contarChamadosPorStatusEMes();
    }
}
