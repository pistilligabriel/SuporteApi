package br.com.api_suporte.dto.Usuario;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginResponseDto {
    private String token;
}