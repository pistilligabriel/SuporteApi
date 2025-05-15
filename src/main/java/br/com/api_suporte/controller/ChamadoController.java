package br.com.api_suporte.controller;

import br.com.api_suporte.dto.Chamado.*;
import br.com.api_suporte.dto.modelMapper.ChamadoMapper;
import br.com.api_suporte.model.Chamado;
import br.com.api_suporte.model.Nota;
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

    @Autowired
    private ChamadoMapper chamadoMapper;

    @PostMapping
    public ResponseEntity<ResponseChamadoDto> criarChamado(@RequestBody CreateChamadoDto chamadoDto){
        Chamado cham = chamadoService.salvar(chamadoMapper.toChamado(chamadoDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(chamadoMapper.toDto(cham));
    }

    @GetMapping
    public ResponseEntity<List<ResponseChamadoDto>> getAllChamado(){
        List<Chamado> cham = chamadoService.buscarTodos();

        return ResponseEntity.status(HttpStatus.OK).body(chamadoMapper.toListDto(cham));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseChamadoDto> getChamadoById(@PathVariable Long id){
        Chamado cham = chamadoService.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(chamadoMapper.toDto(cham));
    }

    @PatchMapping("status/{id}")
    public ResponseEntity<ResponseChamadoDto> editarStatusChamado(@PathVariable Long id, @RequestBody IniciarEditarChamadoDto chamado){
        Chamado cham = chamadoService.editarStatusChamado(id,chamado.getStatus());
        return ResponseEntity.status(HttpStatus.OK).body(chamadoMapper.toDto(cham));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Chamado> editarChamado(@PathVariable Long id, @RequestBody Chamado chamado){
        Chamado cham = chamadoService.editarChamado(id);
        return ResponseEntity.status(HttpStatus.OK).body(cham);
    }

    @PutMapping("/iniciar/{id}")
    public ResponseEntity<ResponseChamadoDto> iniciarChamado(@PathVariable Long id, @RequestBody IniciarEditarChamadoDto dto){
        Chamado cham = chamadoService.iniciarChamado(id, chamadoMapper.toChamado(dto));
        return ResponseEntity.status(HttpStatus.OK).body(chamadoMapper.toDto(cham));
    }

    @PutMapping("/finalizar/{id}")
    public ResponseEntity<ResponseChamadoDto> finalizarChamado(@PathVariable Long id,
                                                              @RequestBody IniciarEditarChamadoDto dto){
        Chamado cham = chamadoService.finalizarChamado(id, chamadoMapper.toChamado(dto));
        return ResponseEntity.status(HttpStatus.OK).body(chamadoMapper.toDto(cham));
    }


    @PatchMapping("/cancelar/{id}")
    public ResponseEntity<Chamado> cancelarChamado(@PathVariable Long id){
        Chamado chamado = chamadoService.cancelarChamado(id);
        return ResponseEntity.status(HttpStatus.OK).body(chamado);
    }

    @PatchMapping("{codigo}/adicionar-nota")
    public ResponseEntity<NotaResponseDto> adicionarNota(@PathVariable Long codigo,
                                                         @RequestBody NotaChamadoDto notaDto) {
        Nota nota = chamadoService.adicionarNota(codigo, chamadoMapper.toNota(notaDto));
        return ResponseEntity.ok(chamadoMapper.toDto(nota));
    }
}
