package br.com.fiap.datatech.service;

import br.com.fiap.datatech.dto.ProdutoDTO;
import br.com.fiap.datatech.entity.Produto;
import br.com.fiap.datatech.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<ProdutoDTO> listarTodosProdutos() {
        List<Produto> produtos = produtoRepository.findAll();
        return produtos.stream()
                .map(produto -> modelMapper.map(produto, ProdutoDTO.class))
                .collect(Collectors.toList());
    }

    public Optional<ProdutoDTO> encontrarProdutoPorId(Long produtoId) {
        Optional<Produto> produto = produtoRepository.findById(produtoId);
        return produto.map(value -> modelMapper.map(value, ProdutoDTO.class));
    }

    public ProdutoDTO salvarProduto(ProdutoDTO produtoDTO) {
        Produto produto = modelMapper.map(produtoDTO, Produto.class);
        produto = produtoRepository.save(produto);
        return modelMapper.map(produto, ProdutoDTO.class);
    }

    public void deletarProduto(Long produtoId) {
        produtoRepository.deleteById(produtoId);
    }
}
