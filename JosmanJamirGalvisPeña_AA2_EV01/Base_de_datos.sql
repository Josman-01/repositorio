CREATE DATABASE base_proyecto;

USE base_proyecto;

CREATE TABLE registro (
	id_registro INT NOT NULL AUTO_INCREMENT,
    usuario VARCHAR(25) NOT NULL,
    correo_electronico VARCHAR(30) NOT NULL,
    contraseña VARCHAR (20) NOT NULL,
    PRIMARY KEY(id_registro)
)ENGINE=INNODB;

CREATE TABLE usuario (
	id_admin INT NOT NULL AUTO_INCREMENT,
    administrador VARCHAR(25) NOT NULL,
    contraseña VARCHAR (20) NOT NULL,
    PRIMARY KEY(id_admin)
)ENGINE=INNODB;