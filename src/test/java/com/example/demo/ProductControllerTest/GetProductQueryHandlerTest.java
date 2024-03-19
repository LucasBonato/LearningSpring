package com.example.demo.ProductControllerTest;

import com.example.demo.Exceptions.ProductNotFoundException;
import com.example.demo.LearningSpringApplication;
import com.example.demo.Product.Models.DTOs.ProductDTO;
import com.example.demo.Product.Models.Product;
import com.example.demo.Product.Query.QueryHandlers.GetProductQueryHandler;
import com.example.demo.Repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = LearningSpringApplication.class)
public class GetProductQueryHandlerTest {

    @InjectMocks
    private GetProductQueryHandler getProductQueryHandler;
    @Mock
    private ProductRepository productRepository;

    @Test
    public void getProductQueryHandler_validId_returnsProductDTO(){
        Product product = new Product();
        product.setId(1);
        product.setName("Octopus Plush");
        product.setDescription("A Blue octopus plush.");
        product.setPrice(49.99);
        product.setQuantity(150);

        ProductDTO expectedDTO = new ProductDTO(product);

        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));

        ResponseEntity<ProductDTO> response = getProductQueryHandler.execute(product.getId());
        assertEquals(expectedDTO, response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    @Test
    public void getProductQueryHandler_NotFoundProduct_returnsNotFoundStatus() {
        Product product = new Product();
        product.setId(1);
        product.setName("Octopus Plush");
        product.setDescription("A Blue octopus plush.");
        product.setPrice(49.99);
        product.setQuantity(150);

        ProductNotFoundException exception = assertThrows(
                ProductNotFoundException.class,
                () -> getProductQueryHandler.execute(product.getId())
        );
        assertEquals(HttpStatus.NOT_FOUND, exception.getStatus());
    }
    @Test void getProductQueryHandler_invalidId_throwsProductNotFoundException() {
        when(productRepository.findById(1)).thenReturn(Optional.empty());

        ProductNotFoundException exception = assertThrows(
                ProductNotFoundException.class,
                () -> getProductQueryHandler.execute(1)
        );
        assertEquals("Product Not Found.", exception.getExceptionResponse().getMessage());
    }
}