package baiTap;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FrmKTTenTapTin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtBieuThuc;
	private JTextField txtTenTapTin;
	private JTextField txtKetQua;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmKTTenTapTin frame = new FrmKTTenTapTin();
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
	public FrmKTTenTapTin() {
		setTitle("Kiem tra dinh dang file");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(12, 0, 574, 263);
		contentPane.add(contentPane_1);

		JLabel lblMunhDng = new JLabel("Mẫu định dạng Image File");
		lblMunhDng.setBounds(10, 27, 181, 24);
		contentPane_1.add(lblMunhDng);

		JLabel lblImageFileKie = new JLabel("Image File Kiểm tra");
		lblImageFileKie.setBounds(10, 73, 181, 24);
		contentPane_1.add(lblImageFileKie);

		txtBieuThuc = new JTextField();
		txtBieuThuc.setEditable(false);
		txtBieuThuc.setColumns(10);
		txtBieuThuc.setText("([^\\s]+(\\.(?i)(jpe?g|png|gif|bmp))$) ");
		JButton btnKiemTra = new JButton("Kiểm tra");
		btnKiemTra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String regrex = "[^\\s]+(\\.(?i)(jpe?g|png|gif|bmp))$";
				String str = txtTenTapTin.getText();
				txtKetQua.setText(KiemTra(regrex, str));
			}

		});
		btnKiemTra.setBounds(187, 125, 127, 23);
		contentPane_1.add(btnKiemTra);

		txtBieuThuc.setBounds(231, 28, 265, 24);
		contentPane_1.add(txtBieuThuc);

		txtTenTapTin = new JTextField();
		txtTenTapTin.setColumns(10);
		txtTenTapTin.setBounds(231, 72, 265, 25);
		contentPane_1.add(txtTenTapTin);

		txtKetQua = new JTextField();
		txtKetQua.setEditable(false);
		txtKetQua.setColumns(10);
		txtKetQua.setBounds(231, 181, 265, 20);
		contentPane_1.add(txtKetQua);

		JLabel lblKtQua = new JLabel("Kết quả");
		lblKtQua.setBounds(64, 178, 127, 24);
		contentPane_1.add(lblKtQua);
	}

	private String KiemTra(String regrex, String str) {
		Pattern pattern = Pattern.compile(regrex);
		Matcher matcher = pattern.matcher(str);
		try {
			if (matcher.matches()) {
				return "Tên tập tin hình hợp lệ";
			} else {
				return "Tên tập tin hình không hợp lệ";
			}
		} catch (PatternSyntaxException e) {
			return "Error name";
		}
	}
}
