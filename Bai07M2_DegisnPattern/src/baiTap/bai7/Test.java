package baiTap.bai7;

import java.awt.Menu;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		CarBuilder builder = new CarBuilderImpl();
		CarBuildDirector carBuildDirector = new CarBuildDirector(builder);

		int chon = 0;
		do {
			menu();
			chon = Integer.parseInt(input.readLine());
			switch (chon) {
			case 1: {
				System.out.println(carBuildDirector.construct() + "\n");
				break;
			}
			case 2: {
				System.out.println("Nhập số bánh:");
				int wheels = Integer.parseInt(input.readLine());
				System.out.println("Nhập màu:");
				String color = input.readLine();
				System.out.println(carBuildDirector.construct1(wheels, color) + "\n");
				break;
			}
			case 3: {
				System.out.println("Nhập số bánh:");
				int wheels = Integer.parseInt(input.readLine());
				System.out.println(carBuildDirector.construct2(wheels) + "\n");
				break;
			}
			case 4: {
				System.out.println("Nhập màu:");
				String color = input.readLine();
				System.out.println(carBuildDirector.construct3(color) + "\n");
				break;
			}
			default:
				System.out.println("Chỉ có 4 loại để lựa chọn!");
				System.out.println("\nBạn có tiếp tục tạo xe? 1: Có, Khác 0:Không");
				chon = Integer.parseInt(input.readLine());
				break;
			}
		} while (chon != 0);
		System.out.println("Bạn đã thoát chương trình...");

	}

	private static void menu() {
		System.out.println("Bạn muốn tạo xe như thế nào?");
		System.out.println("1. Tiêu chuẩn bốn bánh, màu đen");
		System.out.println("2. Tùy chọn số bánh màu");
		System.out.println("3. Tùy chọn số bánh màu đen");
		System.out.println("4. 4 bánh tùy màu");
		System.out.println("Nhập lựa chọn: ");
	}
}
