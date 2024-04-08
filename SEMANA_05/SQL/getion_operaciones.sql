CREATE DATABASE gestion_operaciones;

USE gestion_operaciones;

CREATE TABLE Tienda(
id_tienda INT(11) PRIMARY KEY,
nombre VARCHAR(255),
ubicacion VARCHAR(255) 
);

INSERT INTO Tienda VALUES(1, "De Moda Outlet", "Guayabal");

CREATE TABLE Producto(
id_producto INT(11) AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(255) NOT NULL,
precio DECIMAL(10,2) NOT NULL,
id_tienda INT(11),
FOREIGN KEY (id_tienda) REFERENCES Tienda(id_tienda) ON DELETE CASCADE
);

ALTER TABLE Producto 
ADD stock INT(11) NOT NULL;

INSERT INTO Producto VALUES(1, "Arroz", 4000, 30),(2,"Huevos", 500, 30);

CREATE TABLE Cliente(
id_cliente INT(11) PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(255) NOT NULL,
apellido VARCHAR(255) NOT NULL,
email VARCHAR(255) NOT NULL
);

INSERT INTO Cliente VALUES(1, "Juan", "Florez", "juan@florez.dom"),(2,"Jose", "Perez", "jose@perez.dom");

CREATE TABLE Compra(
id_compra INT(11) AUTO_INCREMENT PRIMARY KEY,
fecha_compra TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
cantidad INT(11) NOT NULL,
id_cliente INT(11),
id_producto INT(11),
FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente) ON DELETE CASCADE,
FOREIGN KEY (id_producto) REFERENCES Producto(id_producto) ON DELETE CASCADE
);
