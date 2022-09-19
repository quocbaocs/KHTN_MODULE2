# XML DOM
	- Dùng để chứa và truyền dữ liệu

## Cú pháp XML
	
	1. Có một nút gốc
	2. Phải có tag mở/đóng
	3. tag mở/đóng phải trùng tên
	4. tag con nằm trong tag cha
	5. Giá trị thuộc tính phải đặt trong "chuỗi"
	
## Cú pháp JSON

	{"ten":"gia tri",...}
	{"ten":[{"ten":"gia tri",....}]}
	
## Đọc file XML

	Bước 1: Import các gói thư viện XML có liên quan trước khi sử dụng
	Bước 2: Tạo đối tượng Document Builder 
	Bước 3: Tạo đối tượng Document từ một file hoặc stream
	Bước 4: Lấy phần tử gốc (root element)
	Bước 5: Kiếm tra các thuộc tính (attributes)
	Bước 6: Kiếm tra các phần tử con (sub-attribute)
	
## Ghi tài liệu XML
	Bước 1: import các thư viện XML liên qan trước khi sử dụng
	Bước 4: Lấy phần tử gốc, nếu không có phần tử gốc thì tạo phần tử gốc
	Bước 5: ....
	 
	