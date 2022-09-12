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


-- Dumping database structure for qlnhanviendb
CREATE DATABASE IF NOT EXISTS `qlnhanviendb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `qlnhanviendb`;

-- Dumping structure for table qlnhanviendb.cong_ty
CREATE TABLE IF NOT EXISTS `cong_ty` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ten` varchar(200) DEFAULT NULL,
  `dien_thoai` varchar(200) DEFAULT NULL,
  `dia_chi` varchar(200) DEFAULT NULL,
  `tuoi_toi_thieu` int(11) DEFAULT NULL,
  `tuoi_toi_da` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table qlnhanviendb.cong_ty: ~0 rows (approximately)
DELETE FROM `cong_ty`;

-- Dumping structure for table qlnhanviendb.don_vi
CREATE TABLE IF NOT EXISTS `don_vi` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ten` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table qlnhanviendb.don_vi: ~0 rows (approximately)
DELETE FROM `don_vi`;

-- Dumping structure for table qlnhanviendb.kha_nang
CREATE TABLE IF NOT EXISTS `kha_nang` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_NHAN_VIEN` int(11) DEFAULT NULL,
  `ID_NGOAI_NGU` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_khanang_nhanvien` (`ID_NHAN_VIEN`),
  KEY `fk_khanang_ngoaingu` (`ID_NGOAI_NGU`),
  CONSTRAINT `fk_khanang_ngoaingu` FOREIGN KEY (`ID_NGOAI_NGU`) REFERENCES `ngoai_ngu` (`ID`),
  CONSTRAINT `fk_khanang_nhanvien` FOREIGN KEY (`ID_NHAN_VIEN`) REFERENCES `nhan_vien` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table qlnhanviendb.kha_nang: ~0 rows (approximately)
DELETE FROM `kha_nang`;

-- Dumping structure for table qlnhanviendb.loai_cong_viec
CREATE TABLE IF NOT EXISTS `loai_cong_viec` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ten` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table qlnhanviendb.loai_cong_viec: ~0 rows (approximately)
DELETE FROM `loai_cong_viec`;

-- Dumping structure for table qlnhanviendb.ngoai_ngu
CREATE TABLE IF NOT EXISTS `ngoai_ngu` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ten` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table qlnhanviendb.ngoai_ngu: ~0 rows (approximately)
DELETE FROM `ngoai_ngu`;

-- Dumping structure for table qlnhanviendb.nguoi_dung
CREATE TABLE IF NOT EXISTS `nguoi_dung` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ten` varchar(200) DEFAULT NULL,
  `mat_khau` varchar(200) DEFAULT NULL,
  `mo_rong` varchar(200) DEFAULT NULL,
  `ID_NHOM_NGUOI_DUNG` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_nguoidung_nhomnguoidung` (`ID_NHOM_NGUOI_DUNG`),
  CONSTRAINT `fk_nguoidung_nhomnguoidung` FOREIGN KEY (`ID_NHOM_NGUOI_DUNG`) REFERENCES `nguoi_dung` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table qlnhanviendb.nguoi_dung: ~0 rows (approximately)
DELETE FROM `nguoi_dung`;

-- Dumping structure for table qlnhanviendb.nhan_vien
CREATE TABLE IF NOT EXISTS `nhan_vien` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ho_ten` varchar(200) DEFAULT NULL,
  `gioi_tinh` int(1) DEFAULT NULL,
  `ngay_sinh` date DEFAULT NULL,
  `CMND` varchar(200) DEFAULT NULL,
  `muc_luong` double DEFAULT NULL,
  `dia_chi` varchar(200) DEFAULT NULL,
  `ID_DON_VI` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_nhanvien_donvi` (`ID_DON_VI`),
  CONSTRAINT `fk_nhanvien_donvi` FOREIGN KEY (`ID_DON_VI`) REFERENCES `don_vi` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table qlnhanviendb.nhan_vien: ~0 rows (approximately)
DELETE FROM `nhan_vien`;

-- Dumping structure for table qlnhanviendb.nhom_nguoi_dung
CREATE TABLE IF NOT EXISTS `nhom_nguoi_dung` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ten` varchar(200) DEFAULT NULL,
  `ma_so` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table qlnhanviendb.nhom_nguoi_dung: ~0 rows (approximately)
DELETE FROM `nhom_nguoi_dung`;

-- Dumping structure for table qlnhanviendb.phieu_phan_cong
CREATE TABLE IF NOT EXISTS `phieu_phan_cong` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ngay_bat_dau` date DEFAULT NULL,
  `so_ngay` int(11) DEFAULT NULL,
  `ID_NHAN_VIEN` int(11) DEFAULT NULL,
  `ID_LOAI_CONG_VIEC` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_phieuphancong_nhanvien` (`ID_NHAN_VIEN`),
  CONSTRAINT `fk_phieuphancong_nhanvien` FOREIGN KEY (`ID_NHAN_VIEN`) REFERENCES `nhan_vien` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table qlnhanviendb.phieu_phan_cong: ~0 rows (approximately)
DELETE FROM `phieu_phan_cong`;

-- Dumping structure for table qlnhanviendb.yeu_cau
CREATE TABLE IF NOT EXISTS `yeu_cau` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_LOAI_CONG_VIEC` int(11) DEFAULT NULL,
  `ID_NGOAI_NGU` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_yeucau_ngoai_ngu` (`ID_NGOAI_NGU`),
  KEY `fk_yeucau_loaicongviec` (`ID_LOAI_CONG_VIEC`),
  CONSTRAINT `fk_yeucau_loaicongviec` FOREIGN KEY (`ID_LOAI_CONG_VIEC`) REFERENCES `loai_cong_viec` (`ID`),
  CONSTRAINT `fk_yeucau_ngoai_ngu` FOREIGN KEY (`ID_NGOAI_NGU`) REFERENCES `ngoai_ngu` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table qlnhanviendb.yeu_cau: ~0 rows (approximately)
DELETE FROM `yeu_cau`;

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
