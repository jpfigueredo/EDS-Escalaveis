package br.com.infnet.veiculo_service.service;

import br.com.infnet.veiculo_service.model.Veiculo;
import br.com.infnet.veiculo_service.repository.VeiculoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class VeiculoServiceTest {

    @MockBean
    private VeiculoRepository veiculoRepository;

    @Autowired
    private VeiculoService veiculoService;

    @Test
    public void testFindAllVeiculos() {
        List<Veiculo> veiculos = Arrays.asList(new Veiculo("Honda", "Civic", 2020));
        when(veiculoRepository.findAll()).thenReturn(veiculos);

        List<Veiculo> result = veiculoService.getAllVeiculos();
        assertEquals(1, result.size());
        assertEquals("Honda", result.get(0).getMarca());
    }
}
