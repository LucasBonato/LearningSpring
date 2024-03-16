package com.example.demo.Command.CommandHandlers;

import com.example.demo.Models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UpdateProductCommand {
    private Integer id;
    private Product product;
}