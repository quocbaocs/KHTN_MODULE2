package businessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CSDL {
	private static Connection ketNoi;

	private static String url = "jdbc:mysql://localhost:3306/qllienhe";

	public static Connection getKetNoi() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			ketNoi = DriverManager.getConnection(url, "root", "");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketNoi;
	}

	public static void close(Connection conn) throws SQLException {
		conn.close();
		
	}
}
