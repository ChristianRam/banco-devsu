package com.devsu.cuenta.service;

import com.devsu.cuenta.model.dto.MovimientoDto;

import java.util.List;
import java.util.Optional;

public interface MovimientoService {

    /**
     * Guarda un movimiento nuevo
     *
     * @param movimientoDto movimiento a guardar
     */
    void agregarMovimiento(MovimientoDto movimientoDto);

    /**
     * Actualiza un movimiento por id
     *
     * @param id id del movimiento
     * @param movimientoDto objeto a actualizar
     */
    void actualizarMovimiento(Long id, MovimientoDto movimientoDto);

    /**
     * Elimina un movimiento
     * @param id id del movimiento
     */
    void eliminarMovimiento(Long id);

    /**
     * Retorna un movimiento por id o un optional vacio si no existe un registro
     *
     * @param id del movimiento
     * @return Optional del movimiento
     */
    Optional<MovimientoDto> encontrarPorId(Long id);

    /**
     * Retorna todos los movimientos registrados
     *
     * @return lista de movimientos
     */
    List<MovimientoDto> encontrarTodos();
}
