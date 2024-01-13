package com.devsu.cuenta.service;

import com.devsu.cuenta.model.Cuenta;
import com.devsu.cuenta.model.dto.CuentaDto;

import java.util.List;
import java.util.Optional;

public interface CuentaService {

    /**
     * Guarda a una cuenta nuevo
     *
     * @param cuentaDto cuenta a guardar
     */
    void agregarCuenta(CuentaDto cuentaDto);

    /**
     * Actualiza una cuenta por id
     *
     * @param id id de cuenta
     * @param cuentaDto objeto a actualizar
     */
    void actualizarCuenta(Long id, CuentaDto cuentaDto);

    /**
     * Elimina una cuenta
     * @param id id de la cuenta
     */
    void eliminarCuenta(Long id);

    /**
     * Retorna una cuenta por id o un optional vacio si no existe un registro
     *
     * @param id de la cuenta
     * @return Optional de la cuenta
     */
    Optional<Cuenta> encontrarPorId(Long id);

    /**
     * Retorna todas las cuentas registrados
     *
     * @return lista de cuentas
     */
    List<CuentaDto> encontrarTodos();
}
