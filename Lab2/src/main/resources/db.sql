-- CREATE DATABASE lab2;
USE lab2;

DROP TABLE `users`;
CREATE TABLE `users` (
    `usr` varchar(255) NOT NULL PRIMARY KEY,
    `mail` varchar(255) NOT NULL,
    `pwd` varchar(255) NOT NULL,
    `birthday` date NOT NULL,
    UNIQUE KEY `mail` (`mail`),
    `gender` ENUM('male', 'female') NOT NULL,
    `phoneNumber` VARCHAR(255) UNIQUE,
    `terms` bool NOT NULL,
    `newsletter` bool NOT NULL
);
