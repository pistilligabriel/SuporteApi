package br.com.api_suporte.controller;

import br.com.api_suporte.dto.Usuario.LoginDto;
import br.com.api_suporte.dto.Usuario.LoginResponseDto;
import br.com.api_suporte.infra.security.TokenService;
import br.com.api_suporte.model.Usuario;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<LoginResponseDto> login(@RequestBody @Valid LoginDto authenticationDto) {
        logger.info("Iniciando autenticação para o login: {}", authenticationDto.login());
        var usernamePassword = new UsernamePasswordAuthenticationToken(authenticationDto.login(), authenticationDto.password());
        var authentication = authenticationManager.authenticate(usernamePassword);

        logger.info("Autenticação bem-sucedida para o login: {}", authenticationDto.login());
        var usuario = (Usuario) authentication.getPrincipal();

        logger.debug("Usuário autenticado: {}", usuario.getLogin());
        var token = tokenService.generateToken(usuario);
        
        logger.info("Token gerado com sucesso para o login: {}", authenticationDto.login());
        return ResponseEntity.ok(new LoginResponseDto(token, usuario));
    }
}
