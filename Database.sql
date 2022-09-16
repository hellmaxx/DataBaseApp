-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: gibdd
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `car_info`
--

DROP TABLE IF EXISTS `car_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `car_info` (
  `VIN_ID` int unsigned NOT NULL AUTO_INCREMENT,
  `Model` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Year_realise` int NOT NULL,
  `Color` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`VIN_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car_info`
--

LOCK TABLES `car_info` WRITE;
/*!40000 ALTER TABLE `car_info` DISABLE KEYS */;
INSERT INTO `car_info` VALUES (1,'bmw m5',2008,'Белый'),(2,'ford mustang',2011,'Черный'),(3,'ВАЗ 2101',1999,'Синий'),(4,'Chevrolet Comaro',2011,'Желтый'),(5,'bmw 3',2008,'Белый'),(6,'mitsubishi lancer',2007,'Голубой'),(7,'Subaru impreza WRX',2008,'Синий'),(8,'Skoda Kodiak',2018,'Металлик'),(9,'KIA RIO',2014,'Розовый'),(10,'Rolls Royce Ghost',2011,'Пепсикольный'),(14,'ВАЗ 2109',2000,'Белый'),(15,'shelbic',2020,'черный');
/*!40000 ALTER TABLE `car_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorys`
--

DROP TABLE IF EXISTS `categorys`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorys` (
  `categorys_id` int unsigned NOT NULL AUTO_INCREMENT,
  `category` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`categorys_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorys`
--

LOCK TABLES `categorys` WRITE;
/*!40000 ALTER TABLE `categorys` DISABLE KEYS */;
INSERT INTO `categorys` VALUES (1,'A'),(2,'B'),(3,'C'),(4,'D'),(5,'Категория не открыта');
/*!40000 ALTER TABLE `categorys` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fines`
--

DROP TABLE IF EXISTS `fines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fines` (
  `id_fines` int NOT NULL AUTO_INCREMENT,
  `VIN` int unsigned NOT NULL,
  `Owner` int unsigned NOT NULL,
  `fine_text` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `data` date NOT NULL,
  PRIMARY KEY (`id_fines`),
  KEY `registred_ca_idx` (`VIN`),
  KEY `owner_info_idx` (`Owner`),
  CONSTRAINT `owner_info` FOREIGN KEY (`Owner`) REFERENCES `owner_info` (`id_owner`),
  CONSTRAINT `registred_ca` FOREIGN KEY (`VIN`) REFERENCES `registered_ca` (`VIN`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fines`
--

LOCK TABLES `fines` WRITE;
/*!40000 ALTER TABLE `fines` DISABLE KEYS */;
INSERT INTO `fines` VALUES (1,2,2,'Превышение скорости','2011-10-01'),(2,3,3,'Превышение скорости','2011-10-01'),(3,4,4,'Превышение скорости','2011-10-01'),(4,4,4,'Превышение скорости','2011-10-01'),(5,6,7,'Превышение скорости','2020-12-12');
/*!40000 ALTER TABLE `fines` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hijacked_car`
--

DROP TABLE IF EXISTS `hijacked_car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hijacked_car` (
  `hij_car_id` int unsigned NOT NULL AUTO_INCREMENT,
  `VIN` int unsigned NOT NULL,
  `Date_hij` date NOT NULL,
  PRIMARY KEY (`hij_car_id`),
  KEY `VIN` (`VIN`),
  CONSTRAINT `hijacked_car_ibfk_1` FOREIGN KEY (`VIN`) REFERENCES `car_info` (`VIN_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hijacked_car`
--

LOCK TABLES `hijacked_car` WRITE;
/*!40000 ALTER TABLE `hijacked_car` DISABLE KEYS */;
INSERT INTO `hijacked_car` VALUES (1,6,'2020-11-10'),(3,7,'2020-11-11'),(5,3,'2020-11-11');
/*!40000 ALTER TABLE `hijacked_car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `owner_info`
--

DROP TABLE IF EXISTS `owner_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `owner_info` (
  `id_owner` int unsigned NOT NULL AUTO_INCREMENT,
  `initials` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone_number` bigint unsigned NOT NULL,
  `date_born` date NOT NULL,
  `address` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id_owner`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `owner_info`
--

LOCK TABLES `owner_info` WRITE;
/*!40000 ALTER TABLE `owner_info` DISABLE KEYS */;
INSERT INTO `owner_info` VALUES (1,'Летов Максим Александрович',88005553535,'2000-02-28','Воронеж, площадь Ленина, д. 1'),(2,'Дыкин Роман Олегович',88005553536,'1999-11-10','Воронеж, Плехановская, д. 53'),(3,'Газизянов Олег Сергеевич',88005553533,'2000-10-28','Воронеж, Плехановская, д. 54'),(4,'Коноплин Александр Васильевич',88005553531,'2000-10-20','Воронеж, пр-кт Московский, д. 53'),(5,'Халарис Андрей Игоревич',88005553511,'2000-02-21','Воронеж, пр-кт Московский, д. 175'),(6,'Анцупов Павел Андреевич',88035312341,'1999-11-15','Воронеж, пр-кт Ленина, д. 17'),(7,'Грачев Максим Андреевич',88005553554,'2000-02-22','Воронеж, пр-кт Московский, д. 173'),(8,'Кисляков Андрей Евгеньевич',88035312349,'2000-10-20','Воронеж, ул. Урицкого, 129'),(9,'Вахтин Андрей Андреевич',8800555363,'2000-07-21','Воронеж, ул. Бульвар Победы, д. 71'),(10,'Гончаренко Никита Сергеевич',88005553511,'2000-10-27','Воронеж, пр-кт Революции, 1'),(11,'Коденцева Наталья Геннадьевна',880055535351,'1999-12-12','Воронеж, Хользунова 12'),(12,'Коденцева Наталья Вадимовна',88005553535122,'2021-01-17','Воронеж, Хользунова 12');
/*!40000 ALTER TABLE `owner_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registered_ca`
--

DROP TABLE IF EXISTS `registered_ca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registered_ca` (
  `reg_car_id` int unsigned NOT NULL AUTO_INCREMENT,
  `VIN` int unsigned NOT NULL,
  `Owner` int unsigned NOT NULL,
  `Date_start` date NOT NULL,
  `gos_number` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`reg_car_id`),
  KEY `VIN` (`VIN`),
  KEY `Owner` (`Owner`),
  CONSTRAINT `registered_ca_ibfk_1` FOREIGN KEY (`VIN`) REFERENCES `car_info` (`VIN_ID`),
  CONSTRAINT `registered_ca_ibfk_2` FOREIGN KEY (`Owner`) REFERENCES `owner_info` (`id_owner`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registered_ca`
--

LOCK TABLES `registered_ca` WRITE;
/*!40000 ALTER TABLE `registered_ca` DISABLE KEYS */;
INSERT INTO `registered_ca` VALUES (1,1,2,'2020-11-17','а111ку36'),(2,2,1,'2020-12-01','а112ку36'),(3,6,3,'2020-03-30','а113ку36'),(4,5,4,'2020-02-26','а114ку36'),(5,3,8,'2020-09-30','а116ку36'),(6,4,6,'2019-11-25','а115ку36'),(7,7,10,'2020-11-17','а117ку36'),(8,9,7,'2020-08-17','а118ку36'),(9,8,9,'2020-05-25','а119ку36'),(10,10,5,'2019-04-30','а120ку36');
/*!40000 ALTER TABLE `registered_ca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rights_give`
--

DROP TABLE IF EXISTS `rights_give`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rights_give` (
  `rights_id` int unsigned NOT NULL AUTO_INCREMENT,
  `owner` int unsigned NOT NULL,
  `data_start` date NOT NULL,
  `data_end` date NOT NULL,
  `category` int unsigned NOT NULL,
  PRIMARY KEY (`rights_id`),
  KEY `category` (`category`),
  KEY `owner` (`owner`),
  CONSTRAINT `rights_give_ibfk_1` FOREIGN KEY (`category`) REFERENCES `categorys` (`categorys_id`),
  CONSTRAINT `rights_give_ibfk_2` FOREIGN KEY (`owner`) REFERENCES `owner_info` (`id_owner`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rights_give`
--

LOCK TABLES `rights_give` WRITE;
/*!40000 ALTER TABLE `rights_give` DISABLE KEYS */;
INSERT INTO `rights_give` VALUES (1,1,'2017-08-01','2027-08-01',2),(2,2,'2018-08-01','2027-08-01',5),(3,3,'2016-08-01','2026-08-01',2),(4,4,'2018-08-02','2027-08-02',2),(5,5,'2016-08-11','2025-08-11',2),(6,6,'2018-08-11','2028-08-11',2),(7,7,'2017-11-11','2027-11-11',2),(8,8,'2017-11-01','2027-11-01',2),(9,9,'2017-03-01','2027-03-01',2),(10,10,'2017-03-02','2027-03-02',2),(11,2,'2020-12-12','2020-12-12',4);
/*!40000 ALTER TABLE `rights_give` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rigts_dep`
--

DROP TABLE IF EXISTS `rigts_dep`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rigts_dep` (
  `id_dep` int unsigned NOT NULL AUTO_INCREMENT,
  `right_id` int unsigned NOT NULL,
  `owner_id` int unsigned NOT NULL,
  `data_start` date NOT NULL,
  `data_end` date NOT NULL,
  PRIMARY KEY (`id_dep`),
  KEY `r.id_idx` (`right_id`),
  KEY `o.id_idx` (`owner_id`),
  CONSTRAINT `o.id` FOREIGN KEY (`owner_id`) REFERENCES `owner_info` (`id_owner`),
  CONSTRAINT `r.id` FOREIGN KEY (`right_id`) REFERENCES `rights_give` (`rights_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rigts_dep`
--

LOCK TABLES `rigts_dep` WRITE;
/*!40000 ALTER TABLE `rigts_dep` DISABLE KEYS */;
INSERT INTO `rigts_dep` VALUES (1,3,3,'2020-10-01','2021-10-01'),(2,4,4,'2020-10-01','2021-10-01'),(3,7,7,'2020-10-10','2021-01-01');
/*!40000 ALTER TABLE `rigts_dep` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `technical_inspection`
--

DROP TABLE IF EXISTS `technical_inspection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `technical_inspection` (
  `technical_inspection_id` int unsigned NOT NULL AUTO_INCREMENT,
  `VIN` int unsigned NOT NULL,
  `Date_start` date NOT NULL,
  `Date_end` date NOT NULL,
  PRIMARY KEY (`technical_inspection_id`),
  KEY `VIN` (`VIN`),
  CONSTRAINT `technical_inspection_ibfk_1` FOREIGN KEY (`VIN`) REFERENCES `car_info` (`VIN_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `technical_inspection`
--

LOCK TABLES `technical_inspection` WRITE;
/*!40000 ALTER TABLE `technical_inspection` DISABLE KEYS */;
INSERT INTO `technical_inspection` VALUES (1,1,'2020-06-01','2021-06-01'),(2,2,'2020-06-02','2021-06-02'),(4,4,'2020-06-04','2021-06-04'),(5,5,'2020-06-06','2021-06-06'),(6,6,'2020-06-07','2021-06-07'),(7,7,'2020-06-10','2021-06-10'),(8,8,'2020-06-11','2021-06-11'),(9,9,'2020-06-12','2021-06-12'),(10,10,'2020-04-10','2021-04-10');
/*!40000 ALTER TABLE `technical_inspection` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-17  1:10:06
