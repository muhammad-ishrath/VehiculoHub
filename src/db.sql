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



