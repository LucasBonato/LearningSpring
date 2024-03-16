package com.example.demo.Command.CommandHandlers;

import com.example.demo.Command.Command;
import com.example.demo.Exceptions.ProductNotFoundException;
import com.example.demo.Models.Product;
import com.example.demo.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteProductCommandHandler implements Command<Integer, Void> {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public ResponseEntity<Void> execute(Integer id) {
        validateId(id);
        productRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    private void validateId(Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException();
        }
    }
}
