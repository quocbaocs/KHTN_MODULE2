package businessLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dataTransferObject.Sach;

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
			Connection conn = CSDL.connect();
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
			CSDL.close(stmt, rs);
		}
		return null;
	}

	public List<Sach> dsSach() {
		List<Sach> list;

		list = new ArrayList<Sach>();
		try {

			String sql = "SELECT * FROM Sach";
			Connection conn = CSDL.connect();
			stmt = conn.createStatement();
			if(conn!=null) {
				System.out.println("connected!");
			}

			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Sach s = new Sach();
				s.setTenSach(rs.getString("tensach"));
				s.setTacGia(rs.getString("tacgia"));
				s.setNXB(rs.getString("nxb"));
				s.setGiaBia(rs.getDouble("giabia"));
				list.add(s);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			CSDL.close(stmt, rs);
		}
		return list;
	}

	public boolean xoaSach(String tenSach) {
		String sql = "DELETE FROM sach WHERE tensach=?";

		try {
			conn = CSDL.connect();
			prstmt = conn.prepareStatement(sql);
			prstmt.setString(1, tenSach);
			int result = prstmt.executeUpdate();
			if (result > 0) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			CSDL.close(conn, prstmt);
		}
		return false;

	}

	public void capNhatSach(Sach s) {
		String sql = "UPDATE sach SET tacgia=?,nxb=?, giabia=? WHERE tensach=?";
		try {
			conn = CSDL.connect();
			prstmt = conn.prepareStatement(sql);
			prstmt.setString(1, s.getTacGia());
			prstmt.setString(2, s.getNXB());
			prstmt.setDouble(3, s.getGiaBia());
			prstmt.setString(4, s.getTenSach());
			prstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			CSDL.close(conn, prstmt);
		}
	}

}
