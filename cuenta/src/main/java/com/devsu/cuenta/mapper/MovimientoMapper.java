package com.devsu.cuenta.mapper;

import com.devsu.cuenta.model.Cuenta;
import com.devsu.cuenta.model.Movimiento;
import com.devsu.cuenta.model.dto.MovimientoDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface MovimientoMapper {

    @Mapping(source = "cuenta.id", target = "cuentaId")
    MovimientoDto toDto(Movimiento movimiento);

    @Mapping(source = "cuentaId", target = "cuenta", qualifiedByName = "mapCuentaIdToCuenta")
    Movimiento toEntity(MovimientoDto movimientoDto);


    @Named("mapCuentaIdToCuenta")
    default Cuenta mapCuentaIdToCuenta(Long cuentaId) {
        if (cuentaId == null) {
            return null;
        }
        Cuenta cuenta = new Cuenta();
        cuenta.setId(cuentaId);
        return cuenta;
    }

}
