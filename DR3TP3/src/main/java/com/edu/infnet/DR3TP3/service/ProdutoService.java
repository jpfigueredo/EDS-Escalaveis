package com.edu.infnet.DR3TP3.service;

import com.edu.infnet.DR3TP3.model.Produto;
import com.edu.infnet.DR3TP3.repository.jpa.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Mono<Produto> criarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Mono<Produto> atualizarProduto(Long id, Produto produto) {
        return produtoRepository.findById(id)
                .flatMap(produtoExistente -> {
                    produtoExistente.setNome(produto.getNome());
                    produtoExistente.setPreco(produto.getPreco());
                    return produtoRepository.save(produtoExistente);
                });
    }

    public Mono<Void> excluirProduto(Long id) {
        return produtoRepository.deleteById(id);
    }

    public Flux<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }
}
