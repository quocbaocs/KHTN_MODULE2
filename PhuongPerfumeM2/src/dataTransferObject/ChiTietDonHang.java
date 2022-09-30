package dataTransferObject;

public class ChiTietDonHang {
	private int id;
	private String tenSanPham;
	private int soLuong;
	private double donGia;

	public ChiTietDonHang() {
		super();
	}

	public ChiTietDonHang(int id, String tenSanPham, int soLuong, double donGia) {
		super();
		this.id = id;
		this.tenSanPham = tenSanPham;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double thanhTien() {
		return this.soLuong * this.donGia;
	}

	@Override
	public String toString() {
		return "ChiTietDonHang [id=" + id + ", tenSanPham=" + tenSanPham + ", soLuong=" + soLuong + ", donGia=" + donGia
				+ "]";
	}

}
