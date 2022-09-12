package presentationLayer;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import businessLayer.UserBL;
import dataTransferObject.User;

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
					User user = UserBL.timUser(userName, password);

					// Bước 6: xử lí kết quả
					if (user!=null) {
						JOptionPane.showMessageDialog(rootPane, "Đã đăng nhập thành công");
					} else
						JOptionPane.showMessageDialog(rootPane, "Tên đăng nhập và mật khẩu sai");

					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnLogin.setBounds(127, 136, 89, 37);
		contentPane.add(btnLogin);
	}
}
