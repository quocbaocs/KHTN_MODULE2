package businessLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dataTransferObject.LienHe;

public class LienHeBL {
	public static int them(LienHe lh) {
		String sql = "insert into lienhe(ho_ten, dien_thoai, hinh_anh) values(?,?,?)";
		int stm =0;
		try (Connection kn = CSDL.getKetNoi()){
			PreparedStatement prstmt = kn.prepareStatement(sql);
			prstmt.setString(1,lh.getHoTen());
			prstmt.setString(2,lh.getDtdd());
			prstmt.setString(3, lh.getHinhAnh());
			stm = prstmt.executeUpdate();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return stm;
	}
}
