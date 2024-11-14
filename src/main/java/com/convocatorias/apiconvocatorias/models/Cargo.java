package com.convocatorias.apiconvocatorias.models;

import com.convocatorias.apiconvocatorias.utils.StringListConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "cargo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del cargo no puede estar vacío")
    @Size(max = 100, message = "El nombre del cargo no puede tener más de 100 caracteres")
    @Column(name = "nombre_cargo", nullable = false)
    private String nombreCargo;

    @Convert(converter = StringListConverter.class)
    @Column(name = "requisitos_estudios", columnDefinition = "text")
    private List<String> requisitosEstudios;

    @Convert(converter = StringListConverter.class)
    @Column(name = "requisitos_experiencia", columnDefinition = "text")
    private List<String> requisitosExperiencia;

    @OneToMany(mappedBy = "cargo")
    @JsonIgnore
    private List<Solicitud> solicitudes;
}