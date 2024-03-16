package com.example.demo.Command.CommandHandlers;

import com.example.demo.Command.Command;
import com.example.demo.Repositories.ProductRepository;
import com.example.demo.Util.ValidateUtils;
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