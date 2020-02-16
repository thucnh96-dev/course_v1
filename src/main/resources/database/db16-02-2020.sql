-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: course_system
-- ------------------------------------------------------
-- Server version	5.5.5-10.3.10-MariaDB

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
-- Table structure for table `tb_appbaner`
--

DROP TABLE IF EXISTS `tb_appbaner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_appbaner` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_at` datetime(6) DEFAULT NULL,
  `delete_at` datetime(6) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `prioritize` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_appbaner`
--

LOCK TABLES `tb_appbaner` WRITE;
/*!40000 ALTER TABLE `tb_appbaner` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_appbaner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_exam`
--

DROP TABLE IF EXISTS `tb_exam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_exam` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `create_at` datetime(6) DEFAULT NULL,
  `delete_at` datetime(6) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  `announce_at` datetime(6) DEFAULT NULL,
  `end_at` datetime(6) DEFAULT NULL,
  `exam_cutoff_time` smallint(6) DEFAULT NULL,
  `question_average_time` smallint(6) DEFAULT NULL,
  `start_at` datetime(6) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_2919y72dt0r4s1q6euuruerik` (`title`),
  KEY `FKkglxk19spn019v7t12xtjdm9u` (`user_id`),
  CONSTRAINT `FKkglxk19spn019v7t12xtjdm9u` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_exam`
--

LOCK TABLES `tb_exam` WRITE;
/*!40000 ALTER TABLE `tb_exam` DISABLE KEYS */;
INSERT INTO `tb_exam` VALUES (1,'2020-02-15 21:37:58.000000',NULL,NULL,'2020-03-20 00:00:00.000000','2020-05-20 00:00:00.000000',60,NULL,'2020-04-20 00:00:00.000000','THI HOC KI',NULL);
/*!40000 ALTER TABLE `tb_exam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_exam_question`
--

DROP TABLE IF EXISTS `tb_exam_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_exam_question` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_at` datetime(6) DEFAULT NULL,
  `delete_at` datetime(6) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  `exam_id` smallint(6) DEFAULT NULL,
  `question_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnec7he9aol27sr5gbxqav5fme` (`exam_id`),
  KEY `FKfljmdwosjvje8f57i51yqhn31` (`question_id`),
  CONSTRAINT `FKfljmdwosjvje8f57i51yqhn31` FOREIGN KEY (`question_id`) REFERENCES `tb_question` (`id`),
  CONSTRAINT `FKnec7he9aol27sr5gbxqav5fme` FOREIGN KEY (`exam_id`) REFERENCES `tb_exam` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_exam_question`
--

LOCK TABLES `tb_exam_question` WRITE;
/*!40000 ALTER TABLE `tb_exam_question` DISABLE KEYS */;
INSERT INTO `tb_exam_question` VALUES (1,'2020-02-15 21:44:21.000000',NULL,NULL,1,3),(2,'2020-02-15 21:44:21.000000',NULL,NULL,1,4),(3,'2020-02-15 21:44:22.000000',NULL,NULL,1,5),(4,'2020-02-15 21:44:22.000000',NULL,NULL,1,6),(5,'2020-02-15 21:44:22.000000',NULL,NULL,1,7),(6,'2020-02-15 21:44:22.000000',NULL,NULL,1,8),(7,'2020-02-15 21:44:22.000000',NULL,NULL,1,9),(8,'2020-02-15 21:44:22.000000',NULL,NULL,1,10),(9,'2020-02-15 21:44:22.000000',NULL,NULL,1,11),(10,'2020-02-15 21:44:22.000000',NULL,NULL,1,12),(11,'2020-02-15 21:44:22.000000',NULL,NULL,1,13),(12,'2020-02-15 21:44:22.000000',NULL,NULL,1,14),(13,'2020-02-15 21:44:22.000000',NULL,NULL,1,15),(14,'2020-02-15 21:44:22.000000',NULL,NULL,1,16),(15,'2020-02-15 21:44:22.000000',NULL,NULL,1,17);
/*!40000 ALTER TABLE `tb_exam_question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_question`
--

DROP TABLE IF EXISTS `tb_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_question` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_at` datetime(6) DEFAULT NULL,
  `delete_at` datetime(6) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  `difficulty` varchar(255) DEFAULT NULL,
  `explan` varchar(700) DEFAULT NULL,
  `question_code` varchar(255) DEFAULT NULL,
  `question_type` varchar(255) DEFAULT NULL,
  `question` varchar(700) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_question`
--

LOCK TABLES `tb_question` WRITE;
/*!40000 ALTER TABLE `tb_question` DISABLE KEYS */;
INSERT INTO `tb_question` VALUES (1,'2020-02-15 21:39:06.000000',NULL,NULL,'HIGH','bong da',NULL,NULL,'cr7'),(2,'2020-02-15 21:40:20.000000',NULL,NULL,'HIGH','bong da',NULL,NULL,'cr7'),(3,'2020-02-15 21:44:21.000000',NULL,NULL,'HIGH','bong da',NULL,NULL,'cr7'),(4,'2020-02-15 21:44:21.000000',NULL,NULL,'HIGH','bong da',NULL,NULL,'cr7'),(5,'2020-02-15 21:44:22.000000',NULL,NULL,'HIGH','bong da',NULL,NULL,'cr7'),(6,'2020-02-15 21:44:22.000000',NULL,NULL,'HIGH','bong da',NULL,NULL,'cr7'),(7,'2020-02-15 21:44:22.000000',NULL,NULL,'HIGH','bong da',NULL,NULL,'cr7'),(8,'2020-02-15 21:44:22.000000',NULL,NULL,'HIGH','bong da',NULL,NULL,'cr7'),(9,'2020-02-15 21:44:22.000000',NULL,NULL,'HIGH','bong da',NULL,NULL,'cr7'),(10,'2020-02-15 21:44:22.000000',NULL,NULL,'HIGH','bong da',NULL,NULL,'cr7'),(11,'2020-02-15 21:44:22.000000',NULL,NULL,'HIGH','bong da',NULL,NULL,'cr7'),(12,'2020-02-15 21:44:22.000000',NULL,NULL,'HIGH','bong da',NULL,NULL,'cr7'),(13,'2020-02-15 21:44:22.000000',NULL,NULL,'HIGH','bong da',NULL,NULL,'cr7'),(14,'2020-02-15 21:44:22.000000',NULL,NULL,'HIGH','bong da',NULL,NULL,'cr7'),(15,'2020-02-15 21:44:22.000000',NULL,NULL,'HIGH','bong da',NULL,NULL,'cr7'),(16,'2020-02-15 21:44:22.000000',NULL,NULL,'HIGH','bong da',NULL,NULL,'cr7'),(17,'2020-02-15 21:44:22.000000',NULL,NULL,'HIGH','bong da',NULL,NULL,'cr7');
/*!40000 ALTER TABLE `tb_question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_question_normal`
--

DROP TABLE IF EXISTS `tb_question_normal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_question_normal` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_at` datetime(6) DEFAULT NULL,
  `delete_at` datetime(6) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  `answer1` varchar(255) DEFAULT NULL,
  `answer2` varchar(255) DEFAULT NULL,
  `answer3` varchar(255) DEFAULT NULL,
  `answer4` varchar(255) DEFAULT NULL,
  `answer_corect` varchar(255) DEFAULT NULL,
  `question_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_d1p2f4qybqfs3m1b9pv85y4oj` (`question_id`),
  CONSTRAINT `FKjbe8tc1y2qr3k6uowup2fhanb` FOREIGN KEY (`question_id`) REFERENCES `tb_question` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_question_normal`
--

LOCK TABLES `tb_question_normal` WRITE;
/*!40000 ALTER TABLE `tb_question_normal` DISABLE KEYS */;
INSERT INTO `tb_question_normal` VALUES (1,'2020-02-15 21:44:21.000000',NULL,NULL,'tiano','pele','mpape','junior','answer1',3),(2,'2020-02-15 21:44:21.000000',NULL,NULL,'tiano','pele','mpape','junior','answer1',4),(3,'2020-02-15 21:44:22.000000',NULL,NULL,'tiano','pele','mpape','junior','answer1',5),(4,'2020-02-15 21:44:22.000000',NULL,NULL,'tiano','pele','mpape','junior','answer1',6),(5,'2020-02-15 21:44:22.000000',NULL,NULL,'tiano','pele','mpape','junior','answer1',7),(6,'2020-02-15 21:44:22.000000',NULL,NULL,'tiano','pele','mpape','junior','answer1',8),(7,'2020-02-15 21:44:22.000000',NULL,NULL,'tiano','pele','mpape','junior','answer1',9),(8,'2020-02-15 21:44:22.000000',NULL,NULL,'tiano','pele','mpape','junior','answer1',10),(9,'2020-02-15 21:44:22.000000',NULL,NULL,'tiano','pele','mpape','junior','answer1',11),(10,'2020-02-15 21:44:22.000000',NULL,NULL,'tiano','pele','mpape','junior','answer1',12),(11,'2020-02-15 21:44:22.000000',NULL,NULL,'tiano','pele','mpape','junior','answer1',13),(12,'2020-02-15 21:44:22.000000',NULL,NULL,'tiano','pele','mpape','junior','answer1',14),(13,'2020-02-15 21:44:22.000000',NULL,NULL,'tiano','pele','mpape','junior','answer1',15),(14,'2020-02-15 21:44:22.000000',NULL,NULL,'tiano','pele','mpape','junior','answer1',16),(15,'2020-02-15 21:44:22.000000',NULL,NULL,'tiano','pele','mpape','junior','answer1',17);
/*!40000 ALTER TABLE `tb_question_normal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_role`
--

DROP TABLE IF EXISTS `tb_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_at` datetime(6) DEFAULT NULL,
  `delete_at` datetime(6) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_role`
--

LOCK TABLES `tb_role` WRITE;
/*!40000 ALTER TABLE `tb_role` DISABLE KEYS */;
INSERT INTO `tb_role` VALUES (1,NULL,NULL,NULL,'ADMIN'),(2,NULL,NULL,NULL,'USER');
/*!40000 ALTER TABLE `tb_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_at` datetime(6) DEFAULT NULL,
  `delete_at` datetime(6) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  `expiry_token_date` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_8yfdv7pbvgjexnabpkxnd2v2w` (`phone`),
  UNIQUE KEY `UK_4wv83hfajry5tdoamn8wsqa6x` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user`
--

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user_eq_no_answer`
--

DROP TABLE IF EXISTS `tb_user_eq_no_answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_user_eq_no_answer` (
  `user_exam_question_id` bigint(20) NOT NULL,
  `create_at` datetime(6) DEFAULT NULL,
  `delete_at` datetime(6) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  `user_answer` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_exam_question_id`),
  CONSTRAINT `FKgxcdrdp9e4kkqpx3lxvqcmpfb` FOREIGN KEY (`user_exam_question_id`) REFERENCES `tb_user_exam_question` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user_eq_no_answer`
--

LOCK TABLES `tb_user_eq_no_answer` WRITE;
/*!40000 ALTER TABLE `tb_user_eq_no_answer` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_user_eq_no_answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user_exam`
--

DROP TABLE IF EXISTS `tb_user_exam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_user_exam` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_at` datetime(6) DEFAULT NULL,
  `delete_at` datetime(6) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  `completed_at` datetime(6) DEFAULT NULL,
  `expect_point` decimal(10,0) DEFAULT NULL,
  `immediately_result` bit(1) NOT NULL,
  `question_code` varchar(255) DEFAULT NULL,
  `exam_id` smallint(6) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsql4bh65kgouvago6i0k37xws` (`exam_id`),
  KEY `FKaykoxtcleoj913tgjbgo8pxes` (`user_id`),
  CONSTRAINT `FKaykoxtcleoj913tgjbgo8pxes` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`id`),
  CONSTRAINT `FKsql4bh65kgouvago6i0k37xws` FOREIGN KEY (`exam_id`) REFERENCES `tb_exam` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user_exam`
--

LOCK TABLES `tb_user_exam` WRITE;
/*!40000 ALTER TABLE `tb_user_exam` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_user_exam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user_exam_question`
--

DROP TABLE IF EXISTS `tb_user_exam_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_user_exam_question` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_at` datetime(6) DEFAULT NULL,
  `delete_at` datetime(6) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  `answered` bit(1) NOT NULL,
  `correct` bit(1) DEFAULT NULL,
  `exam_question_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `user_exam_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKh54vrv7jtkflanvmkyyoqtmik` (`exam_question_id`),
  KEY `FK76a4k6av5qxocp3qe2mfr1b2s` (`user_id`),
  KEY `FKp2c5m3pr0q3ci46fmcm024bj4` (`user_exam_id`),
  CONSTRAINT `FK76a4k6av5qxocp3qe2mfr1b2s` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`id`),
  CONSTRAINT `FKh54vrv7jtkflanvmkyyoqtmik` FOREIGN KEY (`exam_question_id`) REFERENCES `tb_exam_question` (`id`),
  CONSTRAINT `FKp2c5m3pr0q3ci46fmcm024bj4` FOREIGN KEY (`user_exam_id`) REFERENCES `tb_user_exam` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user_exam_question`
--

LOCK TABLES `tb_user_exam_question` WRITE;
/*!40000 ALTER TABLE `tb_user_exam_question` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_user_exam_question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  KEY `FKeayxeqvq6j9yuf6ogfgvr9u6` (`role_id`),
  KEY `FK430om9qnxgilp5cvcbeyovi37` (`user_id`),
  CONSTRAINT `FK430om9qnxgilp5cvcbeyovi37` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`id`),
  CONSTRAINT `FKeayxeqvq6j9yuf6ogfgvr9u6` FOREIGN KEY (`role_id`) REFERENCES `tb_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-16 23:14:26
