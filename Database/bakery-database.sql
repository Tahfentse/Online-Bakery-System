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
  `street_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `suburb` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `postal_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `person_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`address_id`),
  KEY `FK_address_person` (`person_id`),
  CONSTRAINT `FK_address_person` FOREIGN KEY (`person_id`) REFERENCES `person` (`idNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table bakery-systemdb.address: ~0 rows (approximately)

-- Dumping structure for table bakery-systemdb.category
DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
  `categoryId` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`categoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table bakery-systemdb.category: ~7 rows (approximately)
INSERT INTO `category` (`categoryId`, `name`) VALUES
	(1, 'cakes'),
	(2, 'cupcakes'),
	(3, 'brownies'),
	(4, 'fresh bread'),
	(5, 'pies'),
	(6, 'donuts'),
	(7, 'cookies');

-- Dumping structure for table bakery-systemdb.ingredient
DROP TABLE IF EXISTS `ingredient`;
CREATE TABLE IF NOT EXISTS `ingredient` (
  `ingredient_id` int NOT NULL AUTO_INCREMENT,
  `ingredient_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0',
  `ingredient_size` double NOT NULL DEFAULT '0',
  `item_id` int DEFAULT NULL,
  PRIMARY KEY (`ingredient_id`) USING BTREE,
  KEY `FK_ingridient_item` (`item_id`),
  CONSTRAINT `FK_ingridient_item` FOREIGN KEY (`item_id`) REFERENCES `item` (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table bakery-systemdb.ingredient: ~0 rows (approximately)

-- Dumping structure for table bakery-systemdb.item
DROP TABLE IF EXISTS `item`;
CREATE TABLE IF NOT EXISTS `item` (
  `item_id` int NOT NULL AUTO_INCREMENT,
  `item_title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0',
  `item_description` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0',
  `item_nutrients` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `item_pic` longblob NOT NULL,
  `item_category` int NOT NULL DEFAULT '0',
  `item_price` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`item_id`),
  KEY `FK_item_category` (`item_category`),
  CONSTRAINT `FK_item_category` FOREIGN KEY (`item_category`) REFERENCES `category` (`categoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table bakery-systemdb.item: ~1 rows (approximately)
INSERT INTO `item` (`item_id`, `item_title`, `item_description`, `item_nutrients`, `item_pic`, `item_category`, `item_price`) VALUES
	(1, 'Banana Bread', 'tsbfhnfehfgv', 'rvfcrfbtfhgrh', _binary '', 4, 2359);

-- Dumping structure for table bakery-systemdb.oderitemid
DROP TABLE IF EXISTS `oderitemid`;
CREATE TABLE IF NOT EXISTS `oderitemid` (
  `OrderId` int NOT NULL,
  `OrderItemid` int NOT NULL AUTO_INCREMENT,
  `ItemId` int DEFAULT NULL,
  PRIMARY KEY (`OrderItemid`),
  KEY `FK_oderitemid_order` (`OrderId`),
  KEY `FK_oderitemid_item` (`ItemId`),
  CONSTRAINT `FK_oderitemid_item` FOREIGN KEY (`ItemId`) REFERENCES `item` (`item_id`),
  CONSTRAINT `FK_oderitemid_order` FOREIGN KEY (`OrderId`) REFERENCES `order` (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table bakery-systemdb.oderitemid: ~0 rows (approximately)

-- Dumping structure for table bakery-systemdb.order
DROP TABLE IF EXISTS `order`;
CREATE TABLE IF NOT EXISTS `order` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `order_price` double NOT NULL DEFAULT (0),
  `orderTimeStamp` timestamp NOT NULL,
  `item_note` mediumtext,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table bakery-systemdb.order: ~0 rows (approximately)

-- Dumping structure for table bakery-systemdb.person
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

-- Dumping data for table bakery-systemdb.person: ~0 rows (approximately)

-- Dumping structure for table bakery-systemdb.recipe
DROP TABLE IF EXISTS `recipe`;
CREATE TABLE IF NOT EXISTS `recipe` (
  `recipeid` int NOT NULL DEFAULT (0),
  `item_recipe` longtext,
  `size` double NOT NULL DEFAULT (0),
  KEY `FK_recipe_ingridient` (`recipeid`),
  CONSTRAINT `FK_recipe_item` FOREIGN KEY (`recipeid`) REFERENCES `item` (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table bakery-systemdb.recipe: ~0 rows (approximately)

-- Dumping structure for table bakery-systemdb.recipe_ingredient
DROP TABLE IF EXISTS `recipe_ingredient`;
CREATE TABLE IF NOT EXISTS `recipe_ingredient` (
  `recipeIngredient` int NOT NULL AUTO_INCREMENT,
  `recipeId` int DEFAULT NULL,
  `ingredientId` int DEFAULT NULL,
  PRIMARY KEY (`recipeIngredient`),
  KEY `FK_recipe_ingredient_recipe` (`recipeId`),
  KEY `FK_recipe_ingredient_ingredient` (`ingredientId`),
  CONSTRAINT `FK_recipe_ingredient_ingredient` FOREIGN KEY (`ingredientId`) REFERENCES `ingredient` (`ingredient_id`),
  CONSTRAINT `FK_recipe_ingredient_recipe` FOREIGN KEY (`recipeId`) REFERENCES `recipe` (`recipeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table bakery-systemdb.recipe_ingredient: ~0 rows (approximately)

-- Dumping structure for table bakery-systemdb.stock
DROP TABLE IF EXISTS `stock`;
CREATE TABLE IF NOT EXISTS `stock` (
  `stock_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '0',
  `size` double NOT NULL DEFAULT (0),
  `recipe_id` int NOT NULL DEFAULT (0),
  PRIMARY KEY (`stock_id`),
  KEY `FK_stock_recipe` (`recipe_id`),
  CONSTRAINT `FK_stock_recipe` FOREIGN KEY (`recipe_id`) REFERENCES `recipe` (`recipeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table bakery-systemdb.stock: ~0 rows (approximately)

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
