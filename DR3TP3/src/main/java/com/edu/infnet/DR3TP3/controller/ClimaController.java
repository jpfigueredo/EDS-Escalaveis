package com.edu.infnet.DR3TP3.controller;

import com.edu.infnet.DR3TP3.model.ClimaResponse;
import com.edu.infnet.DR3TP3.service.ClimaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/clima")
public class ClimaController {

    @Autowired
    private ClimaService climaService;

    @GetMapping("/{cidade}")
    public Mono<ResponseEntity<ClimaResponse>> buscarClima(@PathVariable String cidade) {
        return climaService.buscarClima(cidade)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
