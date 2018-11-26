DROP TABLE IF EXISTS restaurantes;
DROP TABLE IF EXISTS categorias;
DROP TABLE IF EXISTS distritos;

-- crear tablas
CREATE TABLE distritos (
    iddistrito  int(11) NOT NULL AUTO_INCREMENT,
    distrito    varchar(50) NOT NULL,

    PRIMARY KEY (iddistrito)
) ENGINE=InnoDB AUTO_INCREMENT=1338 DEFAULT CHARSET=utf8;


CREATE TABLE categorias (
    idcategoria int(11) NOT NULL AUTO_INCREMENT,
    categoria   varchar(100) NOT NULL,

    PRIMARY KEY (idcategoria),
    UNIQUE KEY IDX_categorias_1 (categoria)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE restaurantes (
    idrestaurante   int(11) NOT NULL AUTO_INCREMENT,
    idcategoria     int(11) NOT NULL,
    restaurante     varchar(200) NOT NULL,
    direccion       varchar(200) NOT NULL,
    iddistrito      int(11) NOT NULL,

    PRIMARY KEY (idrestaurante),
    UNIQUE KEY IDX_restaurantes_4 (restaurante),
    KEY FK_restaurantes_1 (idcategoria),
    KEY FK_restaurantes_2 (iddistrito),
    CONSTRAINT FK_restaurantes_1 FOREIGN KEY (idcategoria) 
        REFERENCES categorias (idcategoria) 
        ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FK_restaurantes_2 FOREIGN KEY (iddistrito) 
        REFERENCES distritos (iddistrito) 
        ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- insert a distritos
INSERT INTO distritos(distrito) VALUES('Ancón');
INSERT INTO distritos(distrito) VALUES('Ate');
INSERT INTO distritos(distrito) VALUES('Barranco');
INSERT INTO distritos(distrito) VALUES('Breña');
INSERT INTO distritos(distrito) VALUES('Carabayllo');
INSERT INTO distritos(distrito) VALUES('Chaclacayo');
INSERT INTO distritos(distrito) VALUES('Chorrillos');
INSERT INTO distritos(distrito) VALUES('Cieneguilla');
INSERT INTO distritos(distrito) VALUES('Comas');
INSERT INTO distritos(distrito) VALUES('El Agustino');
INSERT INTO distritos(distrito) VALUES('Independencia');
INSERT INTO distritos(distrito) VALUES('Jesús María');
INSERT INTO distritos(distrito) VALUES('La Molina');
INSERT INTO distritos(distrito) VALUES('La Victoria');
INSERT INTO distritos(distrito) VALUES('Lima');
INSERT INTO distritos(distrito) VALUES('Lince');
INSERT INTO distritos(distrito) VALUES('Los Olivos');
INSERT INTO distritos(distrito) VALUES('Lurigancho');
INSERT INTO distritos(distrito) VALUES('Lurin');
INSERT INTO distritos(distrito) VALUES('Magdalena del Mar');
INSERT INTO distritos(distrito) VALUES('Magdalena Vieja');
INSERT INTO distritos(distrito) VALUES('Miraflores');
INSERT INTO distritos(distrito) VALUES('Pachacamac');
INSERT INTO distritos(distrito) VALUES('Pucusana');
INSERT INTO distritos(distrito) VALUES('Puente Piedra');
INSERT INTO distritos(distrito) VALUES('Punta Hermosa');
INSERT INTO distritos(distrito) VALUES('Punta Negra');
INSERT INTO distritos(distrito) VALUES('Rimac');
INSERT INTO distritos(distrito) VALUES('San Bartolo');
INSERT INTO distritos(distrito) VALUES('San Borja');
INSERT INTO distritos(distrito) VALUES('San Isidro');
INSERT INTO distritos(distrito) VALUES('San Juan de Lurigancho');
INSERT INTO distritos(distrito) VALUES('San Juan de Miraflores');
INSERT INTO distritos(distrito) VALUES('San Luis');
INSERT INTO distritos(distrito) VALUES('San Martín de Porres');
INSERT INTO distritos(distrito) VALUES('San Miguel');
INSERT INTO distritos(distrito) VALUES('Santa Anita');
INSERT INTO distritos(distrito) VALUES('Santa María del Mar');
INSERT INTO distritos(distrito) VALUES('Santa Rosa');
INSERT INTO distritos(distrito) VALUES('Santiago de Surco');
INSERT INTO distritos(distrito) VALUES('Surquillo');
INSERT INTO distritos(distrito) VALUES('Villa el Salvador');
INSERT INTO distritos(distrito) VALUES('Villa María del Triunfo');

-- insert a categorias
INSERT INTO categorias(categoria) VALUES('Chifa');
INSERT INTO categorias(categoria) VALUES('Comida Criolla');
INSERT INTO categorias(categoria) VALUES('De la Selva');
INSERT INTO categorias(categoria) VALUES('Internacional');
INSERT INTO categorias(categoria) VALUES('Pescados y Mar.');

-- insert a restaurantes
INSERT INTO restaurantes(idcategoria, restaurante, direccion, iddistrito) 
    VALUES(4, 'Embarcadero 41', 'Av. La Mar 456', 1359);
INSERT INTO restaurantes(idcategoria, restaurante, direccion, iddistrito) 
    VALUES(4, 'Santo Pez', 'Av. La Mar 1098', 1352);
INSERT INTO restaurantes(idcategoria, restaurante, direccion, iddistrito) 
    VALUES(4, 'Alfresco', 'Malecon Balta 790', 1359);
INSERT INTO restaurantes(idcategoria, restaurante, direccion, iddistrito) 
    VALUES(1, 'El Characato', 'Av. Aviación 3101', 1367);
INSERT INTO restaurantes(idcategoria, restaurante, direccion, iddistrito) 
    VALUES(2, 'Chifa Lung Wha', 'Av. Benavides 439', 1350);
INSERT INTO restaurantes(idcategoria, restaurante, direccion, iddistrito) 
    VALUES(3, 'Pura Selva', 'Av. Brasil 548', 1341);

