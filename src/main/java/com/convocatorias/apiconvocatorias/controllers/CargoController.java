package com.convocatorias.apiconvocatorias.controllers;

import com.convocatorias.apiconvocatorias.dto.CargoDTO;
import com.convocatorias.apiconvocatorias.services.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cargos")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @GetMapping
    public List<CargoDTO> getAllCargos() {
        return cargoService.getAllCargos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CargoDTO> getCargoById(@PathVariable Long id) {
        return cargoService.getCargoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CargoDTO createCargo(@RequestBody CargoDTO cargoDTO) {
        return cargoService.createCargo(cargoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CargoDTO> updateCargo(@PathVariable Long id, @RequestBody CargoDTO cargoDTO) {
        return ResponseEntity.ok(cargoService.updateCargo(id, cargoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCargo(@PathVariable Long id) {
        cargoService.deleteCargo(id);
        return ResponseEntity.noContent().build();
    }

}
