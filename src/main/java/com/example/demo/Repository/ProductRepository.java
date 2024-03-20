package com.example.demo.Repository;

import com.example.demo.Product.Models.DTOs.ProductDTO;
import com.example.demo.Product.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByPriceLessThan(Double maxValue);
    @Query("SELECT new com.example.demo.Product.Models.DTOs.ProductDTO(name, description, price) FROM Product")
    List<ProductDTO> getAllProductsDTOs();

    List<Product> findByDescriptionContaining(String description);
}