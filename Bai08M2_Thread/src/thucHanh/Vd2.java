package thucHanh;

//B1 : Xây dựng lớp Kế thừa lớp Thread ghi đè hàm run
class TieuTrinh1 extends Thread {
	@Override
	public void run() {
		for (int i = 1; i <= 50; i++) {
			System.out.print(i + " ");
			try {
				//Trạng thái dừng luồng
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class TieuTrinh2 extends Thread {
	@Override
	public void run() {
		for (int i = 51; i <= 100; i++) {
			System.out.print(i + " ");
		}
	}
}

public class Vd2 {

	public static void main(String[] args) {
//		B2 : Tạo ra đối tượng từ lớp ở trên

		TieuTrinh1 tt1 = new TieuTrinh1();
		TieuTrinh2 tt2 = new TieuTrinh2();

//		B3 : Gọi hàm Start
		tt1.start();
		tt2.start();
	}

}
