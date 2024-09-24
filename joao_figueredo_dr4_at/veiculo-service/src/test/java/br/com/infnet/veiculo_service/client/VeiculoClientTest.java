package br.com.infnet.veiculo_service.client;

import br.com.infnet.veiculo_service.controller.VeiculoClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import reactor.test.StepVerifier;

@SpringBootTest
public class VeiculoClientTest {

    @Autowired
    private VeiculoClient veiculoClient;

    static GenericContainer<?> h2Container = new GenericContainer<>("h2:latest")
            .withExposedPorts(9092);

    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.r2dbc.url", () -> "r2dbc:h2:mem:///veiculoDB");
    }

    @Test
    public void testListarVeiculos() {
        StepVerifier.create(veiculoClient.listarVeiculos())
                .expectSubscription()
                .verifyComplete();
    }
}
