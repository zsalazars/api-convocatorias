package com.convocatorias.apiconvocatorias.services;

import com.convocatorias.apiconvocatorias.dto.CargoDTO;
import com.convocatorias.apiconvocatorias.models.Cargo;
import com.convocatorias.apiconvocatorias.repositories.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    public List<CargoDTO> getAllCargos() {
        return cargoRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public Optional<CargoDTO> getCargoById(Long id) {
        return cargoRepository.findById(id).map(this::convertToDTO);
    }

    public CargoDTO createCargo(CargoDTO cargoDTO) {
        Cargo cargo = convertToEntity(cargoDTO);
        Cargo savedCargo = cargoRepository.save(cargo);
        return convertToDTO(savedCargo);
    }

    public CargoDTO updateCargo(Long id, CargoDTO cargoDTO) {
        Cargo cargo = convertToEntity(cargoDTO);
        cargo.setId(id); // Asegúrate de establecer el ID
        Cargo updatedCargo = cargoRepository.save(cargo);
        return convertToDTO(updatedCargo);
    }

    public void deleteCargo(Long id) {
        cargoRepository.deleteById(id);
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
