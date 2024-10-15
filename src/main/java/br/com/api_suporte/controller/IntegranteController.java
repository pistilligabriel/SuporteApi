package br.com.api_suporte.controller;

import br.com.api_suporte.dto.Integrante.CreateIntegranteDto;
import br.com.api_suporte.dto.Integrante.ResponseIntegranteDto;
import br.com.api_suporte.dto.modelMapper.IntegranteMapper;
import br.com.api_suporte.model.Integrante;
import br.com.api_suporte.service.IntegranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/integrantes")
public class IntegranteController {

    @Autowired
    private IntegranteService integranteService;

    @PostMapping
    public ResponseEntity<ResponseIntegranteDto> criarIntegrante(@RequestBody CreateIntegranteDto integranteDto){
        Integrante integrante = integranteService.criarIntegrante(IntegranteMapper.toIntegrante(integranteDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(IntegranteMapper.toDto(integrante));
    }

    @GetMapping
    public ResponseEntity<List<ResponseIntegranteDto>> buscarIntegrantes(){
        List<Integrante> integrantes = integranteService.buscarIntegrantes();
        return ResponseEntity.status(HttpStatus.CREATED).body(IntegranteMapper.toListDto(integrantes));
    }

    @PatchMapping("/{codigo}")
    public ResponseEntity<ResponseIntegranteDto> alterarTipo(@PathVariable Long codigo){
        Integrante integrante = integranteService.alterarTipo(codigo);
        return ResponseEntity.status(HttpStatus.OK).body(IntegranteMapper.toDto(integrante));
    }
}
