package baiTap.bai3;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FrmObserverPattern extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtBalance;
	private JTextField txtTransfer;
	private JTextArea txtaEmail;
	private JTextArea txtaMobiPhone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmObserverPattern frame = new FrmObserverPattern();
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
	public FrmObserverPattern() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 533, 611);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("INFORMATION OF ACCOUNT XXX");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 24));
		lblNewLabel.setBounds(30, 12, 458, 30);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Balance");
		lblNewLabel_1.setBounds(45, 76, 70, 15);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Transfer");
		lblNewLabel_1_1.setBounds(45, 152, 70, 15);
		contentPane.add(lblNewLabel_1_1);

		txtBalance = new JTextField();
		txtBalance.setText("10000000");
		txtBalance.setBounds(133, 65, 328, 37);
		contentPane.add(txtBalance);
		txtBalance.setColumns(10);

		txtTransfer = new JTextField();
		txtTransfer.setColumns(10);
		txtTransfer.setBounds(133, 141, 328, 37);
		contentPane.add(txtTransfer);

		JButton btnTransfer = new JButton("Transfer");
		btnTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnTransferActionPerformed(e);

			}
		});
		btnTransfer.setBounds(143, 201, 131, 37);
		contentPane.add(btnTransfer);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 260, 444, 125);
		contentPane.add(scrollPane);

		txtaEmail = new JTextArea();
		txtaEmail.setRows(10);
		scrollPane.setViewportView(txtaEmail);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(44, 417, 444, 125);
		contentPane.add(scrollPane_1);

		txtaMobiPhone = new JTextArea();
		txtaMobiPhone.setRows(10);
		scrollPane_1.setViewportView(txtaMobiPhone);
	}

	private void btnTransferActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			double balance = Double.parseDouble(txtBalance.getText());
			double transfer = Double.parseDouble(txtTransfer.getText());
			if (transfer > balance) {
				JOptionPane.showMessageDialog(rootPane, "Transfer phải <= Banlance");
			} else {
				double money = balance - transfer;
				Account account = new Account();
				account.setState(money);
				txtaEmail.setText(new EmailObserver(account).update());
				txtaMobiPhone.setText(new MobiObserver(account).update());
			}
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(rootPane, "Lỗi nhập liệu: " + ex.getMessage());
		}
	}
}
