package com.example.demo.Product.Query.QueryHandlers;

import com.example.demo.Product.Models.DTOs.ProductDTO;
import com.example.demo.Product.Query.Query;
import com.example.demo.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllProductsWithPriceLessThenQueryHandler implements Query<Double, List<ProductDTO>> {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public ResponseEntity<List<ProductDTO>> execute(Double maxPrice) {
        List<ProductDTO> response = productRepository
                .findByPriceLessThan(maxPrice)
                .stream()
                .map(ProductDTO::new)
                .toList();
        return ResponseEntity.ok(response);
    }
}
