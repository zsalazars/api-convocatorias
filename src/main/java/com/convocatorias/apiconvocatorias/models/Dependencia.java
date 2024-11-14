package com.convocatorias.apiconvocatorias.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "dependencia")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dependencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_dependencia")
    private String nombreDependencia;

    @OneToMany(mappedBy = "dependencia")
    @JsonIgnore
    private List<Solicitud> solicitudes;
}