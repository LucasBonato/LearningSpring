package com.example.demo.Command.CommandHandlers;

import com.example.demo.Command.Command;
import com.example.demo.Models.Product;
import com.example.demo.Repositories.ProductRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateProductCommandHandler implements Command<Product, Void> {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public ResponseEntity<Void> execute(Product product) {
        validateProduct(product);
        productRepository.save(product);
        return ResponseEntity.ok().build();
    }

    private static void validateProduct(Product product) {
        if(StringUtils.isBlank(product.getName())) {
            throw new RuntimeException("Product name cannot be blank!");
        }
        if(StringUtils.isBlank(product.getDescription())) {
            throw new RuntimeException("Product description cannot be blank!");
        }
        if(product.getPrice() <= 0.0) {
            throw new RuntimeException("Product price cannot be negative!");
        }
        if(product.getQuantity() < 0) {
            throw new RuntimeException("Product quantity cannot be negative!");
        }
    }
}
