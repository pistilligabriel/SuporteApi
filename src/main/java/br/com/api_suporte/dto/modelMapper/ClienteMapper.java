package br.com.api_suporte.dto.modelMapper;

import br.com.api_suporte.dto.Cliente.CreateClienteDto;
import br.com.api_suporte.dto.Cliente.ResponseClienteDto;
import br.com.api_suporte.model.Cliente;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteMapper {
    public static Cliente toCliente(CreateClienteDto clienteDto){
        return new ModelMapper().map(clienteDto,Cliente.class);
    }

    public static ResponseClienteDto toDto(Cliente cliente){
        return new ModelMapper().map(cliente,ResponseClienteDto.class);
    }

    public static List<ResponseClienteDto> toListDto(List<Cliente> clientes){
        return clientes.stream().map(cliente -> toDto(cliente)).collect(Collectors.toList());
    }
}
