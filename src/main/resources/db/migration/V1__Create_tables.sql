CREATE TABLE IF NOT EXISTS cargo (
    id BIGSERIAL PRIMARY KEY,
    nombre_cargo VARCHAR(255),
    requisitos_estudios TEXT,
    requisitos_experiencia TEXT
);

CREATE TABLE IF NOT EXISTS dependencia (
    id BIGSERIAL PRIMARY KEY,
    nombre_dependencia VARCHAR(255)
);

-- V2__Create_solicitud_table.sql

CREATE TABLE IF NOT EXISTS solicitud (
    id BIGSERIAL PRIMARY KEY,
    documento VARCHAR(255) NOT NULL,
    dependencia_id BIGINT NOT NULL,
    proveedor VARCHAR(255) NOT NULL,
    cargo_id BIGINT NOT NULL,
    fecha_solicitud DATE NOT NULL,
    estado VARCHAR(20) NOT NULL,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Función para actualizar la fecha de actualización
CREATE OR REPLACE FUNCTION update_fecha_actualizacion()
RETURNS TRIGGER AS $$
BEGIN
    NEW.fecha_actualizacion = CURRENT_TIMESTAMP;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Trigger para actualizar la fecha de actualización
CREATE TRIGGER set_fecha_actualizacion
BEFORE UPDATE ON solicitud
FOR EACH ROW
EXECUTE FUNCTION update_fecha_actualizacion();


