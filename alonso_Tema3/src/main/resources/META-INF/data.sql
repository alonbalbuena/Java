INSERT INTO USUARIOS (nombre,nif) VALUES ("alonso","123456p");
INSERT INTO USUARIOS (nombre,nif) VALUES ("paco","13553a");
INSERT INTO USUARIOS (nombre,nif) VALUES ("pablo","874545b");


/*-----MODELO VO 1-----*/

INSERT INTO titulares(dni,nombre) VALUES("53646496P","alonso");
INSERT INTO titulares(dni,nombre) VALUES("53646496P","paco");
INSERT INTO titulares(dni,nombre) VALUES("53646496P","rodrigo");

/*asignamos a alonso 3 cuentas*/
INSERT INTO cuentas(numero,saldo,idtitular) values('aaa',100,1);
INSERT INTO cuentas(numero,saldo,idtitular) values('bbb',19,1);
INSERT INTO cuentas(numero,saldo,idtitular) values('ccc',200,1);