package com.convocatorias.apiconvocatorias.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.net.MalformedURLException;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class FileController {

    @GetMapping(value = "/media/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Path filePath = Paths.get("media/" + filename);
        try {
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists() && resource.isReadable()) {
                String contentType = Files.probeContentType(filePath); // Detectar el tipo de archivo automáticamente
                if (contentType == null) {
                    contentType = MediaType.APPLICATION_OCTET_STREAM_VALUE; // Tipo genérico por si no se detecta
                }

                return ResponseEntity.ok()
                        .contentType(MediaType.valueOf(contentType)) // Usar el tipo de contenido correcto
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (MalformedURLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
