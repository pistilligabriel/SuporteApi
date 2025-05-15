package br.com.api_suporte.service;

import java.util.List;

import br.com.api_suporte.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
        String pass = new BCryptPasswordEncoder().encode(usuario.getPassword());
        usuario.setPassword(pass);
        return usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true)
    public Usuario buscarPorId(Long codigo){
        return usuarioRepository.findById(codigo).orElseThrow(
            () -> new RuntimeException("Usuario não encontrado!")
        );
    }

    @Transactional(readOnly = true)
    public List<Usuario> buscarUsuarios(){
        return usuarioRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Usuario buscarPorLogin(String login){
        return usuarioRepository.findByLogin(login).orElseThrow(
                ()-> new RuntimeException("Usuário não encontrado.")
                );
    }
    
}
