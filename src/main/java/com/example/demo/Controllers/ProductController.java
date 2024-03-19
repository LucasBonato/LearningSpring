package com.example.demo.Controllers;

import com.example.demo.Product.Command.CommandHandlers.CreateProductCommandHandler;
import com.example.demo.Product.Command.CommandHandlers.DeleteProductCommandHandler;
import com.example.demo.Product.Command.CommandHandlers.UpdateProductCommandHandler;
import com.example.demo.Product.Models.DTOs.ProductDTO;
import com.example.demo.Product.Models.Product;
import com.example.demo.Product.Command.CommandHandlers.UpdateProductCommand;
import com.example.demo.Product.Query.QueryHandlers.GetAllProductsQueryHandler;
import com.example.demo.Product.Query.QueryHandlers.GetAllProductsWithPriceLessThenQueryHandler;
import com.example.demo.Product.Query.QueryHandlers.GetAllSearchedProductsDescriptionQueryHandler;
import com.example.demo.Product.Query.QueryHandlers.GetProductQueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired private GetAllProductsWithPriceLessThenQueryHandler getAllProductsPriceLess;
    @Autowired private GetAllSearchedProductsDescriptionQueryHandler getAllProductsDescURL;
    @Autowired private GetAllProductsQueryHandler getAllProducts;
    @Autowired private GetProductQueryHandler getProduct;
    @Autowired private CreateProductCommandHandler createProduct;
    @Autowired private UpdateProductCommandHandler updateProduct;
    @Autowired private DeleteProductCommandHandler deleteProduct;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getProducts() {
        return getAllProducts.execute(null);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Integer id) {
        return getProduct.execute(id);
    }
    @GetMapping("/search/{maxPrice}")
    public ResponseEntity<List<ProductDTO>> getProductsByPrice(@PathVariable Double maxPrice) {
        return getAllProductsPriceLess.execute(maxPrice);
    }
    @GetMapping("/search")
    public ResponseEntity<List<ProductDTO>> getSearchedProducts(@RequestParam(value = "d") String description) {
        return getAllProductsDescURL.execute(description);
    }
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Product product){
        return createProduct.execute(product);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody Product product){
        return updateProduct.execute(new UpdateProductCommand(id, product));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        return deleteProduct.execute(id);
    }
}