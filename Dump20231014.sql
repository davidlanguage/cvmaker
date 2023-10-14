-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: cvmaker
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `logger`
--

DROP TABLE IF EXISTS `logger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `logger` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `message` varchar(255) DEFAULT NULL,
  `timestamp` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=603 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logger`
--

LOCK TABLES `logger` WRITE;
/*!40000 ALTER TABLE `logger` DISABLE KEYS */;
INSERT INTO `logger` VALUES (252,'A user has checked all skills','2023-09-13 18:19:20.000000'),(302,'The usertesting@testing.com has logged in','2023-09-13 18:21:01.000000'),(352,'The usertesting@testing.com has logged in','2023-09-13 18:22:02.000000'),(402,'The usertesting@testing.com has logged in','2023-09-13 18:22:55.000000'),(452,'The usertesting@testing.com has logged in','2023-09-13 18:23:42.000000'),(502,'The skill Test has been added to the database','2023-10-14 20:40:29.000000'),(552,'The skill Test has been added to the database','2023-10-14 20:41:33.000000'),(553,'The skill Test has been added to the database','2023-10-14 20:42:07.000000'),(602,'The skill Test has been added to the database','2023-10-14 20:45:38.000000');
/*!40000 ALTER TABLE `logger` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `logger_seq`
--

DROP TABLE IF EXISTS `logger_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `logger_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logger_seq`
--

LOCK TABLES `logger_seq` WRITE;
/*!40000 ALTER TABLE `logger_seq` DISABLE KEYS */;
INSERT INTO `logger_seq` VALUES (701);
/*!40000 ALTER TABLE `logger_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skill`
--

DROP TABLE IF EXISTS `skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `skill` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `skill_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skill`
--

LOCK TABLES `skill` WRITE;
/*!40000 ALTER TABLE `skill` DISABLE KEYS */;
INSERT INTO `skill` VALUES (1,'Java'),(2,'Kotlin'),(3,'CSS'),(4,'JavaScript'),(5,'C#'),(6,'C++'),(7,'C'),(8,'Python'),(9,'Ruby'),(10,'Test');
/*!40000 ALTER TABLE `skill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studies`
--

DROP TABLE IF EXISTS `studies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `studies` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `studies_title` varchar(255) DEFAULT NULL,
  `start_date` varchar(255) DEFAULT NULL,
  `end_date` varchar(255) DEFAULT NULL,
  `studies_description` longtext,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `studies_user_id_fk_idx` (`user_id`),
  CONSTRAINT `studies_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `userdata` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studies`
--

LOCK TABLES `studies` WRITE;
/*!40000 ALTER TABLE `studies` DISABLE KEYS */;
/*!40000 ALTER TABLE `studies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `summary`
--

DROP TABLE IF EXISTS `summary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `summary` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `summary` varchar(255) DEFAULT NULL,
  `userdata_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK7xyt3ih7l598jeb9awx63yv57` (`summary`),
  KEY `userdata_id_fk_idx` (`userdata_id`),
  CONSTRAINT `userdata_summary_fk` FOREIGN KEY (`userdata_id`) REFERENCES `userdata` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `summary`
--

LOCK TABLES `summary` WRITE;
/*!40000 ALTER TABLE `summary` DISABLE KEYS */;
/*!40000 ALTER TABLE `summary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userdata`
--

DROP TABLE IF EXISTS `userdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userdata` (
  `id` bigint NOT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `country` varchar(255) DEFAULT NULL,
  `role` enum('ADMIN','USER') DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `email_UNIQUE` (`username`),
  UNIQUE KEY `UKnk1nqff43pmuotrhi0vb0da17` (`username`),
  UNIQUE KEY `UKrp4oc99qpxhlot5xr9o5bqgur` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userdata`
--

LOCK TABLES `userdata` WRITE;
/*!40000 ALTER TABLE `userdata` DISABLE KEYS */;
INSERT INTO `userdata` VALUES (103,'Pepe','Pépez','testing@testing.com','$2a$10$q1ijg6plNu.ZCQeN7B7nqu8F.T4zuf24Jk/eWVOgWgj3Hp46VLXwe','España','USER'),(252,'Pepe2','Pépez2','testing2@testing.com','$2a$10$zbhmN.BCA2gvWcvU4pqDDu1ad0Q7Qm9RxE6GWhsStiTuctL9GFBUm','España2','USER'),(302,'Pepe','Pépez','testing3@testing.com','$2a$10$WHAoaaaloDepjDpVyTHGf.YS4GoHRYqt.F40bOZoDlrgWupKRNqUu','España3232','USER');
/*!40000 ALTER TABLE `userdata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userdata_seq`
--

DROP TABLE IF EXISTS `userdata_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userdata_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userdata_seq`
--

LOCK TABLES `userdata_seq` WRITE;
/*!40000 ALTER TABLE `userdata_seq` DISABLE KEYS */;
INSERT INTO `userdata_seq` VALUES (401);
/*!40000 ALTER TABLE `userdata_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userdata_skill`
--

DROP TABLE IF EXISTS `userdata_skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userdata_skill` (
  `id` bigint NOT NULL,
  `userdata_id` bigint DEFAULT NULL,
  `skill_id` bigint DEFAULT NULL,
  `skill` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userdata_id_fk_idx` (`userdata_id`),
  KEY `skill_id_fk_idx` (`skill_id`),
  KEY `FKmhvhqvg3xkjmcymdyx7cjis6u` (`skill`),
  CONSTRAINT `FKmhvhqvg3xkjmcymdyx7cjis6u` FOREIGN KEY (`skill`) REFERENCES `skill` (`id`),
  CONSTRAINT `skill_id_fk` FOREIGN KEY (`skill_id`) REFERENCES `skill` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `userdata_id_fk` FOREIGN KEY (`userdata_id`) REFERENCES `userdata` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userdata_skill`
--

LOCK TABLES `userdata_skill` WRITE;
/*!40000 ALTER TABLE `userdata_skill` DISABLE KEYS */;
/*!40000 ALTER TABLE `userdata_skill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userdata_skill_seq`
--

DROP TABLE IF EXISTS `userdata_skill_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userdata_skill_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userdata_skill_seq`
--

LOCK TABLES `userdata_skill_seq` WRITE;
/*!40000 ALTER TABLE `userdata_skill_seq` DISABLE KEYS */;
INSERT INTO `userdata_skill_seq` VALUES (1);
/*!40000 ALTER TABLE `userdata_skill_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_experience`
--

DROP TABLE IF EXISTS `work_experience`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `work_experience` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `work_experience_title` varchar(255) DEFAULT NULL,
  `start_date` varchar(45) DEFAULT NULL,
  `end_date` varchar(45) DEFAULT NULL,
  `work_experience_description` longtext,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `work_experience_user_id_fk_idx` (`user_id`),
  CONSTRAINT `work_experience_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `userdata` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_experience`
--

LOCK TABLES `work_experience` WRITE;
/*!40000 ALTER TABLE `work_experience` DISABLE KEYS */;
/*!40000 ALTER TABLE `work_experience` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-14 20:54:00
