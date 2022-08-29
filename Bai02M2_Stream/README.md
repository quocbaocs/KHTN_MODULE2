# Java Stream API
	Là một lớp xử lí
	Thao tác trên luồng là tập hợp(cung cấp một số hàm để làm)
	
	1.Là một dãy các phần tử
	2.Có luồng stream là danh sách , hoac tap hợp
	3. Cung cấp các hàm tập hợp
	4. Pipelining trả về luồng, có hàm hết thúc luồng
	5. Tự động lặp
	
	Cac ham:
	generate : phat sinh ra so ngau nhien , vo tan, không có thứ tự
	
	-Luồng sử dụng một lần không sử dụng lại.
	
	-Mảng với List chứa , có thể sử dụng lại nhiều lần
	
## Các phương thức
	forEach
	map ánh sạ từng phần tử với kết quả tương ứng
	flatMap ánh xạ từng phẩn tử với từng phần tử trong danh sách
	peek dùng kiểm tra, gỡ lỗi, đang chạy đến phần tử nào
	filter lọc, giới hạn yếu tố dựa trên một tiêu chí
	Colector: biến đổi danh sách này sang danh sách khác	
	Static  thong ke