package com.devsu.cliente.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity(name = "personas")
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona implements Serializable {

    @Serial
    private static final long serialVersionUID = -6875537261064380618L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "persona_id", nullable = false, unique = true, updatable = false)
    private Long id;
    @Column(length = 50, nullable = false)
    private String nombre;
    @Enumerated(value = EnumType.STRING)
    @Column(length = 30, nullable = false)
    private Genero genero;
    @Column(length = 3, nullable = false)
    private Integer edad;
    @Column(length = 10, nullable = false)
    private String identificacion;
    @Column(length = 45, nullable = false)
    private String direccion;
    @Column(length = 10, nullable = false)
    private String telefono;

    public Persona() {
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

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", genero=" + genero +
                ", edad=" + edad +
                ", identificacion='" + identificacion + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
