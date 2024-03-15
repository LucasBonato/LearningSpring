package com.example.demo.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UpdateProductCommand {
    private Integer id;
    private Product product;
}
