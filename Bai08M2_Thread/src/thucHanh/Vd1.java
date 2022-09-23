package thucHanh;

public class Vd1 {
	private static void inDen50() {
		for (int i = 1; i <= 50; i++) {
			System.out.println(i + " ");
		}
	}

	private static void in50Den100() {
		for (int i =51 ; i <= 100; i++) {
			System.out.println(i + " ");
		}
	}

	public static void main(String[] args) {
		inDen50();
		in50Den100();
	}

}
