package com.example.demo.Controllers;

import com.example.demo.Cliente.Models.Cliente;
import com.example.demo.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getCliente(@PathVariable Integer id){
        return ResponseEntity.ok(clienteRepository.findById(id).get());
    }
    @PutMapping
    public ResponseEntity update(@RequestBody Cliente cliente){
        clienteRepository.save(cliente);
        return ResponseEntity.ok().build();
    }
}
