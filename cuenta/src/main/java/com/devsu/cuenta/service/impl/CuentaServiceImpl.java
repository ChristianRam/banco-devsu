package com.devsu.cuenta.service.impl;

import com.devsu.cuenta.client.ClienteFeignClient;
import com.devsu.cuenta.exception.NotFoundException;
import com.devsu.cuenta.mapper.CuentaMapper;
import com.devsu.cuenta.model.Cuenta;
import com.devsu.cuenta.model.dto.CuentaDto;
import com.devsu.cuenta.repository.CuentaRepository;
import com.devsu.cuenta.service.CuentaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CuentaServiceImpl implements CuentaService {

    private static final String CUENTA_NOT_FOUND_EXCEPTION_MESSAGE = "No se encontro la cuenta con ID: %s";
    private static final String CLIENTE_NOT_FOUND_EXCEPTION_MESSAGE = "No se encontro el cliente con ID: %s";

    private final CuentaRepository repository;
    private final CuentaMapper mapper;

    private final ClienteFeignClient client;

    public CuentaServiceImpl(CuentaRepository repository, CuentaMapper mapper, ClienteFeignClient client) {
        this.repository = repository;
        this.mapper = mapper;
        this.client = client;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void agregarCuenta(CuentaDto cuentaDto) {

        Objects.requireNonNull(client.encontrarPorId(cuentaDto.getClienteId()).getBody())
                .orElseThrow(() -> new NotFoundException(String.format(CLIENTE_NOT_FOUND_EXCEPTION_MESSAGE,
                        cuentaDto.getClienteId())));
        repository.save(mapper.toEntity(cuentaDto));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void actualizarCuenta(Long id, CuentaDto cuentaDto) {
        encontrarPorId(id)
                .orElseThrow(() -> new NotFoundException(String.format(CUENTA_NOT_FOUND_EXCEPTION_MESSAGE, id)));
        cuentaDto.setId(id);
        repository.save(mapper.toEntity(cuentaDto));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void eliminarCuenta(Long id) {
        encontrarPorId(id)
                .orElseThrow(() -> new NotFoundException(String.format(CUENTA_NOT_FOUND_EXCEPTION_MESSAGE, id)));
        repository.deleteById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<CuentaDto> encontrarPorId(Long id) {
        return repository.findById(id).map(mapper::toDto);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CuentaDto> encontrarTodos() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }
}
