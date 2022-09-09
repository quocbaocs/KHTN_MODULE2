package baiTap;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class FrmManHinhThem extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTen;
	private JTextField txtDtdd;
	private JTextField txtHinhanh;
	private JLabel lblHinhAnh;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmManHinhThem frame = new FrmManHinhThem();
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
	public FrmManHinhThem() {
		setTitle("Th\u00EAm m\u1EDBi li\u00EAn h\u1EC7");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 808, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Th\u00EAm m\u1EDBi li\u00EAn h\u1EC7");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(45, 31, 190, 31);
		contentPane.add(lblNewLabel);

		JLabel lblHTn = new JLabel("H\u1ECD t\u00EAn");
		lblHTn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHTn.setBounds(45, 72, 94, 31);
		contentPane.add(lblHTn);

		JLabel lbltdd = new JLabel("\u0110TDD");
		lbltdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbltdd.setBounds(45, 113, 94, 31);
		contentPane.add(lbltdd);

		JLabel lblHnhnh = new JLabel("H\u00ECnh \u1EA3nh");
		lblHnhnh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHnhnh.setBounds(45, 154, 94, 31);
		contentPane.add(lblHnhnh);

		txtTen = new JTextField();
		txtTen.setBounds(170, 72, 374, 31);
		contentPane.add(txtTen);
		txtTen.setColumns(10);

		txtDtdd = new JTextField();
		txtDtdd.setColumns(10);
		txtDtdd.setBounds(170, 113, 244, 31);
		contentPane.add(txtDtdd);

		txtHinhanh = new JTextField();
		txtHinhanh.setColumns(10);
		txtHinhanh.setBounds(170, 154, 305, 31);
		contentPane.add(txtHinhanh);

		 lblHinhAnh = new JLabel("");
		lblHinhAnh.setBounds(593, 31, 180, 215);
		contentPane.add(lblHinhAnh);

		JButton btnChonHinh = new JButton("...");
		btnChonHinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser openFile = new JFileChooser();
				openFile.showOpenDialog(null);
				File file = openFile.getSelectedFile();
				String filepath = file.getAbsolutePath();
				txtHinhanh.setText(filepath);
				ImageIcon icon = new ImageIcon(filepath);
//				icon.getImage().getScaledInstance(lblHinhAnh.getWidth(), lblHinhAnh.getHeight(), Image.SCALE_SMOOTH);
				lblHinhAnh.setIcon(icon);

			}
		});
		btnChonHinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnChonHinh.setBounds(485, 154, 59, 31);
		contentPane.add(btnChonHinh);
		JButton btnThemLienHe = new JButton("Th\u00EAm li\u00EAn h\u1EC7");
		btnThemLienHe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				btnThemMoiActionPerformed(arg0);
				
			}
		});
		btnThemLienHe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThemLienHe.setBounds(170, 225, 180, 31);
		contentPane.add(btnThemLienHe);
	}

	private void btnThemMoiActionPerformed(ActionEvent evt) {

		String ten = txtTen.getText();
		String dtdd = txtDtdd.getText();
		File file = new File(txtHinhanh.getText());
		String hinhAnh = file.getName();

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuider;
		try {
			docBuider = docFactory.newDocumentBuilder();

			// root elements
			Document doc = docBuider.newDocument();
			Element rootElement = doc.createElement("lienhes");
			doc.appendChild(rootElement);

			// lien he
			Element lienhe = doc.createElement("lienhe");
			rootElement.appendChild(lienhe);

			// hoten element
			Element hoten = doc.createElement("hoten");
			hoten.appendChild(doc.createTextNode(ten));
			lienhe.appendChild(hoten);

			// dtdd element
			Element dtdd1 = doc.createElement("dtdd");
			dtdd1.appendChild(doc.createTextNode(dtdd));
			lienhe.appendChild(dtdd1);

			// Hinh anh element
			Element hinh = doc.createElement("hinhanh");
			hinh.appendChild(doc.createTextNode(hinhAnh));
			lienhe.appendChild(hinh);

			// wite the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer stransformer = transformerFactory.newTransformer();

			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("src/baiTap/lienhe.xml"));
			stransformer.transform(source, result);

			JOptionPane.showMessageDialog(contentPane, "Đã thêm liên hệ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(contentPane, "Không thể thêm liên hệ");
		}
	}

}
