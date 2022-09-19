package thucHanh;

public class SingletonPattern {
	public static void main(String[] args) {
		StringBuilder sb1 = new StringBuilder("abc");
//		StringBuilder sb2 = new StringBuilder("abc");
		StringBuilder sb2 = sb1;
		if (sb1.equals(sb2)) {
			System.out.println("sb1===sb2");
		} else {
			System.out.println("sb1!=sb2");

		}
		
		Singleton sgt1 = Singleton.getSingleton();
		Singleton sgt2 = Singleton.getSingleton();
		if(sgt1.equals(sgt2)) {
			System.out.println("sgt1===sgt2");
		}else {
			System.out.println("sgt1!=sgt2");
		}
	}

}

class Singleton {
	private static Singleton singleton = null;

	private Singleton() {
		// TODO Auto-generated constructor stub
	}

	public static Singleton getSingleton() {
		if (singleton == null) {
			singleton = new Singleton();
		}
		return singleton;
	}
}
