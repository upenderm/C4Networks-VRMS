-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.22-rc-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema videorentalstore
--

CREATE DATABASE IF NOT EXISTS videorentalstore;
USE videorentalstore;

--
-- Definition of table `categories`
--

DROP TABLE IF EXISTS `categories`;
CREATE TABLE `categories` (
  `category_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `category_name` varchar(45) NOT NULL,
  `category_desc` varchar(100) DEFAULT NULL,
  `price` int(3) NOT NULL,
  `created_by` int(10) unsigned NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `last_modified_by` int(10) unsigned NOT NULL,
  `last_modified_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`category_id`),
  KEY `FK_categories_1` (`created_by`),
  KEY `FK_categories_2` (`last_modified_by`),
  CONSTRAINT `FK_categories_1` FOREIGN KEY (`created_by`) REFERENCES `customer_details` (`customer_id`),
  CONSTRAINT `FK_categories_2` FOREIGN KEY (`last_modified_by`) REFERENCES `customer_details` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `categories`
--

/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` (`category_id`,`category_name`,`category_desc`,`price`,`created_by`,`created_date`,`last_modified_by`,`last_modified_date`,`status`) VALUES 
 (1,'New releases','New releases',40,1,'2014-04-30 17:35:56',1,'2014-04-30 17:15:14','ACTIVE'),
 (2,'Regular films','Regular films',30,1,'2014-04-30 17:36:03',1,'2014-04-30 17:16:02','ACTIVE'),
 (3,'Old films','Old films',30,1,'2014-04-30 17:36:07',1,'2014-04-30 17:16:03','ACTIVE');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;


--
-- Definition of table `customer_details`
--

DROP TABLE IF EXISTS `customer_details`;
CREATE TABLE `customer_details` (
  `customer_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `vrms_id` varchar(20) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `address` varchar(100) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `mobile` varchar(10) NOT NULL,
  `created_by` int(10) unsigned NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `last_modified_by` int(10) unsigned NOT NULL,
  `last_modified_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer_details`
--

/*!40000 ALTER TABLE `customer_details` DISABLE KEYS */;
INSERT INTO `customer_details` (`customer_id`,`vrms_id`,`first_name`,`last_name`,`email`,`address`,`phone`,`mobile`,`created_by`,`created_date`,`last_modified_by`,`last_modified_date`,`status`) VALUES 
 (1,'VRMS001','ADMIN','SUPER','admin@vrm.com','Hyderabad','67576375','9849613769',1,'2014-05-01 00:08:58',1,'2014-04-30 15:35:30','ACTIVE'),
 (2,'VRMS002','Upender','M','upender@gmail.com','Hyderabad','66668888','9849613769',1,'2014-05-01 00:09:08',1,'2014-04-30 16:12:13','ACTIVE'),
 (3,'VRMS003','Kanakalaxmi','Pinnoju','klaxmi.pinnoju@gmail.com','Karimnagar','','9705406390',1,'2014-05-01 00:09:14',1,'2014-04-30 16:14:32','ACTIVE'),
 (4,'VRMS004','Upender','Mamindlapelly','upender0209@gmail.com','Warangal','','984949494',1,'2014-05-01 00:09:19',1,'2014-04-30 16:17:13','ACTIVE'),
 (5,'VRMS005','fname','lname','test@vrm.com','myaddress','33939','989898989',1,'2014-05-01 00:09:25',1,'2014-04-30 17:02:21','ACTIVE'),
 (6,'VRMS006','Johnson','Ben','johnson.ben@adp.com','Roseland','3933333','231568849',1,'2014-05-01 00:09:51',1,'2014-04-30 19:50:34','ACTIVE');
/*!40000 ALTER TABLE `customer_details` ENABLE KEYS */;


--
-- Definition of table `movies`
--

