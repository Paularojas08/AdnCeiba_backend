INSERT INTO productos (codigo, nombre, precio) VALUES('354', 'plancha', 12000);
INSERT INTO productos (codigo, nombre, precio) VALUES('56', 'secador', 45000);
INSERT INTO municipios (id,nombre, codigomunicipio) VALUES(8,'Armenia', 8);
INSERT INTO tarifas (idmunicipio, precio) VALUES(8, 2000);
INSERT INTO usuarios (id,cedula, nombre, clave, correo) VALUES(1,'1234', 'admin', '1234', 'admin@gmail.com');

INSERT INTO pedidos (id,identificadorSeguimiento, fechaPedido, fechaEnvio, precioTotal, estado, id_municipio, cedula_destinatario, direccion_destinatario,id_usuario) VALUES(1,'aqwer', '2021-12-12', '2021-12-12', 12345, 'PENDIENTE', 8, '1094956843', 'cra 14 #12-9',1);

INSERT INTO detallepedidos (id,cantidadPedida, id_producto, id_pedido) VALUES(1,2, '354', 1);
INSERT INTO detallepedidos (id,cantidadPedida, id_producto, id_pedido) VALUES(2,2, '56', 1);

