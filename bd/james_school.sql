CREATE DATABASE  IF NOT EXISTS `james_school` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `james_school`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: james_school
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
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alumno` (
  `idAlumno` int NOT NULL AUTO_INCREMENT,
  `codAlumno` char(9) NOT NULL,
  `nombreAlumno` varchar(50) NOT NULL,
  `apellidoAlumno` varchar(50) NOT NULL,
  `dniAlumno` char(8) NOT NULL,
  `edadAlumno` int NOT NULL,
  `celularAlumno` int NOT NULL,
  `estadoAlumno` int NOT NULL,
  PRIMARY KEY (`idAlumno`),
  UNIQUE KEY `dniAlumno_UNIQUE` (`dniAlumno`) /*!80000 INVISIBLE */,
  UNIQUE KEY `codAlumno_UNIQUE` (`codAlumno`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` VALUES (1,'A20210001','Genaro','Martinez','71490743',18,977795907,1),(2,'A20210002','Javier','Cárdenas','71231230',19,989456916,2),(3,'A20210003','Ana Lisa','Melculo','98453204',18,984521323,0);
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curso` (
  `idCurso` int NOT NULL AUTO_INCREMENT,
  `codCurso` char(6) NOT NULL,
  `asignaturaCurso` varchar(50) NOT NULL,
  `cicloCurso` int NOT NULL,
  `creditoCurso` int NOT NULL,
  `horasCurso` int NOT NULL,
  PRIMARY KEY (`idCurso`),
  UNIQUE KEY `codCurso_UNIQUE` (`codCurso`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (1,'C10001','HTML',1,6,3),(2,'C10002','JavaScript',2,6,3),(3,'C10003','Python',4,10,2),(4,'C10004','React',4,10,6),(5,'C10005','React',4,10,6);
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matricula`
--

DROP TABLE IF EXISTS `matricula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `matricula` (
  `idMatricula` int NOT NULL AUTO_INCREMENT,
  `numMatricula` char(7) NOT NULL,
  `codAlumno` char(9) NOT NULL,
  `codCurso` char(6) NOT NULL,
  `fechaMatricula` date NOT NULL,
  `horaMatricula` time NOT NULL,
  PRIMARY KEY (`idMatricula`),
  UNIQUE KEY `numMatricula_UNIQUE` (`numMatricula`),
  KEY `codCurso_matricula_idx` (`codCurso`),
  KEY `codAlumno_matricula` (`codAlumno`),
  CONSTRAINT `codAlumno_matricula` FOREIGN KEY (`codAlumno`) REFERENCES `alumno` (`codAlumno`),
  CONSTRAINT `codCurso_matricula` FOREIGN KEY (`codCurso`) REFERENCES `curso` (`codCurso`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matricula`
--

