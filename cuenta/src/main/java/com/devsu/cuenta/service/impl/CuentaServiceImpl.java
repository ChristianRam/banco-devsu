package com.devsu.cuenta.service.impl;

import com.devsu.cuenta.mapper.CuentaMapper;
import com.devsu.cuenta.model.dto.CuentaDto;
import com.devsu.cuenta.repository.CuentaRepository;
import com.devsu.cuenta.service.CuentaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaServiceImpl implements CuentaService {

    private final CuentaRepository repository;
    private final CuentaMapper mapper;

    public CuentaServiceImpl(CuentaRepository repository, CuentaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void agregarCuenta(CuentaDto cuentaDto) {
        repository.save(mapper.toEntity(cuentaDto));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CuentaDto> encontrarTodos() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }
}
