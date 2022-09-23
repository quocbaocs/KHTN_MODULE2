package baiTap.bai6;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class FrmFactoryPattern extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private Graphics g;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmFactoryPattern frame = new FrmFactoryPattern();
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
	public FrmFactoryPattern() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(84, 111, 267, 246);

		contentPane.add(panel);

		JButton btnCircle = new JButton("CIRCLE");
		btnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShapeFactory shapeFactory = new ShapeFactory();
				Shape shape1 = shapeFactory.getShape("CIRCLE");
				 g=panel.getGraphics();
				shape1.draw(g);
			}
		});
		btnCircle.setBounds(12, 44, 117, 40);
		contentPane.add(btnCircle);

		JButton btnSquare = new JButton("SQUARE");
		btnSquare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShapeFactory shapeFactory = new ShapeFactory();
				Shape shape1 = shapeFactory.getShape("SQUARE");
				 g=panel.getGraphics();
				shape1.draw(g);
			}
		});
		btnSquare.setBounds(157, 44, 117, 40);
		contentPane.add(btnSquare);

		JButton btnRectangle = new JButton("RECTANGLE");
		btnRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShapeFactory shapeFactory = new ShapeFactory();
				Shape shape1 = shapeFactory.getShape("RECTANGLE");
				
				 g=panel.getGraphics();
				shape1.draw(g);
			}
		});
		btnRectangle.setBounds(313, 44, 117, 40);
		contentPane.add(btnRectangle);
		
		JLabel lblNewLabel = new JLabel("DRAW IMAGE");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setBounds(145, 0, 191, 21);
		contentPane.add(lblNewLabel);
	}
}
