-- V1__CrearTablasIniciales.sql

CREATE TABLE Perfil (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        nombre VARCHAR(255) NOT NULL
);

CREATE TABLE Usuario (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         nombre VARCHAR(255) NOT NULL,
                         correoElectronico VARCHAR(255) NOT NULL UNIQUE,
                         contrasena VARCHAR(255) NOT NULL
);

CREATE TABLE Curso (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       nombre VARCHAR(255) NOT NULL,
                       categoria VARCHAR(255) NOT NULL
);

CREATE TABLE Topico (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        titulo VARCHAR(255) NOT NULL,
                        mensaje TEXT NOT NULL,
                        fechaCreacion DATETIME NOT NULL,
                        status VARCHAR(255) NOT NULL
);

CREATE TABLE Respuesta (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           mensaje TEXT NOT NULL,
                           fechaCreacion DATETIME NOT NULL,
                           solucion BOOLEAN
);

-- V2__AgregarRelaciones.sql

-- Agregar las columnas de relación
ALTER TABLE Perfil ADD COLUMN usuario_id INT UNIQUE;
ALTER TABLE Usuario ADD COLUMN perfil_id INT UNIQUE;
ALTER TABLE Topico ADD COLUMN autor INT;
ALTER TABLE Topico ADD COLUMN curso INT;
ALTER TABLE Respuesta ADD COLUMN topico INT;
ALTER TABLE Respuesta ADD COLUMN autor INT;

-- Crear las relaciones
ALTER TABLE Perfil ADD CONSTRAINT FK_Perfil_Usuario FOREIGN KEY (usuario_id) REFERENCES Usuario(id);
ALTER TABLE Usuario ADD CONSTRAINT FK_Usuario_Perfil FOREIGN KEY (perfil_id) REFERENCES Perfil(id);
ALTER TABLE Topico ADD CONSTRAINT FK_Topico_Autor FOREIGN KEY (autor) REFERENCES Usuario(id);
ALTER TABLE Topico ADD CONSTRAINT FK_Topico_Curso FOREIGN KEY (curso) REFERENCES Curso(id);
ALTER TABLE Respuesta ADD CONSTRAINT FK_Respuesta_Topico FOREIGN KEY (topico) REFERENCES Topico(id);
ALTER TABLE Respuesta ADD CONSTRAINT FK_Respuesta_Autor FOREIGN KEY (autor) REFERENCES Usuario(id);
