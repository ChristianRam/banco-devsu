package com.devsu.cliente.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity(name = "clientes")
@PrimaryKeyJoinColumn(referencedColumnName = "persona_id", name = "cliente_id")
public class Cliente extends Persona implements Serializable {

    @Serial
    private static final long serialVersionUID = -7817601801693766201L;
    @Column(length = 4, nullable = false)
    private Integer clave;
    @Column(nullable = false)
    private Boolean estado;

    public Cliente() {
    }

    public Integer getClave() {
        return clave;
    }

    public void setClave(Integer clave) {
        this.clave = clave;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "clave=" + clave +
                ", estado=" + estado +
                '}';
    }
}