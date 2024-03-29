package com.devsu.cliente.service;

import com.devsu.cliente.model.dto.ClienteDto;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    /**
     * Guarda a un cliente nuevo
     *
     * @param clienteDto cliente a guardar
     */
    void agregarCliente(ClienteDto clienteDto);

    /**
     * Guarda una lista de clientes
     *
     * @param clienteDtos clientes a guardar
     */
    void agregarClientes(List<ClienteDto> clienteDtos);

    /**
     * Actualiza a un cliente por id
     *
     * @param id id de cliente
     * @param clienteDto objeto a actualizar
     */
    void actualizarCliente(Long id, ClienteDto clienteDto);

    /**
     * Elimina a un cliente
     * @param id id del cliente
     */
    void eliminarCliente(Long id);

    /**
     * Retorna un cliente por id o un optional vacio si no existe un registro
     *
     * @param id id del cliente
     * @return Optional de la cuenta
     */
    Optional<ClienteDto> encontrarPorId(Long id);

    /**
     * Retorna todos los clientes registrados
     *
     * @return lista de clientes
     */
    List<ClienteDto> encontrarTodos();
}
