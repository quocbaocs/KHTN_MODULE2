package thucHanh;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Vd2 {
	public static void main(String[] args) {

		int a[] = { 1, 5, 3, 2, 4 };
		Arrays.stream(a).peek(x -> System.out.println("Dang xet phan tu: " + x)).filter(x -> x % 2 == 0)
				.peek(x -> System.out.println("La so chan: " + x)).forEach(x -> System.out.println(x));

		int[] b = new int[0];
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 == 1) {
				b = Arrays.copyOf(b, b.length + 1);
				b[b.length - 1] = a[i];
			}
		}
		System.out.println("Mang b: " + Arrays.toString(b));

		Arrays.stream(a).filter(x -> x % 2 == 1).forEach(x -> System.out.print(x + " "));

		long sptChan = Arrays.stream(a).filter(x -> x % 2 == 0).count();
		System.out.println("So phan tu la so chan: " + sptChan);

		List<String> ds = Arrays.asList("public", "private", "protected", "final", "static", "super", "extend",
				"implement", "class", "abstract", "interface");
		System.out.println("Cac chuoi co chua 'en'");
		ds.stream().filter(s -> s.contains("en")).forEach(s -> System.out.println(s));

		System.out.println("Cac chuoi co chieu dai >5");
		ds.stream().filter(s -> s.length() > 6).forEach(s -> System.out.println(s));

		System.out.println("Danh sach chua cac chuoi tu ds co chua chu 'e'");
		List<String> ds2 = ds.parallelStream().filter(s -> s.contains("e")).collect(Collectors.toList());
		ds2.forEach(s -> System.out.println(s));

		// Cach 1
		int max, min, sum;
		long count;
		double average;
		max = Arrays.stream(a).max().getAsInt();
		min = Arrays.stream(a).min().getAsInt();
		count = Arrays.stream(a).count();
		average = Arrays.stream(a).average().getAsDouble();
		sum = Arrays.stream(a).sum();
		System.out.println("max = " + max);
		System.out.println("min = " + min);
		System.out.println("sum = " + sum);
		System.out.println("count = " + count);
		System.out.println("average = " + average);

		// THong ke
		System.out.println("Su dung doi tuong thong ke IntSummaryStatistics");
		IntSummaryStatistics tk = Arrays.stream(a).summaryStatistics();
		System.out.println("max = " + tk.getMax());
		System.out.println("min = " + tk.getMin());
		System.out.println("sum = " + tk.getSum());
		System.out.println("count = " + tk.getCount());
		System.out.println("average = " + tk.getAverage());

	}

}
