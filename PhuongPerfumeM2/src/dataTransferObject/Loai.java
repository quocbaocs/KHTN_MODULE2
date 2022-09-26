package dataTransferObject;

public class Loai {
	private int id;
	private String tenLoai;

	public Loai(int id, String tenLoai) {
		super();
		this.id = id;
		this.tenLoai = tenLoai;
	}

	public Loai() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

}
