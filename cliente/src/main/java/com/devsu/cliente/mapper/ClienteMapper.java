package com.devsu.cliente.mapper;


import com.devsu.cliente.model.Cliente;
import com.devsu.cliente.model.dto.ClienteDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {


    ClienteDto toDto(Cliente cliente);

    Cliente toEntity(ClienteDto cliente);
}
