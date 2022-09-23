package thucHanh;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

class ChayChu extends Thread {
	private String chuChay = "	Trung tâm tin học Đại học Khoa học tự nhiên				";
	private Object obj;

	public ChayChu(Object ob) {
		// TODO Auto-generated constructor stub
		this.obj = ob;
	}

	@Override
	public void run() {
		while (obj != null) {
			// chuChay = chuChay.substring(1) + chuChay.substring(0, 1);
			// System.out.println(chuChay);
			chuChay = chuChay.substring(chuChay.length() - 1, chuChay.length())
					+ chuChay.substring(0, chuChay.length() - 1);

			((JFrame) obj).setTitle(chuChay);
			try {
				Thread.sleep(300);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}

class ChayChuButton extends Thread {
	private String chuChay = "Xin Chào Các Bạn ";
	private Object obj;

	public ChayChuButton(Object ob) {
		// TODO Auto-generated constructor stub
		this.obj = ob;
	}

	@Override
	public void run() {
		while (obj != null) {
			// chuChay = chuChay.substring(1) + chuChay.substring(0, 1);
			// System.out.println(chuChay);
			chuChay = chuChay.substring(chuChay.length() - 1, chuChay.length())
					+ chuChay.substring(0, chuChay.length() - 1);

			((JButton) obj).setText(chuChay);
			try {
				Thread.sleep(300);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}

class ChayChuLabel<T> extends Thread {
	private String chuChay = "Làm chữ chạy cho vui thôi :):):)   ";
	private T obj;

	public ChayChuLabel(T ob) {
		// TODO Auto-generated constructor stub
		this.obj = ob;
	}

	@Override
	public void run() {
		while (obj != null) {
			// chuChay = chuChay.substring(1) + chuChay.substring(0, 1);
			// System.out.println(chuChay);
			chuChay = chuChay.substring(chuChay.length() - 1, chuChay.length())
					+ chuChay.substring(0, chuChay.length() - 1);

			((JLabel) obj).setText(chuChay);
			try {
				Thread.sleep(300);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}

public class FrmVDChayChu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnChao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmVDChayChu frame = new FrmVDChayChu();
					ChayChu cc = new ChayChu(frame);
					cc.start();
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
	public FrmVDChayChu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnChao = new JButton();

		ChayChuButton chay = new ChayChuButton(btnChao);
		chay.start();

		btnChao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(rootPane, "Xin chào các bạn");
			}
		});
		btnChao.setBounds(91, 144, 89, 23);
		contentPane.add(btnChao);

		JButton btnExit = new JButton("Thoát");
		btnExit.setBounds(242, 144, 89, 23);
		contentPane.add(btnExit);

		JLabel lblChuChay = new JLabel("");
		ChayChuLabel chayLbl = new ChayChuLabel(lblChuChay);
		chayLbl.start();
		lblChuChay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChuChay.setBounds(22, 11, 369, 52);
		contentPane.add(lblChuChay);
	}

}
