package com.example.demo.Command.CommandHandlers;

import com.example.demo.Command.Command;
import com.example.demo.Models.Product;
import com.example.demo.Repositories.ProductRepository;
import com.example.demo.Util.ValidateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdateProductCommandHandler implements Command<UpdateProductCommand, Void> {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public ResponseEntity<Void> execute(UpdateProductCommand command) {
        Product product = command.getProduct();
        Integer id = command.getId();

        ValidateUtils.validateId(productRepository, id);

        product.setId(id);

        ValidateUtils.validateProduct(product);

        productRepository.save(product);
        return ResponseEntity.ok().build();
    }
}