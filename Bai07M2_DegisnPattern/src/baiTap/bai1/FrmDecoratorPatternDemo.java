package baiTap.bai1;

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
	private final ButtonGroup btgShape = new ButtonGroup();
	private JRadioButton rdbCircle;
	private JRadioButton rdbRectangle;
	private JRadioButton rdbRedBorder;

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
		setBounds(100, 100, 562, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("SHAPE");
		lblNewLabel.setBounds(57, 30, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblBorder = new JLabel("BORDER");
		lblBorder.setBounds(279, 30, 78, 14);
		contentPane.add(lblBorder);

		rdbCircle = new JRadioButton("Circle");
		btgShape.add(rdbCircle);
		rdbCircle.setBounds(57, 60, 109, 23);
		contentPane.add(rdbCircle);

		rdbRectangle = new JRadioButton("Rectangle");
		btgShape.add(rdbRectangle);
		rdbRectangle.setBounds(57, 99, 109, 23);
		contentPane.add(rdbRectangle);

		rdbRedBorder = new JRadioButton("Red Border");
		rdbRedBorder.setBounds(282, 60, 109, 23);
		contentPane.add(rdbRedBorder);

		JButton btnDraw = new JButton("Draw Shape");
		btnDraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDrawActionPerformed(e);
			}
		});
		btnDraw.setBounds(170, 135, 124, 23);
		contentPane.add(btnDraw);

		txtKetQua = new JTextField();
		txtKetQua.setBounds(57, 184, 464, 29);
		contentPane.add(txtKetQua);
		txtKetQua.setColumns(10);
	}

	private void btnDrawActionPerformed(java.awt.event.ActionEvent evt) {
		String result = "";
		if (btgShape.getSelection().equals(rdbCircle.getModel())) {
			Circle circle = new Circle();
			result = circle.draw();
			if (rdbRedBorder.isSelected()) {
				Shape red = new RedShapeDecorator(circle);
				result = red.draw();
			} else {
				result += " with normal border";
			}
		}
		if (btgShape.getSelection().equals(rdbCircle.getModel())) {
			Rectangle rg = new Rectangle();
			result = rg.draw();
			if (rdbRedBorder.isSelected()) {
				Shape red = new RedShapeDecorator(rg);
				result = red.draw();
			} else {
				result += " with normal border";
			}
		}
		txtKetQua.setText(result);
	}

}
