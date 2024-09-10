package br.com.fiap.datatech.controller;

import br.com.fiap.datatech.dto.EmpresaDTO;
import br.com.fiap.datatech.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping("/listar")
    public String listarEmpresas(Model model) {
        List<EmpresaDTO> empresas = empresaService.listarTodasEmpresas();
        model.addAttribute("empresas", empresas);
        return "empresas/listar";
    }

    @GetMapping("/{id}")
    public String obterEmpresaPorId(@PathVariable(value = "id") Long empresaId, Model model) {
        Optional<EmpresaDTO> empresa = empresaService.encontrarEmpresaPorId(empresaId);
        if (empresa.isPresent()) {
            model.addAttribute("empresa", empresa.get());
            return "empresas/detalhes";
        } else {
            return "error/404"; // Redireciona para uma página de erro 404 se a empresa não for encontrada
        }
    }

    @GetMapping("/cadastrar")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("empresaDTO", new EmpresaDTO());
        return "empresas/cadastrar";
    }

    @PostMapping("/cadastrar")
    public String cadastrarEmpresa(@ModelAttribute EmpresaDTO empresaDTO) {
        empresaService.salvarEmpresa(empresaDTO);
        return "redirect:/empresas/listar";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicao(@PathVariable(value = "id") Long empresaId, Model model) {
        Optional<EmpresaDTO> empresa = empresaService.encontrarEmpresaPorId(empresaId);
        if (empresa.isPresent()) {
            model.addAttribute("empresaDTO", empresa.get());
            return "empresas/editar";
        } else {
            return "error/404"; // Redireciona para uma página de erro 404 se a empresa não for encontrada
        }
    }

    @PostMapping("/editar/{id}")
    public String atualizarEmpresa(@PathVariable(value = "id") Long empresaId, @ModelAttribute EmpresaDTO empresaDTO) {
        empresaDTO.setId(empresaId);
        empresaService.salvarEmpresa(empresaDTO);
        return "redirect:/empresas/listar";
    }

    @PostMapping("/deletar/{id}")
    public String deletarEmpresa(@PathVariable(value = "id") Long empresaId) {
        empresaService.deletarEmpresa(empresaId);
        return "redirect:/empresas/listar";
    }
}
