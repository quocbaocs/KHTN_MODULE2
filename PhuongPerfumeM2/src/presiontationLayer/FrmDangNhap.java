package presiontationLayer;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import buisinessLayer.NguoiDungBL;
import dataTransferObject.NguoiDung;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmDangNhap extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtEmail;
	private JTextField txtPassword;
	public static NguoiDung nd;
	public static String str;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDangNhap frame = new FrmDangNhap();
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
	public FrmDangNhap() {
		setTitle("Đăng nhập");
		setBounds(100, 100, 413, 227);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setBounds(72, 43, 46, 14);
		getContentPane().add(lblNewLabel);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(140, 40, 168, 20);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(33, 84, 85, 14);
		getContentPane().add(lblNewLabel_1);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(140, 81, 168, 20);
		getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		JButton btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String email , password;
				email = txtEmail.getText();
				password = txtPassword.getText();
				 nd = NguoiDungBL.timEmailPassword(email, password);
				if(nd!=null) {
					JOptionPane.showMessageDialog(rootPane, "Đăng nhập thành công");
					dispose();
					FrmMain frm = new FrmMain();
					frm.setSize(1500, 15000);
					frm.setDefaultCloseOperation(EXIT_ON_CLOSE);
					frm.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(rootPane, "Email hoặc mật khẩu sai");
				}
			}
		});
		btnDangNhap.setBounds(151, 136, 143, 23);
		getContentPane().add(btnDangNhap);

	}
}
