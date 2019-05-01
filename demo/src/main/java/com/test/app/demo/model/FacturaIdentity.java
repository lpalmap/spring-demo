package com.test.app.demo.model;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

public class FacturaIdentity implements Serializable{
    
    
    private String serie;
    private Long correlativo;

    public FacturaIdentity(){

    }

    public FacturaIdentity(String serie, Long correlativo){
        this.serie=serie;
        this.correlativo=correlativo;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((correlativo == null) ? 0 : correlativo.hashCode());
        result = prime * result + ((serie == null) ? 0 : serie.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FacturaIdentity other = (FacturaIdentity) obj;
        if (correlativo == null) {
            if (other.correlativo != null)
                return false;
        } else if (!correlativo.equals(other.correlativo))
            return false;
        if (serie == null) {
            if (other.serie != null)
                return false;
        } else if (!serie.equals(other.serie))
            return false;
        return true;
    }

    
    

}