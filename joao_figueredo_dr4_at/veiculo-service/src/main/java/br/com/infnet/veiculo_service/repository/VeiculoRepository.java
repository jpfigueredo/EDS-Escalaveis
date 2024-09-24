package br.com.infnet.veiculo_service.repository;

import br.com.infnet.veiculo_service.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends ReactiveCrudRepository<Veiculo, Long> {}
