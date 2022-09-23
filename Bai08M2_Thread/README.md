## Thread
	Có hai cách tạo 
	
	- Đồng bộ đơn luồng
	
		private static void inDen50() {
			for(int i =1; i <=50; i++) {
				System.out.println(i+ " ");
			}
		}
		private static void in50Den100() {
			for(int i =1; i <=50; i++) {
				System.out.println(i+ " ");
			}
		}
### Cách 1:
	- Đa luồng phải chia thành 2 tiêu trình
	+ B1 : Xây dựng lớp Kế thừa lớp Thread ghi đè hàm run
	+ B2 : Tạo ra đối tượng từ lớp ở trên
	+ B3 : Gọi hàm Start
	- Muốn dừng luồng phải dùng hàm sleep() phương thức tĩnh Thread;
### Cách 2:
	B1: Xây dựng lớp implement lớp Runable hiện thực hàm run
	B2:Tạo đối tượng lớp vừa định nghĩa
	B3:Tạo đối tượng của lớp Thread và truyền đối tượng của lớp định nghĩa vào đối số của hàm khởi tạo
	B4: Gọi hàm Start() của đối tượng Thread

## Cơ chế đồng bộ dữ liệu 
	Hai người dùng chung đối tượng
	Phải khóa dữ liệu, có hai cơ chế khóa
	+ khóa trên lớp
	+ 
	