package br.com.api_suporte.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.api_suporte.model.Chamado;
import br.com.api_suporte.model.enums.Prioridade;
import br.com.api_suporte.model.enums.Status;
import br.com.api_suporte.repository.ChamadoRepository;
import br.com.api_suporte.utils.DateFormatter;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository chamadoRepository;

    @Transactional
    public Chamado salvar(Chamado chamado) {
        if (chamado.getPrioridade() == null) {
            chamado.setPrioridade(Prioridade.NORMAL);
        }

        return chamadoRepository.save(chamado);
    }

    @Transactional(readOnly = true)
    public List<Chamado> buscarTodos() {
        return chamadoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Chamado buscarPorId(Long id) {
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
        chamado.setDataVersao(DateFormatter.formatLocalDateTime(LocalDateTime.now()));
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
    public Chamado cancelarChamado(Long id) {
        Chamado chamado = buscarPorId(id);
        if (chamado.getStatus().equals(Status.CANCELADO)) {
            throw new RuntimeException("Chamado já está cancelado.");

        }
        System.out.println("Chamado cancelado");
        chamado.setStatus(Status.CANCELADO);
        chamado.setDataConclusao(DateFormatter.formatLocalDateTime(LocalDateTime.now()));
        return chamado;
    }

}
