package com.devsu.cliente.service.impl;

import com.devsu.cliente.exception.NotFoundException;
import com.devsu.cliente.mapper.ClienteMapper;
import com.devsu.cliente.model.Cliente;
import com.devsu.cliente.model.dto.ClienteDto;
import com.devsu.cliente.repository.ClienteRepository;
import com.devsu.cliente.service.ClienteService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    private static final String NOT_FOUND_EXCEPTION_MESSAGE = "No se encontro el cliente con ID: %s";
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
    public void actualizarCliente(Long id, ClienteDto clienteDto) {
        encontrarPorId(id)
                .orElseThrow(() -> new NotFoundException(String.format(NOT_FOUND_EXCEPTION_MESSAGE, id)));
        clienteDto.setId(id);
        repository.save(mapper.toEntity(clienteDto));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void eliminarCliente(Long id) {
        encontrarPorId(id)
                .orElseThrow(() -> new NotFoundException(String.format(NOT_FOUND_EXCEPTION_MESSAGE, id)));
        repository.deleteById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Cliente> encontrarPorId(Long id) {
        return repository.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ClienteDto> encontrarTodos() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }
}
