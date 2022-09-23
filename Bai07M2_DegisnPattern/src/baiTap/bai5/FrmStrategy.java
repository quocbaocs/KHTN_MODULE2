package baiTap.bai5;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmStrategy extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup rbtgChon = new ButtonGroup();
	private JTextArea txtaKetQua;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmStrategy frame = new FrmStrategy();
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
	public FrmStrategy() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Cảm ơn quý khách đặt hàng");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setBounds(53, 12, 357, 36);
		contentPane.add(lblNewLabel);

		JLabel lblVuiLngChn = new JLabel("Vui lòng chọn hình thức giao hàng");
		lblVuiLngChn.setFont(new Font("Dialog", Font.BOLD, 16));
		lblVuiLngChn.setBounds(53, 60, 357, 36);
		contentPane.add(lblVuiLngChn);

		JRadioButton rbtTieuChuan = new JRadioButton("Giao hàng tiêu chuẩn");
		rbtgChon.add(rbtTieuChuan);
		rbtTieuChuan.setFont(new Font("Dialog", Font.BOLD, 16));
		rbtTieuChuan.setBounds(53, 114, 279, 23);
		contentPane.add(rbtTieuChuan);

		JRadioButton rbtNhanh = new JRadioButton("GIao hàng nhanh");
		rbtgChon.add(rbtNhanh);
		rbtNhanh.setFont(new Font("Dialog", Font.BOLD, 16));
		rbtNhanh.setBounds(53, 151, 239, 23);
		contentPane.add(rbtNhanh);

		JButton btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rbtTieuChuan.isSelected()) {
					DeliveryContext context1 = new DeliveryContext(new StandardDeliveryStrategy());
					txtaKetQua.setText(context1.executeDelivery());
				}
				if (rbtNhanh.isSelected()) {
					DeliveryContext context2 = new DeliveryContext(new QuickDeliveryStrategy());
					txtaKetQua.setText(context2.executeDelivery());
				}
			}
		});
		btnXacNhan.setFont(new Font("Dialog", Font.BOLD, 16));
		btnXacNhan.setBounds(53, 191, 135, 36);
		contentPane.add(btnXacNhan);

		txtaKetQua = new JTextArea();
		txtaKetQua.setLineWrap(true);
		txtaKetQua.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtaKetQua.setRows(5);
		txtaKetQua.setBounds(64, 260, 471, 136);
		contentPane.add(txtaKetQua);
	}
}
