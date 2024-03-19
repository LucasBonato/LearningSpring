package com.example.demo.Product.Command.CommandHandlers;

import com.example.demo.Product.Command.Command;
import com.example.demo.Product.Models.Product;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.Product.Util.ValidateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateProductCommandHandler implements Command<Product, Void> {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public ResponseEntity<Void> execute(Product product) {
        ValidateUtils.validateProduct(product);
        productRepository.save(product);
        return ResponseEntity.ok().build();
    }
}