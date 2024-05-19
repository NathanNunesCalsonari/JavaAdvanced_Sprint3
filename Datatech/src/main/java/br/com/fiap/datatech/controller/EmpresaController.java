package br.com.fiap.datatech.controller;

import br.com.fiap.datatech.dto.EmpresaDTO;
import br.com.fiap.datatech.service.EmpresaService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping("/listar")
    public List<EmpresaDTO> listarEmpresas() {
        return empresaService.listarTodasEmpresas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaDTO> obterEmpresaPorId(@PathVariable(value = "id") Long empresaId) {
        Optional<EmpresaDTO> empresa = empresaService.encontrarEmpresaPorId(empresaId);
        return empresa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<EmpresaDTO> cadastrarEmpresa(@Valid @RequestBody EmpresaDTO empresaDTO) {
        EmpresaDTO novaEmpresa = empresaService.salvarEmpresa(empresaDTO);
        return ResponseEntity.ok().body(novaEmpresa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpresaDTO> atualizarEmpresa(@PathVariable(value = "id") Long empresaId,
                                                       @Valid @RequestBody EmpresaDTO empresaDTO) {
        Optional<EmpresaDTO> empresa = empresaService.encontrarEmpresaPorId(empresaId);
        if (empresa.isPresent()) {
            empresaDTO.setId(empresaId);  // Ensure the ID is set before saving
            EmpresaDTO empresaAtualizada = empresaService.salvarEmpresa(empresaDTO);
            return ResponseEntity.ok(empresaAtualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEmpresa(@PathVariable(value = "id") Long empresaId) {
        empresaService.deletarEmpresa(empresaId);
        return ResponseEntity.ok().build();
    }
}
