package br.com.api_suporte.service;

import br.com.api_suporte.model.Chamado;
import br.com.api_suporte.model.enums.Status;
import br.com.api_suporte.repository.ChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository chamadoRepository;

    @Transactional
    public Chamado salvar(Chamado chamado){
        return chamadoRepository.save(chamado);
    }

    @Transactional(readOnly = true)
    public List<Chamado> buscarTodos(){
        return chamadoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Chamado buscarPorId(Long id){
        return chamadoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Chamado não encontrado!")
        );
    }

    @Transactional
    public Chamado editarStatusChamado(Long id, Status status, LocalDateTime dataVersao){
        Chamado chamado = buscarPorId(id);
        chamado.setStatus(status);
        chamado.setDataVersao(dataVersao);
        return chamado;
    }

    @Transactional
    public Chamado editarChamado(Long id){
        Chamado chamado = buscarPorId(id);
        return chamado;
    }

}
