package thucHanh;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class FrmKiemRegrex extends JFrame {

	private JPanel contentPane;
	private JTextField txtBieuThuc;
	private JTextField txtThongTinNhap;
	private JTextField txtKetQua;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmKiemRegrex frame = new FrmKiemRegrex();
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
	public FrmKiemRegrex() {
		setTitle("Kiểm tra biểu thức chính quy");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Biểu thức");
		lblNewLabel.setBounds(45, 55, 98, 25);
		contentPane.add(lblNewLabel);

		JLabel lblThngTinNhp = new JLabel("Thông tin nhập");
		lblThngTinNhp.setBounds(45, 91, 98, 25);
		contentPane.add(lblThngTinNhp);

		JLabel lblKtQu = new JLabel("Kết quả");
		lblKtQu.setBounds(45, 127, 98, 25);
		contentPane.add(lblKtQu);

		txtBieuThuc = new JTextField();
		txtBieuThuc.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtBieuThuc.setForeground(Color.BLUE);
		txtBieuThuc.setBounds(153, 55, 197, 25);
		contentPane.add(txtBieuThuc);
		txtBieuThuc.setColumns(10);

		txtThongTinNhap = new JTextField();
		txtThongTinNhap.setColumns(10);
		txtThongTinNhap.setBounds(153, 93, 197, 25);
		contentPane.add(txtThongTinNhap);

		txtKetQua = new JTextField();
		txtKetQua.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtKetQua.setForeground(Color.MAGENTA);
		txtKetQua.setColumns(10);
		txtKetQua.setBounds(153, 129, 197, 25);
		contentPane.add(txtKetQua);

		JButton btnKiemTra = new JButton("Kiểm tra");
		btnKiemTra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s1 = txtBieuThuc.getText();
				String s2 = txtThongTinNhap.getText();
				txtKetQua.setText(KiemTra(s1, s2));
			}
		});
		btnKiemTra.setBounds(158, 181, 98, 33);
		contentPane.add(btnKiemTra);
	}

	public String KiemTra(String s1, String s2) {
		try {
			Pattern pt = Pattern.compile(s1);
			Matcher mcMatcher = pt.matcher(s2);
			if (mcMatcher.matches()) {
				return "Hop mau";
			} else {
				return "Khong hop mau";
			}
		} catch (PatternSyntaxException e) {

			return "Bi loi: ";
		}
	}
}
