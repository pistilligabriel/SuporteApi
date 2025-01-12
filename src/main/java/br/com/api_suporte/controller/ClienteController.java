package br.com.api_suporte.controller;

import br.com.api_suporte.dto.Cliente.CreateClienteDto;
import br.com.api_suporte.dto.Cliente.ResponseClienteDto;
import br.com.api_suporte.dto.modelMapper.ClienteMapper;
import br.com.api_suporte.model.Cliente;
import br.com.api_suporte.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ResponseClienteDto> criarCliente(@RequestBody CreateClienteDto clienteDto) {
        Cliente cliente = clienteService.criarCliente(ClienteMapper.toCliente(clienteDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(ClienteMapper.toDto(cliente));
    }

    @GetMapping
    public ResponseEntity<List<ResponseClienteDto>> buscarClientes() {
        List<Cliente> clientes = clienteService.buscarClientes();
        return ResponseEntity.status(HttpStatus.OK).body(ClienteMapper.toListDto(clientes));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseClienteDto> buscarPorId(@PathVariable Long id) {
        Cliente cliente = clienteService.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(ClienteMapper.toDto(cliente));
    }
}
