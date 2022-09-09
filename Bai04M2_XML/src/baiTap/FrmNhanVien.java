package baiTap;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class FrmNhanVien extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblNhanVien;
	private JComboBox cbbDonVi;
	private DefaultComboBoxModel cbbModel;
	Map<String, String> items;
	private DefaultTableModel tableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmNhanVien frame = new FrmNhanVien();
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
	public FrmNhanVien() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				items = new HashMap<String, String>();
				items.put("0", "--Chon--");
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				cbbModel = (DefaultComboBoxModel) cbbDonVi.getModel();

				// Tạo ra bộ xây dựng tài liệu mới
				DocumentBuilder db;
				try {
					db = dbf.newDocumentBuilder();

					// Phân tích
					Document doc = db.parse(new File("src/baiTap/don_vi.xml"));
					NodeList list = doc.getElementsByTagName("don_vi");
					for (int temp = 0; temp < list.getLength(); temp++) {
						Node nNode = list.item(temp);
						if (nNode.getNodeType() == Node.ELEMENT_NODE) {
							Element eElement = (Element) nNode;
							String ten = eElement.getElementsByTagName("ten").item(0).getTextContent();
							String id = eElement.getElementsByTagName("id").item(0).getTextContent();
							items.put(id, ten);
						}

					}
					items.entrySet().stream().forEach(key -> cbbModel.addElement(key.getValue()));
					cbbDonVi.setSelectedItem(items.get("0"));

				} catch (SAXException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParserConfigurationException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 72, 414, 178);
		contentPane.add(scrollPane);

		tblNhanVien = new JTable();
		tblNhanVien.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "H\u1ECD t\u00EAn",
				"Gi\u1EDBi t\u00EDnh", "Ng\u00E0y sinh", "M\u1EE9c l\u01B0\u01A1ng", "\u0110\u1ECBa ch\u1EC9" }));
		scrollPane.setViewportView(tblNhanVien);

		JLabel lblNewLabel = new JLabel("Đơn vị");
		lblNewLabel.setBounds(20, 22, 67, 23);
		contentPane.add(lblNewLabel);

		cbbDonVi = new JComboBox();
		cbbDonVi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder db;
				try {
					db = dbf.newDocumentBuilder();
					Document doc = db.parse(new File("src/baiTap/nhan_vien.xml"));
					NodeList list = doc.getElementsByTagName("nhan_vien");
					tableModel = (DefaultTableModel)tblNhanVien.getModel();
					
					if (cbbDonVi.getSelectedItem()!=null) {
						System.out.println(cbbDonVi.getSelectedItem().toString());
						for (int temp = 0; temp < list.getLength(); temp++) {
							Node nNode = list.item(temp);
							String id_donvi = ((Element) nNode).getElementsByTagName("id_don_vi").item(0).getTextContent();
							if (nNode.getNodeType() == Node.ELEMENT_NODE) {
								tableModel.setRowCount(0);
								Element eElement = (Element) nNode;
								String id = eElement.getElementsByTagName("id").item(0).getTextContent();
								String ten = eElement.getElementsByTagName("ho_ten").item(0).getTextContent();
								String gioiTinh = eElement.getElementsByTagName("gioi_tinh").item(0).getTextContent();
								String ngaySinh = eElement.getElementsByTagName("ngay_sinh").item(0).getTextContent();
								String mucLuong = eElement.getElementsByTagName("muc_luong").item(0).getTextContent();
								String diaChi = eElement.getElementsByTagName("dia_chi").item(0).getTextContent();
								tableModel.addRow(new Object[] {id, ten, gioiTinh, ngaySinh, mucLuong, diaChi});
							}
						}
					}
				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SAXException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// Phân tích

			}
		});
		cbbDonVi.setBounds(103, 22, 243, 23);
		contentPane.add(cbbDonVi);
	}
}
