package com.edu.infnet.DR3TP3.repository.r2dbc;

import com.edu.infnet.DR3TP3.model.Fornecedor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends ReactiveCrudRepository<Fornecedor, Long> {
}
