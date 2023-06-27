# Proyecto en Spring Boot - Sprint Modulo 6 (Spring Boot, Spring Security)

## Integrantes

Full Stack Java - 0018

Marcela Arce --> https://www.github.com/m4arce


## Requerimiento y solución
Aplicación para Empresa de Prevención de Riesgos, con manejo de usuarios y vistas asociadas para cada rol.
El requerimiento no estaba del todo especificado, sin embargo se desarrolla interpretación funcional por parte del equipo, por lo que se optimiza la información disponible y se adapta acorde al aprendizaje adquirido de forma autónoma.

### Los usuarios son 3: 

user1 -> Corresponde a vistas de Administrativo
user2 -> Corresponde a vistas de Cliente
user1 -> Corresponde a vistas de Profesional

Para todos los usuarios la clave es: 123456

### Las vistas asociadas y permisos estan asignados por rol, donde corresponde como sigue:

Administrativo: usuarios y pagos
Cliente: capacitaciones y contacto
Profesional: visitas y revisiones

### Para cada uno de los casos, se genera un CRUD para el manejo y almacenamiento de la informacion

### Manejo de sesiones con login y logout. Para esto, se configura su uso en memoria.

## Modelo de Datos
Antes de comenzar, debemos implementar el siguiente script para Base de datos (MySql)


Los siguientes son los scripts de creación e inserción de datos.

### DDL
Ejecuta este script para la creación de las tablas.
```sql
CREATE SCHEMA `test2` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;

/*tabla capacitaciones*/
CREATE TABLE `test2`.`capacitaciones` (
  `idcapacitaciones` INT NOT NULL AUTO_INCREMENT,
  `docente` VARCHAR(45) NULL,
  `curso` VARCHAR(45) NULL,
  `inicio` VARCHAR(45) NULL,
  `termino` VARCHAR(45) NULL,
  `precio` VARCHAR(45) NULL,
  PRIMARY KEY (`idcapacitaciones`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

/*tabla usuarios*/
CREATE TABLE `test2`.`usuarios` (
  `idusuario` INT NOT NULL AUTO_INCREMENT,
  `nombreusuario` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `tipo` VARCHAR(45) NULL,
  PRIMARY KEY (`idusuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

/*tabla visitas*/
CREATE TABLE `test2`.`visitas` (
  `idvisita` INT NOT NULL AUTO_INCREMENT,
  `cliente` VARCHAR(45) NULL,
  `lugar` VARCHAR(45) NULL,
  `fecha` VARCHAR(45) NULL,
  `comentarios` VARCHAR(45) NULL,
  PRIMARY KEY (`idvisita`));

