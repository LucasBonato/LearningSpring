package com.example.demo.Product.Command.CommandHandlers;

import com.example.demo.Product.Command.Command;
import com.example.demo.Product.Models.DTOs.ProductDTO;
import com.example.demo.Product.Models.Product;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.Product.Util.ValidateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdateProductCommandHandler implements Command<UpdateProductCommand, ResponseEntity> {
    @Autowired
    private ProductRepository productRepository;
    @Override
    @CachePut(value = "productCache", key = "#command.getId()")
    public ResponseEntity execute(UpdateProductCommand command) {
        Product product = command.getProduct();
        Integer id = command.getId();

        ValidateUtils.validateId(productRepository, id);

        product.setId(id);

        ValidateUtils.validateProduct(product);

        productRepository.save(product);
        return ResponseEntity.ok(new ProductDTO(product));
    }
}
// Tomar cuidado, pois com o cache, QUALQUER coisa que ele retornar, será colocada no Cache mesmo que não faça sentido
// ou seja, tem que retornar o objeto que foi atualizado.