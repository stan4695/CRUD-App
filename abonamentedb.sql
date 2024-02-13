-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: abonamentedb
-- ------------------------------------------------------
-- Server version	8.1.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `abonamente`
--

DROP TABLE IF EXISTS `abonamente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `abonamente` (
  `idAbonament` int NOT NULL AUTO_INCREMENT,
  `idAbonat` int DEFAULT NULL,
  `idCompanieTelefonie` int DEFAULT NULL,
  PRIMARY KEY (`idAbonament`),
  KEY `fk1_idx` (`idAbonat`),
  KEY `fk2_idx` (`idCompanieTelefonie`),
  CONSTRAINT `fk1` FOREIGN KEY (`idAbonat`) REFERENCES `abonati` (`idAbonat`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk2` FOREIGN KEY (`idCompanieTelefonie`) REFERENCES `companie_telefonie` (`idCompanieTelefonie`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `abonamente`
--

LOCK TABLES `abonamente` WRITE;
/*!40000 ALTER TABLE `abonamente` DISABLE KEYS */;
INSERT INTO `abonamente` VALUES (4,1,2),(7,5,2),(8,4,4),(10,1,2),(11,6,2);
/*!40000 ALTER TABLE `abonamente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `abonati`
--

DROP TABLE IF EXISTS `abonati`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `abonati` (
  `idAbonat` int NOT NULL AUTO_INCREMENT,
  `nume` varchar(45) DEFAULT NULL,
  `prenume` varchar(45) DEFAULT NULL,
  `cnp` varchar(45) DEFAULT NULL,
  `adresa` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idAbonat`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `abonati`
--

LOCK TABLES `abonati` WRITE;
/*!40000 ALTER TABLE `abonati` DISABLE KEYS */;
INSERT INTO `abonati` VALUES (1,'Stan','Catalin','515161518616','Bucuresti'),(4,'Ilie','George','156115315616','Targoviste'),(5,'Camen','David','1565413513','Targoviste'),(6,'Nicu','Eduart','456453131','Bucuresti, Sector 5');
/*!40000 ALTER TABLE `abonati` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `companie_telefonie`
--

DROP TABLE IF EXISTS `companie_telefonie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `companie_telefonie` (
  `idCompanieTelefonie` int NOT NULL AUTO_INCREMENT,
  `nume` varchar(45) DEFAULT NULL,
  `adresaSediu` varchar(45) DEFAULT NULL,
  `telefonContact` varchar(45) DEFAULT NULL,
  `emailContact` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idCompanieTelefonie`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `companie_telefonie`
--

LOCK TABLES `companie_telefonie` WRITE;
/*!40000 ALTER TABLE `companie_telefonie` DISABLE KEYS */;
INSERT INTO `companie_telefonie` VALUES (1,'Vodafone','Vasile Milea 58','0723141645','suport24@vodafone.ro'),(2,'Orange','Vasile Milea 100','0723141645','suport24@orange.com'),(4,'RCS-RDS','Calea Victoriei 39','07264596231','contact@rcsrds.ro');
/*!40000 ALTER TABLE `companie_telefonie` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-01 12:34:00
