package presiontationLayer;

import java.awt.EventQueue;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import buisinessLayer.LoaiBL;
import buisinessLayer.ThuongHieuBL;

public class FrmThemSanPham extends JInternalFrame {
	private JTextField txtHinhAnh;
	private JTextField txtDonGia;
	private JTextField txtDonGiaKM;
	private JTextField txtSoLuong;
	private JTextField txtTenSP;
	private JComboBox cbbLoai;
	private JComboBox cbbThuongHieu;
	private Map<String, Integer> mapLoai = LoaiBL.mapLoai();
	private Map<String, Integer> mapThuongHieu = ThuongHieuBL.mapThuongHieu();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmThemSanPham frame = new FrmThemSanPham();
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
	public FrmThemSanPham() {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent e) {
				DefaultComboBoxModel dcmLoai = (DefaultComboBoxModel) cbbLoai.getModel();
				for (String tenLoai : mapLoai.keySet()) {
					dcmLoai.addElement(tenLoai);
				}
				DefaultComboBoxModel dcmThuongHieu = (DefaultComboBoxModel) cbbThuongHieu.getModel();
				for (String tenTH : mapThuongHieu.keySet()) {
					dcmThuongHieu.addElement(tenTH);
				}

			}
		});
		setBounds(100, 100, 450, 478);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Tên sản phẩm");
		lblNewLabel.setBounds(23, 11, 90, 23);
		getContentPane().add(lblNewLabel);

		JLabel lblMT = new JLabel("Mô tả");
		lblMT.setBounds(23, 45, 90, 23);
		getContentPane().add(lblMT);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(98, 45, 241, 112);
		getContentPane().add(scrollPane);

		JTextArea txtaMoTa = new JTextArea();
		scrollPane.setViewportView(txtaMoTa);

		JLabel lblNewLabel_1_1 = new JLabel("HÌnh");
		lblNewLabel_1_1.setBounds(23, 166, 90, 23);
		getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Đơn giá");
		lblNewLabel_1_2.setBounds(23, 206, 90, 23);
		getContentPane().add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_2_1 = new JLabel("Đơn giá KM");
		lblNewLabel_1_2_1.setBounds(23, 243, 90, 23);
		getContentPane().add(lblNewLabel_1_2_1);

		JLabel lblNewLabel_1_2_2 = new JLabel("Số lượng");
		lblNewLabel_1_2_2.setBounds(23, 284, 90, 23);
		getContentPane().add(lblNewLabel_1_2_2);

		JLabel lblNewLabel_1_2_3 = new JLabel("Loại");
		lblNewLabel_1_2_3.setBounds(23, 318, 90, 23);
		getContentPane().add(lblNewLabel_1_2_3);

		cbbLoai = new JComboBox();
		cbbLoai.setBounds(98, 318, 103, 22);
		getContentPane().add(cbbLoai);

		cbbThuongHieu = new JComboBox();
		cbbThuongHieu.setBounds(98, 352, 103, 22);
		getContentPane().add(cbbThuongHieu);

		JLabel lblNewLabel_1_2_3_1 = new JLabel("Thương Hiệu");
		lblNewLabel_1_2_3_1.setBounds(23, 352, 90, 23);
		getContentPane().add(lblNewLabel_1_2_3_1);

		JButton btnThem = new JButton("Thêm");
		btnThem.setBounds(78, 398, 89, 23);
		getContentPane().add(btnThem);

		JButton btnTiepTuc = new JButton("Tiếp tục");
		btnTiepTuc.setBounds(243, 398, 89, 23);
		getContentPane().add(btnTiepTuc);

		txtHinhAnh = new JTextField();
		txtHinhAnh.setBounds(98, 168, 216, 20);
		getContentPane().add(txtHinhAnh);
		txtHinhAnh.setColumns(10);

		txtDonGia = new JTextField();
		txtDonGia.setColumns(10);
		txtDonGia.setBounds(98, 200, 108, 20);
		getContentPane().add(txtDonGia);

		txtDonGiaKM = new JTextField();
		txtDonGiaKM.setColumns(10);
		txtDonGiaKM.setBounds(98, 240, 103, 20);
		getContentPane().add(txtDonGiaKM);

		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(98, 285, 103, 20);
		getContentPane().add(txtSoLuong);

		txtTenSP = new JTextField();
		txtTenSP.setColumns(10);
		txtTenSP.setBounds(98, 12, 216, 20);
		getContentPane().add(txtTenSP);

		JButton btnHinhAnh = new JButton("New button");
		btnHinhAnh.setBounds(324, 168, 26, 23);
		getContentPane().add(btnHinhAnh);

	}
}
