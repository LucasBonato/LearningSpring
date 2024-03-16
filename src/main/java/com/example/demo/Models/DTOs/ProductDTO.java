package com.example.demo.Models.DTOs;

import com.example.demo.Models.Product;
import lombok.Data;

@Data
public class ProductDTO {
    private String name;
    private String description;
    private Double price;

    public ProductDTO(Product product){
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
    }
}