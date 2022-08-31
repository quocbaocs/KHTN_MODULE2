package baiTap;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class BaiTap2_2 {
	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(1, 5, 6, 7, 4, 3, 65, 76, 32, 12, 34, 10, 17, 22, 13);
		list1.forEach(item -> System.out.print(item + ","));
		System.out.println("a List 2 bằng bình phương giá trị phần tử \r\n" + "của List 1");
		List<Integer> list2 = list1.parallelStream().map(x -> x * x).collect(Collectors.toList());
		list2.forEach(x -> System.out.print(x + ","));

		System.out.println();
		IntSummaryStatistics stats = list2.stream().mapToInt((x) -> x).summaryStatistics();
		System.out.println("Giá trị lớn nhất trong List 2 : " + stats.getMax());
		System.out.println("Giá trị nhỏ nhất trong List 2 : " + stats.getMin());
		System.out.println(" Tổng giá trị của tất cả các phần tử trong List 2 : " + stats.getSum());
		System.out.println("Trung bình của tất cả các phần tử trong List 2: " + stats.getAverage());

		List<Integer> list3 = list1.parallelStream().filter(x -> isPrimeNumber(x)).collect(Collectors.toList());
		System.out.println("List 3 từ List 2 mà chỉ lấy các phần tử là số nguyên tố" + list3.toString());

		System.out.println("a List 4 từ List 2 mà chỉ lấy các phần tử là số chính phương");
		List<Integer> list4 = list1.parallelStream().filter(x -> checkPerfectSquare(x)).collect(Collectors.toList());
		list4.forEach(x -> System.out.print(x + ","));
	}

	public static boolean isPrimeNumber(int n) {
		// so nguyen n < 2 khong phai la so nguyen to
		if (n < 2) {
			return false;
		}
		// check so nguyen to khi n >= 2
		int squareRoot = (int) Math.sqrt(n);
		for (int i = 2; i <= squareRoot; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	private static boolean checkPerfectSquare(double x) {
		double sq = Math.sqrt(x);
		return ((sq - Math.floor(sq)) == 0);
	}
}
