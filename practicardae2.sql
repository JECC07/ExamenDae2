CREATE TABLE Correlativo (
    id_correlativo SERIAL PRIMARY KEY,
    ultimo_numero INT NOT NULL
);

CREATE TABLE Genero (
    id_genero SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);

CREATE TABLE Pais (
    id_pais SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);

CREATE TABLE Clasificacion (
    id_clasificacion SERIAL PRIMARY KEY,
    nombre VARCHAR(10) NOT NULL,
    descripcion VARCHAR(200)
);

CREATE TABLE Pelicula (
    codigo VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    id_genero INT REFERENCES Genero(id_genero),
    anio INT CHECK (anio >= 1888),
    id_pais INT REFERENCES Pais(id_pais),
    duracion_min INT CHECK (duracion_min > 0),
    id_clasificacion INT REFERENCES Clasificacion(id_clasificacion),
    audiencia_recomendada VARCHAR(100),
    idioma_original VARCHAR(50),
    fecha_estreno DATE,
    productor VARCHAR(100),
    estado boolean
);

drop table pelicula
INSERT INTO Clasificacion (nombre, descripcion) VALUES
('G', 'Apta para todo público'),
('PG', 'Supervisión de los padres sugerida'),
('PG-13', 'Apta para mayores de 13 años'),
('R', 'Restringida: menores deben ir acompañados de un adulto'),
('NC-17', 'Solo para adultos mayores de 17 años');

INSERT INTO Pais (nombre) VALUES
('Estados Unidos'),
('Francia'),
('Japón'),
('México'),
('Perú');

INSERT INTO Genero (nombre) VALUES
('Acción'),
('Comedia'),
('Drama'),
('Ciencia Ficción'),
('Terror');

select * from pelicula;
