package br.com.api_suporte.service;

<<<<<<< HEAD
import br.com.api_suporte.model.Integrante;
=======
import br.com.api_suporte.model.Cliente;
>>>>>>> 53e9479460c4d2d76f073f2aa6360be2166fcfc9
import br.com.api_suporte.model.enums.Tipo;
import br.com.api_suporte.repository.IntegranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntegranteService {

    @Autowired
    private IntegranteRepository integranteRepository;

<<<<<<< HEAD
    public Integrante criarIntegrante(Integrante integrante){
        return integranteRepository.save(integrante);
    }

    public List<Integrante> buscarIntegrantes(){
        return integranteRepository.findAll();
    }

    public Integrante buscarPorId(Long id){
=======
    public Cliente criarIntegrante(Cliente integrante){
        return integranteRepository.save(integrante);
    }

    public List<Cliente> buscarIntegrantes(){
        return integranteRepository.findAll();
    }

    public Cliente buscarPorId(Long id){
>>>>>>> 53e9479460c4d2d76f073f2aa6360be2166fcfc9
        return integranteRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Integrante não encontrado!")
        );
    }

<<<<<<< HEAD
    public Integrante alterarTipo(Long id){
        Integrante integrante = buscarPorId(id);
=======
    public Cliente alterarTipo(Long id){
        Cliente integrante = buscarPorId(id);
>>>>>>> 53e9479460c4d2d76f073f2aa6360be2166fcfc9

        if(integrante.getTipo().equals(Tipo.CLIENTE)) {
            integrante.setTipo(Tipo.FUNCIONARIO);
        }else {
            integrante.setTipo(Tipo.CLIENTE);
        }
        return integrante;
    }
}
