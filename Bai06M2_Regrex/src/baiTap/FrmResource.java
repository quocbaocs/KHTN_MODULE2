package baiTap;

import java.awt.EventQueue;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class FrmResource extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmResource frame = new FrmResource();
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
	public FrmResource() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Chọn ngôn ngữ");
		lblNewLabel.setBounds(33, 12, 106, 15);
		contentPane.add(lblNewLabel);

		JRadioButton rdbtnVi = new JRadioButton("Vietnamese");
		rdbtnVi.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				rdbActionPerformed(new Locale("vi","VN"));
			}
		});
		buttonGroup.add(rdbtnVi);
		rdbtnVi.setBounds(208, 8, 149, 23);
		contentPane.add(rdbtnVi);

		JRadioButton rdbtnEg = new JRadioButton("English");
		rdbtnEg.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				rdbActionPerformed(new Locale("us","US"));
			}
		});
		buttonGroup.add(rdbtnEg);
		rdbtnEg.setBounds(379, 8, 149, 23);
		contentPane.add(rdbtnEg);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 70, 521, 344);
		contentPane.add(scrollPane);

		list = new JList();
		scrollPane.setViewportView(list);
	}

	private void rdbActionPerformed(Locale lc) {
		
		ResourceBundle message = ResourceBundle.getBundle("baiTap/resource", lc);
		DefaultListModel model = new DefaultListModel();
		Enumeration<String> keys = message.getKeys();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			String value = message.getString(key);
			String kq = value;
			model.addElement(kq);
		}
		list.setModel(model);
	}
}
