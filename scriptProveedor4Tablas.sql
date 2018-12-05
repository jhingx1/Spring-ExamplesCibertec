DROP TABLE IF EXISTS proveedores;
DROP TABLE IF EXISTS clientes;
DROP TABLE IF EXISTS departamentos;
DROP TABLE IF EXISTS distritos;

-- crear tablas
CREATE TABLE departamentos(
    iddepartamento  int(11) NOT NULL AUTO_INCREMENT,
    departamento    varchar(50) NOT NULL,
    PRIMARY KEY (iddepartamento)
) ENGINE=InnoDB AUTO_INCREMENT=1338 DEFAULT CHARSET=utf8;

CREATE TABLE distritos (
    iddistrito  int(11) NOT NULL AUTO_INCREMENT,
    distrito    varchar(50) NOT NULL,	
    PRIMARY KEY (iddistrito)		
) ENGINE=InnoDB AUTO_INCREMENT=1338 DEFAULT CHARSET=utf8;

CREATE TABLE clientes (
    idcliente int(11) NOT NULL AUTO_INCREMENT,
    nombrecliente varchar(100) NOT NULL,
    ruc   varchar(100) NOT NULL,
    iddepartamento int(11) NOT NULL,
    PRIMARY KEY (idcliente),
    UNIQUE KEY IDX_clientes_1 (nombrecliente)
	
	KEY FK_clientes_1 (iddepartamento),
	
	CONSTRAINT FK_clientes_1 FOREIGN KEY (iddepartamento) 
        REFERENCES departamentos (iddepartamento) 
        ON DELETE CASCADE ON UPDATE CASCADE
		
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE proveedores (
    idproveedor   int(11) NOT NULL AUTO_INCREMENT,
    idcliente     int(11) NOT NULL,
    razonsocial     varchar(200) NOT NULL,
    direccion       varchar(200) NOT NULL,    
    iddistrito      int(11) NOT NULL,		
	
    PRIMARY KEY (idproveedor),
    UNIQUE KEY IDX_proveedores_4 (razonsocial),
    KEY FK_proveedores_1 (idcliente),    
	KEY FK_proveedores_2 (iddistrito),
	
    CONSTRAINT FK_proveedores_1 FOREIGN KEY (idcliente) 
        REFERENCES clientes (idcliente) 
        ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT FK_proveedores_2 FOREIGN KEY (iddistrito) 
        REFERENCES distritos (iddistrito) 
        ON DELETE CASCADE ON UPDATE CASCADE		
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- insert a departamentos
INSERT INTO departamentos(departamento) VALUES('AMAZONAS');
INSERT INTO departamentos(departamento) VALUES('ANCASH');
INSERT INTO departamentos(departamento) VALUES('AMAZONAS');
INSERT INTO departamentos(departamento) VALUES('APURIMAC');
INSERT INTO departamentos(departamento) VALUES('AREQUIPA');
INSERT INTO departamentos(departamento) VALUES('AYACUCHO');
INSERT INTO departamentos(departamento) VALUES('CAJAMARCA');
INSERT INTO departamentos(departamento) VALUES('CALLAO');
INSERT INTO departamentos(departamento) VALUES('CUSCO');
INSERT INTO departamentos(departamento) VALUES('HUANCAVELICA');
INSERT INTO departamentos(departamento) VALUES('HUANUCO');
INSERT INTO departamentos(departamento) VALUES('ICA');
INSERT INTO departamentos(departamento) VALUES('JUNIN');
INSERT INTO departamentos(departamento) VALUES('LA LIBERTAD');
INSERT INTO departamentos(departamento) VALUES('LAMBAYEQUE');
INSERT INTO departamentos(departamento) VALUES('LIMA');
INSERT INTO departamentos(departamento) VALUES('LORETO');
INSERT INTO departamentos(departamento) VALUES('MADRE DE DIOS');
INSERT INTO departamentos(departamento) VALUES('MOQUEGUA');
INSERT INTO departamentos(departamento) VALUES('PASCO');
INSERT INTO departamentos(departamento) VALUES('PIURA');
INSERT INTO departamentos(departamento) VALUES('PUNO');
INSERT INTO departamentos(departamento) VALUES('SAN MARTIN');
INSERT INTO departamentos(departamento) VALUES('TACNA');
INSERT INTO departamentos(departamento) VALUES('UCAYALI');

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

-- insert a clientes
INSERT INTO clientes(nombrecliente,ruc,iddepartamento) VALUES('Esmeralda Corp','10156497963',5);
INSERT INTO clientes(nombrecliente,ruc,iddepartamento) VALUES('Soraya SAC','10156497965',5);
INSERT INTO clientes(nombrecliente,ruc,iddepartamento) VALUES('Aliprofesco','10156497968',5);
INSERT INTO clientes(nombrecliente,ruc,iddepartamento) VALUES('Viento Solar','10156497966',5);

-- insert a proveedores
INSERT INTO proveedores(idcliente, razonsocial, direccion, iddistrito) 
    VALUES(1, 'Makro SAC', 'Panamericana Sur km 18.5', 1359);
INSERT INTO proveedores(idcliente, razonsocial, direccion, iddistrito) 
    VALUES(2, 'Embarcadero 41', 'Av. La Mar 456', 1359);
INSERT INTO proveedores(idcliente, razonsocial, direccion, iddistrito) 
    VALUES(3, 'Embarcadero 41', 'Av. La Mar 456', 1359);
INSERT INTO proveedores(idcliente, razonsocial, direccion, iddistrito) 
    VALUES(4, 'Embarcadero 41', 'Av. La Mar 456', 1359);	