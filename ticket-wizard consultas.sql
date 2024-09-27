---------------------
SELECT * FROM Personas;
SELECT * FROM Boletos;
SELECT * FROM Transacciones;
SELECT * FROM HistorialCompraVentas;
SELECT * FROM Reventas;

SELECT * FROM Personas WHERE _id = 1 limit 1;
SELECT * FROM Boletos WHERE _evento = 1 limit 1;

INSERT INTO Eventos (nombre, fecha, venue, ciudad, estado, descripcion) VALUES
('Coldplay World Tour', '2024-10-15', 'Foro Sol', 'Ciudad de México', 'CDMX', 'Concierto de Coldplay como parte de su gira mundial.'),
('Romeo y Julieta', '2024-10-20', 'Teatro de los Insurgentes', 'Ciudad de México', 'CDMX', 'Obra clásica de teatro, adaptada por un elenco internacional.'),
('Festival Vive Latino', '2024-11-05', 'Parque Bicentenario', 'Ciudad de México', 'CDMX', 'Festival de música alternativa con bandas de rock y géneros latinos.'),
('Luis Miguel Tour 2024', '2024-12-18', 'Arena Monterrey', 'Monterrey', 'Nuevo León', 'Concierto de Luis Miguel en su esperada gira por México.'),
('Hamilton', '2024-11-12', 'Teatro Telcel', 'Ciudad de México', 'CDMX', 'Obra musical sobre la vida de Alexander Hamilton, con una mezcla de hip hop y teatro clásico.'),
('Corona Capital 2024', '2024-11-19', 'Autódromo Hermanos Rodríguez', 'Ciudad de México', 'CDMX', 'Festival internacional de música con artistas y bandas de renombre mundial.'),
('Shakira World Tour', '2024-10-30', '', 'Guadalajara', 'Jalisco', 'Concierto de Shakira en su gira mundial.'),
('Café Tacvba 30 años', '2024-12-27', 'Palacio de los Deportes', 'Ciudad de México', 'CDMX', 'Concierto conmemorativo de los 30 años de la banda Café Tacvba.'),
('El Lago de los Cisnes', '2024-12-13', 'Auditorio Nacional', 'Ciudad de México', 'CDMX', 'Espectáculo de ballet clásico por la Compañía Nacional de Danza.'),
('Super Bowl Viewing Party', '2024-11-11', 'Estadio Azteca', 'Ciudad de México', 'CDMX', 'Proyección en vivo del Super Bowl con actividades y entretenimiento adicional.');


INSERT INTO Personas (nombre, correo, domicilio, fecha_nacimiento, saldo, contraseña) VALUES
('Juan Perez', 'juan.perez@example.com', 'Av. Siempre Viva 742, Springfield', '1985-07-23', 150.00, 'password123'),
('Maria Lopez', 'maria.lopez@example.com', 'Calle Falsa 123, Ciudad Gotica', '1990-05-14', 200.50, 'maria456'),
('Carlos Martinez', 'carlos.martinez@example.com', 'Paseo de la Reforma 350, Ciudad de Mexico', '1987-11-30', 350.75, 'carlos789'),
('Laura Garcia', 'laura.garcia@example.com', 'Gran Via 15, Madrid', '1992-02-08', 75.00, 'lauraPass12'),
('Ana Torres', 'ana.torres@example.com', 'Boulevard de los Suenos 222, Monterrey', '1983-09-19', 120.00, 'torresAna34'),
('Jose Ramirez', 'jose.ramirez@example.com', 'Av. Principal 45, Santiago', '1995-12-05', 0.00, 'josePass90'),
('Lucia Fernandez', 'lucia.fernandez@example.com', 'Calle Sol 101, Buenos Aires', '1991-03-17', 250.00, 'luciaFer18'),
('Andres Gomez', 'andres.gomez@example.com', 'Calle Luna 505, Lima', '1988-06-25', 300.00, 'gomezAnd90'),
('Sofia Rivera', 'sofia.rivera@example.com', 'Av. Libertadores 140, Bogota', '1993-10-12', 500.00, 'sofiaSecure123'),
('Ricardo Hernandez', 'ricardo.hernandez@example.com', 'Calle Real 77, Guadalajara', '1984-01-05', 100.00, 'ricardoHern789');


INSERT INTO Boletos (nSerie, _evento, fila, asiento, precioOriginal, precioActual, nControl, estado) VALUES
('A1B2C3D1', 1, 'A', '1', 1200.00, 1200.00, 'CTRL001', 'Disponible'),
('A1B2C3D2', 1, 'A', '2', 1200.00, 1200.00, 'CTRL002', 'Disponible'),
('A1B2C3D3', 1, 'A', '3', 1200.00, 1200.00, 'CTRL003', 'Disponible'),
('A1B2C3D4', 1, 'A', '4', 1200.00, 1200.00, 'CTRL004', 'Disponible'),
('A1B2C3D5', 1, 'A', '5', 1200.00, 1200.00, 'CTRL005', 'Disponible'),

('B1C2D3E1', 2, 'B', '10', 800.00, 800.00, 'CTRL006', 'Disponible'),
('B1C2D3E2', 2, 'B', '11', 800.00, 800.00, 'CTRL007', 'Disponible'),
('B1C2D3E3', 2, 'B', '12', 800.00, 800.00, 'CTRL008', 'Disponible'),

