DROP TABLE IF EXISTS alquileres;
DROP TABLE IF EXISTS autos;
---La tabla secundaria
CREATE TABLE autos (
    idauto int(11) NOT NULL AUTO_INCREMENT,
    modelo varchar(200) NOT NULL,
    precioxdia double NOT NULL,
    alquilado char(1) NOT NULL DEFAULT 'N' 
        COMMENT 'N=No Alquilado, S=Alquilado',

    PRIMARY KEY (idauto),
    UNIQUE KEY IDX_autos_1 (modelo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO autos(modelo,precioxdia,alquilado) VALUES('Toyota',13.2,'N');
INSERT INTO autos(modelo,precioxdia,alquilado) VALUES('Audi',12.2,'S');
INSERT INTO autos(modelo,precioxdia,alquilado) VALUES('Nissan',16.2,'S');

---La tabla principal
CREATE TABLE alquileres (
  idalquiler int(11) NOT NULL AUTO_INCREMENT,
  idauto int(11) NOT NULL,
  alquiler_ini datetime NOT NULL,
  alquiler_fin datetime NOT NULL,
  cliente varchar(200) NOT NULL,
  dni varchar(20) NOT NULL,

  PRIMARY KEY (idalquiler),
  KEY FK_alquileres_1 (idauto),
  CONSTRAINT FK_alquileres_1 FOREIGN KEY (idauto) 
        REFERENCES autos (idauto) 
        ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO alquileres(idauto,alquiler_ini,alquiler_fin,cliente,dni) VALUES('1','2018-03-15','2018-04-15','Romero','07091425');
INSERT INTO alquileres(idauto,alquiler_ini,alquiler_fin,cliente,dni) VALUES('2','2018-05-15','2018-06-15','Romero','07091425');
INSERT INTO alquileres(idauto,alquiler_ini,alquiler_fin,cliente,dni) VALUES('3','2018-06-15','2018-08-15','Romero','07091425');
