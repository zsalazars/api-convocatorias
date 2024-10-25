package com.convocatorias.apiconvocatorias.services;

import com.convocatorias.apiconvocatorias.dto.CargoDTO;

import java.util.List;

public interface CargoService {
    List<CargoDTO> getAllCargos();
    CargoDTO getCargoById(Long id);
    CargoDTO createCargo(CargoDTO cargoDTO);
    CargoDTO updateCargo(Long id, CargoDTO cargoDTO);
    void deleteCargo(Long id);
    boolean existsById(Long id);
}
