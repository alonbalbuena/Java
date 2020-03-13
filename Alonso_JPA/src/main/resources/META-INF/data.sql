--creamos las lineas
INSERT INTO lineas(idlinea,denCorta,denLarga,fecha) values (1,"linea 1","cerilleru-Guia","2019-01-01");
INSERT INTO lineas(idlinea,denCorta,denLarga,fecha) values (2,"linea 2","Cimavilla-Calzada","2019-01-01");

--creamos las paradas
INSERT INTO paradas(idparada,denominacion,fecha) values(1,"corrida","2019-01-01");
INSERT INTO paradas(idparada,denominacion,fecha) values(2,"llano","2019-01-01");
INSERT INTO paradas(idparada,denominacion,fecha) values(3,"parchis","2019-01-01");
INSERT INTO paradas(idparada,denominacion,fecha) values(4,"brasil","2019-01-01");
INSERT INTO paradas(idparada,denominacion,fecha) values(5,"constitucion","2019-01-01");
INSERT INTO paradas(idparada,denominacion,fecha) values(6,"juan carlos I","2019-01-01");
INSERT INTO paradas(idparada,denominacion,fecha) values(7,"molinon","2019-01-01");

--asignamos paradas a las lineas

--primero las paradas de la linea 2
INSERT INTO lineaparadas(marquesina,idlineaparada,idlinea,idparada) values(1,1,1,2);
INSERT INTO lineaparadas(marquesina,idlineaparada,idlinea,idparada) values(1,2,1,3);
INSERT INTO lineaparadas(marquesina,idlineaparada,idlinea,idparada) values(1,3,1,5);
INSERT INTO lineaparadas(marquesina,idlineaparada,idlinea,idparada) values(1,4,1,6);

--luego las paradas de la linea 1
--cambiamos la marquesina en funcion de la linea
INSERT INTO lineaparadas(marquesina,idlineaparada,idlinea,idparada) values(2,5,2,1);
INSERT INTO lineaparadas(marquesina,idlineaparada,idlinea,idparada) values(2,6,2,3);
INSERT INTO lineaparadas(marquesina,idlineaparada,idlinea,idparada) values(1,7,2,6);
INSERT INTO lineaparadas(marquesina,idlineaparada,idlinea,idparada) values(1,8,2,7);