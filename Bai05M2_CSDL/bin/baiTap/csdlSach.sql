-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.20-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             12.0.0.6468
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for dlsachdb
CREATE DATABASE IF NOT EXISTS `dlsachdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci */;
USE `dlsachdb`;

-- Dumping structure for table dlsachdb.sach
CREATE TABLE IF NOT EXISTS `sach` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tenSach` varchar(200) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `tacGia` varchar(200) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `NXB` varchar(200) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `giaBia` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

-- Dumping data for table dlsachdb.sach: ~3 rows (approximately)
DELETE FROM `sach`;
INSERT INTO `sach` (`id`, `tenSach`, `tacGia`, `NXB`, `giaBia`) VALUES
	(2, 'Lá nằm trong lá', 'Nguyễn Nhật Ánh', 'NXB Trẻ', 45000),
	(3, 'Rừng xưa xanh lá', 'Ngọc Tuấn', 'Hội nhà văn', 36000),
	(4, 'Ngôi trường dấu yêu', 'Nguyễn Thị Thu Thảo', 'NXB Trẻ', 52000);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
