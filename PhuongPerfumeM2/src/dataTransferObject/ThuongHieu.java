package dataTransferObject;

public class ThuongHieu {
	private int id;
	private String tenTH;
	private String hinhAnh;

	public ThuongHieu(int id, String tenTH, String hinhAnh) {
		super();
		this.id = id;
		this.tenTH = tenTH;
		this.hinhAnh = hinhAnh;
	}

	public ThuongHieu() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenTH() {
		return tenTH;
	}

	public void setTenTH(String tenTH) {
		this.tenTH = tenTH;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

}
