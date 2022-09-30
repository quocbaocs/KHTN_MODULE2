package buisinessLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dataTransferObject.DonHang;

public class DonHangBL {
	public static List<DonHang> dsDonHang(String str) throws SQLException, ClassNotFoundException {
		String sql = "select * from donhang " + str;
		List<DonHang> rs;
		try (Connection conn = CSDL.getKetNoi()) {
			rs = new ArrayList<>();
			java.sql.Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				DonHang dh = new DonHang();
				dh.setId(resultSet.getInt("id"));
				dh.setIdKhachHang(resultSet.getInt("id_khachhang"));
				dh.setDiaChiGiaoHang(resultSet.getString("diachigiaohang"));
				dh.setDenThoaiNguoiNhan(resultSet.getString("dienthoainguoinhan"));
				dh.setGhiChu(resultSet.getString("ghichu"));
				dh.setIdTrangThai(resultSet.getInt("id_trangthai"));
				dh.setNgayDatHang(resultSet.getDate("ngaydathang"));
				dh.setTenNguoiNhanNang(resultSet.getString("tennguoinhanhang"));
				dh.setThanhToan(resultSet.getBoolean("thanhtoan"));
				rs.add(dh);
			}
		}
		return rs;
	}

	public static DonHang findDonHangById(int id) throws SQLException, ClassNotFoundException {
		String sql = "select * from donhang where id=" + id;
		DonHang dh = null;
		try (Connection conn = CSDL.getKetNoi()) {
			java.sql.Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				dh = new DonHang();
				dh.setId(resultSet.getInt("id"));
				dh.setIdKhachHang(resultSet.getInt("id_khachhang"));
				dh.setDiaChiGiaoHang(resultSet.getString("diachigiaohang"));
				dh.setDenThoaiNguoiNhan(resultSet.getString("dienthoainguoinhan"));
				dh.setGhiChu(resultSet.getString("ghichu"));
				dh.setIdTrangThai(resultSet.getInt("id_trangthai"));
				dh.setNgayDatHang(resultSet.getDate("ngaydathang"));
				dh.setTenNguoiNhanNang(resultSet.getString("tennguoinhanhang"));
				dh.setThanhToan(resultSet.getBoolean("thanhtoan"));

			}
		}
		return dh;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String str = "Thanh";
		List<DonHang> dsDonHang = DonHangBL.dsDonHang("WHERE tennguoinhanhang like '%" + str + "%'");
		System.out.println(dsDonHang.size());
	}

}
