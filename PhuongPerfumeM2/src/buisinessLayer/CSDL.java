package buisinessLayer;

import java.sql.Connection;
import java.sql.DriverManager;

public class CSDL {
	private static Connection ketNoi;
	private static String url = "jdbc:mysql://localhost:3306/phuong_perfume?useSSL=true";
	private static String user = "root";
	private static String password = "";

	public static Connection getKetNoi() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			ketNoi = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return ketNoi;
	}

}
