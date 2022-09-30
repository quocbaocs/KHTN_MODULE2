package dataTransferObject;

import java.sql.Date;

public class DonHang {
	private int id;
	private int idKhachHang;
	private Date ngayDatHang;
	private String tenNguoiNhanNang;
	private String denThoaiNguoiNhan;
	private String diaChiGiaoHang;
	private String ghiChu;
	private boolean thanhToan;
	private int idTrangThai;

	public DonHang() {
		super();
	}

	public DonHang(int id, int idKhachHang, Date ngayDatHang, String tenNguoiNhanNang, String denThoaiNguoiNhan,
			String diaChiGiaoHang, String ghiChu, boolean thanhToan, int idTrangThai) {
		super();
		this.id = id;
		this.idKhachHang = idKhachHang;
		this.ngayDatHang = ngayDatHang;
		this.tenNguoiNhanNang = tenNguoiNhanNang;
		this.denThoaiNguoiNhan = denThoaiNguoiNhan;
		this.diaChiGiaoHang = diaChiGiaoHang;
		this.ghiChu = ghiChu;
		this.thanhToan = thanhToan;
		this.idTrangThai = idTrangThai;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdKhachHang() {
		return idKhachHang;
	}

	public void setIdKhachHang(int idKhachHang) {
		this.idKhachHang = idKhachHang;
	}

	public Date getNgayDatHang() {
		return ngayDatHang;
	}

	public void setNgayDatHang(Date ngayDatHang) {
		this.ngayDatHang = ngayDatHang;
	}

	public String getTenNguoiNhanNang() {
		return tenNguoiNhanNang;
	}

	public void setTenNguoiNhanNang(String tenNguoiNhanNang) {
		this.tenNguoiNhanNang = tenNguoiNhanNang;
	}

	public String getDenThoaiNguoiNhan() {
		return denThoaiNguoiNhan;
	}

	public void setDenThoaiNguoiNhan(String denThoaiNguoiNhan) {
		this.denThoaiNguoiNhan = denThoaiNguoiNhan;
	}

	public String getDiaChiGiaoHang() {
		return diaChiGiaoHang;
	}

	public void setDiaChiGiaoHang(String diaChiGiaoHang) {
		this.diaChiGiaoHang = diaChiGiaoHang;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public boolean getThanhToan() {
		return thanhToan;
	}

	public void setThanhToan(boolean thanhToan) {
		this.thanhToan = thanhToan;
	}

	public int getIdTrangThai() {
		return idTrangThai;
	}

	public void setIdTrangThai(int idTrangThai) {
		this.idTrangThai = idTrangThai;
	}

}
