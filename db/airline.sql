-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: airline
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `aircraft` fdgdfg
-- dfgdfg

DROP TABLE IF EXISTS `aircraft`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `aircraft` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `tail_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aircraft`
--

LOCK TABLES `aircraft` WRITE;
/*!40000 ALTER TABLE `aircraft` DISABLE KEYS */;
INSERT INTO `aircraft` VALUES (1,'Boeing 777','S87D8J4'),(2,'Boeing 787 Dreamliner','KG93F83'),(3,'Airbus A380','KKK83FG');
/*!40000 ALTER TABLE `aircraft` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `airport`
--

DROP TABLE IF EXISTS `airport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `airport` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(45) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airport`
--

LOCK TABLES `airport` WRITE;
/*!40000 ALTER TABLE `airport` DISABLE KEYS */;
INSERT INTO `airport` VALUES (1,'SVO','Sheremetyevo International Airport','Russia'),(2,'VKO','Vnukovo International Airport','Russia'),(3,'IJK','Izhevsk Airport','Russia'),(4,'AER','Sochi International Airport','Russia'),(5,'SZG','Salzburg Airport','Austria'),(6,'VIE','Vienna International Airport ','Austria'),(7,'LNZ','Linz Airport','Austria'),(8,'LED','Pulkovo Airport','Russia');
/*!40000 ALTER TABLE `airport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crew`
--

DROP TABLE IF EXISTS `crew`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `crew` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `status` enum('READY','WAITING_FOR_APPROVAL','WATING_FOR_COMPLETION') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crew`
--

LOCK TABLES `crew` WRITE;
/*!40000 ALTER TABLE `crew` DISABLE KEYS */;
INSERT INTO `crew` VALUES (1,'A8343BH76','READY'),(2,'GG34SD','WAITING_FOR_APPROVAL');
/*!40000 ALTER TABLE `crew` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `flight` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(45) DEFAULT NULL,
  `aircraft` int(11) DEFAULT NULL,
  `from_airport` int(11) DEFAULT NULL,
  `to_airport` int(11) DEFAULT NULL,
  `departure_datetime` datetime DEFAULT NULL,
  `arrival_datetime` datetime DEFAULT NULL,
  `crew` int(11) DEFAULT NULL,
  `status` enum('READY','WAITING_FOR_APPROVAL','WATING_FOR_COMPLETION') DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_flight_crew_idx` (`crew`),
  KEY `fk_flight_to_airport_idx` (`to_airport`),
  KEY `fk_flight_from_airport_idx` (`from_airport`),
  CONSTRAINT `fk_flight_crew` FOREIGN KEY (`crew`) REFERENCES `crew` (`id`),
  CONSTRAINT `fk_flight_from_airport` FOREIGN KEY (`from_airport`) REFERENCES `airport` (`id`),
  CONSTRAINT `fk_flight_to_airport` FOREIGN KEY (`to_airport`) REFERENCES `airport` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` VALUES (1,'IF3F3IJ',1,1,5,'2019-06-23 11:12:00','2019-06-23 13:12:00',2,'READY'),(2,'4J3HGGG',2,3,8,'2019-12-24 10:11:00','2019-12-24 22:30:00',2,'READY'),(5,'JD5L3DA',1,5,2,'2019-03-25 08:12:00','2019-03-25 21:23:00',2,'READY'),(6,'ASDA233',2,7,3,'2019-03-22 21:12:00','2019-03-23 08:12:00',2,'WAITING_FOR_APPROVAL'),(9,'MMJD3S4',2,8,5,'2019-03-29 08:12:00','2019-03-29 21:13:00',2,'WAITING_FOR_APPROVAL'),(10,'23EKL45',1,2,4,'2019-03-24 08:12:00','2019-03-25 08:12:00',2,'READY');
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(45) DEFAULT NULL,
  `position` enum('PILOT','NAVIGATOR','OPERATOR','STEWARDESS') DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `crew` int(11) DEFAULT '-1',
  PRIMARY KEY (`id`),
  KEY `fk_crew_member_idx` (`crew`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (1,'15A3434','PILOT','John','Doe',1),(2,'15B34','PILOT','Richard','Stallman',2),(3,'435S4','NAVIGATOR','Linus','Torvalds',-1),(4,'65E3R','OPERATOR','Bill','Gates',-1),(5,'255FE','STEWARDESS','Jane','Doe',1),(6,'9384R','STEWARDESS','Emma','Stone',-1),(7,'983JE','STEWARDESS','Natalie','Portman',1),(8,'93J7E','STEWARDESS','Anne','Hathaway',-1),(12,'DFS34','PILOT','KEN','BECK',-1),(13,'123213123','STEWARDESS','Hells','Bells',-1),(14,'SD123123','PILOT','Марк','Цукер',1),(17,'HABR31','STEWARDESS','Habra','Habr',1),(18,'87FDD','STEWARDESS','Тест','Тест1',-1),(19,'12AC34','STEWARDESS','Highway','To Hell',1),(20,'5DC343','OPERATOR','TNT','Thunderstruck',1),(21,'AS3D2S','NAVIGATOR','Jane','Kelvin',-1),(22,'sdfsdfsdf3','OPERATOR','Micky','Rooney',-1),(23,'12HYT3','NAVIGATOR','Jae','Dong',1),(24,'34DFH','PILOT','Пилот1','Пилот1',-1),(27,'DF34FD','STEWARDESS','Стюардесса1','Стюардесса1',-1),(28,'РВОАР7','STEWARDESS','Стюардесса2','Стюардесса2',-1),(29,'JDHF7','STEWARDESS','TEst','FDE',-1),(30,'SD234e','STEWARDESS','HABBB','JUF',-1);
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` enum('ADMIN','DISPATCHER') NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','admin','ADMIN','Homer','Simpson'),(2,'dis','pass','DISPATCHER','Linus','Torvalds'),(6,'test','test','DISPATCHER','test','test'),(7,'root','root','DISPATCHER','root','root'),(15,'test1','test','DISPATCHER','test','test');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-08 23:42:21