DROP TABLE IF EXISTS `movies`;
CREATE TABLE `movies` (
  `movie_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `movie_name` varchar(50) NOT NULL,
  `movie_desc` varchar(100) DEFAULT NULL,
  `category_id` int(10) unsigned NOT NULL,
  `copies` int(11) NOT NULL,
  `created_by` int(10) unsigned NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `last_modified_by` int(10) unsigned NOT NULL,
  `last_modified_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`movie_id`),
  KEY `FK_movies_1` (`category_id`),
  KEY `FK_movies_2` (`created_by`),
  KEY `FK_movies_3` (`last_modified_by`),
  CONSTRAINT `FK_movies_1` FOREIGN KEY (`category_id`) REFERENCES `categories` (`category_id`),
  CONSTRAINT `FK_movies_2` FOREIGN KEY (`created_by`) REFERENCES `customer_details` (`customer_id`),
  CONSTRAINT `FK_movies_3` FOREIGN KEY (`last_modified_by`) REFERENCES `customer_details` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `movies`
--

/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies` (`movie_id`,`movie_name`,`movie_desc`,`category_id`,`copies`,`created_by`,`created_date`,`last_modified_by`,`last_modified_date`) VALUES 
 (1,'Matrix 11','Matrix 11',1,5,1,'2014-04-30 23:49:01',1,'2014-04-30 18:58:16'),
 (2,'Spiderman','Spiderman',2,5,1,'2014-04-30 23:49:01',1,'2014-04-30 18:58:43'),
 (3,'Spiderman 2','Spiderman 2',2,5,1,'2014-04-30 23:49:01',1,'2014-04-30 18:59:00'),
 (4,'Bladerunner','Bladerunner',3,5,1,'2014-04-30 23:49:01',1,'2014-04-30 18:59:11'),
 (5,'Out of Africa','Out of Africa',3,5,1,'2014-04-30 23:49:01',1,'2014-04-30 18:59:23'),
 (6,'X-Men Volverine','X-Men Volverine',1,5,1,'2014-04-30 23:49:01',1,'2014-04-30 19:49:10'),
 (7,'Mid night meat train','Mid night meat train',2,3,1,'2014-04-30 23:56:31',1,'2014-04-30 23:56:31');
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;


--
-- Definition of table `rental_details`
--

DROP TABLE IF EXISTS `rental_details`;
CREATE TABLE `rental_details` (
  `rental_details_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `rental_Id` varchar(10) NOT NULL,
  `customer_id` int(10) unsigned NOT NULL,
  `movie_id` int(10) unsigned NOT NULL,
  `rental_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `expected_return_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `actual_return_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `bonus_points` int(10) unsigned NOT NULL,
  `bonus_status` varchar(10) NOT NULL,
  `late_charges` int(10) unsigned NOT NULL,
  PRIMARY KEY (`rental_details_id`),
  KEY `FK_rental_details_1` (`customer_id`),
  KEY `FK_rental_details_2` (`movie_id`),
  CONSTRAINT `FK_rental_details_1` FOREIGN KEY (`customer_id`) REFERENCES `customer_details` (`customer_id`),
  CONSTRAINT `FK_rental_details_2` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`movie_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rental_details`
--

/*!40000 ALTER TABLE `rental_details` DISABLE KEYS */;
INSERT INTO `rental_details` (`rental_details_id`,`rental_Id`,`customer_id`,`movie_id`,`rental_date`,`expected_return_date`,`actual_return_date`,`bonus_points`,`bonus_status`,`late_charges`) VALUES 
 (1,'RNT001',3,1,'2014-05-01 00:23:18','2014-04-30 23:14:42','2014-04-30 23:14:50',2,'ACTIVE',0),
 (2,'RNT002',2,2,'2014-05-01 00:23:32','2014-04-30 23:19:32','2014-04-30 23:19:32',1,'ACTIVE',0),
 (3,'RNT003',6,5,'2014-05-01 00:23:44','2014-04-30 23:19:47','2014-04-30 23:19:47',1,'ACTIVE',0),
 (4,'RNT004',5,5,'2014-05-01 00:29:29','2014-05-01 00:29:29','2014-05-01 00:29:29',1,'ACTIVE',0);
/*!40000 ALTER TABLE `rental_details` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
