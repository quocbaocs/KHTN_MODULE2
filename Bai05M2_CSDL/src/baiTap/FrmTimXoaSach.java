package baiTap;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmTimXoaSach extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTenSach;
	private JTable tblSach;
	private List<Sach> listSach;
	private QLCSDL qlcsdl = new QLCSDL();
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTimXoaSach frame = new FrmTimXoaSach();
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
	public FrmTimXoaSach() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtTenSach = new JTextField();
		txtTenSach.setBounds(154, 45, 480, 30);
		contentPane.add(txtTenSach);
		txtTenSach.setColumns(10);

		JLabel lblNewLabel = new JLabel("Tên sách");
		lblNewLabel.setBounds(34, 45, 95, 30);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 149, 584, 252);
		contentPane.add(scrollPane);

		tblSach = new JTable();
		tblSach.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				txtTenSach.setText(String.valueOf(model.getValueAt(tblSach.getSelectedRow(), 0)));
			}
		});
		tblSach.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "T\u00EAn S\u00E1ch", "T\u00E1c Gi\u1EA3", "NXB", "Gi\u00E1 B\u00ECa" }));
		scrollPane.setViewportView(tblSach);

		JButton btnTimSach = new JButton("Tìm sách");
		btnTimSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tenSach = txtTenSach.getText();
				listSach = qlcsdl.dsSach(tenSach);
				try {
					if (listSach.size() <= 0) {
						JOptionPane.showMessageDialog(null, "Không tìm thấy sách");
					} else {
						System.out.println("Dang o day");
						model = (DefaultTableModel) tblSach.getModel();
						listSach.forEach(sach -> {
							model.addRow(new Object[] { sach.getTenSach(), sach.getTacGia(), sach.getNXB(),
									sach.getGiaBia() });
						});
						tblSach.setModel(model);
					}

				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnTimSach.setBounds(151, 95, 103, 30);
		contentPane.add(btnTimSach);

		JButton btnXoaSach = new JButton("Xóa sách");
		btnXoaSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tenSach = txtTenSach.getText();
				int reply = JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn xóa sách: "+tenSach+"?","Confirm",JOptionPane.YES_NO_OPTION);
				if(reply==JOptionPane.YES_OPTION) {
					qlcsdl.xoaSach(tenSach);
					model.removeRow(tblSach.getSelectedRow());
					txtTenSach.setText("");
					JOptionPane.showMessageDialog(null, "Xóa sách thành công");
				}
			}
		});
		btnXoaSach.setBounds(331, 95, 103, 30);
		contentPane.add(btnXoaSach);
	}

	
}
