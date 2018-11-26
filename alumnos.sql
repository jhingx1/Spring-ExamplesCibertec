-- En DB: parainfo de MySQL, ejecutar este script:

DROP TABLE IF EXISTS alumnos;

-- tabla alumnos
CREATE TABLE alumnos(
    idalumno	int(11) NOT NULL AUTO_INCREMENT,
    nombre	varchar(200) NOT NULL,
    correo	varchar(20) NOT NULL,
    telefono	varchar(20) NOT NULL,
    PRIMARY KEY	(idalumno),
    UNIQUE KEY IDX_alumnos_1 (nombre)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- insertando filas
INSERT INTO alumnos(nombre, correo, telefono) 
VALUES('Consulta', 'Separata@gmail.com', '999999');



