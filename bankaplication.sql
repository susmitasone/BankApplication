-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: bankapplication
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `bankemployee`
--

DROP TABLE IF EXISTS `bankemployee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bankemployee` (
  `bankEmpId` bigint NOT NULL,
  `bankEmpPassword` varchar(50) NOT NULL,
  `bankEmpName` varchar(100) NOT NULL,
  PRIMARY KEY (`bankEmpId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bankemployee`
--

LOCK TABLES `bankemployee` WRITE;
/*!40000 ALTER TABLE `bankemployee` DISABLE KEYS */;
INSERT INTO `bankemployee` VALUES (675645,'2233','Roshani');
/*!40000 ALTER TABLE `bankemployee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bankuser`
--

DROP TABLE IF EXISTS `bankuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bankuser` (
  `userId` bigint NOT NULL,
  `userName` varchar(100) NOT NULL,
  `userAddress` varchar(200) NOT NULL,
  `userPassword` varchar(50) NOT NULL,
  `balance` double NOT NULL,
  `phone` bigint NOT NULL,
  `email` varchar(40) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bankuser`
--

LOCK TABLES `bankuser` WRITE;
/*!40000 ALTER TABLE `bankuser` DISABLE KEYS */;
INSERT INTO `bankuser` VALUES (11,'Ayush','Sangali','11',6000,5522331147,'ayush@gmail.com'),(101,'Piyush','Sangali','1011',412,9654123820,'piyush@gmail.com'),(102,'Ritesh','Kolkatta','1022',2199,2134567890,'ritesh@gmail.com'),(103,'Riya','Solapur','1033',10500,8695043284,'riya@gmail.com'),(104,'Rahul','Satara','1044',14500,865432908,'rahul@gmail.com'),(105,'Sujata','Sangali','1055',34000,8655367283,''),(1210,'Vrushali','Kolhapur','1111',111200,7732190291,'vrushali@gmail.com');
/*!40000 ALTER TABLE `bankuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactions`
--

DROP TABLE IF EXISTS `transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transactions` (
  `transactionId` bigint NOT NULL,
  `amount` double NOT NULL,
  `transactionDate` datetime NOT NULL,
  `senderId` bigint NOT NULL,
  `receiverId` bigint NOT NULL,
  PRIMARY KEY (`transactionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactions`
--

LOCK TABLES `transactions` WRITE;
/*!40000 ALTER TABLE `transactions` DISABLE KEYS */;
INSERT INTO `transactions` VALUES (31118,500,'2022-02-28 21:51:47',104,103),(87364,1000,'2022-02-15 16:34:44',101,1210),(98765,1000,'2022-02-01 03:23:56',0,0);
/*!40000 ALTER TABLE `transactions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-02 14:47:50
