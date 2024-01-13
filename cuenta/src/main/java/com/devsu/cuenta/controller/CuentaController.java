package com.devsu.cuenta.controller;

import com.devsu.cuenta.model.dto.CuentaDto;
import com.devsu.cuenta.service.CuentaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cuentas")
public class CuentaController {

    private final CuentaService service;

    public CuentaController(CuentaService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void guardar(@Valid @RequestBody CuentaDto cuentaDto) {
        service.agregarCuenta(cuentaDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void actualizar(@PathVariable Long id, @Valid @RequestBody CuentaDto cuentaDto) {
        service.actualizarCuenta(id, cuentaDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void eliminar(@PathVariable Long id) {
        service.eliminarCuenta(id);
    }

    @GetMapping
    public ResponseEntity<List<CuentaDto>> encontrarTodos() {
        return ResponseEntity.ok(service.encontrarTodos());
    }
}
