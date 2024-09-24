package br.com.infnet.veiculo_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Table("Veiculo")
public class Veiculo {
    @Id
    private Long id;
    private String modelo;
    private String marca;
    private Integer ano;

    public Veiculo (String modelo, String marca, Integer ano){
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
    }
}
