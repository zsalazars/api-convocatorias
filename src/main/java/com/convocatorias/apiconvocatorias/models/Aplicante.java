package com.convocatorias.apiconvocatorias.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "aplicante") // Nombre de la tabla en la base de datos
@Data // Genera automáticamente los getters, setters, toString, hashCode y equals
@NoArgsConstructor // Genera un constructor sin argumentos
public class Aplicante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Estrategia para la generación del ID
    private Long id;

    private String nombres;

    @Column(name = "apellido_paterno")
    private String apellidoPaterno;

    @Column(name = "apellido_materno")
    private String apellidoMaterno;

    @Column(name = "numero_celular")
    private String numeroCelular;

    @Column(name = "correo_electronico")
    private String correoElectronico;

    private String requerimientos;

    private String observaciones;

    @Column(name = "es_apto")
    private boolean esApto;

}
