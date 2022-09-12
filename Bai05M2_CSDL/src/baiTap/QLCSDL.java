package baiTap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QLCSDL {
	Connection conn;
	Statement stmt;
	PreparedStatement prstmt;
	ResultSet rs;

	public List<Sach> dsSach(String tenSach) {
		List<Sach> list;

		list = new ArrayList<Sach>();
		try {

			String sql = "SELECT * FROM Sach WHERE tensach LIKE '%" + tenSach + "%'";
			Connection conn = this.connect();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Sach s = new Sach();
				s.setTenSach(rs.getString("tensach"));
				s.setTacGia(rs.getString("tacgia"));
				s.setNXB(rs.getString("nxb"));
				s.setGiaBia(rs.getDouble("giabia"));
				list.add(s);
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			this.close(conn, stmt, rs);
		}
		return null;
	}
	public List<Sach> dsSach() {
		List<Sach> list;

		list = new ArrayList<Sach>();
		try {

			String sql = "SELECT * FROM Sach";
			Connection conn = this.connect();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Sach s = new Sach();
				s.setTenSach(rs.getString("tensach"));
				s.setTacGia(rs.getString("tacgia"));
				s.setNXB(rs.getString("nxb"));
				s.setGiaBia(rs.getDouble("giabia"));
				list.add(s);
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			this.close(conn, stmt, rs);
		}
		return null;
	}


	public boolean xoaSach(String tenSach) {
		String sql = "DELETE FROM sach WHERE tensach=?";
		
		try {
			conn = this.connect();
			prstmt = conn.prepareStatement(sql);
			prstmt.setString(1,tenSach);
			int result = prstmt.executeUpdate();
			if (result>0) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			this.close(conn, prstmt);
		}
		return false;

	}
	
	public void capNhatSach(Sach s) {
		String sql = "UPDATE sach SET tacgia=?,nxb=?, giabia=? WHERE tensach=?";
		try {
			conn = this.connect();
			prstmt = conn.prepareStatement(sql);
			prstmt.setString(1, s.getTacGia());
			prstmt.setString(2, s.getNXB());
			prstmt.setDouble(3, s.getGiaBia());
			prstmt.setString(4, s.getTenSach());
			prstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			this.close(conn, prstmt);
		}
	}

	public Connection connect() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/dlsachdb?useUsenicode=true&characterEncoding=UTF-8";
		String user = "root";
		String password = "quocbao@123";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void close(Connection conn, Statement stmt, ResultSet rs) {

		try {
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void close(Connection conn, PreparedStatement stmt, ResultSet rs) {

		try {
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void close(Connection conn, PreparedStatement stmt) {

		try {
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
