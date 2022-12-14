package presiontationLayer;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.filechooser.FileNameExtensionFilter;

import buisinessLayer.LoaiBL;
import buisinessLayer.SanPhamBL;
import buisinessLayer.ThuongHieuBL;
import dataTransferObject.SanPham;

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
	private JLabel lblHinhAnh;

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

		JLabel lblNewLabel = new JLabel("T??n s???n ph???m");
		lblNewLabel.setBounds(23, 11, 118, 23);
		getContentPane().add(lblNewLabel);

		JLabel lblMT = new JLabel("M?? t???");
		lblMT.setBounds(23, 45, 90, 23);
		getContentPane().add(lblMT);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(131, 45, 216, 112);
		getContentPane().add(scrollPane);

		JTextArea txtaMoTa = new JTextArea();
		scrollPane.setViewportView(txtaMoTa);

		JLabel lblNewLabel_1_1 = new JLabel("H??nh");
		lblNewLabel_1_1.setBounds(23, 166, 90, 23);
		getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("????n gi??");
		lblNewLabel_1_2.setBounds(23, 208, 106, 23);
		getContentPane().add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_2_1 = new JLabel("????n gi?? KM");
		lblNewLabel_1_2_1.setBounds(23, 243, 90, 23);
		getContentPane().add(lblNewLabel_1_2_1);

		JLabel lblNewLabel_1_2_2 = new JLabel("S??? l?????ng");
		lblNewLabel_1_2_2.setBounds(23, 283, 106, 23);
		getContentPane().add(lblNewLabel_1_2_2);

		JLabel lblNewLabel_1_2_3 = new JLabel("Lo???i");
		lblNewLabel_1_2_3.setBounds(23, 318, 90, 23);
		getContentPane().add(lblNewLabel_1_2_3);

		cbbLoai = new JComboBox();
		cbbLoai.setBounds(131, 318, 118, 22);
		getContentPane().add(cbbLoai);

		cbbThuongHieu = new JComboBox();
		cbbThuongHieu.setBounds(131, 352, 118, 22);
		getContentPane().add(cbbThuongHieu);

		JLabel lblNewLabel_1_2_3_1 = new JLabel("Th????ng Hi???u");
		lblNewLabel_1_2_3_1.setBounds(23, 352, 90, 23);
		getContentPane().add(lblNewLabel_1_2_3_1);

		JButton btnThem = new JButton("Th??m");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tenSP, moTa, hinhAnh;
				int idLoai, idThuongHieu, soLuong, hienThi;
				double donGia, donGiaKM;
				Date ngayTao;
				tenSP = txtTenSP.getText();
				moTa = txtaMoTa.getText();
//				Path path = Paths.get(txtHinhAnh.getText());
//				hinhAnh = path.getFileName().toString();
				hinhAnh = txtHinhAnh.getText();
				idLoai = mapLoai.get(cbbLoai.getSelectedItem().toString());
				idThuongHieu = mapThuongHieu.get(cbbThuongHieu.getSelectedItem().toString());
				soLuong = Integer.parseInt(txtSoLuong.getText());
				hienThi = 1;// Gi?? tr??? c??n ???????c hi???n th??? s??? d???ng
				donGia = Double.parseDouble(txtDonGia.getText());
				donGiaKM = Double.parseDouble(txtDonGiaKM.getText());
				ngayTao = new java.sql.Date((new java.util.Date()).getTime());// Ng??y t???o l???y ng??y hi???n t???i c???a h??? th???ng
				SanPham sp = new SanPham(tenSP, moTa, hinhAnh, donGia, donGiaKM, soLuong, ngayTao, hienThi, idLoai,
						idThuongHieu);
				int smt = SanPhamBL.them(sp);
				if (smt > 0) {
					JOptionPane.showMessageDialog(rootPane, "???? th??m s???n ph???m th??nh c??ng");
				} else {
					JOptionPane.showMessageDialog(rootPane, "Kh??ng th??m ???????c s???n ph???m");
				}

			}
		});
		btnThem.setBounds(78, 398, 89, 23);
		getContentPane().add(btnThem);

		JButton btnTiepTuc = new JButton("Ti???p t???c");
		btnTiepTuc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTiepTuc.setBounds(243, 398, 104, 23);
		getContentPane().add(btnTiepTuc);

		txtHinhAnh = new JTextField();
		txtHinhAnh.setBounds(131, 168, 183, 20);
		getContentPane().add(txtHinhAnh);
		txtHinhAnh.setColumns(10);

		txtDonGia = new JTextField();
		txtDonGia.setColumns(10);
		txtDonGia.setBounds(131, 210, 118, 20);
		getContentPane().add(txtDonGia);

		txtDonGiaKM = new JTextField();
		txtDonGiaKM.setColumns(10);
		txtDonGiaKM.setBounds(131, 245, 118, 21);
		getContentPane().add(txtDonGiaKM);

		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(131, 286, 118, 20);
		getContentPane().add(txtSoLuong);

		txtTenSP = new JTextField();
		txtTenSP.setColumns(10);
		txtTenSP.setBounds(131, 13, 216, 20);
		getContentPane().add(txtTenSP);

		JButton btnChon = new JButton("New button");
		btnChon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser openFile = new JFileChooser("src/images/");
				openFile.setDialogTitle("M??? m???t t???p tin h??nh ???nh");
				openFile.setFileFilter(new FileNameExtensionFilter("C??c t???p tin *.jpg", "jpg"));
				openFile.setFileFilter(new FileNameExtensionFilter("C??c t???p tin *.png", "png"));
				int chon = openFile.showOpenDialog(rootPane);
				if (chon == JFileChooser.APPROVE_OPTION) {
					File file = openFile.getSelectedFile();
					String filepath = file.getAbsolutePath();
					System.out.println(filepath);

					ImageIcon icon = new ImageIcon(filepath);
					txtHinhAnh.setText(file.getName());
					icon.setImage(icon.getImage().getScaledInstance(lblHinhAnh.getWidth(), lblHinhAnh.getHeight(),
							Image.SCALE_SMOOTH));
					lblHinhAnh.setIcon(icon);
				}
			}
		});
		btnChon.setBounds(324, 168, 26, 23);
		getContentPane().add(btnChon);

		lblHinhAnh = new JLabel("");
		lblHinhAnh.setBounds(272, 210, 156, 164);
		getContentPane().add(lblHinhAnh);

	}
}
