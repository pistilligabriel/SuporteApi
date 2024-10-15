package br.com.api_suporte.dto.modelMapper;

import br.com.api_suporte.dto.Integrante.CreateIntegranteDto;
import br.com.api_suporte.dto.Integrante.ResponseIntegranteDto;
import br.com.api_suporte.model.Integrante;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class IntegranteMapper {
    public static Integrante toIntegrante(CreateIntegranteDto integranteDto){
        return new ModelMapper().map(integranteDto,Integrante.class);
    }

    public static ResponseIntegranteDto toDto(Integrante integrante){
        return new ModelMapper().map(integrante,ResponseIntegranteDto.class);
    }

    public static List<ResponseIntegranteDto> toListDto(List<Integrante> integrantes){
        return integrantes.stream().map(integrante -> toDto(integrante)).collect(Collectors.toList());
    }
}
