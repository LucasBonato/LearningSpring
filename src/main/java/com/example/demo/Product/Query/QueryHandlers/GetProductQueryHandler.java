package com.example.demo.Product.Query.QueryHandlers;

import com.example.demo.Exceptions.ProductNotFoundException;
import com.example.demo.Product.Models.DTOs.ProductDTO;
import com.example.demo.Product.Models.Product;
import com.example.demo.Product.Query.Query;
import com.example.demo.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetProductQueryHandler implements Query<Integer, ProductDTO> {
    @Autowired
    private ProductRepository productRepository;
    @Override
    @Cacheable("productCache")
    public ResponseEntity<ProductDTO> execute(Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()){
            return ResponseEntity.ok(new ProductDTO(optionalProduct.get()));
        }
        throw new ProductNotFoundException();
    }
}