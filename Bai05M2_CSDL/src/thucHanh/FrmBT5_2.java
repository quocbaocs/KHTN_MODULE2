package thucHanh;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FrmBT5_2 extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserName;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmBT5_2 frame = new FrmBT5_2();
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
	public FrmBT5_2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 354, 236);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setBounds(28, 62, 85, 21);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(28, 105, 85, 21);
		contentPane.add(lblNewLabel_1);

		txtUserName = new JTextField();
		txtUserName.setBounds(107, 62, 175, 21);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(106, 104, 176, 21);
		contentPane.add(txtPassword);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = txtUserName.getText();
				String password = new String(txtPassword.getPassword());

				// Bước 1: nạp trình điều khiển
				try {
					Class.forName("com.mysql.jdbc.Driver");
					// buoc 2: tao chuoi ket noi
					String url = "jdbc:mysql://localhost:3306/qllienhe?useUnicode=true&characterEncoding=UTF-8";

					// buoc 3: tao ket noi
					Connection ketNoi = DriverManager.getConnection(url, "root", "");

					// buoc 4: tao phat bieu
//					C1
					// Statement stm = ketNoi.createStatement();
					String sql = "select * from user where username=? and password=?";

//					C2
					PreparedStatement prstmt = ketNoi.prepareStatement(sql);
					// buoc 5: thuc hien cau truy van
//					String sql = "select * from user where username='"+userName+"' and password='"+password+"'";

					prstmt.setString(1, userName);
					prstmt.setString(2, password);

					ResultSet rs = prstmt.executeQuery();

					// Bước 6: xử lí kết quả
					if (rs.next()) {
						JOptionPane.showMessageDialog(rootPane, "Đã đăng nhập thành công");
					} else
						JOptionPane.showMessageDialog(rootPane, "Tên đăng nhập và mật khẩu sai");

					// Bước 7: Đóng kết nối
					ketNoi.close();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnLogin.setBounds(127, 136, 89, 37);
		contentPane.add(btnLogin);
	}
}
