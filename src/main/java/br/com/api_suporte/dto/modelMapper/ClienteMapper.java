package br.com.api_suporte.dto.modelMapper;

import br.com.api_suporte.dto.Cliente.CreateClienteDto;
import br.com.api_suporte.dto.Cliente.ResponseClienteDto;
import br.com.api_suporte.model.Cliente;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteMapper {
    public static Cliente toIntegrante(CreateClienteDto integranteDto){
        return new ModelMapper().map(integranteDto,Cliente.class);
    }

    public static ResponseClienteDto toDto(Cliente integrante){
        return new ModelMapper().map(integrante,ResponseClienteDto.class);
    }

    public static List<ResponseClienteDto> toListDto(List<Cliente> integrantes){
        return integrantes.stream().map(integrante -> toDto(integrante)).collect(Collectors.toList());
    }
}
