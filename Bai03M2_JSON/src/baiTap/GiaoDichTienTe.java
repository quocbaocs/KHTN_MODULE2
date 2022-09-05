package baiTap;

public class GiaoDichTienTe extends GiaoDich {
	private boolean mua;

	public boolean isMua() {
		return mua;
	}

	public void setMua(boolean mua) {
		this.mua = mua;
	}

	public GiaoDichTienTe() {
		super();
	}

	public GiaoDichTienTe(String ma, String ngay, float donGia, int soLuong, String loai, boolean mua) {
		super(ma, ngay, donGia, soLuong, loai);
		this.mua = mua;
	}



}
