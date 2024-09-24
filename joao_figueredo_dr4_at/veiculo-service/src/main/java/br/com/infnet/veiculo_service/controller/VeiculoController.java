package br.com.infnet.veiculo_service.controller;

import br.com.infnet.veiculo_service.model.Veiculo;
import br.com.infnet.veiculo_service.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @GetMapping
    public Flux<Veiculo> listar() {
        return veiculoRepository.findAll();
    }

    @PostMapping
    public Mono<Veiculo> adicionar(@RequestBody Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }
}
