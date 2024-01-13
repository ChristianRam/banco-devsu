package com.devsu.cuenta.model.dto;

import com.devsu.cuenta.model.TipoMovimiento;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class MovimientoDto implements Serializable {

    private Long id;

    @NotNull
    private LocalDate fecha;

    @NotNull
    private TipoMovimiento tipoMovimiento;

    @NotNull
    private BigDecimal valor;

    private BigDecimal saldo;

    @NotNull
    private Long cuentaId;

    public MovimientoDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public TipoMovimiento getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Long getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(Long cuentaId) {
        this.cuentaId = cuentaId;
    }

    @Serial
    private static final long serialVersionUID = -3976503473674705641L;
}
