CREATE DATABASE  IF NOT EXISTS `ssafytest`;
USE `ssafytest`;

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product`(
  `code` varchar(20) NOT NULL,
  `model` varchar(20) NOT NULL,
  `price` int NOT NULL,
  
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `product` WRITE;
INSERT INTO `product` VALUES ('1234','2021',1234),('16ZD95P-GX50K','2022 그램16',1475900),('NT550XDZ-AD5A','노트북 플러스2',729000);
UNLOCK TABLES;

