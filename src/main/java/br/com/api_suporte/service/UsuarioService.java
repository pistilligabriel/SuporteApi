package br.com.api_suporte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.api_suporte.model.Usuario;
import br.com.api_suporte.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario criarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true)
    public Usuario buscarPorId(Long codigo){
        return usuarioRepository.findById(codigo).orElseThrow(
            () -> new RuntimeException("Usuario nao encontrado!")
        );
    }

    @Transactional(readOnly = true)
    public List<Usuario> buscarUsuarios(){
        return usuarioRepository.findAll();
    }

    
}
