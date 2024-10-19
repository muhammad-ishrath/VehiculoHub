-- Create the database
CREATE DATABASE IF NOT EXISTS vehiculohub;

-- Use the database
USE vehiculohub;

-- Create the vehicle table
CREATE TABLE vehicle
(
    vid              INT AUTO_INCREMENT PRIMARY KEY,
    brand            VARCHAR(50),
    model            VARCHAR(50),
    engineCapacity   INT,
    transmissionMode VARCHAR(50),
    qty              INT,
    price            DECIMAL(10, 2)
);

GRANT ALL PRIVILEGES ON vehiculo_hub.* TO 'Ishrath'@'localhost';
FLUSH PRIVILEGES;


INSERT INTO vehicle(brand,model,engineCapacity,transmissionMode,qty,price) VALUES
    ("Toyota","Corolla",2500,'manual',5,20000.00),
    ('Honda', 'Civic', 1800, 'manual', 7, 22000.00),
    ('Mercedes', 'C-Class', 3000, 'manual', 5, 45000.00);


