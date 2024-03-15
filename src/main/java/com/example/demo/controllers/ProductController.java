package com.example.demo.controllers;

import com.example.demo.models.Product;
import com.example.demo.query.queryHandlers.GetAllProductsQueryHandler;
import com.example.demo.query.queryHandlers.GetProductQueryHandler;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private GetAllProductsQueryHandler getAllProductsQueryHandler;
    @Autowired
    private GetProductQueryHandler getProductQueryHandler;

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        return getAllProductsQueryHandler.execute(null);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer id) {
        return getProductQueryHandler.execute(id);
    }
    @PostMapping
    public ResponseEntity create(@RequestBody Product product){
        productRepository.save(product);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody Product product){
        product.setId(id);
        productRepository.save(product);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
        return ResponseEntity.ok().build();
    }
}
