/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

DROP DATABASE IF EXISTS `bakery-systemdb`;
CREATE DATABASE IF NOT EXISTS `bakery-systemdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bakery-systemdb`;

DROP TABLE IF EXISTS `address`;
CREATE TABLE IF NOT EXISTS `address` (
  `address_id` varchar(50) NOT NULL,
  `street_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `suburb` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `postal_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `person_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`address_id`),
  KEY `FK_address_person` (`person_id`),
  CONSTRAINT `FK_address_person` FOREIGN KEY (`person_id`) REFERENCES `person` (`idNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `ingridient`;
CREATE TABLE IF NOT EXISTS `ingridient` (
  `ingridient_id` int NOT NULL AUTO_INCREMENT,
  `ingridient_name` varchar(50) NOT NULL DEFAULT '0',
  `ingridient_size` double NOT NULL DEFAULT (0),
  `item_id` int DEFAULT NULL,
  PRIMARY KEY (`ingridient_id`),
  KEY `FK_ingridient_item` (`item_id`),
  CONSTRAINT `FK_ingridient_item` FOREIGN KEY (`item_id`) REFERENCES `item` (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `item`;
CREATE TABLE IF NOT EXISTS `item` (
  `item_id` int NOT NULL AUTO_INCREMENT,
  `item_title` varchar(50) NOT NULL DEFAULT '0',
  `item_description` varchar(50) NOT NULL DEFAULT '0',
  `item_warnings` varchar(50) NOT NULL DEFAULT '0',
  `item_nutrients` varchar(50) NOT NULL DEFAULT '0',
  `item_pic` longblob,
  `item_category` varchar(50) NOT NULL DEFAULT '',
  `item_price` double NOT NULL DEFAULT (0),
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `oderitemid`;
CREATE TABLE IF NOT EXISTS `oderitemid` (
  `OrderId` int NOT NULL,
  `OrderItemid` int NOT NULL AUTO_INCREMENT,
  `ItemId` int DEFAULT NULL,
  PRIMARY KEY (`OrderItemid`),
  KEY `FK_oderitemid_order` (`OrderId`),
  KEY `FK_oderitemid_item` (`ItemId`),
  CONSTRAINT `FK_oderitemid_item` FOREIGN KEY (`ItemId`) REFERENCES `item` (`item_id`),
  CONSTRAINT `FK_oderitemid_order` FOREIGN KEY (`OrderId`) REFERENCES `ordert` (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `ordert`;
CREATE TABLE IF NOT EXISTS `ordert` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `order_price` double NOT NULL DEFAULT (0),
  `orderTimeStamp` timestamp NOT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `person`;
CREATE TABLE IF NOT EXISTS `person` (
  `idNumber` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(50) NOT NULL DEFAULT '0',
  `surname` varchar(50) NOT NULL DEFAULT '0',
  `title` varchar(50) NOT NULL DEFAULT '0',
  `contactNo` varchar(50) NOT NULL DEFAULT '0',
  `email` varchar(50) NOT NULL DEFAULT '0',
  `password` varchar(50) NOT NULL,
  `role` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`idNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `recipe`;
CREATE TABLE IF NOT EXISTS `recipe` (
  `recipeid` int NOT NULL DEFAULT (0),
  `ingridientid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(50) NOT NULL,
  `size` double NOT NULL DEFAULT (0),
  KEY `FK_recipe_ingridient` (`recipeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `stock`;
CREATE TABLE IF NOT EXISTS `stock` (
  `stock_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '0',
  `size` double NOT NULL DEFAULT (0),
  PRIMARY KEY (`stock_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
