package br.com.fiap.datatech.controller;

import br.com.fiap.datatech.dto.ProdutoDTO;
import br.com.fiap.datatech.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/listar")
    public String listarProdutos(Model model) {
        List<ProdutoDTO> produtos = produtoService.listarTodosProdutos();
        model.addAttribute("produtos", produtos);
        return "produtos/listar";
    }

    @GetMapping("/{id}")
    public String obterProdutoPorId(@PathVariable("id") Long produtoId, Model model) {
        Optional<ProdutoDTO> produto = produtoService.encontrarProdutoPorId(produtoId);
        if (produto.isPresent()) {
            model.addAttribute("produto", produto.get());
            return "produtos/detalhes";
        } else {
            return "error/404";
        }
    }

    @GetMapping("/cadastrar")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("produtoDTO", new ProdutoDTO());
        return "produtos/cadastrar";
    }

    @PostMapping("/cadastrar")
    public String cadastrarProduto(@ModelAttribute ProdutoDTO produtoDTO) {
        produtoService.salvarProduto(produtoDTO);
        return "redirect:/produtos/listar";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicao(@PathVariable("id") Long produtoId, Model model) {
        Optional<ProdutoDTO> produto = produtoService.encontrarProdutoPorId(produtoId);
        if (produto.isPresent()) {
            model.addAttribute("produtoDTO", produto.get());
            return "produtos/editar";
        } else {
            return "error/404";
        }
    }

    @PostMapping("/editar/{id}")
    public String atualizarProduto(@PathVariable("id") Long produtoId, @ModelAttribute ProdutoDTO produtoDTO) {
        produtoDTO.setId(produtoId);
        produtoService.salvarProduto(produtoDTO);
        return "redirect:/produtos/listar";
    }

    // Atualizado para @DeleteMapping
    @PostMapping("/deletar/{id}")
    public String deletarProduto(@PathVariable("id") Long produtoId) {
        produtoService.deletarProduto(produtoId);
        return "redirect:/produtos/listar";
    }


}
