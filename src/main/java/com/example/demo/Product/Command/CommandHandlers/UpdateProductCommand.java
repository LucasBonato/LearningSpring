package com.example.demo.Product.Command.CommandHandlers;

import com.example.demo.Product.Models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UpdateProductCommand {
    private Integer id;
    private Product product;
}