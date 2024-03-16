package com.example.demo.Command;

import com.example.demo.Command.CommandHandlers.UpdateProductCommand;
import com.example.demo.Exceptions.ProductNotFoundException;
import com.example.demo.Exceptions.ProductNotValidException;
import com.example.demo.Models.Product;
import com.example.demo.Repositories.ProductRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateProductCommandHandler implements Command<UpdateProductCommand, Void> {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public ResponseEntity<Void> execute(UpdateProductCommand command) {
        Product product = command.getProduct();
        Integer id = command.getId();

        validateId(id);

        product.setId(id);
        validateProduct(product);
        productRepository.save(product);
        return ResponseEntity.ok().build();
    }
    private void validateId(Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException();
        }
    }
    private void validateProduct(Product product) {
        if(StringUtils.isBlank(product.getName())) {
            throw new ProductNotValidException("Product 'name' cannot be blank!");
        }
        if(StringUtils.isBlank(product.getDescription())) {
            throw new ProductNotValidException("Product 'description' cannot be blank!");
        }
        if(product.getPrice() <= 0.0) {
            throw new ProductNotValidException("Product 'price' cannot be negative!");
        }
        if(product.getQuantity() < 0) {
            throw new ProductNotValidException("Product 'quantity' cannot be negative!");
        }
    }
}