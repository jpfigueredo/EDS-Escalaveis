package br.com.infnet.veiculo_service.controller;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VeiculoClient {

    private final WebClient webClient;

    public VeiculoClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080/carros").build();
    }

    public Flux<Veiculo> listarVeiculos() {
        return webClient.get()
                .retrieve()
                .bodyToFlux(Veiculo.class);
    }

    public Mono<Veiculo> adicionarVeiculo(Veiculo carro) {
        return webClient.post()
                .bodyValue(carro)
                .retrieve()
                .bodyToMono(Veiculo.class);
    }
}
