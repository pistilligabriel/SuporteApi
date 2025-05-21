package br.com.api_suporte.service;

import br.com.api_suporte.model.Empresa;
import br.com.api_suporte.repository.EmpresaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;


    public Empresa obterConfiguracao() {
        // Para simplicidade, vamos retornar a primeira configuração
        // No futuro, pode-se adicionar lógica para obter uma única configuração
        return empresaRepository.findById(1L).orElse(null);
    }

    public byte[] getLogoById(Long id) {
        Empresa empresa = empresaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Empresa não encontrada"));
        return empresa.getLogo(); // Supondo que o campo logo seja byte[]
    }

    public Empresa editarConfiguracao(String nomeEmpresa, MultipartFile file) {
        Empresa empresa = obterConfiguracao();

        if (nomeEmpresa != null && !nomeEmpresa.isEmpty()) {
            empresa.setNomeEmpresa(nomeEmpresa);
        }

        if (file != null && !file.isEmpty()) {
            try {
                byte[] fileBytes = file.getBytes();
                empresa.setLogo(fileBytes);
            } catch (IOException e) {
                throw new RuntimeException("Erro ao processar o arquivo", e);
            }
        }

        return empresaRepository.save(empresa);
    }
}
