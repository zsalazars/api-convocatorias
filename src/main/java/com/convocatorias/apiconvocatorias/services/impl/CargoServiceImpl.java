package com.convocatorias.apiconvocatorias.services.impl;

import com.convocatorias.apiconvocatorias.dto.CargoDTO;
import com.convocatorias.apiconvocatorias.mappers.CargoMapper;
import com.convocatorias.apiconvocatorias.models.Cargo;
import com.convocatorias.apiconvocatorias.repositories.CargoRepository;
import com.convocatorias.apiconvocatorias.services.CargoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // Lombok generará un constructor que toma como argumento todas las variables finales
public class CargoServiceImpl implements CargoService {

    private final CargoRepository cargoRepository;
    private final CargoMapper cargoMapper;

    @Override
    public List<CargoDTO> getAllCargos() {
        return cargoRepository.findAll().stream()
                .map(cargoMapper::convertToDTO)
                .toList();
    }

    @Override
    public CargoDTO getCargoById(Long id) {
        Cargo cargo = cargoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cargo no encontrado"));
        return cargoMapper.convertToDTO(cargo);
    }

    @Override
    public CargoDTO createCargo(CargoDTO cargoDTO) {
        Cargo cargo = cargoMapper.convertToEntity(cargoDTO);
        Cargo savedCargo = cargoRepository.save(cargo);
        return cargoMapper.convertToDTO(savedCargo);
    }

    @Override
    public CargoDTO updateCargo(Long id, CargoDTO cargoDTO) {
        Cargo cargo = cargoMapper.convertToEntity(cargoDTO);
        cargo.setId(id);
        Cargo updatedCargo = cargoRepository.save(cargo);
        return cargoMapper.convertToDTO(updatedCargo);
    }

    @Override
    public void deleteCargo(Long id) { cargoRepository.deleteById(id); }

    @Override
    public boolean existsById(Long id) { return cargoRepository.existsById(id); }

}
