package com.example.demo.Cliente.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Endereco")
@Data
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Logradouro")
    private String logradouro;

    @Column(name = "Cidade")
    private String cidade;

    @Column(name = "Estado")
    private String estado;

    @ManyToMany(mappedBy = "enderecos")
    @JsonIgnore // Como temos uma lista dos dois lados, ficaria um loop, então não vai colocar esse atributo no JSON
    private List<Cliente> clientes;
}
