package com.example.demo.Product.Command.CommandHandlers;

import com.example.demo.Product.Command.Command;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.Product.Util.ValidateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteProductCommandHandler implements Command<Integer, Void> {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public ResponseEntity<Void> execute(Integer id) {
        ValidateUtils.validateId(productRepository, id);
        productRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}