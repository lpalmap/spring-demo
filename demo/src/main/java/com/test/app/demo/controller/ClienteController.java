package com.test.app.demo.controller;

import com.test.app.demo.repository.ClienteRepository;
import com.test.app.demo.model.Cliente;
import java.util.List;
import com.test.app.demo.exception.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/capi")
public class ClienteController {
    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping("/clientes")
    public List<Cliente> clientes() {
        return clienteRepository.findAll();
    }

    @PostMapping("/clientes")
    public Cliente newCliente(@Valid @RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @GetMapping("/clientes/{id}")
    public Cliente getCliente(@PathVariable(value = "id") Long ideCliente) {
        return clienteRepository.findById(ideCliente)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", ideCliente));
    }

    @PutMapping("/clientes/{id}")
    public Cliente updateCliente(@PathVariable(value = "id") Long ideCliente, @Valid @RequestBody Cliente details) {
        Cliente theCliente = clienteRepository.findById(ideCliente)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", ideCliente));
        theCliente.setNombres1(details.getNombres1());
        theCliente.setNombres2(details.getNombres2());
        theCliente.setApellidos1(details.getApellidos1());
        theCliente.setApellidos2(details.getApellidos2());
        theCliente.setSexo(details.getSexo());
        theCliente.setNit(details.getNit());
        Cliente updatedCliente = clienteRepository.save(theCliente);
        return updatedCliente;
    }

    @DeleteMapping("/clientes/{id}")
    public String deleteCliente(@PathVariable(value = "id") Long ideCliente) {
        Cliente theCliente = clienteRepository.findById(ideCliente)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", ideCliente));
        clienteRepository.delete(theCliente);
        return "OK";
    }

}