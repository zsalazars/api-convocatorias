package com.convocatorias.apiconvocatorias.services.impl;

import com.convocatorias.apiconvocatorias.dto.CargoDTO;
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

    @Override
    public List<CargoDTO> getAllCargos() {
        return cargoRepository.findAll().stream()
                .map(this::convertToDTO)
                .toList();
    }

    @Override
    public CargoDTO getCargoById(Long id) {
        Cargo cargo = cargoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aplicante no encontrado"));
        return convertToDTO(cargo);
    }

    @Override
    public CargoDTO createCargo(CargoDTO cargoDTO) {
        Cargo cargo = convertToEntity(cargoDTO);
        Cargo savedCargo = cargoRepository.save(cargo);
        return convertToDTO(savedCargo);
    }

    @Override
    public CargoDTO updateCargo(Long id, CargoDTO cargoDTO) {
        Cargo cargo = convertToEntity(cargoDTO);
        cargo.setId(id);
        Cargo updatedCargo = cargoRepository.save(cargo);
        return convertToDTO(updatedCargo);
    }

    @Override
    public void deleteCargo(Long id) {
        cargoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return cargoRepository.existsById(id);
    }

    private CargoDTO convertToDTO(Cargo cargo) {
        CargoDTO cargoDTO = new CargoDTO();
        cargoDTO.setId(cargo.getId());
        cargoDTO.setNombreCargo(cargo.getNombreCargo());
        cargoDTO.setRequisitosEstudios(cargo.getRequisitosEstudios());
        cargoDTO.setRequisitosExperiencia(cargo.getRequisitosExperiencia());
        return cargoDTO;
    }

    private Cargo convertToEntity(CargoDTO cargoDTO) {
        Cargo cargo = new Cargo();
        cargo.setNombreCargo(cargoDTO.getNombreCargo());
        cargo.setRequisitosEstudios(cargoDTO.getRequisitosEstudios());
        cargo.setRequisitosExperiencia(cargoDTO.getRequisitosExperiencia());
        return cargo;
    }
}
