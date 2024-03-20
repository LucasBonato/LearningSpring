package com.example.demo.Cliente.Models;

import jakarta.persistence.*;
import lombok.Data;

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

    @Column(name = "Id_Cliente")
    private Integer idCliente;
}
