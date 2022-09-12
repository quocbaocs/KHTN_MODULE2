package baiTap;

public class Sach {
	private String tenSach;
	private String tacGia;
	private String NXB;
	private double giaBia;

	public Sach() {
		super();
	}

	public Sach(String tenSach, String tacGia, String nXB, double giaBia) {
		super();
		this.tenSach = tenSach;
		this.tacGia = tacGia;
		NXB = nXB;
		this.giaBia = giaBia;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public String getNXB() {
		return NXB;
	}

	public void setNXB(String nXB) {
		NXB = nXB;
	}

	public double getGiaBia() {
		return giaBia;
	}

	public void setGiaBia(double giaBia) {
		this.giaBia = giaBia;
	}

	@Override
	public String toString() {
		return "Sach [tenSach=" + tenSach + ", tacGia=" + tacGia + ", NXB=" + NXB + ", giaBia=" + giaBia + "]";
	}

}
