package thucHanh;

//B1 : Xây dựng lớp Kế thừa lớp Thread ghi đè hàm run
class TieuTrinh11 implements Runnable {
	@Override
	public void run() {
		for (int i = 1; i <= 50; i++) {
			System.out.print(i + " ");

		}
	}
}

class TieuTrinh22 implements Runnable {
	@Override
	public void run() {
		for (int i = 51; i <= 100; i++) {
			System.out.print(i + " ");
		}
	}
}

public class Vd3 {

	public static void main(String[] args) {
//		B2 : Tạo ra đối tượng từ lớp ở trên

		TieuTrinh11 tt1 = new TieuTrinh11();
		TieuTrinh22 tt2 = new TieuTrinh22();
		Thread t1 = new Thread(tt1);
		Thread t2 = new Thread(tt2);

//		B3 : Gọi hàm Start
		t1.start();
		t2.start();
	}

}
