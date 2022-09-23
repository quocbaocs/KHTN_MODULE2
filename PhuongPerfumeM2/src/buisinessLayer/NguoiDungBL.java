package buisinessLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dataTransferObject.NguoiDung;

public class NguoiDungBL {

	// TODO Auto-generated constructor stub

	public static NguoiDung timEmailPassword(String email, String password) {
		NguoiDung nd = null;
		String sql = "select * from nguoidung where email='" + email + "' and password='" + password + "'";
		try {
			Connection kn = CSDL.getKetNoi();
			Statement stm = kn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if (rs.next()) {
				nd = new NguoiDung();
				nd.setId(rs.getInt("id"));
				nd.setEmail(rs.getString("email"));
				nd.setPassword(rs.getString("password"));
				nd.setHoTen(rs.getString("hoten"));
				nd.setDiaChi(rs.getString("diachi"));
				nd.setDtdd(rs.getString("dtdd"));
				nd.setIdVaiTro(rs.getInt("id_vaitro"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return nd;

	}

	public static void main(String[] args) {
		NguoiDung nd = timEmailPassword(null, null);
		if (nd != null) {
			System.out.println("Có " + nd.getHoTen());
		} else {
			System.out.println("Khong tim thay");
		}

	}

}
