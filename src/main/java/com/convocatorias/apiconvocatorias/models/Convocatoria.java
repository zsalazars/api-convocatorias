package com.convocatorias.apiconvocatorias.models;

import com.convocatorias.apiconvocatorias.models.enums.TipoConvocatoria;
import com.convocatorias.apiconvocatorias.models.enums.TipoRegion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "convocatoria")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Convocatoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_convocatoria", nullable = false)
    private int numeroConvocatoria;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_convocatoria")
    private TipoConvocatoria tipoConvocatoria;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_region")
    private TipoRegion tipoRegion;

    @Column(name = "fecha_publicacion", nullable = false)
    private String fechaPublicacion;

    @Column(name = "fecha_envio_documentos", nullable = false)
    private String fechaEnvioDocumentos;

    @Column(name = "fecha_calificacion_documentos", nullable = false)
    private String fechaCalificacionDocumentos;

    @Column(name = "fecha_publicacion_aptos", nullable = false)
    private String fechaPublicacionAptos;

    @Column(name = "fecha_horarios_entrevistas", nullable = false)
    private String fechaHorariosEntrevistas;

    @Column(name = "fecha_entrevista_personal", nullable = false)
    private String fechaEntrevistaPersonal;

    @Column(name = "fecha_publicacion_resultados", nullable = false)
    private String fechaPublicacionResultados;

    @Column(name = "fecha_inicio_funciones", nullable = false)
    private String fechaInicioFunciones;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private Status estado = Status.ABIERTO;

    @ManyToOne
    @JoinColumn(name = "solicitud_id", nullable = false)
    private Solicitud solicitud;

    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCre;

    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaAct;

    @OneToMany(mappedBy = "convocatoria", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Postulacion> postulacions;

    @PrePersist
    protected void onCreate() {
        fechaCre = LocalDateTime.now();
        fechaAct = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        fechaAct = LocalDateTime.now();
    }

    public enum Status {
        ABIERTO,
        PROCESO,
        CERRADO
    }
}