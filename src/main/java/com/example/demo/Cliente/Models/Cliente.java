package com.example.demo.Cliente.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Cliente")
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Nome")
    private String nome;

    @Column(name = "Sobrenome")
    private String sobrenome;

    @OneToOne(cascade = CascadeType.ALL) // O cascade significa que quando alterado o Cliente ira alterar o Endereco automaticamente mesmo não estando no mesmo contexto
    @JoinColumn(name = "IdEndereco")
    private Endereco endereco;
}