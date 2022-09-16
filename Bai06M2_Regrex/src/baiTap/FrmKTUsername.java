package baiTap;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class FrmKTUsername extends JFrame {

	private JPanel contentPane;
	private JTextField txtMauDinhDang;
	private JTextField txtUserName;
	private JTextField txtKetQua;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmKTUsername frame = new FrmKTUsername();
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
	public FrmKTUsername() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Mẫu định dạng Username");
		lblNewLabel.setBounds(10, 27, 127, 24);
		contentPane.add(lblNewLabel);

		JLabel lblUsernameKimTra = new JLabel("Username kiểm tra");
		lblUsernameKimTra.setBounds(10, 73, 127, 24);
		contentPane.add(lblUsernameKimTra);

		JButton btnKiemTra = new JButton("Kiểm tra");
		btnKiemTra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String reprex = txtMauDinhDang.getText();
				String username = txtUserName.getText();
				txtKetQua.setText(KiemTra(reprex, username));
			}
		});
		btnKiemTra.setBounds(187, 125, 89, 23);
		contentPane.add(btnKiemTra);

		txtMauDinhDang = new JTextField();
		txtMauDinhDang.setBounds(186, 29, 265, 20);
		contentPane.add(txtMauDinhDang);
		txtMauDinhDang.setColumns(10);

		txtUserName = new JTextField();
		txtUserName.setColumns(10);
		txtUserName.setBounds(186, 75, 265, 20);
		contentPane.add(txtUserName);

		txtKetQua = new JTextField();
		txtKetQua.setColumns(10);
		txtKetQua.setBounds(186, 180, 265, 20);
		txtKetQua.setEditable(false);
		contentPane.add(txtKetQua);

		JLabel lblKtQua = new JLabel("Kết quả");
		lblKtQua.setBounds(10, 178, 127, 24);
		contentPane.add(lblKtQua);
	}

	private String KiemTra(String regrex, String s2) {
		Pattern pattern = Pattern.compile(regrex);
		Matcher matcher = pattern.matcher(s2);
		return matcher.matches() ? "UserName hợp lệ" : "Username Không hợp lệ";

	}

}
