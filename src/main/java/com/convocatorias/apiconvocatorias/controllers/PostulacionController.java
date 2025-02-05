package com.convocatorias.apiconvocatorias.controllers;

import com.convocatorias.apiconvocatorias.dto.PostulacionDTO;
import com.convocatorias.apiconvocatorias.services.PostulacionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostulacionController {

    private static final String ERROR_SERVER_MESSAGE = "Error interno del servidor";
    private static final String NOT_FOUND_MESSAGE = "Solicitud no encontrada con el ID: ";

    private final PostulacionService postulacionService;

    private final ObjectMapper objectMapper; // Para convertir el JSON string a objeto

    @GetMapping("postulaciones")
    public ResponseEntity<Object> getAllPostulaciones() {
        try {
            List<PostulacionDTO> postulaciones = postulacionService.getAllPostulaciones();
            return ResponseEntity.ok(postulaciones);
        } catch (DataAccessException err) {
            return ResponseEntity.status(500).body(ERROR_SERVER_MESSAGE);
        }
    }

    @GetMapping("postulaciones/{id}")
    public ResponseEntity<Object> getPostulacionById(@PathVariable Long id) {
        try {
            PostulacionDTO postulacion = postulacionService.getPostulacionById(id);

            if (postulacion == null) {
                return ResponseEntity.status(404).body(NOT_FOUND_MESSAGE + id);
            }

            return ResponseEntity.ok(postulacion);
        } catch (DataAccessException err) {
            return ResponseEntity.status(500).body(ERROR_SERVER_MESSAGE);
        }
    }

    @GetMapping("postulaciones/convocatorias/{convocatoriaId}")
    public ResponseEntity<Object> getPostulacionesByConvocatoria(@PathVariable Long convocatoriaId) {
        List<PostulacionDTO> postulaciones = postulacionService.getPostulacionesByConvocatoria(convocatoriaId);
        return ResponseEntity.ok(postulaciones);
    }

    @PostMapping(
            value = "postulaciones",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public ResponseEntity<Object> createPostulacion(
            @RequestParam("model") String model,
            @RequestParam(value = "file", required = false) MultipartFile file) throws JsonProcessingException {

            // Convertir el JSON string a PostulacionDTO
            PostulacionDTO postulacionDTO = objectMapper.readValue(model, PostulacionDTO.class);

            // Establecer el archivo
            if (file != null && !file.isEmpty()) {
                postulacionDTO.setDocumento(file);
            } else {
                return ResponseEntity.badRequest().body("ERROR EN EL ENVIO DEL DOCUMENTO");
            }

            // Crear la postulacion
            PostulacionDTO createdPostulacion = postulacionService.createPostulacion(postulacionDTO);
            return ResponseEntity.ok(createdPostulacion);
    }

    @PutMapping("postulaciones/{id}")
    public ResponseEntity<Object> updatePostulacion(@PathVariable Long id, @RequestBody PostulacionDTO postulacionDTO) {
        try {
            if (postulacionService.existsById(id)) {
                PostulacionDTO updatedPostulacion = postulacionService.updatePostulacion(id, postulacionDTO);
                return ResponseEntity.ok(updatedPostulacion);
            }
            return ResponseEntity.status(404).body(NOT_FOUND_MESSAGE + id);
        } catch (DataAccessException ex) {
            return ResponseEntity.status(500).body(ERROR_SERVER_MESSAGE);
        }
    }
}
