-- En DB: parainfo de MySQL, ejecutar este script:

DROP TABLE IF EXISTS tutoriales;

-- tabla tutoriales
CREATE TABLE tutoriales(
    idtutorial	int(11) NOT NULL AUTO_INCREMENT,
    titulo	varchar(200) NOT NULL,
    tipo	varchar(20) NOT NULL,
    precio	double(10,2) NOT NULL,
    PRIMARY KEY	(idtutorial),
    UNIQUE KEY IDX_tutoriales_1 (titulo, tipo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- insertando filas
INSERT INTO tutoriales(titulo, tipo, precio) 
VALUES('Consulta Paginada con jQuery', 'Separata', 10.0);
INSERT INTO tutoriales(titulo, tipo, precio) 
VALUES('Combos Anidados con jQuery', 'Video', 10.0);
INSERT INTO tutoriales(titulo, tipo, precio) 
VALUES('Transacciones en MySQL', 'Separata', 15.0);
INSERT INTO tutoriales(titulo, tipo, precio) 
VALUES('Store Procedure en Oracle', 'Separata', 15.0);
INSERT INTO tutoriales(titulo, tipo, precio) 
VALUES('PDF con Spring', 'Video', 15.0);

