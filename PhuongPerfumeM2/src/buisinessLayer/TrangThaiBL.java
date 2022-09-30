package buisinessLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import dataTransferObject.TrangThai;

public class TrangThaiBL {

	public static List<TrangThai> dsTrangThai() {
		List<TrangThai> ds1 = new ArrayList<TrangThai>();
		String sql = "select * from trangthaidonhang";
		try {
			Connection kn = CSDL.getKetNoi();
			Statement stm = kn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				TrangThai tt = new TrangThai();
				tt.setId(rs.getInt("id"));
				tt.setTenTrangThai(rs.getString("tentrangthai"));
				ds1.add(tt);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return ds1;
	}

	public static Map<String, Integer> mapTrangThai() {
		Map<String, Integer> ml = new Hashtable<String, Integer>();
		List<TrangThai> ds1 = dsTrangThai();
		for (TrangThai tt : ds1) {
			ml.put(tt.getTenTrangThai(), tt.getId());
		}

		return ml;
	}

	public static void main(String[] args) {
		List<TrangThai> list = dsTrangThai();
		list.forEach(s -> System.out.println(s.toString()));
	}
}
