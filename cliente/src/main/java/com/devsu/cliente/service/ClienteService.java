package com.devsu.cliente.service;

import com.devsu.cliente.model.dto.ClienteDto;

import java.util.List;

public interface ClienteService {

    /**
     * Guarda a un cliente nuevo
     *
     * @param clienteDto cliente a guardar
     */
    void agregarCliente(ClienteDto clienteDto);

    /**
     * Retorna todos los clientes registrados
     *
     * @return lista de clientes
     */
    List<ClienteDto> encontrarTodos();
}
