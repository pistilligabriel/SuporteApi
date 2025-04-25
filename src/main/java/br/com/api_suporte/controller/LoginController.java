package br.com.api_suporte.controller;

import br.com.api_suporte.dto.Usuario.LoginDto;
import br.com.api_suporte.dto.Usuario.LoginResponseDto;
import br.com.api_suporte.infra.security.TokenService;
import br.com.api_suporte.model.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<LoginResponseDto> login(@RequestBody @Valid LoginDto authenticationDto)  {
        var usernamePassword = new UsernamePasswordAuthenticationToken(authenticationDto.getLogin(), authenticationDto.getPassword());
        var authentication = authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((Usuario) authentication.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDto(token));
    }
}
