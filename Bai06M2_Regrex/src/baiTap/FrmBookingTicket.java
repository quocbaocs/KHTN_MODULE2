package baiTap;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ButtonGroup;

public class FrmBookingTicket extends JFrame {

	private JPanel contentPane;
	private JTextField txtNgayDi;
	private JTextField txtNgayVe;
	private JLabel lblLoaiVe;
	private JRadioButton rbt1Chieu;
	private JRadioButton rbtKH;
	private JLabel lblNL ;
	private JButton btnTimVe;
	private JLabel lblEB ;
	private JLabel lblTE;
	private JLabel lblKH;
	private JLabel lblDD;
	private JLabel lblNgayDi;
	private JLabel lblNgayVe;
	private JButton btnViet;
	private JLabel title;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmBookingTicket frame = new FrmBookingTicket();
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
	public FrmBookingTicket() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 568, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 btnViet = new JButton("Việt");
		btnViet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DaNgonNgu(new Locale("vi","VN"));
			}
		});
		btnViet.setBounds(12, 0, 72, 41);
		contentPane.add(btnViet);

		JButton btnAnh = new JButton("Anh");
		btnAnh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DaNgonNgu(new Locale("us","US"));
			}
		});
		btnAnh.setBounds(96, 0, 72, 41);
		contentPane.add(btnAnh);

		 title = new JLabel("Tìm vé máy bay");
		title.setFont(new Font("Dialog", Font.BOLD, 12));
		title.setBounds(177, 47, 274, 15);
		contentPane.add(title);

		lblLoaiVe = new JLabel("Loại vé");
		lblLoaiVe.setBounds(34, 77, 109, 26);
		contentPane.add(lblLoaiVe);

		 lblKH = new JLabel("Điểm khởi hành");
		lblKH.setBounds(34, 115, 134, 26);
		contentPane.add(lblKH);

		 lblDD = new JLabel("Điểm đến");
		lblDD.setBounds(34, 154, 109, 26);
		contentPane.add(lblDD);

		lblNgayDi = new JLabel("Ngày đi");
		lblNgayDi.setBounds(34, 200, 109, 26);
		contentPane.add(lblNgayDi);

		 lblNgayVe = new JLabel("Ngày về");
		lblNgayVe.setBounds(34, 238, 109, 26);
		contentPane.add(lblNgayVe);

		 lblNL = new JLabel("Người lớn");
		lblNL.setBounds(34, 276, 109, 26);
		contentPane.add(lblNL);

		 lblTE = new JLabel("Trẻ em");
		lblTE.setBounds(34, 314, 109, 26);
		contentPane.add(lblTE);

		 lblEB = new JLabel("Em bé");
		lblEB.setBounds(34, 352, 109, 26);
		contentPane.add(lblEB);

		rbt1Chieu = new JRadioButton("Một chiều");
		buttonGroup.add(rbt1Chieu);
		rbt1Chieu.setBounds(162, 79, 149, 23);
		contentPane.add(rbt1Chieu);

		 rbtKH = new JRadioButton("Khử hồi");
		 buttonGroup.add(rbtKH);
		rbtKH.setBounds(315, 79, 149, 23);
		contentPane.add(rbtKH);

		JComboBox cbbKH = new JComboBox();
		cbbKH.setModel(new DefaultComboBoxModel(new String[] {"Item 1"}));
		cbbKH.setBounds(177, 116, 183, 24);
		contentPane.add(cbbKH);

		JComboBox cbbDD = new JComboBox();
		cbbDD.setModel(new DefaultComboBoxModel(new String[] {"Item 1"}));
		cbbDD.setBounds(177, 155, 183, 24);
		contentPane.add(cbbDD);

		txtNgayDi = new JTextField();
		txtNgayDi.setBounds(177, 196, 183, 32);
		contentPane.add(txtNgayDi);
		txtNgayDi.setColumns(10);

		txtNgayVe = new JTextField();
		txtNgayVe.setColumns(10);
		txtNgayVe.setBounds(177, 234, 183, 32);
		contentPane.add(txtNgayVe);

		JComboBox cbbNL = new JComboBox();
		cbbNL.setModel(new DefaultComboBoxModel(new String[] {"Item 1"}));
		cbbNL.setBounds(177, 281, 102, 24);
		contentPane.add(cbbNL);

		JComboBox cbbTE = new JComboBox();
		cbbTE.setModel(new DefaultComboBoxModel(new String[] {"Item 1"}));
		cbbTE.setBounds(177, 317, 102, 24);
		contentPane.add(cbbTE);

		JComboBox cbbEB = new JComboBox();
		cbbEB.setModel(new DefaultComboBoxModel(new String[] {"Item 1"}));
		cbbEB.setBounds(177, 353, 102, 24);
		contentPane.add(cbbEB);

		 btnTimVe = new JButton("Tìm vé");
		btnTimVe.setBounds(312, 398, 117, 25);
		contentPane.add(btnTimVe);
	}

	private void DaNgonNgu(Locale lc) {
		ResourceBundle translate = ResourceBundle.getBundle("baiTap/movie", lc);
		title.setText(translate.getString("title"));
		lblLoaiVe.setText(translate.getString("ticket_type"));
		rbt1Chieu.setText(translate.getString("oneway"));
		rbtKH.setText(translate.getString("roundtrip"));
		lblKH.setText(translate.getString("departure"));
		lblDD.setText(translate.getString("destination"));
		lblNgayDi.setText(translate.getString("fromDate"));
		lblNgayVe.setText(translate.getString("toDay"));
		lblNL.setText(translate.getString("adults"));
		lblTE.setText(translate.getString("children"));
		lblEB.setText(translate.getString("infant"));
		btnTimVe.setText(translate.getString("search"));

	}
}
