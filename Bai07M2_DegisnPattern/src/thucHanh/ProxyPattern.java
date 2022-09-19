package thucHanh;


interface HinhAnh{
	void xuat();
}
class HinhThuc implements HinhAnh{
	private String tenHinh;

	public HinhThuc(String tenHinh) {
		this.tenHinh = tenHinh;
		taiHinh();
	}
	@Override
	public void xuat() {
		// TODO Auto-generated method stub
		System.out.println("Xuat Hinh "+tenHinh);
	}
	public void taiHinh() {
		System.out.println("Tai hinh "+tenHinh);
	}
}
class HinhUyQuyen implements HinhAnh{
	private String tenHinh;
	HinhThuc hinhThuc = null;
	public HinhUyQuyen(String tenHinh) {
		// TODO Auto-generated constructor stub
		this.tenHinh = tenHinh;
	}
	
	
	@Override
	public void xuat() {
		// TODO Auto-generated method stub
		if(hinhThuc==null) {
			hinhThuc = new HinhThuc(tenHinh);
			hinhThuc.xuat();
		}
	}
	
}
public class ProxyPattern {
	public static void main(String[] args) {
//		HinhAnh h1 = new HinhThuc("abc.jpg");
//		h1.xuat();
		HinhAnh h2 = new HinhUyQuyen("abc.jpg");
		h2.xuat();
	}
}
