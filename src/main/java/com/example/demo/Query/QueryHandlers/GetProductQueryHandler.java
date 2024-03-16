package com.example.demo.Query.QueryHandlers;

import com.example.demo.Models.DTOs.ProductDTO;
import com.example.demo.Models.Product;
import com.example.demo.Query.Query;
import com.example.demo.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetProductQueryHandler implements Query<Integer, ProductDTO> {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public ResponseEntity<ProductDTO> execute(Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        return (optionalProduct.isPresent())
                ? ResponseEntity.ok(new ProductDTO(optionalProduct.get()))
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
