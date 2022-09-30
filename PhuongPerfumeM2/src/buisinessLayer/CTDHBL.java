package buisinessLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dataTransferObject.ChiTietDonHang;

public class CTDHBL {

	public static List<ChiTietDonHang> dsCTDH_IDDH(int id) {

		String sql = "select ctdh.id, sp.tensanpham, sp.dongia, ctdh.soluong from chitietdonhang as ctdh inner join sanpham as sp on ctdh.id_sanpham=sp.id where id_donhang="
				+ id;
		List<ChiTietDonHang> rs = null;
		try (Connection conn = CSDL.getKetNoi()) {
			rs = new ArrayList<>();
			java.sql.Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				ChiTietDonHang ctdh = new ChiTietDonHang();
				ctdh.setId(resultSet.getInt("id"));
				ctdh.setTenSanPham(resultSet.getString("tensanpham"));
				ctdh.setDonGia(resultSet.getDouble("dongia"));
				ctdh.setSoLuong(resultSet.getInt("soluong"));
				rs.add(ctdh);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;

	}

	public static void xoaCTDH(int id) {
		try (Connection conn = CSDL.getKetNoi()) {
			String sql = "DELETE FROM chitietdonhang WHERE id = " + id;
			Statement statement = conn.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		List<ChiTietDonHang> list = dsCTDH_IDDH(14);
		list.forEach(s -> System.out.println(s.toString()));
	}

}
