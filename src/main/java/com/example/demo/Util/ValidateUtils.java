package com.example.demo.Util;

import com.example.demo.Exceptions.ProductNotFoundException;
import com.example.demo.Exceptions.ProductNotValidException;
import com.example.demo.Models.Product;
import com.example.demo.Repositories.ProductRepository;
import io.micrometer.common.util.StringUtils;

import java.util.Optional;

public class ValidateUtils {
    public static void validateId(ProductRepository productRepository, Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException();
        }
    }
    public static void validateProduct(Product product) {
        if(StringUtils.isBlank(product.getName())) {
            throw new ProductNotValidException("Product 'name' cannot be blank!");
        }
        if(StringUtils.isBlank(product.getDescription())) {
            throw new ProductNotValidException("Product 'description' cannot be blank!");
        }
        if(product.getPrice() <= 0.0) {
            throw new ProductNotValidException("Product 'price' cannot be negative!");
        }
        if(product.getQuantity() < 0) {
            throw new ProductNotValidException("Product 'quantity' cannot be negative!");
        }
    }
}