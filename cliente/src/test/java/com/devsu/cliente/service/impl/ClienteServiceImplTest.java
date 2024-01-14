package com.devsu.cliente.service.impl;


import com.devsu.cliente.exception.NotFoundException;
import com.devsu.cliente.mapper.ClienteMapper;
import com.devsu.cliente.model.dto.ClienteDto;
import com.devsu.cliente.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ClienteServiceImplTest {

    @Mock
    private ClienteRepository repository;

    @Mock
    private ClienteMapper clienteMapper;

    @InjectMocks
    private ClienteServiceImpl clienteService;

    @Test
    void dadoUnClienteIdInexistente_CuandoLlameElMetodoActualizarCliente_LuegoRetornaNotFoundException() {
        when(repository.findById(any())).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> clienteService.actualizarCliente(1L, new ClienteDto()));

        verify(repository).findById(any());
    }
}