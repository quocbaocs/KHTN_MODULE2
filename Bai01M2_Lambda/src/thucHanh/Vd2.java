package thucHanh;

import java.util.ArrayList;
import java.util.List;

public class Vd2 {
	public static void main(String[] args) {
		List<String> ds = new ArrayList<>();
		ds.add("mai");
		ds.add("lan");
		ds.add("cuc");
		ds.add("truc");

		System.out.println("Xuat List ds ra man hinh");
		for (String s : ds) {
			System.out.println(s);
		}

		System.out.println("Xuat ra man hinh dung forEach");
		ds.forEach(s -> System.out.println(s));
	}
}
