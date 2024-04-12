create table rol(

                    id_rol serial primary key,
                    nombre_rol varchar(20) not null,
                    estado_rol char not null
);

create table tipo_producto(
                              id_tipo_producto serial primary key,
                              nombre_tipo_producto varchar(50) not null,
                              estado_tipo_producto char not null
);

create table usuario(
                        id_usuario serial primary key,
                        nombres varchar(50) not null,
                        apellidos varchar(50) not null,
                        telefono varchar(20),
                        email varchar(20),
                        contraseina varchar(20) not null,
                        id_rol_fk int not null,
                        foreign key(id_rol_fk) references rol(id_rol)
);

create table inventario(

                           id_inventario serial primary key,
                           precio_producto_inventario numeric(10,2) not null,
                           stock_producto_inventario int not null,
                           nombre_producto_inventario varchar(50) not null,
                           id_tipo_producto_fk int not null,
                           foreign key(id_tipo_producto_fk) references tipo_producto(id_tipo_producto)
);

create table producto(
                         precio_producto numeric(10,2) not null,
                         codigo_producto varchar(10) not null,
                         fecha_vencimiento date not null,
                         estado_producto char not null,
                         id_inventario_fk int not null,
                         foreign key(id_inventario_fk) references inventario(id_inventario)
);

create table venta(
                      id_venta serial  primary key,
                      cantidad_venta smallint not null,
                      estado_venta char not null,
                      fecha_venta date not null,
                      precio_total_venta numeric(10,2) not null,
                      id_usuario_fk int not null,
                      foreign key(id_usuario_fk) references usuario(id_usuario)
);

create table venta_producto(
                               id_producto_fk varchar(10) not null,
                               id_venta_fk int not null,
                               foreign key(id_producto_fk) references producto(codigo_producto),
                               foreign key(id_venta_fk) references venta(id_venta)
);

create table pedido(
                       codigo_pedido varchar(10) primary key,
                       estado_pedido char not null,
                       fecha_inicio_pedido date not null,
                       fecha_vencimiento_pedido date not null,
                       id_usuario_fk int not null,
                       id_venta_fk int not null,
                       foreign key(id_usuario_fk) references usuario(id_usuario),
                       foreign key(id_venta_fk) references venta(id_venta)
);

CREATE INDEX idx_usuario_email ON usuario(email);
CREATE INDEX idx_inventario_nombre ON inventario(nombre_producto_original);
CREATE INDEX idx_inventario_tipo_producto_fk ON inventario(id_tipo_producto_fk);
CREATE INDEX idx_producto_codigo ON producto(codigo_producto);
CREATE INDEX idx_venta_fecha ON venta(fecha_venta);
CREATE INDEX idx_venta_usuario_fk ON venta(id_usuario_fk);
CREATE INDEX idx_venta_producto_producto_fk ON venta_producto(id_producto_fk);
CREATE INDEX idx_venta_producto_venta_fk ON venta_producto(id_venta_fk);
CREATE INDEX idx_pedido_codigo_pedido ON pedido(codigo_pedido);
CREATE INDEX idx_pedido_usuario_fk ON pedido(id_usuario_fk);
CREATE INDEX idx_pedido_venta_fk ON pedido(id_venta_fk);
