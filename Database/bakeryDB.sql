-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.25 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.5.0.6677
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for bakery-systemdb
DROP DATABASE IF EXISTS `bakery-systemdb`;
CREATE DATABASE IF NOT EXISTS `bakery-systemdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bakery-systemdb`;

-- Dumping structure for table bakery-systemdb.address
DROP TABLE IF EXISTS `address`;
CREATE TABLE IF NOT EXISTS `address` (
  `address_id` int NOT NULL AUTO_INCREMENT,
  `street_name` varchar(50) NOT NULL DEFAULT '0',
  `suburb` varchar(50) NOT NULL DEFAULT '0',
  `postal_code` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table bakery-systemdb.address: ~0 rows (approximately)
INSERT INTO `address` (`address_id`, `street_name`, `suburb`, `postal_code`) VALUES
	(1, 'crestview', 'Temba', '0403');

-- Dumping structure for table bakery-systemdb.ingridient
DROP TABLE IF EXISTS `ingridient`;
CREATE TABLE IF NOT EXISTS `ingridient` (
  `ingridient_id` int NOT NULL AUTO_INCREMENT,
  `ingridient_name` varchar(50) NOT NULL DEFAULT '0',
  `ingridient_size` double NOT NULL DEFAULT (0),
  PRIMARY KEY (`ingridient_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table bakery-systemdb.ingridient: ~0 rows (approximately)

-- Dumping structure for table bakery-systemdb.item
DROP TABLE IF EXISTS `item`;
CREATE TABLE IF NOT EXISTS `item` (
  `item_id` int NOT NULL AUTO_INCREMENT,
  `item_title` varchar(50) NOT NULL DEFAULT '0',
  `item_description` varchar(50) NOT NULL DEFAULT '0',
  `item_warnings` varchar(50) NOT NULL DEFAULT '0',
  `item_nutrients` varchar(50) NOT NULL DEFAULT '0',
  `item_pic` blob NOT NULL,
  `item_category` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table bakery-systemdb.item: ~0 rows (approximately)

-- Dumping structure for table bakery-systemdb.order
DROP TABLE IF EXISTS `order`;
CREATE TABLE IF NOT EXISTS `order` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `order_price` double NOT NULL DEFAULT (0),
  `item_id` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`order_id`),
  KEY `FK_order_item` (`item_id`),
  CONSTRAINT `FK_order_item` FOREIGN KEY (`item_id`) REFERENCES `item` (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table bakery-systemdb.order: ~0 rows (approximately)

-- Dumping structure for table bakery-systemdb.person
DROP TABLE IF EXISTS `person`;
CREATE TABLE IF NOT EXISTS `person` (
  `idNumber` bigint NOT NULL DEFAULT (0),
  `name` varchar(50) NOT NULL DEFAULT '0',
  `surname` varchar(50) NOT NULL DEFAULT '0',
  `title` varchar(50) NOT NULL DEFAULT '0',
  `address_id` int NOT NULL DEFAULT (0),
  `contactNo` varchar(50) NOT NULL DEFAULT '0',
  `email` varchar(50) NOT NULL DEFAULT '0',
  `password` varchar(50) NOT NULL,
  `role` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`idNumber`),
  KEY `FK_customer_address` (`address_id`),
  CONSTRAINT `FK_customer_address` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table bakery-systemdb.person: ~1 rows (approximately)
INSERT INTO `person` (`idNumber`, `name`, `surname`, `title`, `address_id`, `contactNo`, `email`, `password`, `role`) VALUES
	(1212125698741, 'Ofentse', 'Ngobeni', 'Mr', 1, '0798529034', 'fentse283@gmail.com', 'Demo@1234', 'admin');

-- Dumping structure for table bakery-systemdb.stock
DROP TABLE IF EXISTS `stock`;
CREATE TABLE IF NOT EXISTS `stock` (
  `stock_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '0',
  `size` double NOT NULL DEFAULT (0),
  PRIMARY KEY (`stock_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table bakery-systemdb.stock: ~0 rows (approximately)

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
