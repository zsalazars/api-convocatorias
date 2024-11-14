package com.convocatorias.apiconvocatorias.mappers;

import com.convocatorias.apiconvocatorias.dto.CargoDTO;
import com.convocatorias.apiconvocatorias.models.Cargo;
import org.springframework.stereotype.Component;

@Component
public class CargoMapper {
    public CargoDTO convertToDTO(Cargo cargo) {
        CargoDTO cargoDTO = new CargoDTO();

        cargoDTO.setId(cargo.getId());
        cargoDTO.setNombreCargo(cargo.getNombreCargo());
        cargoDTO.setRequisitosEstudios(cargo.getRequisitosEstudios());
        cargoDTO.setRequisitosExperiencia(cargo.getRequisitosExperiencia());

        return cargoDTO;
    }

    public Cargo convertToEntity(CargoDTO cargoDTO) {
        Cargo cargo = new Cargo();

        cargo.setId(cargoDTO.getId());
        cargo.setNombreCargo(cargoDTO.getNombreCargo());
        cargo.setRequisitosEstudios(cargoDTO.getRequisitosEstudios());
        cargo.setRequisitosExperiencia(cargoDTO.getRequisitosExperiencia());

        return cargo;
    }
}
