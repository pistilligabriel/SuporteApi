package br.com.api_suporte.controller;

import br.com.api_suporte.dto.Cliente.CreateClienteDto;
import br.com.api_suporte.dto.Cliente.ResponseClienteDto;
import br.com.api_suporte.dto.modelMapper.ClienteMapper;
import br.com.api_suporte.model.Cliente;
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
    public ResponseEntity<ResponseClienteDto> criarIntegrante(@RequestBody CreateClienteDto integranteDto) {
        Cliente integrante = integranteService.criarIntegrante(ClienteMapper.toIntegrante(integranteDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(ClienteMapper.toDto(integrante));
    }

    @GetMapping
    public ResponseEntity<List<ResponseClienteDto>> buscarIntegrantes() {
        List<Cliente> integrantes = integranteService.buscarIntegrantes();
        return ResponseEntity.status(HttpStatus.CREATED).body(ClienteMapper.toListDto(integrantes));
    }

    @PatchMapping("/{codigo}")
    public ResponseEntity<ResponseClienteDto> alterarTipo(@PathVariable Long codigo) {
        Cliente integrante = integranteService.alterarTipo(codigo);
        return ResponseEntity.status(HttpStatus.OK).body(ClienteMapper.toDto(integrante));
    }
}
