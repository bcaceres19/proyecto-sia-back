SET search_path = sia;


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
                           url_imagen_producto varchar(255),
                           foreign key(id_tipo_producto_fk) references tipo_producto(id_tipo_producto)
);





create table producto(
                         codigo_producto varchar(10) primary key,
                         precio_producto numeric(10,2) not null,
                         fecha_vencimiento_producto date not null,
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
CREATE INDEX idx_inventario_nombre ON inventario(nombre_producto_inventario);
CREATE INDEX idx_inventario_tipo_producto_fk ON inventario(id_tipo_producto_fk);
CREATE INDEX idx_producto_codigo ON producto(codigo_producto);
CREATE INDEX idx_venta_fecha ON venta(fecha_venta);
CREATE INDEX idx_venta_usuario_fk ON venta(id_usuario_fk);
CREATE INDEX idx_venta_producto_producto_fk ON venta_producto(id_producto_fk);
CREATE INDEX idx_venta_producto_venta_fk ON venta_producto(id_venta_fk);
CREATE INDEX idx_pedido_codigo_pedido ON pedido(codigo_pedido);
CREATE INDEX idx_pedido_usuario_fk ON pedido(id_usuario_fk);

/*DATA*/
INSERT INTO rol (nombre_rol, estado_rol) VALUES
                                             ('Administrador', 'A'),
                                             ('Usuario', 'A'),
                                             ('Empleado', 'A');

INSERT INTO tipo_producto (nombre_tipo_producto, estado_tipo_producto) VALUES
                                                                           ('Electrónicos', 'A'),
                                                                           ('Ropa', 'A'),
                                                                           ('Alimentos', 'A');
INSERT INTO usuario (nombres, apellidos, telefono, email, contraseina, id_rol_fk) VALUES
                                                                                      ('Juan', 'Pérez', '123456789', 'juan@ejemplo.com', 'password1', 1),
                                                                                      ('Ana', 'Gómez', '987654321', 'ana@ejemplo.com', 'password2', 2),
                                                                                      ('Carlos', 'López', '456789123', 'carlos@ejemplo.com', 'password3', 3);
INSERT INTO inventario (precio_producto_inventario, stock_producto_inventario, nombre_producto_inventario, id_tipo_producto_fk) VALUES
                                                                                                                                    (100.00, 20, 'Laptop', 1),
                                                                                                                                    (20.00, 100, 'Camiseta', 2),
                                                                                                                                    (5.00, 200, 'Pan', 3);
INSERT INTO producto (precio_producto, codigo_producto, fecha_vencimiento_producto, estado_producto, id_inventario_fk) VALUES
                                                                                                                           (100.00, 'LPT001', '2025-12-31', 'A', 1),
                                                                                                                           (20.00, 'CMP001', '2023-12-31', 'A', 2),
                                                                                                                           (5.00, 'PAN001', '2024-06-30', 'A', 3);
INSERT INTO venta (cantidad_venta, estado_venta, fecha_venta, precio_total_venta, id_usuario_fk) VALUES
                                                                                                     (1, 'A', '2024-04-10', 100.00, 1),
                                                                                                     (3, 'A', '2024-04-11', 60.00, 2),
                                                                                                     (10, 'A', '2024-04-12', 50.00, 3);
INSERT INTO venta_producto (id_producto_fk, id_venta_fk) VALUES
                                                             ('LPT001', 1),
                                                             ('CMP001', 2),
                                                             ('PAN001', 3);
INSERT INTO pedido (codigo_pedido, estado_pedido, fecha_inicio_pedido, fecha_vencimiento_pedido, id_usuario_fk, id_venta_fk) VALUES
                                                                                                                                 ('PED001', 'A', '2024-04-10', '2024-04-15', 1, 1),
                                                                                                                                 ('PED002', 'A', '2024-04-11', '2024-04-18', 2, 2),
                                                                                                                                 ('PED003', 'A', '2024-04-12', '2024-04-19', 3, 3);
INSERT INTO producto (precio_producto, codigo_producto, fecha_vencimiento_producto, estado_producto, id_inventario_fk) VALUES
                                                                                                                           (80.00, 'LPT002', '2025-11-15', 'A', 1),
                                                                                                                           (90.00, 'LPT003', '2026-03-20', 'A', 1),
                                                                                                                           (15.00, 'CMP002', '2023-08-31', 'A', 2),
                                                                                                                           (22.00, 'CMP003', '2023-11-15', 'A', 2),
                                                                                                                           (3.50, 'PAN002', '2024-03-31', 'A', 3),
                                                                                                                           (4.00, 'PAN003', '2024-04-15', 'A', 3),
                                                                                                                           (200.00, 'TV001', '2027-12-31', 'A', 1),
                                                                                                                           (10.00, 'HAT001', '2023-09-30', 'A', 2),
                                                                                                                           (12.00, 'HAT002', '2023-10-31', 'A', 2),
                                                                                                                           (3.00, 'JUC001', '2024-05-31', 'A', 3),
                                                                                                                           (5.00, 'JUC002', '2024-06-30', 'A', 3),
                                                                                                                           (150.00, 'PHONE1', '2026-12-31', 'A', 1),
                                                                                                                           (70.00, 'SPK001', '2025-07-15', 'A', 1),
                                                                                                                           (2.00, 'CND001', '2024-07-31', 'A', 3),
                                                                                                                           (2.50, 'CND002', '2024-08-31', 'A', 3),
                                                                                                                           (20.00, 'SHT001', '2024-09-30', 'A', 2),
                                                                                                                           (25.00, 'SHT002', '2024-10-15', 'A', 2);
INSERT INTO tipo_producto (nombre_tipo_producto, estado_tipo_producto) VALUES
                                                                           ('Juguetes', 'A'),
                                                                           ('Muebles', 'A'),
                                                                           ('Herramientas', 'A');
INSERT INTO inventario (precio_producto_inventario, stock_producto_inventario, nombre_producto_inventario, id_tipo_producto_fk) VALUES
                                                                                                                                    (120.00, 30, 'Consola de juegos', 1),  -- tipo_producto: Electrónicos
                                                                                                                                    (45.00, 60, 'Vestido', 2),             -- tipo_producto: Ropa
                                                                                                                                    (2.00, 300, 'Manzana', 3),             -- tipo_producto: Alimentos
                                                                                                                                    (60.00, 40, 'Camión de juguete', 4),   -- tipo_producto: Juguetes
                                                                                                                                    (150.00, 20, 'Sofá', 5),               -- tipo_producto: Muebles
                                                                                                                                    (8.00, 50, 'Martillo', 6),             -- tipo_producto: Herramientas
                                                                                                                                    (200.00, 15, 'Sistema de sonido', 1);  -- tipo_producto: Electrónicos

select * from venta_producto vp;

select * from pedido p inner join venta v on p.id_venta_fk = v.id_venta
                       inner join venta_producto vp on vp.id_venta_fk = v.id_venta
                       inner join producto p2 on vp.id_producto_fk = p2.codigo_producto;

select p.codigo_producto, p.fecha_vencimiento_producto, p.precio_producto, p.estado_producto from venta_producto vp
                                                                                                      inner join producto p ON vp.id_producto_fk = p.codigo_producto where p.codigo_producto = :codigoProducto;

select * from producto p;

select
    p.codigo_producto,
    p.fecha_vencimiento_producto,
    p.precio_producto,
    p.estado_producto
from venta_producto vp
         inner join producto p
                    ON vp.id_producto_fk = p.codigo_producto

select p.codigo_producto, p.precio_producto , p.estado_producto, i.precio_producto_inventario, p.precio_producto, p.fecha_vencimiento_producto, i.nombre_producto_inventario
from producto p inner join inventario i on p.id_inventario_fk  = i.id_inventario;
