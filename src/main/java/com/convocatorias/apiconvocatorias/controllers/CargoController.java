package com.convocatorias.apiconvocatorias.controllers;

import com.convocatorias.apiconvocatorias.dto.CargoDTO;
import com.convocatorias.apiconvocatorias.services.CargoService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CargoController {

    private static final String ERROR_SERVER_MESSAGE = "Error interno del servidor";
    private static final String NOT_FOUND_MESSAGE = "Cargo no encontrado con el ID: ";

    private final CargoService cargoService;

    @GetMapping(value = "cargos")
    public ResponseEntity<Object> getAllCargos() {
        try {
            List<CargoDTO> cargos = cargoService.getAllCargos();
            return ResponseEntity.ok(cargos);
        } catch (DataAccessException ex) {
            return ResponseEntity.status(500).body(ERROR_SERVER_MESSAGE);
        }
    }

    @GetMapping(value = "cargos/{id}")
    public ResponseEntity<Object> getCargoById(@PathVariable Long id) {
        try {
            CargoDTO cargo = cargoService.getCargoById(id);

            if (cargo == null) {
                return ResponseEntity.status(404).body(NOT_FOUND_MESSAGE + id);
            }

            return ResponseEntity.ok(cargo);
        } catch (DataAccessException err) {
            return ResponseEntity.status(500).body(ERROR_SERVER_MESSAGE);
        }
    }

    @PostMapping(value = "cargos")
    public ResponseEntity<Object> createCargo(@RequestBody CargoDTO cargoDTO) {
        try {
            CargoDTO createdCargo = cargoService.createCargo(cargoDTO);
            return ResponseEntity.status(201).body(createdCargo);
        } catch (DataAccessException ex) {
            return ResponseEntity.status(500).body(ERROR_SERVER_MESSAGE);
        }
    }

    @PutMapping(value = "cargos/{id}")
    public ResponseEntity<Object> updateCargo(@PathVariable Long id, @RequestBody CargoDTO cargoDTO) {
        try {
            if (cargoService.existsById(id)) {
                CargoDTO updatedCargo = cargoService.updateCargo(id, cargoDTO);
                return ResponseEntity.ok(updatedCargo);
            }
            return ResponseEntity.status(404).body(NOT_FOUND_MESSAGE + id);
        } catch (DataAccessException ex) {
            return ResponseEntity.status(500).body(ERROR_SERVER_MESSAGE);
        }
    }

    @DeleteMapping(value = "cargos/{id}")
    public ResponseEntity<Object> deleteCargo(@PathVariable Long id) {
        try {
            if (cargoService.existsById(id)) {
                cargoService.deleteCargo(id);
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.status(404).body(NOT_FOUND_MESSAGE + id);
        } catch (DataAccessException ex) {
            return ResponseEntity.status(500).body(ERROR_SERVER_MESSAGE);
        }
    }
}
