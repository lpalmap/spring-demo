package com.test.app.demo.controller;

import java.util.List;

import javax.validation.Valid;

import com.test.app.demo.model.*;
import com.test.app.demo.repository.FacturasRepository;
import com.test.app.demo.exception.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/fapi")
public class FacturasController {

    @Autowired
    private FacturasRepository facturasRepository;

    @GetMapping("/facturas")
    public List<Factura> getFacturas(){
        return facturasRepository.findAll();
    }

    @PostMapping("/facturas")
    public Factura agregarFactura(@Valid @RequestBody Factura factura){
        Factura f= facturasRepository.save(factura);
        return f;
    }

    @GetMapping("/facturas/{serie}/{correlativo}")
    public Factura getFactura(@PathVariable(value = "serie") String serie,@PathVariable(value = "correlativo") Long correlativo){
        FacturaIdentity fidentity=new FacturaIdentity(serie,correlativo);

        Factura f= facturasRepository.findById(fidentity).orElseThrow(()->new ResourceNotFoundException("Note","id",correlativo));
        f.getCliente();
        return f;
    }

}