CREATE database if not exists finallab ;

USE finallab;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
                         `id` int NOT NULL AUTO_INCREMENT,
                         `name` varchar(20) DEFAULT NULL,
                         `mail` varchar(40) NOT NULL,
                         `pwd` varchar(20) NOT NULL,
                         `birthday` date NOT NULL,
                         `gender` ENUM('male', 'female') NOT NULL,
                         `phoneNumber` VARCHAR(20) UNIQUE,
                         `terms` bool NOT NULL,
                         `newsletter` bool NOT NULL,
                         PRIMARY KEY (`id`),
                         UNIQUE KEY `mail` (`mail`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `follows`;
CREATE TABLE `follows` (
                           `uid` int NOT NULL,
                           `fid` int NOT NULL,
                           PRIMARY KEY (`uid`,`fid`),
                           KEY `fid_users_fk` (`fid`),
                           CONSTRAINT `fid_users_fk` FOREIGN KEY (`fid`) REFERENCES `users` (`id`),
                           CONSTRAINT `uid_users_fk` FOREIGN KEY (`uid`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `tweets`;
CREATE TABLE `tweets` (
                          `id` int NOT NULL AUTO_INCREMENT,
                          `uid` int DEFAULT NULL,
                          `postdatetime` timestamp NULL DEFAULT NULL,
                          `content` varchar(100) DEFAULT NULL,
                          `pid` int DEFAULT NULL,
                          PRIMARY KEY (`id`),
                          KEY `tweets_users_fk` (`uid`),
                          KEY `tweets_tweets_fk` (`pid`),
                          CONSTRAINT `tweets_tweets_fk` FOREIGN KEY (`pid`) REFERENCES `tweets` (`id`) ON DELETE CASCADE,
                          CONSTRAINT `tweets_users_fk` FOREIGN KEY (`uid`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



