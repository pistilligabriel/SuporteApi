package br.com.api_suporte.dto.modelMapper;

import br.com.api_suporte.dto.Chamado.*;
import br.com.api_suporte.model.Chamado;
import br.com.api_suporte.model.Nota;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ChamadoMapper {

    private final ModelMapper modelMapper;

    public ChamadoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        // Configuração do mapeamento para o IniciarChamadoDto -> Chamado
        modelMapper.addMappings(new PropertyMap<IniciarEditarChamadoDto, Chamado>() {
            @Override
            protected void configure() {
                // Mapeamento de campos do IniciarChamadoDto para a entidade Chamado
                map(source.getStatus(), destination.getStatus());
            }
        });
    }

    public  Chamado toChamado(CreateChamadoDto dto){
        return modelMapper.map(dto, Chamado.class);
    }

    public ResponseChamadoDto toDto(Chamado chamado){
        return modelMapper.map(chamado, ResponseChamadoDto.class);
    }

    public List<ResponseChamadoDto> toListDto(List<Chamado> chamados){
        return chamados.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Chamado toChamado(IniciarEditarChamadoDto dto) {
        return modelMapper.map(dto, Chamado.class);
    }

    public Nota toNota(NotaChamadoDto dto) {
        return modelMapper.map(dto, Nota.class);
    }

    public NotaResponseDto toDto(Nota nota) {
        return modelMapper.map(nota, NotaResponseDto.class);
    }

}
