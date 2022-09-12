package dataTransferObject;

public class LienHe implements java.io.Serializable {
	private int id;
	private String hoTen;
	private String dtdd;
	private String hinhAnh;

	public LienHe(int id, String hoTen, String dtdd, String hinhAnh) {
		this(hoTen,dtdd, hinhAnh);
		this.id = id;
		
	}
	public LienHe(String hoTen, String dtdd, String hinhAnh) {
		super();
		this.hoTen = hoTen;
		this.dtdd = dtdd;
		this.hinhAnh = hinhAnh;
	}

	public LienHe() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getDtdd() {
		return dtdd;
	}

	public void setDtdd(String dtdd) {
		this.dtdd = dtdd;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

}
