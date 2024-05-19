package br.com.fiap.datatech.controller;

import br.com.fiap.datatech.dto.ProdutoDTO;
import br.com.fiap.datatech.service.ProdutoService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/listar")
    public List<ProdutoDTO> listarProdutos() {
        return produtoService.listarTodosProdutos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> obterProdutoPorId(@PathVariable(value = "id") Long produtoId) {
        Optional<ProdutoDTO> produto = produtoService.encontrarProdutoPorId(produtoId);
        return produto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<ProdutoDTO> cadastrarProduto(@Valid @RequestBody ProdutoDTO produtoDTO) {
        ProdutoDTO novoProduto = produtoService.salvarProduto(produtoDTO);
        return ResponseEntity.ok().body(novoProduto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> atualizarProduto(@PathVariable(value = "id") Long produtoId,
                                                       @Valid @RequestBody ProdutoDTO produtoDTO) {
        Optional<ProdutoDTO> produto = produtoService.encontrarProdutoPorId(produtoId);
        if (produto.isPresent()) {
            produtoDTO.setId(produtoId); // Ensure the ID is set for updating
            ProdutoDTO produtoAtualizado = produtoService.salvarProduto(produtoDTO);
            return ResponseEntity.ok(produtoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable(value = "id") Long produtoId) {
        produtoService.deletarProduto(produtoId);
        return ResponseEntity.ok().build();
    }
}
