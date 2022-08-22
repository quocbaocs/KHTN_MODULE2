package baiTap;

import java.util.Scanner;

interface Area {
	public double calAre(double x1, double x2);
}

public class Bai1_3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập bán kính: ");
		int bk = sc.nextInt();
		Area circle = (pi, r) -> pi * r * r;

		System.out.println("S = PI * (r*r) = " + circle.calAre(Math.PI, bk));
		System.out.println("Nhập chiều dài :");
		int cd = sc.nextInt();
		System.out.println("Nhập chiều rộng :");
		int cr = sc.nextInt();
		Area rectangle = (d, r) -> d * r;
		System.out.println("S = W * H = " + rectangle.calAre(cd, cr));
	}
}
