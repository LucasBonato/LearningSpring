package com.example.demo.Cliente.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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

    @ManyToMany(cascade = CascadeType.ALL) // O cascade significa que quando alterado o Cliente ira alterar o Endereco automaticamente mesmo não estando no mesmo contexto
    @JoinTable(name = "Cliente_Endereco", joinColumns = @JoinColumn(name = "Id_Cliente"), inverseJoinColumns = @JoinColumn(name = "Id_Endereco"))
    private List<Endereco> enderecos;
}