/*tabla revisiones*/
 CREATE TABLE `test2`.`revisiones` (
  `idrevision` INT NOT NULL AUTO_INCREMENT,
  `nombrerevision` VARCHAR(45) NULL,
  `detalle` VARCHAR(45) NULL,
  `estado` VARCHAR(45) NULL,
  PRIMARY KEY (`idrevision`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

/*tabla pagos*/
CREATE TABLE `test2`.`pagos` (
  `idpago` INT NOT NULL AUTO_INCREMENT,
  `curso` VARCHAR(45) NULL,
  `docente` VARCHAR(45) NULL,
  `fecha` VARCHAR(45) NULL,
  `tipopago` VARCHAR(45) NULL,
  `monto` VARCHAR(45) NULL,
  PRIMARY KEY (`idpago`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

/*tabla contacto*/
CREATE TABLE `test2`.`contacto` (
  `idcontacto` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `mensaje` VARCHAR(45) NULL,
  PRIMARY KEY (`idcontacto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;
```
### DML
Ejecuta este script para llenar con datos.
```sql

INSERT INTO test2.capacitaciones(docente, curso, inicio, termino, precio) VALUES('Gardie Lunt','Manejo de extintores','28-09-2022','10-10-2022','$3.829.476');
INSERT INTO test2.capacitaciones(docente, curso, inicio, termino, precio) VALUES('Mirella Filpi','Comites paritarios','26-09-2022','17-10-2022','$3.200.430');
INSERT INTO test2.capacitaciones(docente, curso, inicio, termino, precio) VALUES('Decca Essex','Manejo manual de cargas','15-09-2022','27-10-2022','$1.535.106');
INSERT INTO test2.capacitaciones(docente, curso, inicio, termino, precio) VALUES('Cathie Carlett','Manejo residuos peligrosos','18-09-2022','12-10-2022','$4.389.072');
INSERT INTO test2.capacitaciones(docente, curso, inicio, termino, precio) VALUES('Shep De Giovanni','Monitores de emergencia','25-09-2022','07-10-2022','$3.696.800');
INSERT INTO test2.capacitaciones(docente, curso, inicio, termino, precio) VALUES('Rana Brogiotti','Controlde riesgo radiacion ultravioleta','28-09-2022','02-10-2022','$3.687.456');
INSERT INTO test2.capacitaciones(docente, curso, inicio, termino, precio) VALUES('Cesar Simmins','Primeros auxilios','26-09-2022','24-10-2022','$3.621.270');
INSERT INTO test2.capacitaciones(docente, curso, inicio, termino, precio) VALUES('Gustave Hawker','Manipulacion de plaguicidas','29-09-2022','09-10-2022','$3.583.379');
INSERT INTO test2.capacitaciones(docente, curso, inicio, termino, precio) VALUES('Cyndy Cockman','Creando cultura de seguridad','06-09-2022','15-10-2022','$4.304.468');
INSERT INTO test2.capacitaciones(docente, curso, inicio, termino, precio) VALUES('Bronson Rebbeck','Fundamentos de higiene industrial','16-09-2022','02-10-2022','$2.966.964');

INSERT INTO test2.usuarios(nombreusuario, password, tipo) VALUES('Aube Woollett','6lwwJ6ODcsg3','1');
INSERT INTO test2.usuarios(nombreusuario, password, tipo) VALUES('Arnuad Verbeek','aO7ZRDYK','2');
INSERT INTO test2.usuarios(nombreusuario, password, tipo) VALUES('Ange Singleton','aZYKhWVlgYs','2');
INSERT INTO test2.usuarios(nombreusuario, password, tipo) VALUES('Laverna Brunger','8a4Rarr','3');
INSERT INTO test2.usuarios(nombreusuario, password, tipo) VALUES('Horatio Matteoni','MgkDDnn','2');
INSERT INTO test2.usuarios(nombreusuario, password, tipo) VALUES('Nickie Giaomozzo','ca1oPuQKMiO','2');
INSERT INTO test2.usuarios(nombreusuario, password, tipo) VALUES('Panchito Symcox','txf74vY','1');
INSERT INTO test2.usuarios(nombreusuario, password, tipo) VALUES('Alphonso Magnar','NEJUqxnh5T','1');
INSERT INTO test2.usuarios(nombreusuario, password, tipo) VALUES('Tracee McKeighen','zyl05GtU6cVK','2');
INSERT INTO test2.usuarios(nombreusuario, password, tipo) VALUES('Lena Sammon','IqwvLe','3');

INSERT INTO test2.visitas(cliente, lugar, fecha, comentarios) VALUES('Aube Woollett','Santiago','05-10-2021','et, magna. Praesent interdum');
INSERT INTO test2.visitas(cliente, lugar, fecha, comentarios) VALUES('Arnuad Verbeek','Arica','02-05-2022','nibh lacinia orci, consectetuer');
INSERT INTO test2.visitas(cliente, lugar, fecha, comentarios) VALUES('Ange Singleton','Punta Arenas','18-03-2022','id sapien. Cras dolor ');
INSERT INTO test2.visitas(cliente, lugar, fecha, comentarios) VALUES('Alphonso Magnar','Concepcion','29-03-2022','lacus. Aliquam rutrum ');

INSERT INTO test2.revisiones(nombrerevision, detalle, estado) VALUES('Revision 1', 'Primera revision', 'En proceso');
INSERT INTO test2.revisiones(nombrerevision, detalle, estado) VALUES('Revision 36', 'revision de rutina', 'En proceso');
INSERT INTO test2.revisiones(nombrerevision, detalle, estado) VALUES('Revision 24', 'Segunda revision', 'Finalizada');
INSERT INTO test2.revisiones(nombrerevision, detalle, estado) VALUES('Revision 7', 'Revision final', 'En proceso');
INSERT INTO test2.revisiones(nombrerevision, detalle, estado) VALUES('Revision 3', 'Tercera revision', 'Finalizada');

INSERT INTO test2.pagos(curso, docente, fecha, tipopago, monto) VALUES('Manejo residuos peligrosos', 'Cathie Carlett', '18-09-2022', '1', '$4.389.072');
INSERT INTO test2.pagos(curso, docente, fecha, tipopago, monto) VALUES('Primeros auxilios', 'Cesar Simmins', '26-09-2022', '2', '$4.389.072');
INSERT INTO test2.pagos(curso, docente, fecha, tipopago, monto) VALUES('Manejo de extintores', 'Gardie Lunt', '28-09-2022', '1', '$3.829.476');

INSERT INTO test2.contacto(nombre, email, mensaje) VALUES('Armstrong Querrard','aquerrard0@statcounter.com','nibh in quis justo maecenas rhoncus');
INSERT INTO test2.contacto(nombre, email, mensaje) VALUES('Sean Hember','shember2@baidu.com','nonummy integer non velit donec diam neque');
INSERT INTO test2.contacto(nombre, email, mensaje) VALUES('Colan Hinrichs','chinrichs3@ebay.com','pellentesque at nulla suspendisse potenti');
INSERT INTO test2.contacto(nombre, email, mensaje) VALUES('Alfie Lum','alum4@time.com','sodales scelerisque mauris sit ');
INSERT INTO test2.contacto(nombre, email, mensaje) VALUES('Candis Tarrier','ctarrier5@ebay.co.uk','eu sapien cursus vestibulum proin eu mi');
```

## Configuración
Indica en el archivo application.properties lo siguiente

```properties
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/[nombre de base de datos]
spring.datasource.username=[usuario]
spring.datasource.password=[clave]
```
