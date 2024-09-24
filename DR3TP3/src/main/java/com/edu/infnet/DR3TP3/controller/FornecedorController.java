package com.edu.infnet.DR3TP3.controller;

import com.edu.infnet.DR3TP3.model.Fornecedor;
import com.edu.infnet.DR3TP3.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping
    public Mono<ResponseEntity<Fornecedor>> criarFornecedor(@RequestBody Fornecedor fornecedor) {
        return fornecedorService.criarFornecedor(fornecedor)
                .map(f -> ResponseEntity.status(HttpStatus.CREATED).body(f));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Fornecedor>> buscarFornecedorPorId(@PathVariable Long id) {
        return fornecedorService.buscarFornecedorPorId(id)
                .map(f -> ResponseEntity.ok(f))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Fornecedor>> atualizarFornecedor(@PathVariable Long id, @RequestBody Fornecedor fornecedor) {
        return fornecedorService.atualizarFornecedor(id, fornecedor)
                .map(f -> ResponseEntity.ok(f))
                .onErrorResume(e -> Mono.just(ResponseEntity.notFound().build()));
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Object>> excluirFornecedor(@PathVariable Long id) {
        return fornecedorService.excluirFornecedor(id)
                .then(Mono.just(ResponseEntity.noContent().build()))
                .onErrorResume(e -> Mono.just(ResponseEntity.notFound().build()));
    }
}
