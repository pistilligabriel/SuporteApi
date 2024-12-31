package br.com.api_suporte.dto.modelMapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import br.com.api_suporte.dto.Usuario.CreateUsuarioDto;
import br.com.api_suporte.dto.Usuario.ResponseUsuarioDto;
import br.com.api_suporte.model.Usuario;

public class UsuarioMapper {
    public static Usuario toUsuario(CreateUsuarioDto usuarioDto){
        return new ModelMapper().map(usuarioDto,Usuario.class);
    }

    public static ResponseUsuarioDto toDto(Usuario usuario){
        return new ModelMapper().map(usuario,ResponseUsuarioDto.class);
    }

    public static List<ResponseUsuarioDto> toListDto(List<Usuario> usuarios){
        return usuarios.stream().map(usuario -> toDto(usuario)).collect(Collectors.toList());
    }
}
