package com.example.demo.Product.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "NameP")
    private String name;

    @Column(name = "DescriptionP")
    private String description;

    @Column(name = "Price")
    private Double price;

    @Column(name = "Quantity")
    private Integer quantity;
}