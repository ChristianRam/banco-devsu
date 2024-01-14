package com.devsu.cuenta.controller;

import com.devsu.cuenta.model.dto.MovimientoDto;
import com.devsu.cuenta.service.MovimientoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movimientos")
public class MovimientoController {

    private final MovimientoService service;

    public MovimientoController(MovimientoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void guardar(@Valid @RequestBody MovimientoDto movimientoDto) {
        service.agregarMovimiento(movimientoDto);
    }

    @PostMapping("/guardar-lista")
    @ResponseStatus(HttpStatus.CREATED)
    public void guardarTodos(@Valid @RequestBody List<MovimientoDto> movimientoDtos) {
        service.agregarMovimientos(movimientoDtos);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void actualizar(@PathVariable Long id, @Valid @RequestBody MovimientoDto movimientoDto) {
        service.actualizarMovimiento(id, movimientoDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void eliminar(@PathVariable Long id) {
        service.eliminarMovimiento(id);
    }

    @GetMapping
    public ResponseEntity<List<MovimientoDto>> encontrarTodos() {
        return ResponseEntity.ok(service.encontrarTodos());
    }
}
