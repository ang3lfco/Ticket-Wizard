CREATE DATABASE ticketwizard;
USE ticketwizard;

CREATE TABLE Personas (
  _id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(255) NOT NULL,
  correo VARCHAR(255) NOT NULL UNIQUE,
  domicilio TEXT NOT NULL,
  fecha_nacimiento DATE NOT NULL,
  saldo DECIMAL(10, 2) DEFAULT 0.00,
  contraseña VARCHAR(255) NOT NULL
);

CREATE TABLE Eventos (
  _id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(255) NOT NULL,
  fecha DATE NOT NULL,
  venue VARCHAR(255) NOT NULL,
  ciudad VARCHAR(255) NOT NULL,
  estado VARCHAR(255) NOT NULL,
  descripcion VARCHAR(355),
  imagenPath VARCHAR(355)
);

CREATE TABLE Boletos (
  _id INT AUTO_INCREMENT PRIMARY KEY,
  nSerie VARCHAR(8) NOT NULL UNIQUE,
  _evento INT NOT NULL,
  fila VARCHAR(50),
  asiento VARCHAR(50),
  precioOriginal DECIMAL(10, 2) NOT NULL,
  precioActual DECIMAL(10, 2) NOT NULL,
  nControl VARCHAR(255),
  estado ENUM('Disponible', 'Apartado') DEFAULT 'Disponible',
  FOREIGN KEY (_evento) REFERENCES Eventos(_id)
);

CREATE TABLE Transacciones (
  _id INT AUTO_INCREMENT PRIMARY KEY,
  _idComprador INT NOT NULL,
  _idVendedor INT NOT NULL,
  monto DECIMAL(10, 2) NOT NULL,
  comision DECIMAL(10, 2) NOT NULL,
  adquisicion DATETIME NOT NULL,
  pagado BOOLEAN DEFAULT FALSE,
  tipo ENUM('Compra', 'Reventa') NOT NULL,
  FOREIGN KEY (_idComprador) REFERENCES Personas(_id),
  FOREIGN KEY (_idVendedor) REFERENCES Personas(_id)
);

CREATE TABLE HistorialCompraVentas (
  _id INT AUTO_INCREMENT PRIMARY KEY,
  _boleto INT NOT NULL,
  _transaccion INT NOT NULL,
  FOREIGN KEY (_boleto) REFERENCES Boletos(_id),
  FOREIGN KEY (_transaccion) REFERENCES Transacciones(_id)
);
