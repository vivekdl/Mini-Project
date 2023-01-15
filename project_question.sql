-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: project
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question` (
  `No` int NOT NULL AUTO_INCREMENT,
  `Qusestion` varchar(225) NOT NULL,
  `Answer1` varchar(225) NOT NULL,
  `Answer2` varchar(225) NOT NULL,
  `Answer3` varchar(225) NOT NULL,
  `Answer4` varchar(225) NOT NULL,
  `ans` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`No`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,'Who invented Java Programming?','Guido van Rossum','James Gosling',' Dennis Ritchie',' Bjarne Stroustrup','B'),(2,' Which of the following is not an OOPS concept in Java?',' Polymorphism',' Inheritance','Compilation','Encapsulation','C'),(3,'3.What is the extension of compiled java classes?','.txt',' .js',' .class','.java','C'),(4,' Which of the following is a superclass of every class in Java?','ArrayList','Abstract class',' Object class','String','C'),(5,'Which of the following are not Java keywords ?','double','switch','then','instanceof','C'),(6,'Which of the following are not the methods of the Thread class?','yield()','sleep(long msec)','go()','stop()','C'),(7,'JDK stands for __','Java Development Kit','Java Developer Kit',' Java Database Kit','Java Data Kit','A'),(8,'JIT stand s for …………..','Just In Time Compilation',' Java In Time Compiler','Java Information Technology',' Java Input Technique','B'),(9,'Which method waits for a thread to die?','stop()','start()','terminate(',' join()','D'),(10,'Which of these exceptions handles the divide by zero error?',' ArithmeticException',' MathException',' IllegalAccessException',' IllegarException','A');
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-15 17:06:54
