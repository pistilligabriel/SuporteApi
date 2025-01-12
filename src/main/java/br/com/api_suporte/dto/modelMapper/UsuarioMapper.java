package br.com.api_suporte.dto.modelMapper;

<<<<<<< HEAD
=======
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
>>>>>>> 53e9479460c4d2d76f073f2aa6360be2166fcfc9

import br.com.api_suporte.dto.Usuario.CreateUsuarioDto;
import br.com.api_suporte.dto.Usuario.ResponseUsuarioDto;
import br.com.api_suporte.model.Usuario;
<<<<<<< HEAD
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;
=======
>>>>>>> 53e9479460c4d2d76f073f2aa6360be2166fcfc9

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
