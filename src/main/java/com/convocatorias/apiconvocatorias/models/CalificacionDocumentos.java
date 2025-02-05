package com.convocatorias.apiconvocatorias.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "calificacion_documentos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalificacionDocumentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "datos_generales", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean datosGenerales = false;

    @Column(name = "titulos_certificados", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean titulosCertificados = false;

    @Column(name = "reporte_sunedu", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean reporteSunedu = false;

    @Column(name = "cursos_especializacion", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean cursosEspecializacion = false;

    @Column(name = "experiencia_laboral", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean experienciaLaboral = false;

    @Column(name = "declaracion_jurada_horario", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean declaracionJuradaHorario = false;

    @Column(name = "declaracion_jurada_parentesco", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean declaracionJuradaParentesco = false;

    @Column(name = "declaracion_jurada_antecedentes", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean declaracionJuradaAntecedentes = false;

    @Column(name = "certiadulto", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean certiadulto = false;

    @Column(name = "carnet_vacunacion", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean carnetVacunacion = false;

    @Column(name = "voucher_pago", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean voucherPago = false;

    private String observaciones = "";

    @OneToOne(mappedBy = "calificacionDocumentos")
    private Postulacion postulacion;
}
