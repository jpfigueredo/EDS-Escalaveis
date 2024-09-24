package com.edu.infnet.DR3TP3.controller;

import com.edu.infnet.DR3TP3.model.Produto;
import com.edu.infnet.DR3TP3.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public Mono<ResponseEntity<Produto>> criarProduto(@RequestBody Produto produto) {
        return produtoService.criarProduto(produto)
                .map(p -> new ResponseEntity<>(p, HttpStatus.CREATED));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Produto>> atualizarProduto(@PathVariable Long id, @RequestBody Produto produto) {
        return produtoService.atualizarProduto(id, produto)
                .map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> excluirProduto(@PathVariable Long id) {
        return produtoService.excluirProduto(id)
                .map(r -> new ResponseEntity<Void>(HttpStatus.NO_CONTENT))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public Flux<Produto> listarProdutos() {
        return produtoService.listarProdutos();
    }
}
