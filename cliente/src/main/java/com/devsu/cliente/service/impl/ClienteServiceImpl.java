package com.devsu.cliente.service.impl;

import com.devsu.cliente.mapper.ClienteMapper;
import com.devsu.cliente.model.dto.ClienteDto;
import com.devsu.cliente.repository.ClienteRepository;
import com.devsu.cliente.service.ClienteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repository;
    private final ClienteMapper mapper;

    public ClienteServiceImpl(ClienteRepository repository, ClienteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void agregarCliente(ClienteDto clienteDto) {
        repository.save(mapper.toEntity(clienteDto));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ClienteDto> encontrarTodos() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }
}
