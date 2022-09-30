package presiontationLayer;

import java.awt.Button;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import buisinessLayer.CTDHBL;
import buisinessLayer.DonHangBL;
import buisinessLayer.TrangThaiBL;
import dataTransferObject.ChiTietDonHang;
import dataTransferObject.DonHang;

public class FrmQuanLyDonHang extends JInternalFrame {
	private JTextField txtNgayDat;
	private JTextField txtTenKH;
	private JTable tblDonHang;
	private JTextField txtMa;
	private JTextField txtNgay;
	private JTextField txtTenCTKH;
	private JTextField txtTen;
	private JTextField txtDiaChi;
	private JTextField txtDienThoai;
	private JTable tblChiTietDH;
	private List<DonHang> dsDH;
	DefaultTableModel model1;
	DefaultTableModel modelCtdh;
	private DonHang dh;
	private JComboBox cbbTrangThai;
	private Map<String, Integer> mapTrangThai = TrangThaiBL.mapTrangThai();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmQuanLyDonHang frame = new FrmQuanLyDonHang();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmQuanLyDonHang() {
		setBounds(100, 100, 746, 658);
		getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 12, 705, 602);
		getContentPane().add(tabbedPane);

		JPanel panelTimKiem = new JPanel();
		tabbedPane.addTab("Tìm kiếm đơn hàng", null, panelTimKiem, null);
		panelTimKiem.setLayout(null);

		JLabel lblNewLabel = new JLabel("Tìm kiếm theo");
		lblNewLabel.setBounds(28, 36, 120, 15);
		panelTimKiem.add(lblNewLabel);

		JLabel lblTnKhchHng = new JLabel("Tên khách hàng");
		lblTnKhchHng.setBounds(28, 79, 120, 15);
		panelTimKiem.add(lblTnKhchHng);

		JLabel lblNgytHng = new JLabel("Ngày đặt hàng");
		lblNgytHng.setBounds(28, 120, 120, 15);

		panelTimKiem.add(lblNgytHng);

		JLabel lblTrngThin = new JLabel("Trạng thái đơn hàng");
		lblTrngThin.setBounds(28, 162, 143, 15);
		panelTimKiem.add(lblTrngThin);

		JComboBox comboBox = new JComboBox();
		DefaultComboBoxModel modelTrangThai = (DefaultComboBoxModel) comboBox.getModel();
		mapTrangThai.forEach((k, v) -> {
			modelTrangThai.addElement(k.toString());
		});
		comboBox.setModel(modelTrangThai);
//		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Nhận đơn hàng", "Đang giao hàng", "Đã nhận hàng" }));
		comboBox.setBounds(203, 157, 149, 24);
		panelTimKiem.add(comboBox);

		txtNgayDat = new JTextField();
		txtNgayDat.setBounds(203, 113, 149, 24);
		panelTimKiem.add(txtNgayDat);
		txtNgayDat.setColumns(10);

		txtTenKH = new JTextField();
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(203, 77, 149, 24);
		panelTimKiem.add(txtTenKH);

