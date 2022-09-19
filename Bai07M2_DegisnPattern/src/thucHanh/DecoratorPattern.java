package thucHanh;

interface Hinh {
	public void xuat();
}

abstract class Decorator implements Hinh {
	private Hinh hinh;

	protected Decorator(Hinh hinh) {
		this.hinh = hinh;
	}

	@Override
	public void xuat() {
		// TODO Auto-generated method stub
		hinh.xuat();
	}
}

class DVD extends Decorator {
	public DVD(Hinh hinh) {
		super(hinh);
	}

	@Override
	public void xuat() {
		// TODO Auto-generated method stub
		super.xuat();
		System.out.println("Duong vien do");
	}

}

public class DecoratorPattern {
//	Hinh h1 = new HT();
//	h1.xuat();
//	Hinh h2 = new HTDVD();
//	h2.xuat();
	
//	Hinh h3 = new DVD(new HT());
//	h3.xuat();
}
