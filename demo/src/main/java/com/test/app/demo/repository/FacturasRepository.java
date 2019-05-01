package com.test.app.demo.repository;

import com.test.app.demo.model.Factura;
import com.test.app.demo.model.FacturaIdentity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturasRepository extends JpaRepository<Factura,FacturaIdentity>{

}