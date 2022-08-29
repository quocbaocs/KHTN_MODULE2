package baiTap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaiTap2_1 {
	public static void main(String[] args) {
		List<String> ds = Arrays.asList("public", "private", "protected", "final", "static", "super", "", "extend",
				"implement", "", "class", "", "abstract", "interface", "");
		System.out.println(ds.size());

		System.out.println("Phần tử có giá trị “”");
		long tong = ds.stream().filter(x -> x.equals("")).count();
		System.out.println(tong);
		System.out.println("Phần tử có chiều dài > 5");
		ds.stream().filter(x -> x.length() > 5).forEach(s -> System.out.println(s));
		System.out.println("phần tử giá trị bắt đầu là “a”");
		ds.stream().filter(x -> x.startsWith("a")).forEach(s -> System.out.println(s));

		long sl = ds.stream().filter(x -> x.equals("happy")).count();
		System.out.println("số phần tử có giá trị chính xác là “happy :" + sl);

		System.out.println(" List 2 mới từ List 1\r\n" + "▪ Chỉ gồm các phần tử có giá trị khác “”");
		List<String> ds2 = ds.parallelStream().filter(x -> !x.equals("")).collect(Collectors.toList());
		ds2.forEach(x -> System.out.println(x));

		System.out.println("List 3 mới từ List ử có chiều dài >=3 và <=6 cach nhau bang dau phay");
		List<String> ds3 = ds.parallelStream().filter(x -> x.length() >= 3 && x.length() <= 6)
				.collect(Collectors.toList());
		ds3.forEach(s -> {
			System.out.print(s + ", ");
		});

		System.out.println("List 4 mới từ List 1\r\n" + "cộng thêm chứ happy :");

		List<String> ds4 = ds.parallelStream().map(elem -> new String(elem + " happy")).collect(Collectors.toList());
		ds4.forEach(x -> System.out.println(x));
	}

}
