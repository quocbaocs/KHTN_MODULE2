package thucHanh;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class FrmKhoa extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtMaKH;
	private JTextField txtTenKH;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmKhoa frame = new FrmKhoa();
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
	public FrmKhoa() {
		setTitle("Danh s\u00E1ch Khoa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 26, 375, 118);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 khoa", "T\u00EAn khoa"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnDoc = new JButton("\u0110\u1ECDc DSKhoa");
		btnDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File("dskhoa2.xml");
				if(file.isFile()==false) {
					JOptionPane.showMessageDialog(rootPane, "Khong co tap tin "+file.getName()+" nay");
					return;
				}
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				try {
					DocumentBuilder db = dbf.newDocumentBuilder();
					Document doc = db.parse(file);
					Element nutGoc = doc.getDocumentElement();
					NodeList nodeList1 = nutGoc.getChildNodes();
					
					DefaultTableModel dtm = (DefaultTableModel) table.getModel();
					dtm.setRowCount(0);	//xoa cac dong cu neu co
					
					for(int i=0; i<nodeList1.getLength(); i++) {
						Node node1 = nodeList1.item(i);
						if(node1.getNodeType()==Node.ELEMENT_NODE) {
							NodeList nodeList2 = node1.getChildNodes();
							String makh = null, tenkh = null;
							for(int j=0; j<nodeList2.getLength(); j++) {
								Node node2 = nodeList2.item(j);
								if(node2.getNodeType() == Node.ELEMENT_NODE) {
									if(node2.getNodeName().equals("makh"))
										makh = node2.getTextContent();
									else
										tenkh = node2.getTextContent();
								}
							}
							dtm.addRow(new String[] {makh,tenkh});
						}
					}
				} catch (ParserConfigurationException | SAXException | IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnDoc.setBounds(297, 155, 109, 23);
		contentPane.add(btnDoc);
		
		JLabel lblNewLabel = new JLabel("M\u00E3 khoa");
		lblNewLabel.setBounds(75, 206, 67, 14);
		contentPane.add(lblNewLabel);
		
		txtMaKH = new JTextField();
		txtMaKH.setBounds(152, 203, 86, 20);
		contentPane.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EAn khoa");
		lblNewLabel_1.setBounds(75, 242, 67, 14);
		contentPane.add(lblNewLabel_1);
		
		txtTenKH = new JTextField();
		txtTenKH.setBounds(152, 239, 178, 20);
		contentPane.add(txtTenKH);
		txtTenKH.setColumns(10);
		
		JButton btnGhi = new JButton("Ghi DSKhoa");
		btnGhi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String makh, tenkh;
				makh = txtMaKH.getText();
				tenkh = txtTenKH.getText();
				if(makh.isBlank() || tenkh.isBlank()) {
					JOptionPane.showMessageDialog(rootPane, "Vui long nhap du lieu");
					return;
				}
				
				File file = new File("dskhoa2.xml");
				
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				try {
					DocumentBuilder db = dbf.newDocumentBuilder();
					Document doc = null;
					Element nutDSKhoa = null;
					if(file.isFile()) {
						doc = db.parse(file);
						nutDSKhoa = doc.getDocumentElement();
					}else {
						doc = db.newDocument();
						nutDSKhoa = doc.createElement("dskhoa");
						doc.appendChild(nutDSKhoa);
					}
					
					Element nutKhoa = doc.createElement("khoa");
					nutDSKhoa.appendChild(nutKhoa);
					
					Element nutMaKH = doc.createElement("makh");
					nutKhoa.appendChild(nutMaKH);
					
					Text textMaKH = doc.createTextNode(makh);
					nutMaKH.appendChild(textMaKH);
					
					Element nutTenKH = doc.createElement("tenkh");
					nutKhoa.appendChild(nutTenKH);
					
					Text textTenKH = doc.createTextNode(tenkh);
					nutTenKH.appendChild(textTenKH);
					
					//bien doi tai lieu sang tap tin
					TransformerFactory tff = TransformerFactory.newInstance();
					Transformer tf = tff.newTransformer();
					
					Source source = new DOMSource(doc);
					Result result = new StreamResult(file); 
					
					tf.transform(source, result);
					
				} catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
					e.printStackTrace();
				}
				
			}
		});
		btnGhi.setBounds(152, 285, 121, 23);
		contentPane.add(btnGhi);
	}
}
