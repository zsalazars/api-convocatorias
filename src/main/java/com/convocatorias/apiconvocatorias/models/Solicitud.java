package com.convocatorias.apiconvocatorias.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "solicitud")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_documento", nullable = false)
    private String nombreDocumento;

    @Column(nullable = false)
    private String proveido;

    @Column(name = "fecha_solicitud", nullable = false)
    private LocalDate fechaSolicitud;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status estado = Status.NUEVO;

    @ManyToOne
    @JoinColumn(name = "dependencia_id", nullable = false)
    private Dependencia dependencia;

    @ManyToOne
    @JoinColumn(name = "cargo_id", nullable = false)
    private Cargo cargo;

    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCre;

    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaAct;

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
        REINGRESO,
        NUEVO
    }
}