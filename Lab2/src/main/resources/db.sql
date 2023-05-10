CREATE DATABASE lab2;
USE lab2;

CREATE TABLE `users` (
    `usr` varchar(255) NOT NULL,
    `mail` varchar(255) NOT NULL,
    `pwd` varchar(255) NOT NULL,
    `birthday` date NOT NULL,
    PRIMARY KEY (`usr`),
    UNIQUE KEY `mail` (`mail`)
);
ALTER TABLE `users` ADD `gender` ENUM('male', 'female') NOT NULL;
ALTER TABLE `users` ADD `phoneNumber` VARCHAR(255) UNIQUE;
