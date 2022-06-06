-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: microservices
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `userid` bigint NOT NULL AUTO_INCREMENT,
  `password` varchar(255) NOT NULL,
  `role` varchar(20) DEFAULT NULL,
  `username` varchar(20) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'$2a$10$eK0fC0MaF6jk4SiUxAbzvOhbaTtv6HqaDhpUGYImF9ky79AJqF9uO','ROLE_LOCAL','rishu'),(2,'$2a$10$xTEy0k0tCyHq82dno3f9ROC55mV7X.t4SF348IuKJVRK.4LuTtfte','ROLE_LOCAL','praveen'),(3,'$2a$10$zPCLVHOxsSn6Gxio10O6Bupmo8SpglaAxu4uhr9l6kqB8CTi0Q7S2','ROLE_LOCAL','vikas'),(4,'$2a$10$H/L4O.tqzg1A.j3fx.fQ.uf6rmN7qzVc/AuN3DiyLO1/diwWk6xVK','ROLE_ADMIN','rishab'),(5,'$2a$10$KWQWNQ8aaD1bKfwzCOpb..L59JgZVu5MVbPrjbG7TeavIwVZ2JedG','ROLE_ADMIN','rishabh'),(6,'$2a$10$5wRWGli7bR1QUq8WmxfiSOnZvX8dKMLY2wCPX.IYG1y2547JRAqf.','ROLE_LOCAL','vikas'),(7,'$2a$10$Qzrl8A2l0fkHtJYMEnuWVeSxLU32VOjQvgHnqALeMdNrU7Kfdi62S','ROLE_LOCAL','vinod'),(8,'$2a$10$ub7O5eQXK1QNPF1yy1VvNeYsRAl71s099jKesm5hY1yHtU3IJ4PiS','ROLE_LOCAL','vinay');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project` (
  `projectid` bigint NOT NULL,
  `projectstartdate` date DEFAULT NULL,
  `projectenddate` date DEFAULT NULL,
  `budgetallotted` int DEFAULT NULL,
  `budgetused` int DEFAULT NULL,
  `typeofproject` varchar(45) NOT NULL DEFAULT 'CLIENT',
  `userid` bigint NOT NULL,
  `projectname` varchar(45) NOT NULL,
  PRIMARY KEY (`projectid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (1,'2022-05-12','2022-09-02',170000,88000,'CLIENT',1,'Indigo'),(2,'2022-05-12','2022-05-12',200000,8000,'CLIENT',3,'Payback'),(3,'2021-12-12','2022-05-12',150000,8000,'CLIENT',3,'Crisil'),(4,'2022-02-22','2022-05-12',450000,75000,'INTERNAL',2,'Tally'),(5,'2022-02-22','2022-05-12',300000,75000,'CLIENT',4,'Asian');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `userid` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `projectid` bigint NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `officeid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'bangalore','ICFNEXT','$2a$12$JKHPbFwlzASdHca4CfMgnODUNELLdEXzXBmcjMT22UDGQ.gvM/1ba',3,'ROLE_LOCAL','Vikas_T_S','55686'),(2,'kanpur','ICFNEXT','$2a$12$Cav5P.lsGECpQcEAt7jrBOdw5B6rjoDiSY7YaC0twABbLWu12wofu',2,'ROLE_ADMIN','rishabh','55683'),(3,'bangalore','ICFNEXT','$2a$12$w0xG9SBzVm7hyu.cgEsMg.0SDYQ75kYXcvLLU3NRWJ0osBzM2pKpm',3,'ROLE_LOCAL','Vinod','55684'),(4,'kanpur','ICFNEXT','$2a$12$DbKmM3ynTEHV4EeNlcn4BOSTF9ialCI1f3ITa.kRQ5pqdtp5NOidq',5,'ROLE_LOCAL','sibi','55682'),(5,'Kerala','ICFNEXT','$2a$12$WwDDd6btUpscZdBK.cG/Wez8hRPGjJQHqHrQMc/Zn9LxRaM36qdnG',4,'ROLE_LOCAL','ashok','55681'),(6,'Hydrabad','ICFNEXT','$2a$12$Sj3G2tw90w6zl2gzaReyx.jbIliOCvD7uW.LQXvqjGEQ4XjqrKLxi',1,'ROLE_LOCAL','manoj','55680'),(7,'delhi','ICFNEXT','$2a$10$2H4wNWzIS32QRMRFlljRK.J2O5ViRU0V59eWwl701.GGGbBuM2Vje',1,'ROLE_LOCAL','anuj','55650');
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

-- Dump completed on 2022-06-06 13:10:20
