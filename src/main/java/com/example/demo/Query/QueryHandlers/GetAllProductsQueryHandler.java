package com.example.demo.Query.QueryHandlers;

import com.example.demo.Models.DTOs.ProductDTO;
import com.example.demo.Query.Query;
import com.example.demo.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllProductsQueryHandler implements Query<Void, List<ProductDTO>> {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public ResponseEntity<List<ProductDTO>> execute(Void input) {
        List<ProductDTO> productDTOs = productRepository
                .findAll()
                .stream()
                .map(ProductDTO::new)
                .toList();
        return ResponseEntity.ok(productDTOs);
    }
}