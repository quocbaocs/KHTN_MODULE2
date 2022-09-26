package buisinessLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dataTransferObject.SanPham;

public class SanPhamBL {
	public static int them(SanPham sp) {
		String sql = "insert into sanpham(tensanpham,mota,hinhanh,dongia,dongiakm,soluong,ngaytao, hienthi,id_loai,id_thuonghieu) values(?,?,?,?,?,?,?,?,?,?)";
		int smt = 0;
		try {
			Connection kn = CSDL.getKetNoi();
			PreparedStatement pst = kn.prepareStatement(sql);
			pst.setString(1, sp.getTenSP());
			pst.setString(2, sp.getMoTa());
			pst.setString(3, sp.getHinhAnh());
			pst.setDouble(4, sp.getDonGia());
			pst.setDouble(5, sp.getDonGiaKM());
			pst.setInt(6, sp.getSoLuong());
			pst.setDate(7, sp.getNgayTao());
			pst.setInt(8, sp.getHienThi());
			pst.setInt(9, sp.getIdLoai());
			pst.setInt(10, sp.getIdThuongHieu());
			smt = pst.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return smt;
	}
	public static void main(String[] args) {
		SanPham sp = new SanPham("aaa", "aaa", "aaa.jpg", 1.0, 0.5, 10, new java.sql.Date((new java.util.Date()).getTime()), 0, 1, 1);
		
		them(sp);
	}

}
