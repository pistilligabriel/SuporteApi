package br.com.api_suporte.service;

import br.com.api_suporte.model.Integrante;
import br.com.api_suporte.model.enums.Tipo;
import br.com.api_suporte.repository.IntegranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntegranteService {

    @Autowired
    private IntegranteRepository integranteRepository;

    public Integrante criarIntegrante(Integrante integrante){
        return integranteRepository.save(integrante);
    }

    public List<Integrante> buscarIntegrantes(){
        return integranteRepository.findAll();
    }

    public Integrante buscarPorId(Long id){
        return integranteRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Integrante não encontrado!")
        );
    }

    public Integrante alterarTipo(Long id){
        Integrante integrante = buscarPorId(id);

        if(integrante.getTipo().equals(Tipo.CLIENTE)) {
            integrante.setTipo(Tipo.FUNCIONARIO);
        }else {
            integrante.setTipo(Tipo.CLIENTE);
        }
        return integrante;
    }
}
