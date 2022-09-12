package presentationLayer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import businessLayer.QLCSDL;
import dataTransferObject.Sach;

public class FrmCapNhatSach extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTenSach;
	private JTextField txtTacGia;
	private JTextField txtNXB;
	private JTextField txtGia;
	private JTable tblSach;
	private DefaultTableModel model;
	private QLCSDL qlcsdl = new QLCSDL();
	private List<Sach> listSach;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCapNhatSach frame = new FrmCapNhatSach();
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
	public FrmCapNhatSach() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				model = (DefaultTableModel) tblSach.getModel();
				listSach = qlcsdl.dsSach();
				if(listSach!=null) {
					listSach.forEach(sach->{model.addRow(new Object[] {sach.getTenSach(), sach.getTacGia(), sach.getNXB(), sach.getGiaBia()});});
				}
				
				tblSach.setModel(model);
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Cap nhat sach");
		setBounds(100, 100, 678, 564);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Tên sách");
		lblNewLabel.setBounds(66, 38, 90, 31);
		contentPane.add(lblNewLabel);

		JLabel lblTcGi = new JLabel("Tác giả");
		lblTcGi.setBounds(66, 88, 90, 31);
		contentPane.add(lblTcGi);

		JLabel lblNxb = new JLabel("NXB");
		lblNxb.setBounds(66, 136, 90, 31);
		contentPane.add(lblNxb);

		JLabel lblGiBa = new JLabel("Giá bìa");
		lblGiBa.setBounds(66, 183, 90, 31);
		contentPane.add(lblGiBa);

		JButton btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setBounds(189, 240, 143, 37);
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tenSach = txtTenSach.getText();
				String tacGia = txtTacGia.getText();
				String nxb = txtNXB.getText();
				double giabia = Double.parseDouble(txtGia.getText());
				Sach s = new Sach(tenSach, tacGia, nxb, giabia);
				qlcsdl.capNhatSach(s);
				int rowSelected = tblSach.getSelectedRow();
				model.setValueAt(s.getTenSach(), rowSelected, 0);
				model.setValueAt(s.getTacGia(), rowSelected, 1);
				model.setValueAt(s.getNXB(), rowSelected, 2);
				model.setValueAt(s.getGiaBia(), rowSelected, 3);
				
			}
		});
		contentPane.add(btnCapNhat);

		txtTenSach = new JTextField();
		txtTenSach.setBackground(Color.WHITE);
		txtTenSach.setEditable(false);
		txtTenSach.setBounds(189, 38, 413, 31);
		contentPane.add(txtTenSach);
		txtTenSach.setColumns(10);

		txtTacGia = new JTextField();
		txtTacGia.setBounds(189, 88, 413, 31);
		txtTacGia.setColumns(10);
		contentPane.add(txtTacGia);

		txtNXB = new JTextField();
		txtNXB.setBounds(189, 136, 413, 31);
		txtNXB.setColumns(10);
		contentPane.add(txtNXB);

		txtGia = new JTextField();
		txtGia.setBounds(189, 183, 413, 31);
		txtGia.setColumns(10);
		contentPane.add(txtGia);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(66, 316, 536, 182);
		contentPane.add(scrollPane);
		
		tblSach = new JTable();
		tblSach.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtTenSach.setText(String.valueOf(model.getValueAt(tblSach.getSelectedRow(),0)));
				txtTacGia.setText(String.valueOf(model.getValueAt(tblSach.getSelectedRow(),1)));
				txtNXB.setText(String.valueOf(model.getValueAt(tblSach.getSelectedRow(),2)));
				txtGia.setText(String.valueOf(model.getValueAt(tblSach.getSelectedRow(),3)));
				
			}
		});
		tblSach.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"T\u00EAn s\u00E1ch", "T\u00E1c Gi\u1EA3", "NXB", "Gi\u00E1 B\u00ECa"
			}
		));
		scrollPane.setViewportView(tblSach);
	}

	
}
