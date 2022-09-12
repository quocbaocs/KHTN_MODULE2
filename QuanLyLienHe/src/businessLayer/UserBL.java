package businessLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dataTransferObject.User;

public class UserBL {
	private static Connection conn =null;
	public static User timUser(String userName, String password) throws SQLException {
		User user = null;
		
		String sql = "SELECT * FROM user where username = ? and password=?";
		try{
			conn = CSDL.getKetNoi();
			PreparedStatement prstmt = conn.prepareStatement(sql);
			prstmt.setString(1, userName);
			prstmt.setString(2, password);
			ResultSet rs = prstmt.executeQuery();
			while(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				
			}
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			CSDL.close(conn);
		}
		return user;
	}
	/*
	 * public static void main(String[] args) throws SQLException { User user =
	 * timUser("phuong","12345"); if(user!=null) {
	 * System.out.println(user.getUserName()); } }
	 */
}
