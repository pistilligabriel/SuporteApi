package br.com.api_suporte.controller;

import br.com.api_suporte.dto.Chamado.CreateChamadoDto;
import br.com.api_suporte.dto.Chamado.ResponseChamadoDto;
import br.com.api_suporte.dto.modelMapper.ChamadoMapper;
import br.com.api_suporte.model.Chamado;
import br.com.api_suporte.service.ChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/chamados")
public class ChamadoController {

    @Autowired
    private ChamadoService chamadoService;

    @PostMapping
    public ResponseEntity<ResponseChamadoDto> criarChamado(@RequestBody CreateChamadoDto chamadoDto){
        Chamado cham = chamadoService.salvar(ChamadoMapper.toChamado(chamadoDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(ChamadoMapper.toDto(cham));
    }

    @GetMapping
    public ResponseEntity<List<ResponseChamadoDto>> getAllChamado(){
        List<Chamado> cham = chamadoService.buscarTodos();

        return ResponseEntity.status(HttpStatus.OK).body(ChamadoMapper.toListDto(cham));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseChamadoDto> getChamadoById(@PathVariable Long id){
        Chamado cham = chamadoService.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(ChamadoMapper.toDto(cham));
    }

    @PatchMapping("status/{id}")
    public ResponseEntity<ResponseChamadoDto> editarStatusChamado(@PathVariable Long id, @RequestBody Chamado chamado){
        Chamado cham = chamadoService.editarStatusChamado(id,chamado.getStatus());
        return ResponseEntity.status(HttpStatus.OK).body(ChamadoMapper.toDto(cham));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Chamado> editarChamado(@PathVariable Long id, @RequestBody Chamado chamado){
        Chamado cham = chamadoService.editarChamado(id);
        return ResponseEntity.status(HttpStatus.OK).body(cham);
    }

    @PatchMapping("/cancelar/{id}")
    public ResponseEntity<Chamado> cancelarChamado(@PathVariable Long id){
        Chamado chamado = chamadoService.cancelarChamado(id);
        return ResponseEntity.status(HttpStatus.OK).body(chamado);
    }
}
