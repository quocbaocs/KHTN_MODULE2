package dataTransferObject;

public class TrangThai {
	private int id;
	private String tenTrangThai;

	public TrangThai(int id, String tenTrangThai) {
		super();
		this.id = id;
		this.tenTrangThai = tenTrangThai;
	}

	public TrangThai() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenTrangThai() {
		return tenTrangThai;
	}

	public void setTenTrangThai(String tenTrangThai) {
		this.tenTrangThai = tenTrangThai;
	}

}
