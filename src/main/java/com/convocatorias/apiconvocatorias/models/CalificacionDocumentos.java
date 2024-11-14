package com.convocatorias.apiconvocatorias.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "calificacion_documento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalificacionDocumentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "datos_generales")
    private Boolean datosGenerales;

    @Column(name = "titulos_certificados")
    private Boolean titulosCertificados;

    @Column(name = "reporte_sunedu")
    private Boolean reporteSunedu;

    @Column(name = "cursos_especializacion")
    private Boolean cursosEspecializacion;

    @Column(name = "experiencia_laboral")
    private Boolean experienciaLaboral;

    @Column(name = "declaracion_jurada_horario")
    private Boolean declaracionJuradaHorario;

    @Column(name = "declaracion_jurada_parentesco")
    private Boolean declaracionJuradaParentesco;

    @Column(name = "declaracion_jurada_antecedentes")
    private Boolean declaracionJuradaAntecedentes;

    private Boolean certiadulto;

    @Column(name = "carnet_vacunacion")
    private Boolean carnetVacunacion;

    @Column(name = "voucher_pago")
    private Boolean voucherPago;

    private String observaciones;

    @OneToOne(mappedBy = "calificacionDocumentos")
    private Postulacion postulacion;
}
