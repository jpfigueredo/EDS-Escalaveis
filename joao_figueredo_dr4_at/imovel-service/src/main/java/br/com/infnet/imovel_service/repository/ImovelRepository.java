package br.com.infnet.imovel_service.repository;

import br.com.infnet.imovel_service.model.Imovel;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImovelRepository extends ReactiveCrudRepository<Imovel, Long> {}
