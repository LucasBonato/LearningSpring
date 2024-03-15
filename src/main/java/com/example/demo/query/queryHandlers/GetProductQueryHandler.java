package com.example.demo.query.queryHandlers;

import com.example.demo.models.Product;
import com.example.demo.query.Query;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetProductQueryHandler implements Query<Integer, Product> {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public ResponseEntity<Product> execute(Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            return ResponseEntity.ok(optionalProduct.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
