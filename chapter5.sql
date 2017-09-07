-- MySQL dump 10.13  Distrib 5.7.19, for Win64 (x86_64)
--
-- Host: localhost    Database: chapter5
-- ------------------------------------------------------
-- Server version	5.7.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `chapter5`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `chapter5` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `chapter5`;

--
-- Table structure for table `spitter`
--

DROP TABLE IF EXISTS `spitter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `spitter` (
  `id` int(12) DEFAULT NULL,
  `username` varchar(20) CHARACTER SET utf8 NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 NOT NULL,
  `first_name` varchar(30) CHARACTER SET utf8 NOT NULL,
  `last_name` varchar(30) CHARACTER SET utf8 NOT NULL,
  `email` varchar(30) CHARACTER SET utf8 NOT NULL,
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spitter`
--

LOCK TABLES `spitter` WRITE;
/*!40000 ALTER TABLE `spitter` DISABLE KEYS */;
INSERT INTO `spitter` VALUES (201,'ldx','123123','lei','slark','7514@qq.com');
/*!40000 ALTER TABLE `spitter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spittle`
--

DROP TABLE IF EXISTS `spittle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `spittle` (
  `id` int(12) DEFAULT NULL,
  `message` varchar(140) CHARACTER SET utf8 NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spittle`
--

LOCK TABLES `spittle` WRITE;
/*!40000 ALTER TABLE `spittle` DISABLE KEYS */;
INSERT INTO `spittle` VALUES (1,'大大萨达大所爱的','2017-09-07 01:42:27',1.2,2.3);
/*!40000 ALTER TABLE `spittle` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-07 19:14:02
