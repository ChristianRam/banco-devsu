package com.devsu.cuenta.client;

import com.devsu.cuenta.model.dto.ClienteDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "cliente")
public interface ClienteFeignClient {
    @GetMapping("/api/clientes/{id}")
    ResponseEntity<Optional<ClienteDto>> encontrarPorId(@PathVariable Long id);
}
