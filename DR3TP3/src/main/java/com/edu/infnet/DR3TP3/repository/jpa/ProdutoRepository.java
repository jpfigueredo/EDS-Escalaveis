package com.edu.infnet.DR3TP3.repository.jpa;

import com.edu.infnet.DR3TP3.model.Produto;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProdutoRepository extends ReactiveCrudRepository<Produto, Long> {
    // Métodos CRUD reativos padrão fornecidos pelo ReactiveCrudRepository
    Flux<Produto> findAll();
}
