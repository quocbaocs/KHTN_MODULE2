package thucHanh;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QuiTrinhKetNoi {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//buoc 1: nap trinh dieu khien
		Class.forName("com.mysql.jdbc.Driver");

		//buoc 2: tao chuoi ket noi
		String url = "jdbc:mysql://localhost:3306/qlsv?useUnicode=true&characterEncoding=UTF-8";
		
		//buoc 3: tao ket noi
		Connection ketNoi = DriverManager.getConnection(url, "root", "");
	
		//buoc 4: tao phat bieu
		Statement stm = ketNoi.createStatement();
		
		//buoc 5: thuc hien cau truy van
		String sql = "select * from sinhvien";
		ResultSet rs = stm.executeQuery(sql);
		
		//buoc 6: xu ly ket qua
		String masv, hosv, tensv, makh;
		boolean phai;
		Date ngaySinh;
		int hocBong;
		
		while(rs.next()) {
			masv = rs.getString("masv");
			hosv = rs.getString("hosv");
			tensv = rs.getString("tensv");
			phai = rs.getBoolean("phai");
			ngaySinh = rs.getDate("ngaysinh");
			makh = rs.getString("makh");
			hocBong = rs.getInt("hocbong");
			
			System.out.println(String.format("%s - %s - %s - %s - %s - %s - %d", masv,hosv,tensv,ngaySinh,phai,makh,hocBong));
		}
		//buoc 7: dong ket noi
		ketNoi.close();
		
	}

}
