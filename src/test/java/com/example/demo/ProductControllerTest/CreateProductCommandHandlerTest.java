package com.example.demo.ProductControllerTest;

import com.example.demo.Command.CommandHandlers.CreateProductCommandHandler;
import com.example.demo.Exceptions.ProductNotValidException;
import com.example.demo.LearningSpringApplication;
import com.example.demo.Models.Product;
import com.example.demo.Repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(classes = LearningSpringApplication.class)
public class CreateProductCommandHandlerTest {
    @InjectMocks
    private CreateProductCommandHandler createProductCommandHandler;
    @Mock
    private ProductRepository productRepository;

    //NomeDoMétodo_EstadoASerTestado_ComportamentoEsperado
    //Given/Arrange, When/Act and Then/Assert
    @Test
    public void createProductCommandHandler_validProduct_returnsSuccess(){
        Product product = new Product();
        product.setId(1);
        product.setName("Octopus Plush");
        product.setDescription("A Blue octopus plush.");
        product.setPrice(49.99);
        product.setQuantity(150);

        ResponseEntity response = createProductCommandHandler.execute(product);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    @Test
    public void CreateProductCommandHandler_invalidPrice_throwsInvalidPriceException() {
        Product product = new Product();
        product.setId(1);
        product.setName("Octopus Plush");
        product.setDescription("A Blue octopus plush.");
        product.setPrice(-49.99);
        product.setQuantity(150);

        ProductNotValidException exception = assertThrows(ProductNotValidException.class, () -> createProductCommandHandler.execute(product));
        assertEquals("Product 'price' cannot be negative!", exception.getExceptionResponse().getMessage());
    }
}
