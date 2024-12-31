package br.com.api_suporte.service;

import br.com.api_suporte.model.Cliente;
import br.com.api_suporte.model.enums.Tipo;
import br.com.api_suporte.repository.IntegranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntegranteService {

    @Autowired
    private IntegranteRepository integranteRepository;

    public Cliente criarIntegrante(Cliente integrante){
        return integranteRepository.save(integrante);
    }

    public List<Cliente> buscarIntegrantes(){
        return integranteRepository.findAll();
    }

    public Cliente buscarPorId(Long id){
        return integranteRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Integrante não encontrado!")
        );
    }

    public Cliente alterarTipo(Long id){
        Cliente integrante = buscarPorId(id);

        if(integrante.getTipo().equals(Tipo.CLIENTE)) {
            integrante.setTipo(Tipo.FUNCIONARIO);
        }else {
            integrante.setTipo(Tipo.CLIENTE);
        }
        return integrante;
    }
}
