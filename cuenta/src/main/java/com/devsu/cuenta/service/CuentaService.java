package com.devsu.cuenta.service;

import com.devsu.cuenta.model.dto.CuentaDto;
import com.devsu.cuenta.model.dto.ReporteEstadoDto;

import java.time.LocalDate;
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
     * Guarda una lista de cuentas
     *
     * @param cuentaDtos cuentas a guardar
     */
    void agregarCuentas(List<CuentaDto> cuentaDtos);

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
    Optional<CuentaDto> encontrarPorId(Long id);

    /**
     * Retorna todas las cuentas registrados
     *
     * @return lista de cuentas
     */
    List<CuentaDto> encontrarTodos();

    /**
     * Genera un reporte con la informacion de cuentas y movimientos por cuentas de un cliente
     *
     * @param fechaInicio rango de fecha inicial a obtener movimientos
     * @param fechaFin rango de fecha final a obtener movimientos
     * @param clienteId id del cliente
     * @return reporte con los datos necesarios
     */
    ReporteEstadoDto generarReporteEstado(LocalDate fechaInicio, LocalDate fechaFin, Long clienteId);
}
