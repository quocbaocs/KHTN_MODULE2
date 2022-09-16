package thucHanh;

import java.util.Locale;
import java.util.ResourceBundle;

public class Vd4 {
	public static void main(String[] args) {
		Locale lcVN = new Locale("vi", "VN");
		Locale lcUS = new Locale("en", "US");

		ResourceBundle rsBundle;
		rsBundle = ResourceBundle.getBundle("thucHanh.tudien", lcVN);
		System.out.println("s2 = " + rsBundle.getString("s2"));

		rsBundle = ResourceBundle.getBundle("thucHanh.tudien", lcUS);
		System.out.println("s2 = " + rsBundle.getString("s2"));

	}

}
