package thucHanh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Vd1 {
	public static void main(String[] args) {
		String s = "Trung tam tin hoc dai hoc Khoa hoc tu nhien";
		s = s.substring(5).toUpperCase().substring(0, 20).toLowerCase();
		System.out.println(s);
		int a[] = { 15, 3, 4, 2, 1 };

		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > max)
				max = a[i];
		}
		System.out.println("max = " + max);

		// 5 cach tao luong
		
		System.out.println("\n 1. Tao Stream bang phuong thuc static: Stream.of");
		Stream<String> l1 = Stream.of("mai", "lan", "cuc", "truc");
		System.out.println("Cac chuoi trong l1 la: " + l1.count());
		
		System.out.println("\n 2.Tao Stream bang phuong thuc tinh Stream.generate");
		Stream<Integer> l2 = Stream.generate(() -> {
			Random rd = new Random();
			return rd.nextInt(21);

		});
		l2.limit(5).forEach(x -> System.out.println(x));

		System.out.println("3. Tao Stream bang phuong tinh tinh Stram.iterate");
		Stream<String> l3 = Stream.iterate("a", (x) -> x + x);
		l3.limit(5).forEach(x -> System.out.println(x));
		

		System.out.println("\n 4.Tao Stream tu mang bang phuong thuc Arrays.stream");
		int sln = Arrays.stream(a).max().getAsInt();
		System.out.println("sln = " + sln);

		
		System.out.println("\n 5. Tao Stram tu collection dung ham streams()");
		List<Integer> ds2 = new ArrayList<Integer>();
		ds2.add(1);
		ds2.add(5);
		ds2.add(3);
		ds2.add(2);
		ds2.add(4);
		int tong = ds2.stream().mapToInt(x -> x).sum();
		System.out.println("tong = " + tong);

		
	}

}
