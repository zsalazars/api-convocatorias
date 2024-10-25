package com.convocatorias.apiconvocatorias.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "cargo")
@Data
@NoArgsConstructor
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del cargo no puede estar vacío")
    @Size(max = 100, message = "El nombre del cargo no puede tener más de 100 caracteres")
    @Column(name = "nombre_cargo", nullable = false)
    private String nombreCargo;

    @Size(max = 255, message = "Los requisitos de estudios no pueden tener más de 255 caracteres")
    @Column(name = "requisitos_estudios")
    private String requisitosEstudios;

    @Size(max = 255, message = "Los requisitos de experiencia no pueden tener más de 255 caracteres")
    @Column(name = "requisitos_experiencia")
    private String requisitosExperiencia;

    @OneToMany(mappedBy = "cargo")
    private List<Solicitud> solicitudes;
}
