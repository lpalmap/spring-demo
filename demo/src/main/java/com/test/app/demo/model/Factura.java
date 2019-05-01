package com.test.app.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import com.test.app.demo.model.Cliente;

import org.hibernate.annotations.Fetch;
import org.hibernate.validator.constraints.CodePointLength;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;

@Entity
@Table(name = "lp_factura")
@IdClass(FacturaIdentity.class)
@EntityListeners(AuditingEntityListener.class)
public class Factura implements Serializable{
    @Id
    private String serie;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long correlativo;
    @NotBlank
    private String direccion;
    @NotNull
    @Column(precision = 10, scale = 2)
    private Double total;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ide_cliente")
    @JsonBackReference
    private Cliente cliente;

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the total
     */
    public Double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(Double total) {
        this.total = total;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the serie
     */
    public String getSerie() {
        return serie;
    }

    /**
     * @param serie the serie to set
     */
    public void setSerie(String serie) {
        this.serie = serie;
    }

    /**
     * @return the correlativo
     */
    public Long getCorrelativo() {
        return correlativo;
    }

    /**
     * @param correlativo the correlativo to set
     */
    public void setCorrelativo(Long correlativo) {
        this.correlativo = correlativo;
    }
}