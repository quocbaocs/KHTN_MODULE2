/*CREATE DATABASE `qlnhanviendb` CHARACTER SET utf8 COLLATE UTF8_GENERAL_CI;

CREATE TABLE cong_ty(
	ID INT(11) PRIMARY KEY AUTO_INCREMENT,
	ten VARCHAR (200)  NULL,
	dien_thoai VARCHAR (200)  NULL,
	dia_chi VARCHAR (200)  NULL,
	tuoi_toi_thieu INT(11) NULL,
	tuoi_toi_da INT(11) NULL
);

CREATE TABLE don_vi(
	ID INT(11) PRIMARY KEY AUTO_INCREMENT,
	ten VARCHAR (200)  NULL
);

CREATE TABLE nhan_vien(
	ID INT(11) PRIMARY KEY AUTO_INCREMENT,
	ho_ten VARCHAR (200)  NULL,
	gioi_tinh int (1)  NULL,
	ngay_sinh DATE  NULL,
	CMND VARCHAR(200) NULL,
	muc_luong double NULL,
	dia_chi VARCHAR(200) NULL,
	ID_DON_VI INT(11) NULL
);

CREATE TABLE loai_cong_viec(
	ID INT(11) PRIMARY KEY AUTO_INCREMENT,
	ten VARCHAR (200)  NULL
);
CREATE TABLE ngoai_ngu(
	ID INT(11) PRIMARY KEY AUTO_INCREMENT,
	ten VARCHAR (200)  NULL
);
CREATE TABLE yeu_cau(
	ID INT(11) PRIMARY KEY AUTO_INCREMENT,
	ID_LOAI_CONG_VIEC INT(11),
	ID_NGOAI_NGU INT(11)
);
CREATE TABLE kha_nang(
	ID INT(11)  KEY AUTO_INCREMENT,
	ID_NHAN_VIEN INT(11),
	ID_NGOAI_NGU INT(11)
);

CREATE TABLE phieu_phan_cong(
	ID INT(11) PRIMARY KEY AUTO_INCREMENT,
	ngay_bat_dau DATE null,
	so_ngay INT(11),
	ID_NHAN_VIEN INT(11),
	ID_LOAI_CONG_VIEC INT(11)
);

CREATE TABLE nhom_nguoi_dung(
	ID INT(11) PRIMARY KEY AUTO_INCREMENT,
	ten VARCHAR (200)  NULL,
	ma_so VARCHAR(200) NULL
);

CREATE TABLE nguoi_dung(
	ID INT(11) PRIMARY KEY AUTO_INCREMENT,
	ten VARCHAR (200)  NULL,
	mat_khau VARCHAR(200) NULL,
	mo_rong VARCHAR(200) NULL,
	ID_NHOM_NGUOI_DUNG INT(11)
);


ALTER TABLE nhan_vien ADD CONSTRAINT fk_nhanvien_donvi FOREIGN KEY (ID_DON_VI) REFERENCES don_vi(id);
ALTER TABLE kha_nang ADD CONSTRAINT fk_khanang_nhanvien FOREIGN KEY (id_nhan_vien) REFERENCES nhan_vien(id);
ALTER TABLE kha_nang ADD CONSTRAINT fk_khanang_ngoaingu FOREIGN KEY(id_ngoai_ngu) REFERENCES ngoai_ngu(id);
ALTER TABLE yeu_cau ADD CONSTRAINT fk_yeucau_ngoai_ngu FOREIGN KEY(id_ngoai_ngu) REFERENCES ngoai_ngu(id);
ALTER TABLE phieu_phan_cong ADD CONSTRAINT fk_phieuphancong_nhanvien FOREIGN KEY(id_nhan_vien) REFERENCES nhan_vien(id);
ALTER TABLE yeu_cau ADD CONSTRAINT fk_yeucau_loaicongviec FOREIGN KEY(id_loai_cong_viec) REFERENCES loai_cong_viec(id);
ALTER TABLE nguoi_dung ADD CONSTRAINT fk_nguoidung_nhomnguoidung FOREIGN KEY (id_nhom_nguoi_dung) REFERENCES nguoi_dung(id);*/

