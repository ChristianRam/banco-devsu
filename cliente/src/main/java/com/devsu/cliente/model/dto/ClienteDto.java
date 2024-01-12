package com.devsu.cliente.model.dto;

import com.devsu.cliente.model.Genero;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;

public class ClienteDto implements Serializable {

    private Long id;

    @NotEmpty
    @Size(max = 50, message = "El nombre no puede exceder los 50 caracteres")
    private String nombre;

    @NotNull
    private Genero genero;

    @NotNull
    private Integer edad;

    @NotEmpty
    @Size(max = 10, message = "El numero de identificacion no puede exceder los 10 digitos")
    private String identificacion;

    @NotEmpty
    @Size(max = 45, message = "La direccion no puede exceder los 45 caracteres")
    private String direccion;

    @NotEmpty
    @Size(max = 10, message = "El telefono no puede exceder los 10 digitos")
    private String telefono;

    @NotNull
    @Digits(integer = 4, fraction = 0, message = "La clave debe tener 4 digitos")
    private Integer clave;

    @NotNull
    private Boolean estado;

    public ClienteDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
        return "ClienteDto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", genero=" + genero +
                ", edad=" + edad +
                ", identificacion='" + identificacion + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", clave=" + clave +
                ", estado=" + estado +
                '}';
    }

    @Serial
    private static final long serialVersionUID = 3809228335220853768L;
}
