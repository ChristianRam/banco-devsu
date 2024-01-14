package com.devsu.cuenta.repository;

import com.devsu.cuenta.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long> {

    @Query(value = "SELECT c.* FROM cuentas c" +
            " JOIN movimientos m on c.cuenta_id = m.cuenta_id" +
            " WHERE c.cliente_id = ?1" +
            " AND m.fecha BETWEEN ?2 AND ?3", nativeQuery = true)
    List<Cuenta> findCuentasAndMovimientosByClienteIdAndFecha(Long clienteId, LocalDate fechaInicio, LocalDate fechaFin);
}
