package com.devsu.cuenta.service;

import com.devsu.cuenta.model.dto.CuentaDto;

import java.util.List;

public interface CuentaService {

    /**
     * Guarda a una cuenta nuevo
     *
     * @param cuentaDto cuenta a guardar
     */
    void agregarCuenta(CuentaDto cuentaDto);

    /**
     * Retorna todas las cuentas registrados
     *
     * @return lista de cuentas
     */
    List<CuentaDto> encontrarTodos();
}
