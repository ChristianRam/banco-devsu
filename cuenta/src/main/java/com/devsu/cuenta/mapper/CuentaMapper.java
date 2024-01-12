package com.devsu.cuenta.mapper;

import com.devsu.cuenta.model.Cuenta;
import com.devsu.cuenta.model.dto.CuentaDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CuentaMapper {


    CuentaDto toDto(Cuenta cuenta);

    Cuenta toEntity(CuentaDto cuentaDto);
}
