package br.com.api_suporte.service;

<<<<<<< HEAD
import br.com.api_suporte.model.Usuario;
import br.com.api_suporte.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api_suporte.model.Usuario;
import br.com.api_suporte.repository.UsuarioRepository;
>>>>>>> 53e9479460c4d2d76f073f2aa6360be2166fcfc9

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
}
