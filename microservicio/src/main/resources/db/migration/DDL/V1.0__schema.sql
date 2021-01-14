create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);


CREATE TABLE clientes(
	id bigint NOT NULL AUTO_INCREMENT,
	idMunicipio BIGINT  NOT null,
	cedula VARCHAR ( 50 ) UNIQUE NOT NULL,
	nombre VARCHAR ( 255 )  NOT NULL,
	telefono VARCHAR ( 50 )  NOT NULL,
	direccion VARCHAR ( 255 )  NOT NULL,
	primary key (id)
);


CREATE TABLE vendedores (
	id bigint NOT NULL AUTO_INCREMENT,
	cedula VARCHAR ( 50 ) UNIQUE NOT NULL,
	nombre VARCHAR ( 255 )  NOT NULL,
	password VARCHAR ( 50 ) NOT NULL,
	email VARCHAR ( 255 ) UNIQUE NOT NULL,
	primary key (id)
);


CREATE TABLE detallePedidos (
	id bigint NOT NULL AUTO_INCREMENT,
	cantidadPedida BIGINT  NOT null,
	id_vendedor BIGINT ,
	id_cliente BIGINT  ,
	id_producto  VARCHAR ( 50 )  NOT NULL,
	id_pedido BIGINT  NOT null,
	primary key (id)

);

CREATE TABLE pedidos (
	id bigint NOT NULL AUTO_INCREMENT,
	identificadorSeguimiento  VARCHAR ( 50 ) UNIQUE NOT NULL,
	fechaPedido VARCHAR ( 50 )  NOT NULL,
	fechaEnvio VARCHAR ( 50 ),
	precioTotal FLOAT  NOT null,
	estado  VARCHAR ( 50 ) NOT NULL,
	primary key (id)

);

CREATE TABLE productos (
	id bigint NOT NULL AUTO_INCREMENT,
	codigo  VARCHAR ( 50 ) UNIQUE NOT null,
	nombre VARCHAR ( 50 )  NOT NULL,
	precio FLOAT  NOT NULL,
	primary key (id)
);

  Alter table detallePedidos ADD FOREIGN KEY (id_producto) REFERENCES productos(codigo);
  Alter table detallePedidos ADD FOREIGN KEY (id_pedido) REFERENCES pedidos(id);


  CREATE TABLE municipios (
	id bigint NOT NULL AUTO_INCREMENT,
	nombre VARCHAR ( 50 )  NOT NULL,
	codigoMunicipio BIGINT  NOT NULL,
	primary key (id)
);
  CREATE TABLE tarifas (
	id bigint NOT NULL AUTO_INCREMENT,
	idMunicipio BIGINT REFERENCES municipios(id),
	precio FLOAT  NOT null,
	primary key (id),
	UNIQUE(idMunicipio)
);




