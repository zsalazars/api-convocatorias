package com.convocatorias.apiconvocatorias.models;

import com.convocatorias.apiconvocatorias.utils.StringListConverter;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "calificacion_requisitos")
@Data
@NoArgsConstructor
public class CalificacionRequisitos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Convert(converter = StringListConverter.class)
    @Column(name = "requisitos_estudios_cumplidos", columnDefinition = "text")
    private List<String> requisitosEstudiosCumplidos = new ArrayList<>();

    @Convert(converter = StringListConverter.class)
    @Column(name = "requisitos_estudios_nocumplidos", columnDefinition = "text")
    private List<String> requisitosEstudiosNoCumplidos = new ArrayList<>();

    @Convert(converter = StringListConverter.class)
    @Column(name = "requisitos_experiencia_cumplidos", columnDefinition = "text")
    private List<String> requisitosExperienciaCumplidos = new ArrayList<>();

    @Convert(converter = StringListConverter.class)
    @Column(name = "requisitos_experiencia_nocumplidos", columnDefinition = "text")
    private List<String> requisitosExperienciaNoCumplidos = new ArrayList<>();

    private String observaciones = "";

    @OneToOne(mappedBy = "calificacionRequisitos")
    private Postulacion postulacion;
}
