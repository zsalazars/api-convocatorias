package com.convocatorias.apiconvocatorias.controllers;

import com.convocatorias.apiconvocatorias.dto.ConvocatoriaDTO;
import com.convocatorias.apiconvocatorias.services.ConvocatoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ConvocatoriaController {

    private static final String ERROR_SERVER_MESSAGE = "Error interno del servidor";
    private static final String NOT_FOUND_MESSAGE = "Solicitud no encontrada con el ID: ";

    private final ConvocatoriaService convocatoriaService;

    @GetMapping(value = "convocatorias")
    public ResponseEntity<Object> getAllConvocatorias() {
        try {
            List<ConvocatoriaDTO> convocatorias = convocatoriaService.getAllConvocatorias();
            return ResponseEntity.ok(convocatorias);
        } catch (DataAccessException err) {
            return ResponseEntity.status(500).body(ERROR_SERVER_MESSAGE);
        }
    }

    @GetMapping(value = "convocatorias/{id}")
    public ResponseEntity<Object> getConvocatoriaById(@PathVariable Long id) {
        try {
            ConvocatoriaDTO convocatoria = convocatoriaService.getConvocatoriaById(id);

            if (convocatoria == null) {
                return ResponseEntity.status(404).body(NOT_FOUND_MESSAGE + id);
            }
            return ResponseEntity.ok(convocatoria);
        } catch (DataAccessException err) {
            return ResponseEntity.status(500).body(ERROR_SERVER_MESSAGE);
        }
    }

    @PostMapping(value = "convocatorias")
    public ResponseEntity<Object> createConvocatoria(@RequestBody ConvocatoriaDTO convocatoriaDTO) {
        try {
            ConvocatoriaDTO createdConvocatoria = convocatoriaService.createConvocatoria(convocatoriaDTO);
            return ResponseEntity.status(201).body(createdConvocatoria);
        } catch (DataAccessException err) {
            return ResponseEntity.status(500).body(ERROR_SERVER_MESSAGE);
        }
    }

    @PutMapping(value = "convocatorias/{id}")
    public ResponseEntity<Object> updateConvocatoria(@PathVariable Long id, @RequestBody ConvocatoriaDTO convocatoriaDTO) {
        try {
            if (convocatoriaService.existsById(id)){
                ConvocatoriaDTO updatedConvocatoria = convocatoriaService.updateConvocatoria(id, convocatoriaDTO);
                return ResponseEntity.ok(updatedConvocatoria);
            }
            return ResponseEntity.status(404).body(NOT_FOUND_MESSAGE + id);
        } catch (DataAccessException err) {
            return ResponseEntity.status(500).body(ERROR_SERVER_MESSAGE);
        }
    }

}
