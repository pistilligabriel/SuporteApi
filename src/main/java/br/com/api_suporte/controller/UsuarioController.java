package br.com.api_suporte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api_suporte.dto.Usuario.CreateUsuarioDto;
import br.com.api_suporte.dto.Usuario.ResponseUsuarioDto;
import br.com.api_suporte.dto.modelMapper.UsuarioMapper;
import br.com.api_suporte.model.Usuario;
import br.com.api_suporte.service.UsuarioService;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<ResponseUsuarioDto> criarUsuario(@RequestBody CreateUsuarioDto usuarioDto) {
        Usuario usuario = usuarioService.criarUsuario(UsuarioMapper.toUsuario(usuarioDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toDto(usuario));
    }

    @GetMapping
    public ResponseEntity<List<ResponseUsuarioDto>> buscarUsuarios() {
        List<Usuario> usuarios = usuarioService.buscarUsuarios();
        return ResponseEntity.status(HttpStatus.OK).body(UsuarioMapper.toListDto(usuarios));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseUsuarioDto> buscarPorId(@PathVariable Long id) {
        Usuario usuario = usuarioService.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(UsuarioMapper.toDto(usuario));
    }

    @GetMapping("/perfil")
    public ResponseEntity<Usuario> getUsuarioPerfil() {
        // Recuperando a autenticação
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Verificando se a autenticação está presente e se o principal é do tipo UserDetails
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            // Realizando o cast seguro para UserDetails
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            // Acessando o nome de usuário (login)
            String login = userDetails.getUsername();

            // Agora, você pode usar o login para buscar o usuário no banco de dados
            Usuario usuario = usuarioService.buscarPorLogin(login);

            if (usuario != null) {
                return ResponseEntity.ok(usuario);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } else {
            // Caso a autenticação não seja válida ou o principal não seja um UserDetails
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
