package com.devsu.cuenta.model.dto;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class ReporteEstadoDto implements Serializable {

    private String nombre;

    List<CuentaDto> cuentas;

    public ReporteEstadoDto(){}

    public ReporteEstadoDto(String nombre, List<CuentaDto> cuentas) {
        this.nombre = nombre;
        this.cuentas = cuentas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<CuentaDto> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<CuentaDto> cuentas) {
        this.cuentas = cuentas;
    }

    @Override
    public String toString() {
        return "ReporteEstadoDto{" +
                "nombre='" + nombre + '\'' +
                ", cuentas=" + cuentas +
                '}';
    }

    @Serial
    private static final long serialVersionUID = 4161570579183018982L;
}
