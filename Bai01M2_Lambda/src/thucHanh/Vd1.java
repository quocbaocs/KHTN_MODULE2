package thucHanh;

interface PhepTinh {
	double tinh(int a, int b);
}

//cach 1: xay dung lop thuc thi giao tiep
class Cong implements PhepTinh {

	@Override
	public double tinh(int a, int b) {
		// TODO Auto-generated method stub
		return (double) a + b;
	}

}

public class Vd1 {
	public static void main(String[] args) {
		int a = 5, b = 4;
		double tong, hieu, tich;

		Cong cong = new Cong();
		tong = cong.tinh(a, b);
		System.out.println("tong = " + tong);

		// Cách 2 : Long cap vo danh
		PhepTinh tru = new PhepTinh() {
			
			@Override
			public double tinh(int a, int b) {
				// TODO Auto-generated method stub
				return a-b;
			}
		};

		// Cách 3 ; Dùng lambda (viết code ngắn gọn cho các giao tiếp có chứa 1 thức)
		//PhepTinh nhan = (int x, int y) -> x * y;
		PhepTinh nhan = (x, y) -> x * y;
		tich = nhan.tinh(a, b);
		System.out.println("tich =" + tich);
		
//		PhepTinh tru = (x, y) -> (x - y);
//		hieu = tru.tinh(a, b);
//		System.out.println("Hieu = " + hieu);

	}
	
	
	interface ChaoHoi {
		void chao();
	}

	public class Vd2 {
		public static void main2(String[] args) {
			ChaoHoi ch = () -> System.out.println("Chào mừng các bạn đến với lập trình Lambda");
			ch.chao();

			ChaoHoi ch2 = () -> {
				String s = "Chào mừng các bạn đến Lập trình Java Module 2";
				s = s.toUpperCase();
				System.out.println(s);
			};
			ch2.chao();
		}
	}
}
