## CSDL
	- Tất cả thông tin quảng lý cần lưu lại 
	- Nhiều thông tin bảo mật, xử lí cần csdl, có thể xử lí dữ liệu lớn .
	- Là một phần mềm hệ thông, lưu trữ , sửa chữa , tìm kiếm, ...
	- Không có sql phải lập trình dài dòng
	4 lệnh thường dùng nhất
	- SELECT (97%) thường sử dụng nhất
	- INSERT INTO
	- UPDATE SET
	- DELETE (xóa mất không phục hồi lại được)
	-Restrict (use)
	-cascade xóa bảng này xóa luôn bảng kia 
	- Ngày tháng năm trong mysql là dạng chuỗi
	- Thư viện thầy gửi : mysql-connector-java-5.1.49.jar 
	- Dùng:  Wampserver 3.2.3 để sử dụng PHPAdmin và mysql 
	- Để đọc được tiếng việt nhất định phải dùng :useUsenicode=true&characterEncoding=UTF-8//
	
	jdbc:mysql://localhost:3306/qlsv?useUsenicode=true&characterEncoding=UTF-8
## Qui trình kết nối cơ sở dữ liệu
	- Bước 1:Nạp trình điều khiển
	( Khai báo thư viện kết nối, tạo lóp kết nối hay qui trình)
	- Bước 2: Tạo chuỗi kết nối
	- Bước 3: Tạo kết nối
	- Bước 4: Tạo phát biểu
	- Bước 5: Thực hiện câu truy vấn
		- Nếu câu truy vấn là SELECT thì dùng executeQuery();
		- Nếu câu truy vấn là Update, inser \t, delete là executeUpdate();
	Bước 6: 
		- Tùy theo kiểu dữ liệu của field ta gọi phương thức tương ứng
	Bước 7: Đóng kết nối cơ sở dữ liệu
	
## Bài tập 1: password sử dụng passwordField
	- new String(txtPassword.getPassword);
	- Field không phải là số thì đóng bằng dấu nháy đơn
	String sql = "select * from user where username='"+userName+"' and password='"+password+"'";
	
	-Use Statement , tạo ra một chuỗi dài
	-User prepareStatement , sử dụng ? thêm tham số vào
	
# Kiến trúc 3 lớp( Three-layer arcitecture)

		 				Đối tượng chứa và truyền dữ liệu
	*-><-	Trình bày---------------><--------------- Xử lý -><- truy cập dữ liệu -><- database
	