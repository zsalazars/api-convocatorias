package com.convocatorias.apiconvocatorias.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "solicitud")
@Data
@NoArgsConstructor
public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String documento;

    @Column(name = "dependencia_id", nullable = false)
    private Integer dependenciaId;

    @Column(nullable = false)
    private String proveedor;

    @Column(name = "cargo_id", nullable = false)
    private Integer cargoId;

    @Column(name = "fecha_solicitud", nullable = false)
    private LocalDate fechaSolicitud;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status = Status.NUEVO;

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

    // Enum para el estado
    public enum Status {
        REINGRESO,
        NUEVO
    }
}
