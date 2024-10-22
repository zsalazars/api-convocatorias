package com.convocatorias.apiconvocatorias.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cargo") // Nombre de la tabla en la base de datos
@Data // Genera automáticamente los getters, setters, toString, hashCode y equals
@NoArgsConstructor // Genera un constructor sin argumentos
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Estrategia para la generación del ID
    private Long id;

    @Column(name = "nombre_cargo")
    private String nombreCargo;

    @Column(name = "requisitos_estudios")
    private String requisitosEstudios;

    @Column(name = "requisitos_experiencia")
    private String requisitosExperiencia;

}
