create table usuarios (
 id bigint NOT NULL AUTO_INCREMENT,
 cedula varchar(50) not null,
 nombre varchar(255) not null,
 correo varchar(255) not null,
 clave varchar(50) not null,
 primary key (id)
);
CREATE TABLE pedidos (
	id bigint NOT NULL AUTO_INCREMENT,
	identificadorSeguimiento  VARCHAR ( 50 ) UNIQUE NOT NULL,
	fechaPedido VARCHAR ( 50 )  NOT NULL,
	fechaEnvio VARCHAR ( 50 ),
	precioTotal FLOAT  NOT null,
	estado  VARCHAR ( 50 ) NOT NULL,
	id_municipio BIGINT  NOT null,
	cedula_destinatario VARCHAR ( 50 )  NOT NULL,
	direccion_destinatario VARCHAR ( 50 )  NOT NULL,
	id_usuario BIGINT  NOT null,
	primary key (id)

);
  CREATE TABLE municipios (
	id bigint NOT NULL AUTO_INCREMENT,
	nombre VARCHAR ( 50 )  NOT NULL,
	codigoMunicipio BIGINT  NOT NULL,
	primary key (id)
);
Alter table pedidos ADD FOREIGN KEY (id_municipio) REFERENCES municipios(id);
Alter table pedidos ADD FOREIGN KEY (id_usuario) REFERENCES usuarios(id);


CREATE TABLE detallePedidos (
	id bigint NOT NULL AUTO_INCREMENT,
	cantidadPedida BIGINT  NOT null,
	id_producto  VARCHAR ( 50 )  NOT NULL,
	id_pedido BIGINT  NOT null,
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


  CREATE TABLE tarifas (
	id bigint NOT NULL AUTO_INCREMENT,
	idMunicipio BIGINT REFERENCES municipios(id),
	precio FLOAT  NOT null,
	primary key (id),
	UNIQUE(idMunicipio)
);




