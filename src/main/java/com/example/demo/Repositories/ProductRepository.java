package com.example.demo.Repositories;

import com.example.demo.Models.DTOs.ProductDTO;
import com.example.demo.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT new com.example.demo.Models.DTOs.ProductDTO(name, description, price) FROM Product p WHERE p.price < :maxPrice")
    List<ProductDTO> findProductsWithPriceLessThan(@Param(value = "maxPrice") Double maxValue);

    @Query("SELECT new com.example.demo.Models.DTOs.ProductDTO(name, description, price) FROM Product")
    List<ProductDTO> getAllProductsDTOs();
}