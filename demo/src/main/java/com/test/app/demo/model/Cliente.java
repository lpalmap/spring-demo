package com.test.app.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.test.app.demo.model.Factura;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "lp_cliente")
@EntityListeners(AuditingEntityListener.class)
public class Cliente implements Serializable{

    @Id
    @Column(name = "ide_cliente")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ideCliente;
    @NotBlank
    private String nombres1;
    @NotBlank
    private String nombres2;
    @NotBlank
    private String apellidos1;
    @NotBlank
    private String apellidos2;
    @NotBlank
    private String sexo;
    @NotBlank
    private String nit;

    @OneToMany(mappedBy = "cliente",fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Factura> facturas;

    /**
     * @return the ideCliente
     */
    public Long getIdeCliente() {
        return ideCliente;
    }

    /**
     * @param ideCliente the ideCliente to set
     */
    public void setIdeCliente(Long ideCliente) {
        this.ideCliente = ideCliente;
    }

    /**
     * @return the nombres1
     */
    public String getNombres1() {
        return nombres1;
    }

    /**
     * @param nombres1 the nombres1 to set
     */
    public void setNombres1(String nombres1) {
        this.nombres1 = nombres1;
    }

    /**
     * @return the nombres2
     */
    public String getNombres2() {
        return nombres2;
    }

    /**
     * @param nombres2 the nombres2 to set
     */
    public void setNombres2(String nombres2) {
        this.nombres2 = nombres2;
    }

    /**
     * @return the apellidos1
     */
    public String getApellidos1() {
        return apellidos1;
    }

    /**
     * @param apellidos1 the apellidos1 to set
     */
    public void setApellidos1(String apellidos1) {
        this.apellidos1 = apellidos1;
    }

    /**
     * @return the apellidos2
     */
    public String getApellidos2() {
        return apellidos2;
    }

    /**
     * @param apellidos2 the apellidos2 to set
     */
    public void setApellidos2(String apellidos2) {
        this.apellidos2 = apellidos2;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the nit
     */
    public String getNit() {
        return nit;
    }

    /**
     * @param nit the nit to set
     */
    public void setNit(String nit) {
        this.nit = nit;
    }

    /**
     * @return the facturas
     */
    public List<Factura> getFacturas() {
        return facturas;
    }

    /**
     * @param facturas the facturas to set
     */
    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

}