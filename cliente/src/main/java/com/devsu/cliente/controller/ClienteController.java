package com.devsu.cliente.controller;

import com.devsu.cliente.model.dto.ClienteDto;
import com.devsu.cliente.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void guardar(@Valid @RequestBody ClienteDto clienteDto) {
        service.agregarCliente(clienteDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void actualizar(@PathVariable Long id, @Valid @RequestBody ClienteDto clienteDto) {
        service.actualizarCliente(id, clienteDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void eliminar(@PathVariable Long id) {
        service.eliminarCliente(id);
    }

    @GetMapping
    public ResponseEntity<List<ClienteDto>> encontrarTodos() {
        return ResponseEntity.ok(service.encontrarTodos());
    }
}
