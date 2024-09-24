package com.edu.infnet.DR3TP3.service;

import com.edu.infnet.DR3TP3.model.Fornecedor;
import com.edu.infnet.DR3TP3.repository.r2dbc.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class FornecedorService {

    private final FornecedorRepository fornecedorRepository;

    @Autowired
    public FornecedorService(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    public Mono<Fornecedor> criarFornecedor(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public Mono<Fornecedor> buscarFornecedorPorId(Long id) {
        return fornecedorRepository.findById(id);
    }

    public Mono<Fornecedor> atualizarFornecedor(Long id, Fornecedor fornecedor) {
        return fornecedorRepository.findById(id)
                .map(fornecedorExistente -> {
                    fornecedorExistente.setNome(fornecedor.getNome());
                    fornecedorExistente.setCnpj(fornecedor.getCnpj());
                    fornecedorExistente.setEndereco(fornecedor.getEndereco());
                    return fornecedorRepository.save(fornecedorExistente);
                })
                .switchIfEmpty(Mono.error(new RuntimeException("Fornecedor não encontrado"))).block();
    }

    public Mono<Void> excluirFornecedor(Long id) {
        return fornecedorRepository.deleteById(id);
    }
}
