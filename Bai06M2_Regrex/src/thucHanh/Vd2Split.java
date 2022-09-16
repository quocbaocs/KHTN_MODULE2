package thucHanh;

import java.util.Arrays;

public class Vd2Split {
	public static void main(String[] args) {
		String s= "Trung,Tam,Tin,hoc";
		String ms[] = s.split(",");
		Arrays.stream(ms).forEach(str->System.out.println(str));
	}

}
