create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);


CREATE TABLE clientes(
	id serial PRIMARY KEY,
	idMunicipio BIGINT  NOT null,
	cedula VARCHAR ( 50 ) UNIQUE NOT NULL,
	nombre VARCHAR ( 255 )  NOT NULL,
	telefono VARCHAR ( 50 )  NOT NULL,
	direccion VARCHAR ( 255 )  NOT NULL
);


CREATE TABLE vendedores (
	id serial PRIMARY KEY,
	cedula VARCHAR ( 50 ) UNIQUE NOT NULL,
	nombre VARCHAR ( 255 )  NOT NULL,
	password VARCHAR ( 50 ) NOT NULL,
	email VARCHAR ( 255 ) UNIQUE NOT NULL
);


CREATE TABLE detallePedidos (
	id serial PRIMARY key,
	cantidadPedida BIGINT  NOT null,
	id_vendedor BIGINT ,
	id_cliente BIGINT  NOT null,
	id_producto  VARCHAR ( 50 )  NOT NULL,
	id_pedido BIGINT  NOT null

);

CREATE TABLE pedidos (
	id serial PRIMARY KEY,
	identificadorSeguimiento  VARCHAR ( 50 ) UNIQUE NOT NULL,
	fechaPedido VARCHAR ( 50 )  NOT NULL,
	fechaEnvio VARCHAR ( 50 ),
	precioTotal FLOAT  NOT null,
	estado  VARCHAR ( 50 ) NOT NULL

);

CREATE TABLE productos (
	id serial PRIMARY KEY,
	codigo  VARCHAR ( 50 ) UNIQUE NOT null,
	nombre VARCHAR ( 50 )  NOT NULL,
	precio FLOAT  NOT NULL
);

alter table detallePedidos
   add constraint FK_vendedores_idVendedor
   foreign key (id_vendedor)
   references vendedores(id);

  alter table detallePedidos
   add constraint FK_clientes_idCliente
   foreign key (id_cliente)
   references clientes(id);


  alter table detallePedidos
   add constraint FK_productos_idProducto
   foreign key (id_producto)
   references productos(codigo);

  alter table detallePedidos
   add constraint FK_pedidos_idPedido
   foreign key (id_pedido)
   references pedidos(id);

  CREATE TABLE municipios (
	id serial PRIMARY KEY,
	nombre VARCHAR ( 50 )  NOT NULL,
	codigoMunicipio BIGINT  NOT NULL
);
  CREATE TABLE tarifas (
	id serial PRIMARY KEY,
	idMunicipio BIGINT REFERENCES municipios(id),
	precio FLOAT  NOT null,
	UNIQUE(idMunicipio)
);


alter table clientes
   add constraint FK_municipios_idMunicipio
   foreign key (idMunicipio)
   references municipios(id);
