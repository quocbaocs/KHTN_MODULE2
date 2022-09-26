package buisinessLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import dataTransferObject.Loai;

public class LoaiBL {

	public static List<Loai> docTatCa() {
		List<Loai> ds1 = new ArrayList<Loai>();
		String sql = "select * from loai";
		try {
			Connection kn = CSDL.getKetNoi();
			Statement stm = kn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Loai loai = new Loai();
				loai.setId(rs.getInt("id"));
				loai.setTenLoai(rs.getString("tenloai"));
				ds1.add(loai);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return ds1;
	}

	public static Map<String, Integer> mapLoai() {
		Map<String, Integer> ml = new Hashtable<String, Integer>();
		List<Loai> ds1 = docTatCa();
		for (Loai l : ds1) {
			ml.put(l.getTenLoai(), l.getId());
		}

		return ml;
	}

	public static void main(String[] args) {
//		List<Loai> ds = docTatCa();
//		ds.forEach(s -> System.out.println(s.getTenLoai()));

		Map<String, Integer> ml = mapLoai();
		ml.forEach((k, v) -> System.out.println(k + "-->" + v));

	}

}
