CREATE DATABASE epaw;
USE epaw;

CREATE TABLE user (
    nom VARCHAR(24),
    descripcio VARCHAR(255),
    id INTEGER NOT NULL AUTO_INCREMENT,
    telefon INTEGER,
    PRIMARY KEY (id)
);

INSERT INTO user
    (nom, descripcio, telefon)
VALUES
    ('Joan', 'Teacher', 600100100),
    ('Francesc', 'Teacher', 600100101),
    ('Dani', 'Teacher', 600100102),
    ('Maria', 'Student', 600100103),
    ('Laura', 'Student', 600100104),
    ('Antoni', 'Student', 600100105);

