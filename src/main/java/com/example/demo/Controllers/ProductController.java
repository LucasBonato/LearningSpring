package com.example.demo.Controllers;

import com.example.demo.Command.CommandHandlers.CreateProductCommandHandler;
import com.example.demo.Command.CommandHandlers.UpdateProductCommandHandler;
import com.example.demo.Models.Product;
import com.example.demo.Models.UpdateProductCommand;
import com.example.demo.Query.QueryHandlers.GetAllProductsQueryHandler;
import com.example.demo.Query.QueryHandlers.GetProductQueryHandler;
import com.example.demo.Repositories.ProductRepository;
import com.mysql.cj.jdbc.result.UpdatableResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private GetAllProductsQueryHandler getAllProducts;
    @Autowired
    private GetProductQueryHandler getProduct;
    @Autowired
    private CreateProductCommandHandler createProduct;
    @Autowired
    private UpdateProductCommandHandler updateProduct;

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        return getAllProducts.execute(null);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer id) {
        return getProduct.execute(id);
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
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
        return ResponseEntity.ok().build();
    }
}