('C1D2E3F1', 3, 'C', '20', 1500.00, 1500.00, 'CTRL009', 'Disponible'),
('C1D2E3F2', 3, 'C', '21', 1500.00, 1500.00, 'CTRL010', 'Disponible'),
('C1D2E3F3', 3, 'C', '22', 1500.00, 1500.00, 'CTRL011', 'Disponible'),
('C1D2E3F4', 3, 'C', '23', 1500.00, 1500.00, 'CTRL012', 'Disponible'),

('D1E2F3G1', 4, 'D', '30', 1800.00, 1800.00, 'CTRL013', 'Disponible'),
('D1E2F3G2', 4, 'D', '31', 1800.00, 1800.00, 'CTRL014', 'Disponible'),
('D1E2F3G3', 4, 'D', '32', 1800.00, 1800.00, 'CTRL015', 'Disponible'),

('E1F2G3H1', 5, 'E', '40', 900.00, 900.00, 'CTRL016', 'Disponible'),
('E1F2G3H2', 5, 'E', '41', 900.00, 900.00, 'CTRL017', 'Disponible'),
('E1F2G3H3', 5, 'E', '42', 900.00, 900.00, 'CTRL018', 'Disponible'),
('E1F2G3H4', 5, 'E', '43', 900.00, 900.00, 'CTRL019', 'Disponible'),

('F1G2H3I1', 6, 'F', '50', 1300.00, 1300.00, 'CTRL020', 'Disponible'),
('F1G2H3I2', 6, 'F', '51', 1300.00, 1300.00, 'CTRL021', 'Disponible'),

('G1H2I3J1', 7, 'G', '60', 1100.00, 1100.00, 'CTRL022', 'Disponible'),
('G1H2I3J2', 7, 'G', '61', 1100.00, 1100.00, 'CTRL023', 'Disponible'),
('G1H2I3J3', 7, 'G', '62', 1100.00, 1100.00, 'CTRL024', 'Disponible'),

('H1I2J3K1', 8, 'H', '70', 1400.00, 1400.00, 'CTRL025', 'Disponible'),
('H1I2J3K2', 8, 'H', '71', 1400.00, 1400.00, 'CTRL026', 'Disponible'),
('H1I2J3K3', 8, 'H', '72', 1400.00, 1400.00, 'CTRL027', 'Disponible'),

('I1J2K3L1', 9, 'I', '80', 1000.00, 1000.00, 'CTRL028', 'Disponible'),
('I1J2K3L2', 9, 'I', '81', 1000.00, 1000.00, 'CTRL029', 'Disponible'),

('J1K2L3M1', 10, 'J', '90', 500.00, 500.00, 'CTRL030', 'Disponible');



INSERT INTO Transacciones (_idComprador, _idVendedor, monto, comision, adquisicion, pagado, tipo) VALUES
(1, 2, 1200.00, 50.00, '2024-09-16 10:30:00', TRUE, 'Compra'),
(3, 2, 1200.00, 50.00, '2024-09-16 11:00:00', TRUE, 'Compra'),
(4, 2, 1200.00, 50.00, '2024-09-16 11:30:00', TRUE, 'Compra'),
(5, 6, 800.00, 40.00, '2024-09-16 12:00:00', TRUE, 'Compra'),
(7, 6, 800.00, 40.00, '2024-09-16 12:30:00', TRUE, 'Compra'),
(8, 9, 1500.00, 75.00, '2024-09-16 13:00:00', TRUE, 'Compra'),
(9, 10, 1500.00, 75.00, '2024-09-16 13:30:00', TRUE, 'Compra'),
(10, 1, 1800.00, 90.00, '2024-09-16 14:00:00', TRUE, 'Compra'),
(2, 3, 900.00, 45.00, '2024-09-16 14:30:00', TRUE, 'Compra'),
(5, 7, 1300.00, 65.00, '2024-09-16 15:00:00', TRUE, 'Compra');


INSERT INTO HistorialCompraVentas (_boleto, _transaccion) VALUES
(1, 1),
(2, 2),
(3, 3),
(6, 4),
(7, 5),
(9, 6),
(10, 7),
(13, 8),
(17, 9),
(20, 10);

INSERT INTO Personas (nombre, correo, domicilio, fecha_nacimiento, saldo, contraseña) VALUES
('Francisco', 'francisco@example.com', 'Av. Viena 2543, Cd. Obregon', '1999-08-13', 1500.00, 'frank123');


SELECT p.nombre, p.correo, t.adquisicion
FROM Personas p
JOIN Transacciones t ON p._id = t._idComprador
JOIN HistorialCompraVentas hcv ON t._id = hcv._transaccion
WHERE hcv._boleto = 22
ORDER BY t.adquisicion DESC
LIMIT 1;


SELECT b._id, b.nSerie, b.fila, b.asiento, b.precioActual, t.adquisicion
FROM Boletos b
JOIN HistorialCompraVentas hcv ON b._id = hcv._boleto
JOIN Transacciones t ON hcv._transaccion = t._id
WHERE t._idComprador = 1 
AND t.adquisicion = (
    SELECT MAX(t2.adquisicion)
    FROM Transacciones t2
    JOIN HistorialCompraVentas hcv2 ON t2._id = hcv2._transaccion
    WHERE hcv2._boleto = b._id
)
ORDER BY t.adquisicion DESC;