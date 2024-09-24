package br.com.infnet.imovel_service.controller;

import br.com.infnet.imovel_service.model.Imovel;
import br.com.infnet.imovel_service.repository.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ImovelController {

    @Autowired
    private ImovelRepository repository;

    @GetMapping()
    public Flux<Imovel> listar() {
        return repository.findAll();
    }

    @PostMapping()
    public Mono<Imovel> adicionar(@RequestBody Imovel imovel) {
        return repository.save(imovel);
    }
}
