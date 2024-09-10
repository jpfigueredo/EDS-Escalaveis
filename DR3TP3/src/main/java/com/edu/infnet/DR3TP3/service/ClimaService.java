package com.edu.infnet.DR3TP3.service;

import com.edu.infnet.DR3TP3.model.ClimaResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ClimaService {

    private final WebClient webClient;

    public ClimaService(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("https://api.openweathermap.org").build();
    }

    public Mono<ClimaResponse> buscarClima(String cidade) {
        return webClient.get()
                .uri("/data/2.5/weather?q={cidade}&appid={apiKey}", cidade, "your_api_key")
                .retrieve()
                .bodyToMono(ClimaResponse.class);
    }
}

