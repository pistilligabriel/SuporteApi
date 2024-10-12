package br.com.api_suporte.dto.modelMapper;

import br.com.api_suporte.dto.CreateChamadoDto;
import br.com.api_suporte.dto.ResponseChamadoDto;
import br.com.api_suporte.model.Chamado;
import org.apache.coyote.Response;
import org.modelmapper.ModelMapper;

public class ChamadoMapper {
    public static Chamado toChamado(CreateChamadoDto dto){
        return new ModelMapper().map(dto, Chamado.class);
    }

    public static ResponseChamadoDto toDto(Chamado chamado){
        return new ModelMapper().map(chamado,ResponseChamadoDto.class);
    }
}
