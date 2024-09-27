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
  asiento int,
  precioOriginal DECIMAL(10, 2) NOT NULL,
  precioActual DECIMAL(10, 2) NOT NULL,
  nControl VARCHAR(255),
  estado ENUM('Disponible', 'Apartado') DEFAULT 'Disponible',
  FOREIGN KEY (_evento) REFERENCES Eventos(_id)
);

CREATE TABLE Reventas(
	_id INT AUTO_INCREMENT PRIMARY KEY,
    _idBoleto INT NOT NULL,
    _idVendedor INT NOT NULL,
    FOREIGN KEY (_idBoleto) REFERENCES Boletos(_id),
	FOREIGN KEY (_idVendedor) REFERENCES Personas(_id)
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

-- /TRIGGER/
DELIMITER $$
CREATE TRIGGER actualizar_saldos_transaccion
AFTER INSERT ON Transacciones
FOR EACH ROW
BEGIN
    -- Descontar monto del saldo del comprador
    UPDATE Personas
    SET saldo = saldo - NEW.monto
    WHERE _id = NEW._idComprador;

    -- Sumar monto (menos comisión) al saldo del vendedor
    UPDATE Personas
    SET saldo = saldo + (NEW.monto - NEW.comision)
    WHERE _id = NEW._idVendedor;
END $$
DELIMITER ;


-- /Stored Procedure/
DELIMITER $$
CREATE PROCEDURE realizar_compra_boleto(
    IN _idComprador INT,
    IN _idVendedor INT,
    IN _idBoleto INT,
    IN monto DECIMAL(10, 2),
    IN comision DECIMAL(10, 2)
)
BEGIN
    DECLARE _saldo_comprador DECIMAL(10,2);
    DECLARE _estado_boleto VARCHAR(20);
    -- Obtener el saldo del comprador
    SELECT saldo INTO _saldo_comprador
    FROM Personas
    WHERE _id = _idComprador;
    -- Obtener el estado del boleto
    SELECT estado INTO _estado_boleto
    FROM Boletos
    WHERE _id = _idBoleto;
    -- Verificar que el saldo sea suficiente y que el boleto esté disponible
    IF _saldo_comprador >= monto AND _estado_boleto = 'Disponible' THEN
        -- Actualizar estado del boleto a 'Apartado'
        UPDATE Boletos
        SET estado = 'Apartado'
        WHERE _id = _idBoleto;
        -- Insertar la transacción
        INSERT INTO Transacciones (_idComprador, _idVendedor, monto, comision, adquisicion, pagado, tipo)
        VALUES (_idComprador, _idVendedor, monto, comision, NOW(), TRUE, 'Compra');
        -- Insertar en el historial
        INSERT INTO HistorialCompraVentas (_boleto, _transaccion)
        VALUES (_idBoleto, LAST_INSERT_ID());
    ELSE
        -- Si no hay saldo suficiente o el boleto no está disponible
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Saldo insuficiente o boleto no disponible';
    END IF;
END $$
DELIMITER ;


-- /TRANSACTION
