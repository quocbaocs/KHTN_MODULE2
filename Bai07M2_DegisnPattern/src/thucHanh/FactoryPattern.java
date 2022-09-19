package thucHanh;

interface HinhHoc {
	void xuat();
}

class HT implements HinhHoc {

	@Override
	public void xuat() {
		// TODO Auto-generated method stub
		System.out.println("HInh tron");
	}

}

class HCN implements HinhHoc {

	@Override
	public void xuat() {
		// TODO Auto-generated method stub
		System.out.println("HInh chu nhat");
	}

}

class HV implements HinhHoc {

	@Override
	public void xuat() {
		// TODO Auto-generated method stub
		System.out.println("Hinh vuong");
	}

}

class HinhFactory {
	public static HinhHoc getHinh(String tenHinh) {
		if (tenHinh.equalsIgnoreCase("ht")) {
			return new HT();
		}
		if (tenHinh.equalsIgnoreCase("hcn")) {
			return new HCN();
		}
		if (tenHinh.equalsIgnoreCase("hv")) {
			return new HV();
		} else {
			return null;
		}
	}
}

public class FactoryPattern {
	public static void main(String[] args) {
		HinhHoc h1 = HinhFactory.getHinh("hcn");
		h1.xuat();
		h1 = HinhFactory.getHinh("hv");
		h1.xuat();
	}
}
