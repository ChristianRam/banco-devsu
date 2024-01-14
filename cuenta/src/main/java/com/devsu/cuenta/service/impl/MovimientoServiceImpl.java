package com.devsu.cuenta.service.impl;

import com.devsu.cuenta.exception.BadRequestException;
import com.devsu.cuenta.exception.NotFoundException;
import com.devsu.cuenta.mapper.MovimientoMapper;
import com.devsu.cuenta.model.TipoMovimiento;
import com.devsu.cuenta.model.dto.CuentaDto;
import com.devsu.cuenta.model.dto.MovimientoDto;
import com.devsu.cuenta.repository.MovimientoRepository;
import com.devsu.cuenta.service.CuentaService;
import com.devsu.cuenta.service.MovimientoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class MovimientoServiceImpl implements MovimientoService {

    private static final Logger log = LoggerFactory.getLogger(MovimientoServiceImpl.class);

    private static final String MOVIMIENTO_NOT_FOUND_EXCEPTION_MESSAGE = "No se encontro el movimiento con ID: %s";

    private static final String CUENTA_NOT_FOUND_EXCEPTION_MESSAGE = "No se encontro una cuenta activa con ID: %s";

    private final MovimientoRepository repository;

    private final MovimientoMapper mapper;

    private final CuentaService cuentaService;

    public MovimientoServiceImpl(MovimientoRepository repository, MovimientoMapper mapper, CuentaService cuentaService) {
        this.repository = repository;
        this.mapper = mapper;
        this.cuentaService = cuentaService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void agregarMovimiento(MovimientoDto movimientoDto) {
        log.info("Agregando un movimiento nuevo para la cuenta con ID: {}", movimientoDto.getCuentaId());

        CuentaDto cuentaDto = cuentaService.encontrarPorId(movimientoDto.getCuentaId()).filter(cuenta -> cuenta.getEstado().equals(true))
                .orElseThrow(() -> new NotFoundException(String.format(CUENTA_NOT_FOUND_EXCEPTION_MESSAGE, movimientoDto.getCuentaId())));

        validarMovimiento(movimientoDto, cuentaDto);

        BigDecimal saldoInicial = cuentaDto.getSaldoInicial();

        movimientoDto.setSaldo(saldoInicial);
        repository.save(mapper.toEntity(movimientoDto));

        log.info("Actualizando el saldo inicial de la cuenta con el ID: {}", movimientoDto.getCuentaId());

        cuentaDto.setSaldoInicial(saldoInicial.add(movimientoDto.getValor()));
        cuentaService.actualizarCuenta(cuentaDto.getId(), cuentaDto);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void agregarMovimientos(List<MovimientoDto> movimientoDtos) {
        movimientoDtos.forEach(this::agregarMovimiento);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void actualizarMovimiento(Long id, MovimientoDto movimientoDto) {
        log.info("Actualizando un movimiento nuevo para la cuenta con ID: {}", movimientoDto.getCuentaId());
        encontrarPorId(id)
                .orElseThrow(() -> new NotFoundException(String.format(MOVIMIENTO_NOT_FOUND_EXCEPTION_MESSAGE, id)));

        movimientoDto.setId(id);
        repository.save(mapper.toEntity(movimientoDto));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void eliminarMovimiento(Long id) {
        log.info("Eliminando el movimiento con el ID: {}", id);
        encontrarPorId(id)
                .orElseThrow(() -> new NotFoundException(String.format(MOVIMIENTO_NOT_FOUND_EXCEPTION_MESSAGE, id)));
        repository.deleteById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<MovimientoDto> encontrarPorId(Long id) {
        return repository.findById(id).map(mapper::toDto);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<MovimientoDto> encontrarTodos() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    private void validarMovimiento(MovimientoDto movimientoDto, CuentaDto cuentaDto) {
        TipoMovimiento tipoMovimiento = movimientoDto.getTipoMovimiento();
        BigDecimal valorMovimiento = movimientoDto.getValor();
        BigDecimal saldoInicial = cuentaDto.getSaldoInicial();

        if (valorMovimiento.compareTo(BigDecimal.ZERO) == 0) {
            throw new BadRequestException("El valor del movimiento no puede ser 0");
        }

        if (TipoMovimiento.RETIRO.equals(tipoMovimiento)) {
            if(valorMovimiento.compareTo(BigDecimal.ZERO) > 0) {
                throw new BadRequestException("El valor debe ser negativo para realizar un RETIRO");
            }

            if (saldoInicial.compareTo(valorMovimiento.abs()) < 0) {
                throw new BadRequestException("No cuenta con el saldo disponible para realizar este movimiento");
            }
        } else if (TipoMovimiento.DEPOSITO.equals(tipoMovimiento) && valorMovimiento.compareTo(BigDecimal.ZERO) < 0) {
            throw new BadRequestException("El valor debe ser positivo para realizar un DEPOSITO");
        }
    }
}
