package presentationLayer;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dataTransferObject.Sach;

public class FrmThemSach extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTen;
	private JTextField txtTacGia;
	private JTextField txtNXB;
	private JTextField txtGia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmThemSach frame = new FrmThemSach();
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
	public FrmThemSach() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Tên sách");
		lblNewLabel.setBounds(66, 88, 90, 31);
		contentPane.add(lblNewLabel);

		JLabel lblTcGi = new JLabel("Tác giả");
		lblTcGi.setBounds(66, 148, 90, 31);
		contentPane.add(lblTcGi);

		JLabel lblNxb = new JLabel("NXB");
		lblNxb.setBounds(66, 218, 90, 31);
		contentPane.add(lblNxb);

		JLabel lblGiBa = new JLabel("Giá bìa");
		lblGiBa.setBounds(66, 285, 90, 31);
		contentPane.add(lblGiBa);

		JButton btnThem = new JButton("Thêm sách mới");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ten = txtTen.getText();
				String tacGia = txtTacGia.getText();
				String nxb = txtNXB.getText();
				double gia = Double.parseDouble(txtGia.getText());
				Sach s = new Sach(ten, tacGia, nxb, gia);
				if (themSach(s)==true) {
					JOptionPane.showMessageDialog(contentPane, "Đã thêm sách");
				} else {
					JOptionPane.showMessageDialog(contentPane, "Không thêm được sách");
				}
			}
		});
		btnThem.setBounds(189, 382, 143, 37);
		contentPane.add(btnThem);

		JButton btnTiepTuc = new JButton("Tiếp tục");
		btnTiepTuc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTen.setText("");
				txtTacGia.setText("");
				txtNXB.setText("");
				txtGia.setText("");
			}
		});
		btnTiepTuc.setBounds(361, 382, 114, 37);
		contentPane.add(btnTiepTuc);

		txtTen = new JTextField();
		txtTen.setBounds(189, 88, 286, 31);
		contentPane.add(txtTen);
		txtTen.setColumns(10);

		txtTacGia = new JTextField();
		txtTacGia.setColumns(10);
		txtTacGia.setBounds(189, 148, 286, 31);
		contentPane.add(txtTacGia);

		txtNXB = new JTextField();
		txtNXB.setColumns(10);
		txtNXB.setBounds(189, 218, 286, 31);
		contentPane.add(txtNXB);

		txtGia = new JTextField();
		txtGia.setColumns(10);
		txtGia.setBounds(189, 285, 286, 31);
		contentPane.add(txtGia);
	}

	private boolean themSach(Sach s) {

		String sql = "INSERT INTO Sach(tensach,tacgia,nxb,giabia) VALUES(?,?,?,?)";
		String url = "jdbc:mysql://localhost:3306/dlsachdb?useUsenicode=true&characterEncoding=UTF-8";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, "root", "quocbao@123");
			if (conn != null) {
				PreparedStatement prstmt = conn.prepareStatement(sql);
				prstmt.setString(1, s.getTenSach());
				prstmt.setString(2, s.getTacGia());
				prstmt.setString(3, s.getNXB());
				prstmt.setDouble(4, s.getGiaBia());

				int result = prstmt.executeUpdate();
				if (result > 0) {
					return true;
				}

			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

}
