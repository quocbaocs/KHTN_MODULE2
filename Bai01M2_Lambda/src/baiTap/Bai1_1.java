package baiTap;

import java.util.Arrays;
import java.util.List;

public class Bai1_1 {
	public static void main(String[] args) {
		// C1 : for mot cach binh thuong
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		for (Integer n : list) {
			System.out.println(n);
		}
		System.out.println("Xuat danh sach su dung forEach");
		// C2 : su dung bieu thuc lambda
		
		list.forEach(item -> System.out.println(item));
	}

}
