package thucHanh;

import java.util.Date;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Vd3 {
	public static void main(String[] args) {
		double so = 12345.67;
		//Định dạng số
		System.out.println("So (Java):" + so);
		Locale ldVN = new Locale("vi", "VN");
		Locale lcUS = new Locale("en", "US");
		NumberFormat nfVN = NumberFormat.getNumberInstance(ldVN);
		NumberFormat nfUS = NumberFormat.getNumberInstance(lcUS);
		System.out.println("So (VN) :" + nfVN.format(so));
		System.out.println("So (US) :" + nfUS.format(so));
		
		//Định dạng ngày
		Date homNayDate = new Date();
		System.out.println("Hom nay (Java): " + homNayDate);

		DateFormat dfVN = DateFormat.getDateInstance(DateFormat.SHORT, ldVN);
		DateFormat dfUS = DateFormat.getDateInstance(DateFormat.SHORT, lcUS);
		System.out.println("Hom nay (VN): " + dfVN.format(homNayDate));
		System.out.println("Hom nay (US): " + dfUS.format(homNayDate));

		//Định dạng tiền tệ
		NumberFormat nfTienVN = NumberFormat.getCurrencyInstance(ldVN);
		NumberFormat nfTienUS = NumberFormat.getCurrencyInstance(lcUS);

		System.out.println("So tien (VN): " + nfTienVN.format(so));
		System.out.println("So tien (US): " + nfTienUS.format(so));
	}

}
