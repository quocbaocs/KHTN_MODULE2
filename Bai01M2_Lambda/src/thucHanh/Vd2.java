package thucHanh;

interface ChaoHoi {
	void chao();
}

public class Vd2 {
	public static void main(String[] args) {
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
