package com.devsu.cuenta.controller;

import com.devsu.cuenta.model.dto.CuentaDto;
import com.devsu.cuenta.model.dto.ReporteEstadoDto;
import com.devsu.cuenta.service.CuentaService;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @PostMapping("/guardar-lista")
    @ResponseStatus(HttpStatus.CREATED)
    public void guardarTodos(@Valid @RequestBody List<CuentaDto> cuentaDtos) {
        service.agregarCuentas(cuentaDtos);
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

    @GetMapping("/reporte")
    public ResponseEntity<ReporteEstadoDto> generarReporteEstado(
            @RequestParam(name = "fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam(name = "fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,
            @RequestParam Long clienteId) {
        return ResponseEntity.ok(service.generarReporteEstado(fechaInicio, fechaFin, clienteId));
    }
}
