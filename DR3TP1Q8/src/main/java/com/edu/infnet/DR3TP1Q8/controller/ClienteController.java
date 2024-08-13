package controller;

import domain.Cliente;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private List<Cliente> clientes = new ArrayList<>();

    // Endpoint para listar todos os clientes
    @GetMapping
    public List<Cliente> getAllClientes() {
        return clientes;
    }

    // Endpoint para obter um cliente específico pelo ID
    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable Long id) {
        return clientes.stream().filter(cliente -> cliente.getId().equals(id)).findFirst().orElse(null);
    }

    // Endpoint para criar um novo cliente
    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente) {
        cliente.setId((long) (clientes.size() + 1));
        clientes.add(cliente);
        return cliente;
    }

    // Endpoint para atualizar um cliente existente
    @PutMapping("/{id}")
    public Cliente updateCliente(@PathVariable Long id, @RequestBody Cliente updatedCliente) {
        Optional<Cliente> existingCliente = clientes.stream().filter(cliente -> cliente.getId().equals(id)).findFirst();
        if (existingCliente.isPresent()) {
            Cliente cliente = existingCliente.get();
            cliente.setNome(updatedCliente.getNome());
            cliente.setEmail(updatedCliente.getEmail());
            return cliente;
        } else {
            return null;
        }
    }

    // Endpoint para deletar um cliente pelo ID
    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id) {
        clientes.removeIf(cliente -> cliente.getId().equals(id));
    }
}
