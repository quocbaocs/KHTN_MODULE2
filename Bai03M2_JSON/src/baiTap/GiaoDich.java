package baiTap;

public class GiaoDich {
	private String ma;
	private String ngay;
	private float donGia;
	private int soLuong;
	private String loai;
	
	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public String getNgay() {
		return ngay;
	}

	public void setNgay(String ngay) {
		this.ngay = ngay;
	}

	public float getDonGia() {
		return donGia;
	}

	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getLoai() {
		return loai;
	}

	public void setLoai(String loai) {
		this.loai = loai;
	}

	public double thanhTien() {
		return (double)soLuong*donGia;
	}

	public GiaoDich() {
		super();
	}

	public GiaoDich(String ma, String ngay, float donGia, int soLuong, String loai) {
		super();
		this.ma = ma;
		this.ngay = ngay;
		this.donGia = donGia;
		this.soLuong = soLuong;
		this.loai = loai;
	}
	public String toString() {
		return "|";
	}
}
