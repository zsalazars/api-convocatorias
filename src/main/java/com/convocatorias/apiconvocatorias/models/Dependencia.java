package com.convocatorias.apiconvocatorias.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "dependencia")
@Data
@NoArgsConstructor
public class Dependencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_dependencia")
    private String nombreDependencia;

    @OneToMany(mappedBy = "dependencia")
    private List<Solicitud> solicitudes;
}
