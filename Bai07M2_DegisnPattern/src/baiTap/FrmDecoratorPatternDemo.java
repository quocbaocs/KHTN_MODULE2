package baiTap;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmDecoratorPatternDemo extends JFrame {

	private JPanel contentPane;
	private JTextField txtKetQua;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDecoratorPatternDemo frame = new FrmDecoratorPatternDemo();
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
	public FrmDecoratorPatternDemo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SHAPE");
		lblNewLabel.setBounds(57, 30, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblBorder = new JLabel("BORDER");
		lblBorder.setBounds(248, 30, 46, 14);
		contentPane.add(lblBorder);
		
		JRadioButton rdbCircle = new JRadioButton("Circle");
		buttonGroup.add(rdbCircle);
		rdbCircle.setBounds(57, 60, 109, 23);
		contentPane.add(rdbCircle);
		
		JRadioButton rdbRectangle = new JRadioButton("Rectangle");
		buttonGroup.add(rdbRectangle);
		rdbRectangle.setBounds(57, 99, 109, 23);
		contentPane.add(rdbRectangle);
		
		JRadioButton rdbRedBorder = new JRadioButton("Red Border");
		rdbRedBorder.setBounds(248, 73, 109, 23);
		contentPane.add(rdbRedBorder);
		
		JButton btnDraw = new JButton("Draw Shape");
		btnDraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDraw.setBounds(170, 135, 124, 23);
		contentPane.add(btnDraw);
		
		txtKetQua = new JTextField();
		txtKetQua.setBounds(57, 184, 301, 29);
		contentPane.add(txtKetQua);
		txtKetQua.setColumns(10);
	}
}