LOCK TABLES `matricula` WRITE;
/*!40000 ALTER TABLE `matricula` DISABLE KEYS */;
INSERT INTO `matricula` VALUES (1,'M100001','A20210001','C10001','2021-11-29','07:19:58'),(2,'M100002','A20210002','C10004','2021-11-22','07:31:42'),(3,'M100003','A20210003','C10003','2022-06-12','10:01:25'),(4,'M100004','A20210003','C10003','2022-06-12','10:04:24');
/*!40000 ALTER TABLE `matricula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `retiro`
--

DROP TABLE IF EXISTS `retiro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `retiro` (
  `idRetiro` int NOT NULL AUTO_INCREMENT,
  `numRetiro` char(7) NOT NULL,
  `numMatricula` char(7) NOT NULL,
  `fechaRetiro` varchar(45) NOT NULL,
  `horaRetiro` varchar(45) NOT NULL,
  PRIMARY KEY (`idRetiro`),
  UNIQUE KEY `numRetiro_UNIQUE` (`numRetiro`),
  KEY `numMatricula_retiro_idx` (`numMatricula`),
  CONSTRAINT `numMatricula_retiro` FOREIGN KEY (`numMatricula`) REFERENCES `matricula` (`numMatricula`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `retiro`
--

LOCK TABLES `retiro` WRITE;
/*!40000 ALTER TABLE `retiro` DISABLE KEYS */;
INSERT INTO `retiro` VALUES (1,'R100001','M100002','2021-11-29','07:24:03'),(4,'R100003','M100001','2022-06-13','21:01:21');
/*!40000 ALTER TABLE `retiro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'james_school'
--

--
-- Dumping routines for database 'james_school'
--
/*!50003 DROP PROCEDURE IF EXISTS `USP_ActualizarRetiro` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_ActualizarRetiro`(retiro char(7), matricula char(7), fecha date, hora time)
BEGIN
	UPDATE retiro SET   numMatricula = matricula, 
						fechaRetiro = fecha, 
						horaRetiro = hora
    WHERE numRetiro = retiro;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `USP_AgregarRetiro` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_AgregarRetiro`(numRetiro char(7), numMatricula char(7), fecha date, hora time)
BEGIN
	UPDATE alumno AS a
    INNER JOIN matricula AS m ON a.codAlumno = m.codAlumno
    INNER JOIN retiro AS r ON m.numMatricula = r.numMatricula
    SET a.estadoAlumno = 2
    WHERE r.numRetiro = numRetiro;
    
	INSERT INTO retiro(retiro.numRetiro, retiro.numMatricula, retiro.fechaRetiro, retiro.horaRetiro)
    VALUES (numRetiro, numMatricula, fecha, hora);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_consultarMatricula` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_consultarMatricula`(IN cm varchar(7))
select *
from matricula as m
where m.numMatricula = cm ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `USP_EliminarRetiro` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_EliminarRetiro`(numRetiro char(7))
BEGIN
	-- UPDATING THE STUDENT STATUS
    UPDATE alumno AS a
    INNER JOIN matricula AS m ON a.codAlumno = m.codAlumno
    INNER JOIN retiro AS r ON m.numMatricula = r.numMatricula
    SET a.estadoAlumno = 0
    WHERE r.numRetiro = numRetiro;
    
    -- DELETING THE RETIRE NUMBER
    DELETE FROM retiro AS r
    WHERE r.numRetiro = numRetiro;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `USP_LeerIdRetiro` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_LeerIdRetiro`(idRetiro int)
BEGIN
	SELECT  r.idRetiro, r.numRetiro, m.numMatricula, 
			m.codAlumno, m.codCurso, r.fechaRetiro, 
			r.horaRetiro
	FROM retiro AS r
	INNER JOIN matricula AS m ON r.numMatricula = m.numMatricula
    WHERE r.idRetiro = idRetiro
    ORDER BY r.idRetiro;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `USP_LeerMatriculaRetiro` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_LeerMatriculaRetiro`(numMatricula char(7))
BEGIN
	SELECT  m.numMatricula, m.codAlumno,
			m.codCurso, m.fechaMatricula, 
            m.horaMatricula, a.nombreAlumno
	FROM matricula AS m
    INNER JOIN alumno AS a ON a.codAlumno = m.codAlumno
	WHERE m.numMatricula = numMatricula;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `USP_LeerNumRetiro` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_LeerNumRetiro`(numRetiro char(7))
BEGIN
	SELECT  r.idRetiro, r.numRetiro, m.numMatricula, 
			m.codAlumno, m.codCurso, r.fechaRetiro, 
			r.horaRetiro
	FROM retiro AS r
	INNER JOIN matricula AS m ON r.numMatricula = m.numMatricula
    WHERE r.numRetiro = numRetiro
    ORDER BY r.idRetiro;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `USP_LeerRetiro` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_LeerRetiro`()
BEGIN
	SELECT  r.idRetiro, r.numRetiro, m.numMatricula, 
			m.codAlumno, m.codCurso, r.fechaRetiro, 
			r.horaRetiro
	FROM retiro AS r
	INNER JOIN matricula AS m ON r.numMatricula = m.numMatricula
    INNER JOIN alumno as a ON m.codAlumno = a.codAlumno
    WHERE a.estadoAlumno = 2
    ORDER BY r.idRetiro;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `USP_LeerUnRetiro` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_LeerUnRetiro`(numRetiro char(7))
BEGIN
	SELECT  r.idRetiro, r.numRetiro, m.numMatricula, 
			m.codAlumno, m.codCurso, r.fechaRetiro, 
			r.horaRetiro
	FROM retiro AS r
	INNER JOIN matricula AS m ON r.numMatricula = m.numMatricula
    WHERE r.numRetiro = numRetiro
    ORDER BY r.idRetiro;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `USP_ModificarRetiro` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_ModificarRetiro`(numRetiro char(7), codCurso char(6))
BEGIN
	UPDATE matricula AS m
    INNER JOIN retiro AS r ON m.numMatricula = r.numMatricula
    SET m.codCurso = codCurso
    WHERE r.numRetiro = numRetiro;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_obtenerEstadoAlumno` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_obtenerEstadoAlumno`(IN cdA varchar(9))
select a.estadoAlumno 
from alumno as a
where a.codAlumno = cdA ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-18 23:02:05
