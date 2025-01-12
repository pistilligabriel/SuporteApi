package br.com.api_suporte.controller;

<<<<<<< HEAD
import br.com.api_suporte.dto.Usuario.CreateUsuarioDto;
import br.com.api_suporte.dto.Usuario.ResponseUsuarioDto;
import br.com.api_suporte.dto.modelMapper.UsuarioMapper;
import br.com.api_suporte.model.Usuario;
import br.com.api_suporte.service.UsuarioService;
=======
>>>>>>> 53e9479460c4d2d76f073f2aa6360be2166fcfc9
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
=======
import br.com.api_suporte.dto.Usuario.CreateUsuarioDto;
import br.com.api_suporte.dto.Usuario.ResponseUsuarioDto;
import br.com.api_suporte.dto.modelMapper.UsuarioMapper;
import br.com.api_suporte.model.Usuario;
import br.com.api_suporte.service.UsuarioService;

>>>>>>> 53e9479460c4d2d76f073f2aa6360be2166fcfc9
@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<ResponseUsuarioDto> criarUsuario(CreateUsuarioDto usuarioDto){
        Usuario usuario = usuarioService.criarUsuario(UsuarioMapper.toUsuario(usuarioDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toDto(usuario));
    }
}
