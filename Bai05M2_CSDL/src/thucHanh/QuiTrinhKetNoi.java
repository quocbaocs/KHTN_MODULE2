package thucHanh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class QuiTrinhKetNoi {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Bước 1: nạp trình điều khiển
		Class.forName("com.mysql.jdbc.Driver");

		// Bước 2: tạo chuỗi kết nôi
		String url = "jdbc:mysql://localhost:3306/qlsv?useUsenicode=true&characterEncoding=UTF-8";

		// Bước 3: Tạo kết nối
		Connection ketNoi = DriverManager.getConnection(url, "root", "");
		
		// Bước 4: Tạo phát biểu
		Statement stm = ketNoi.createStatement();

		// Bước 5: thực hiện câu truy vấn
		String sql = "select * from sinhvien";
		ResultSet rs = stm.executeQuery(sql);

		// Bước 6: xử lí kết quả
		String masv, tensv, hosv, makh;
		boolean phai;
		Date ngaySinh;
		int hocBong;

		while (rs.next()) {
			masv = rs.getString("masv");
			hosv = rs.getString("hosv");
			tensv = rs.getString("tensv");
			ngaySinh = rs.getDate("ngaysinh");
			phai = rs.getBoolean("phai");
			makh = rs.getString("makh");
			hocBong = rs.getInt("hocbong");

			System.out.println(
					String.format("%s - %s - %s - %s - %s - %s -%d", masv, hosv, tensv, ngaySinh, phai, makh, hocBong));
		}

	}
}
