package buisinessLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import dataTransferObject.Loai;
import dataTransferObject.ThuongHieu;

public class ThuongHieuBL {

	public static List<ThuongHieu> docTatCa() {
		List<ThuongHieu> ds1 = new ArrayList<ThuongHieu>();
		String sql = "select * from thuonghieu";
		try {
			Connection kn = CSDL.getKetNoi();
			Statement stm = kn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				ThuongHieu th = new ThuongHieu();
				th.setId(rs.getInt("id"));
				th.setTenTH(rs.getString("tenthuonghieu"));
				th.setHinhAnh(rs.getString("hinhanh"));
				ds1.add(th);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return ds1;
	}

	public static Map<String, Integer> mapThuongHieu() {
		Map<String, Integer> ml = new Hashtable<String, Integer>();
		List<ThuongHieu> ds1 = docTatCa();
		for (ThuongHieu th : ds1) {
			ml.put(th.getTenTH(), th.getId());
		}

		return ml;
	}

	public static void main(String[] args) {

		List<ThuongHieu> list = docTatCa();
		list.forEach(s -> System.out.println(s.getTenTH()));
		Map<String, Integer> ml = mapThuongHieu();
		ml.forEach((k, v) -> System.out.println(k + "-->" + v));


	}
}
