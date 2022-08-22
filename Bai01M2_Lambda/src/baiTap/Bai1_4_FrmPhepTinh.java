package baiTap;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Bai1_4_FrmPhepTinh extends JFrame {

	private JPanel contentPane;
	private JTextField txtSo1;
	private JTextField txtSo2;
	private JTextField txtKQ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bai1_4_FrmPhepTinh frame = new Bai1_4_FrmPhepTinh();
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
	public Bai1_4_FrmPhepTinh() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Số thứ nhất");
		lblNewLabel.setBounds(29, 33, 82, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblSTh = new JLabel("Số thứ hai");
		lblSTh.setBounds(29, 80, 82, 14);
		contentPane.add(lblSTh);
		
		JLabel lblSTh_1 = new JLabel("Kết quả");
		lblSTh_1.setBounds(29, 120, 82, 14);
		contentPane.add(lblSTh_1);
		
		txtSo1 = new JTextField();
		txtSo1.setBounds(101, 27, 130, 20);
		contentPane.add(txtSo1);
		txtSo1.setColumns(10);
		
		txtSo2 = new JTextField();
		txtSo2.setColumns(10);
		txtSo2.setBounds(101, 77, 130, 20);
		contentPane.add(txtSo2);
		
		txtKQ = new JTextField();
		txtKQ.setColumns(10);
		txtKQ.setBounds(101, 117, 130, 20);
		contentPane.add(txtKQ);
		
		JButton btnTong = new JButton("Tổng");
		btnTong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer so1 = Integer.valueOf(txtSo1.getText());
				Integer so2 = Integer.valueOf(txtSo2.getText());
				Operator tong = (x, y)-> x+y;
				txtKQ.setText(tong.operate(so1, so2).toString());
			}
		});
		btnTong.setBounds(241, 29, 65, 23);
		contentPane.add(btnTong);
		
		JButton btnTich = new JButton("Tích");
		btnTich.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTich.setBounds(241, 71, 65, 23);
		contentPane.add(btnTich);
		
		JButton btnHieu = new JButton("Hiệu");
		btnHieu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer so1 = Integer.valueOf(txtSo1.getText());
				Integer so2 = Integer.valueOf(txtSo2.getText());
				Operator tich = (x, y)-> x*y;
				txtKQ.setText(tich.operate(so1, so2).toString());
			}
		});
		btnHieu.setBounds(319, 29, 72, 23);
		contentPane.add(btnHieu);
		
		JButton btnThuong = new JButton("Thương");
		btnThuong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer so1 = Integer.valueOf(txtSo1.getText());
				Integer so2 = Integer.valueOf(txtSo2.getText());
				Operator thuong = (x, y)-> x/y;
				txtKQ.setText(thuong.operate(so1, so2).toString());
			}
		});
		btnThuong.setBounds(316, 71, 75, 23);
		contentPane.add(btnThuong);
	}
}
