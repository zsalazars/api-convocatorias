package com.convocatorias.apiconvocatorias.controllers;

import com.convocatorias.apiconvocatorias.dto.AplicanteDTO;
import com.convocatorias.apiconvocatorias.services.AplicanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aplicantes")
@RequiredArgsConstructor
public class AplicanteController {

    private AplicanteService aplicanteService;

    @GetMapping
    public ResponseEntity<List<AplicanteDTO>> getAllAplicantes() {
        return ResponseEntity.ok(aplicanteService.getAllAplicantes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AplicanteDTO> getAplicanteById(@PathVariable Long id) {
        return ResponseEntity.ok(aplicanteService.getAplicanteById(id));
    }

    @PostMapping
    public ResponseEntity<AplicanteDTO> createAplicante(@RequestBody AplicanteDTO aplicanteDTO) {
        AplicanteDTO createdAplicante = aplicanteService.createAplicante(aplicanteDTO);
        return ResponseEntity.ok(createdAplicante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AplicanteDTO> updateAplicante(@PathVariable Long id, @RequestBody AplicanteDTO aplicanteDTO) {
        AplicanteDTO updatedAplicante = aplicanteService.updateAplicante(id, aplicanteDTO);
        return ResponseEntity.ok(updatedAplicante);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAplicante(@PathVariable Long id) {
        aplicanteService.deleteAplicante(id);
        return ResponseEntity.noContent().build();
    }
}
