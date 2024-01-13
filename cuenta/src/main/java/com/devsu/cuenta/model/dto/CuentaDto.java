package com.devsu.cuenta.model.dto;

import com.devsu.cuenta.model.TipoCuenta;
import jakarta.validation.constraints.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class CuentaDto implements Serializable {

    private Long id;

    @NotEmpty
    @Size(max = 20, message = "El nombre no puede exceder los 20 digitos")
    private String numeroCuenta;

    @NotNull
    private TipoCuenta tipoCuenta;

    @NotNull
    @PositiveOrZero(message = "El saldo inicial debe ser igual o mayor a 0")
    private BigDecimal saldoInicial;

    @NotNull
    private Boolean estado;

    @NotNull
    private Long clienteId;

    private List<MovimientoDto> movimientos;

    public CuentaDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public BigDecimal getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(BigDecimal saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public List<MovimientoDto> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<MovimientoDto> movimientos) {
        this.movimientos = movimientos;
    }

    @Override
    public String toString() {
        return "CuentaDto{" +
                "id=" + id +
                ", numeroCuenta='" + numeroCuenta + '\'' +
                ", tipoCuenta=" + tipoCuenta +
                ", saldoInicial=" + saldoInicial +
                ", estado=" + estado +
                ", clienteId=" + clienteId +
                ", movimientos=" + movimientos +
                '}';
    }

    @Serial
    private static final long serialVersionUID = -4861018079796432111L;
}