		JComboBox cbbTim = new JComboBox();
		cbbTim.setModel(
				new DefaultComboBoxModel(new String[] { "Tên khách hàng", "Ngày đặt hàng", "Trạng thái đơn hàng" }));
		cbbTim.setBounds(203, 31, 149, 24);
		cbbTim.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(cbbTim.getSelectedIndex()==0) {
					cbbTrangThai.setEditable(false);
				}
				
			}
		});
		panelTimKiem.add(cbbTim);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 217, 660, 164);
		panelTimKiem.add(scrollPane);

		tblDonHang = new JTable();
		tblDonHang.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Ma DH", "Ten khach h", "Ngay d", "T\u00ECnh tr", "Thanh t" }));
		scrollPane.setViewportView(tblDonHang);

		JButton btnTim = new JButton("Tìm");
		model1 = (DefaultTableModel) tblDonHang.getModel();
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (cbbTim.getSelectedIndex() == 0) {
					try {
						while (model1.getRowCount() > 0) {
							model1.removeRow(0);
						}
						dsDH = DonHangBL.dsDonHang("WHERE tennguoinhanhang like '%" + txtTenKH.getText() + "%'");

						dsDH.forEach(s -> {
							String tt = "";
							if (s.getIdTrangThai() == 1) {
								tt = "Đã nhận hàng";
							} else if (s.getIdTrangThai() == 2) {
								tt = "Đang giao hàng";
							} else {
								tt = "Đã thanh toán";
							}
							String isPay = s.getThanhToan() ? "X" : "";
							model1.addRow(new String[] { String.valueOf(s.getId()), s.getTenNguoiNhanNang(),
									s.getNgayDatHang().toString(), tt, isPay });
						});

					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});
		btnTim.setBounds(407, 31, 117, 25);
		panelTimKiem.add(btnTim);

		Button btnXemChiTiet = new Button("Xem chi tiết đơn hàng chọn");

		JPanel panelChitiet = new JPanel();
		tabbedPane.addTab("Chi tiết đơn hàng", null, panelChitiet, null);
		panelChitiet.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Mã đơn hàng");
		lblNewLabel_1.setBounds(26, 33, 133, 15);
		panelChitiet.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Ngày đặt hàng");
		lblNewLabel_1_1.setBounds(346, 33, 133, 15);
		panelChitiet.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Tên khách hàng");
		lblNewLabel_1_2.setBounds(26, 82, 133, 15);
		panelChitiet.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Thông tin giao hàng");
		lblNewLabel_1_3.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_1_3.setBounds(26, 131, 179, 15);
		panelChitiet.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("Tình hình đơn hàng");
		lblNewLabel_1_4.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_1_4.setBounds(346, 131, 169, 15);
		panelChitiet.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_3_1 = new JLabel("Tên");
		lblNewLabel_1_3_1.setBounds(26, 183, 133, 15);
		panelChitiet.add(lblNewLabel_1_3_1);

		JLabel lblNewLabel_1_3_2 = new JLabel("Trạng thái");
		lblNewLabel_1_3_2.setBounds(346, 183, 133, 15);
		panelChitiet.add(lblNewLabel_1_3_2);

		JLabel lblNewLabel_1_3_3 = new JLabel("Địa chỉ");
		lblNewLabel_1_3_3.setBounds(26, 232, 133, 15);
		panelChitiet.add(lblNewLabel_1_3_3);

		JLabel lblNewLabel_1_3_4 = new JLabel("Điện thoại");
		lblNewLabel_1_3_4.setBounds(26, 276, 133, 15);
		panelChitiet.add(lblNewLabel_1_3_4);

		cbbTrangThai = new JComboBox();
		cbbTrangThai.setBounds(465, 178, 151, 24);
		panelChitiet.add(cbbTrangThai);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Đã thanh toán");
		rdbtnNewRadioButton.setBounds(346, 228, 149, 23);
		panelChitiet.add(rdbtnNewRadioButton);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 375, 676, 131);
		panelChitiet.add(scrollPane_1);

		tblChiTietDH = new JTable();
		tblChiTietDH
				.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "T\u00EAn s\u1EA3n ph\u1EA9m",
						"S\u1ED1 l\u01B0\u1EE3ng", "\u0110\u01A1n gi\u00E1", "Th\u00E0nh ti\u1EC1n" }));

		scrollPane_1.setViewportView(tblChiTietDH);

		// ---------------------------------------
		modelCtdh = (DefaultTableModel) tblChiTietDH.getModel();

		btnXemChiTiet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
				while (modelCtdh.getRowCount() > 0) {
					modelCtdh.removeRow(0);
				}
				int id = Integer.parseInt((String) model1.getValueAt(tblDonHang.getSelectedRow(), 0));
				try {
					dh = DonHangBL.findDonHangById(id);
					txtTen.setText(dh.getTenNguoiNhanNang());
					txtNgay.setText(dh.getNgayDatHang().toString());
					txtDiaChi.setText(dh.getDiaChiGiaoHang());
					txtDienThoai.setText(dh.getDenThoaiNguoiNhan());
					txtTenCTKH.setText(dh.getTenNguoiNhanNang());
					txtMa.setText(String.valueOf(dh.getId()));
					DefaultComboBoxModel<String> cbbTT = (DefaultComboBoxModel<String>) cbbTrangThai.getModel();
					if (dh.getIdTrangThai() == 1) {
						cbbTT.addElement("Đã nhận hàng");
					} else if (dh.getIdTrangThai() == 2) {
						cbbTT.addElement("Đang giao hàng");
					} else if (dh.getIdTrangThai() == 3) {
						cbbTT.addElement("Đã giao hàng");
					} else {
						cbbTT.addElement("Hủy đơn hang");
					}
					List<ChiTietDonHang> list = CTDHBL.dsCTDH_IDDH(id);
					list.forEach(s -> {
						modelCtdh.addRow(new String[] { String.valueOf(s.getId()), s.getTenSanPham(),
								String.valueOf(s.getSoLuong()), String.valueOf(s.getDonGia()),
								String.valueOf(s.thanhTien()) });
					});
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnXemChiTiet.setBounds(10, 406, 223, 23);
		panelTimKiem.add(btnXemChiTiet);

		// ---------------------------

		JButton btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnCapNhat.setBounds(122, 314, 117, 25);
		panelChitiet.add(btnCapNhat);

		JSeparator separator = new JSeparator();
		separator.setBounds(12, 358, 676, 2);
		panelChitiet.add(separator);

		JButton btnXoaCTDH = new JButton("Xóa chi tiết đơn hàng đang chọn");
		btnXoaCTDH.setBounds(12, 538, 271, 25);
		btnXoaCTDH.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int rowNum = tblDonHang.getSelectedRow();
				int idx = Integer.parseInt((String) model1.getValueAt(tblChiTietDH.getSelectedRow(), 0));
				System.out.println(idx);
				CTDHBL.xoaCTDH(idx);
				modelCtdh.removeRow(rowNum);

			}
		});
		panelChitiet.add(btnXoaCTDH);

		txtMa = new JTextField();
		txtMa.setBounds(158, 29, 81, 24);
		panelChitiet.add(txtMa);
		txtMa.setColumns(10);

		txtNgay = new JTextField();
		txtNgay.setColumns(10);
		txtNgay.setBounds(469, 31, 159, 24);
		panelChitiet.add(txtNgay);

		txtTenCTKH = new JTextField();
		txtTenCTKH.setColumns(10);
		txtTenCTKH.setBounds(158, 78, 458, 24);
		panelChitiet.add(txtTenCTKH);

		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBounds(158, 181, 169, 24);
		panelChitiet.add(txtTen);

		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(158, 230, 169, 24);
		panelChitiet.add(txtDiaChi);

		txtDienThoai = new JTextField();
		txtDienThoai.setColumns(10);
		txtDienThoai.setBounds(158, 272, 169, 24);
		panelChitiet.add(txtDienThoai);

	}
}
