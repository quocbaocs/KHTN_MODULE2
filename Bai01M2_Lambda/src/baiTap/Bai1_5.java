package baiTap;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Bai1_5 {
	public static void main(String[] args) {
		List<String> ds = Arrays.asList("public", "private", "protected", "final", "static", "super", "extend",
				"implement", "class", "abstract", "interface");
		System.out.println("Danh Sach nhap vao ban dau");
		ds.forEach(s -> System.out.println(s));

		// Cach 1: viet code
		System.out.println("\n Sap xep chieu dai chuoi tang dan (dung thuat toan noi bot)");
		for (int i = 0; i < ds.size() - 1; i++) {
			for (int j = i + 1; j < ds.size(); j++) {
				if (ds.get(i).length() > ds.get(j).length()) {
					String tg = ds.get(i);
					ds.set(i, ds.get(j));
					ds.set(j, tg);
				}
			}
		}
		ds.forEach(s -> System.out.println(s));

		// dung ham sap xep cua list
		System.out.println("\n Dap xep chieu dai chuoi tang han ( dung ham sort cua List va long cap vo danh)");
		ds.sort(new Comparator<String>() {
			public int compare(String o1, String o2) {
				if (o1.length() < o2.length())
					return -1;
				else if (o1.length() == o2.length())
					return 0;
				else
					return 1;
			};

		});
		ds.forEach(s -> System.out.println(s));
		// cach 3: dung lamba de viet code cho giao tiep Comparator co 1 phuong thuc)
		System.out.println("\nSap xep chieu dai chuoi tang dan (cung ham sort cua List va lambda)");
		ds.sort((s1, s2) -> {
			if (s1.length() < s2.length())
				return -1;
			else if (s1.length() == s1.length())
				return 0;
			else
				return 1;
		});
		ds.forEach(s -> System.out.println(s));
		
		System.out.println("\n Sap xep chuoi theo thu tu Alpabet");
		Collections.sort(ds);
		ds.forEach(s -> System.out.println(s));
	}

}
