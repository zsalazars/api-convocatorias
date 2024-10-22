package com.convocatorias.apiconvocatorias.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ConvocatoriaController {

    @PostMapping(value = "convocatorias")
    public String convocatoria() {
        return "Creaste una convocatoria";
    }

}
