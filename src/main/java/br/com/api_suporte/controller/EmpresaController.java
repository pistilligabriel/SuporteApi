package br.com.api_suporte.controller;

import br.com.api_suporte.model.Empresa;
import br.com.api_suporte.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/empresa")
public class EmpresaController {
    @Autowired
    private EmpresaService empresaService;


    @GetMapping("/{id}")
    public ResponseEntity<Empresa> obterConfiguracao(@PathVariable Long id) {
        Empresa configuracao = empresaService.obterConfiguracao();
        if (configuracao != null) {
            return ResponseEntity.ok(configuracao);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/logo")
    public ResponseEntity<byte[]> getLogo(@PathVariable Long id) {
        byte[] image = empresaService.getLogoById(id); // retorna o array de bytes da imagem
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG); // ou IMAGE_JPEG conforme o tipo
        return new ResponseEntity<>(image, headers, HttpStatus.OK);
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Empresa> editarConfiguracao(   @RequestParam("file") MultipartFile file,
                                                         @RequestParam("nomeEmpresa") String nomeEmpresa) {
        Empresa empresa = empresaService.editarConfiguracao(nomeEmpresa, file);
        return ResponseEntity.ok(empresa);
    }
}
