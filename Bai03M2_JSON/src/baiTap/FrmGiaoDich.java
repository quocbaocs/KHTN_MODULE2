package baiTap;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;

public class FrmGiaoDich extends JFrame {

	private JPanel contentPane;
	private JTextField txtMa;
	private JTextField txtSoLuong;
	private JTextField txtDonGia;
	private JTextField txtTiGia;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	List<GiaoDich> dsGDVang = new ArrayList<>();
	List<GiaoDichTienTe> dsGDTien = new ArrayList<>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmGiaoDich frame = new FrmGiaoDich();
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
	public FrmGiaoDich() {
		setTitle("Giao dich");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("M\u00E3 giao d\u1ECBch");
		lblNewLabel.setBounds(26, 34, 86, 14);
		contentPane.add(lblNewLabel);
		
		txtMa = new JTextField();
		txtMa.setBounds(122, 31, 86, 20);
		contentPane.add(txtMa);
		txtMa.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("S\u1ED1 l\u01B0\u1EE3ng");
		lblNewLabel_1.setBounds(243, 34, 70, 14);
		contentPane.add(lblNewLabel_1);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setBounds(321, 31, 86, 20);
		contentPane.add(txtSoLuong);
		txtSoLuong.setColumns(10);
		
		JTabbedPane tbpLoaiGD = new JTabbedPane(JTabbedPane.TOP);
		tbpLoaiGD.setBounds(26, 74, 379, 162);
		contentPane.add(tbpLoaiGD);
		
		JPanel pnlGDVang = new JPanel();
		tbpLoaiGD.addTab("Giao d\u1ECBch V\u00E0ng", null, pnlGDVang, null);
		pnlGDVang.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Lo\u1EA1i v\u00E0ng");
		lblNewLabel_2.setBounds(40, 23, 73, 14);
		pnlGDVang.add(lblNewLabel_2);
		
		JComboBox cboLoaiVang = new JComboBox();
		cboLoaiVang.setModel(new DefaultComboBoxModel(new String[] {"18K", "24K", "9999"}));
		cboLoaiVang.setBounds(123, 20, 88, 20);
		pnlGDVang.add(cboLoaiVang);
		
		JLabel lblNewLabel_3 = new JLabel("\u0110\u01A1n gi\u00E1");
		lblNewLabel_3.setBounds(40, 62, 73, 14);
		pnlGDVang.add(lblNewLabel_3);
		
		txtDonGia = new JTextField();
		txtDonGia.setBounds(125, 59, 86, 20);
		pnlGDVang.add(txtDonGia);
		txtDonGia.setColumns(10);
		
		JPanel pnlNgoaiTe = new JPanel();
		tbpLoaiGD.addTab("Giao d\u1ECBch Ti\u1EC1n t\u1EC7", null, pnlNgoaiTe, null);
		pnlNgoaiTe.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Lo\u1EA1i ti\u1EC1n");
		lblNewLabel_4.setBounds(45, 24, 76, 14);
		pnlNgoaiTe.add(lblNewLabel_4);
		
		JComboBox cboLoaiTien = new JComboBox();
		cboLoaiTien.setModel(new DefaultComboBoxModel(new String[] {"USD", "EUR", "AUD"}));
		cboLoaiTien.setBounds(131, 21, 113, 20);
		pnlNgoaiTe.add(cboLoaiTien);
		
		JLabel lblNewLabel_5 = new JLabel("Mua b\u00E1n");
		lblNewLabel_5.setBounds(45, 63, 76, 14);
		pnlNgoaiTe.add(lblNewLabel_5);
		
		JRadioButton rdbMua = new JRadioButton("Mua");
		rdbMua.setSelected(true);
		buttonGroup.add(rdbMua);
		rdbMua.setBounds(131, 59, 65, 23);
		pnlNgoaiTe.add(rdbMua);
		
		JRadioButton rdbBan = new JRadioButton("B\u00E1n");
		buttonGroup.add(rdbBan);
		rdbBan.setBounds(218, 59, 65, 23);
		pnlNgoaiTe.add(rdbBan);
		
		JLabel lblNewLabel_6 = new JLabel("T\u1EC9 gi\u00E1");
		lblNewLabel_6.setBounds(45, 97, 76, 14);
		pnlNgoaiTe.add(lblNewLabel_6);
		
		txtTiGia = new JTextField();
		txtTiGia.setBounds(130, 94, 86, 20);
		pnlNgoaiTe.add(txtTiGia);
		txtTiGia.setColumns(10);
		
		JButton btnNewButton = new JButton("Th\u00EAm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ma=null, ngay=null;
				float donGia;
				String loai;
				int soLuong=0, pnlChon;
				
				//lay ngay hien tai cua he thong
				SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				ngay = df.format(new Date());
				
				ma = txtMa.getText();
				if(ma.isEmpty()) {
					JOptionPane.showMessageDialog(rootPane, "Hay nhap ma giao dich");
					return;
				}

				try {
					soLuong = Integer.parseInt(txtSoLuong.getText());
				}catch(Exception e) {
					JOptionPane.showMessageDialog(rootPane, "Hay nhap so luong hop le");
					return;
				}

				pnlChon = tbpLoaiGD.getSelectedIndex();

				GiaoDich gd = null;
				if(pnlChon == 0) {//Giao dich vang
					loai = cboLoaiVang.getSelectedItem().toString();
					try {
						donGia = Integer.parseInt(txtDonGia.getText());
					}catch(Exception e) {
						JOptionPane.showMessageDialog(rootPane, "Hay nhap don gia hop le");
						return;
					}
					gd = new GiaoDich(ma, ngay, donGia, soLuong, loai);
					dsGDVang.add(gd);
				}else {
					boolean mua = false;
					loai=cboLoaiTien.getSelectedItem().toString();
					try {
						donGia = Integer.parseInt(txtTiGia.getText());
					}catch(Exception e) {
						JOptionPane.showMessageDialog(rootPane, "Hay nhap ti gia hop le");
						return;
					}
					if(rdbMua.isSelected())
						mua = true;
					gd = new GiaoDichTienTe(ma, ngay, donGia, soLuong, loai, mua);
					dsGDTien.add((GiaoDichTienTe) gd);
				}
				
				JSONParser jsPar = new JSONParser();
				JSONObject jsObj = null;
				JSONArray jsArrGDVang = null;
				JSONArray jsArrGDTien = null;
				File file = new File("giaodich.json");
				
				if(file.isFile()) {
					try {
						jsObj = (JSONObject) jsPar.parse(new FileReader(file));
						jsArrGDVang = (JSONArray) jsObj.get("vangs");
						jsArrGDTien = (JSONArray) jsObj.get("tiens");
					} catch (IOException | ParseException e) {
						e.printStackTrace();
					}
				}else {
					jsObj = new JSONObject();
					jsArrGDVang = new JSONArray();
					jsArrGDTien = new JSONArray();
				}
				for(GiaoDich gdv:dsGDVang) {
					JSONObject jsObjVang = new JSONObject();
					jsObjVang.put("ngay", gdv.getNgay());
					jsObjVang.put("ma", gdv.getMa());
					jsObjVang.put("dongia", gdv.getDonGia());
					jsObjVang.put("loai", gdv.getLoai());
					jsObjVang.put("soluong", gdv.getSoLuong());
					jsArrGDVang.add(jsObjVang);
				}
				for(GiaoDichTienTe gdt:dsGDTien) {
					JSONObject jsObjTien = new JSONObject();
					jsObjTien.put("ngay", gdt.getNgay());
					jsObjTien.put("ma", gdt.getMa());
					jsObjTien.put("dongia", gdt.getDonGia());
					jsObjTien.put("mua", gdt.isMua());
					jsObjTien.put("loai", gdt.getLoai());
					jsObjTien.put("soluong", gdt.getSoLuong());
					jsArrGDTien.add(jsObjTien);
				}
				jsObj.put("vangs", jsArrGDVang);
				jsObj.put("tiens", jsArrGDTien);
				
				FileWriter fw;
				try {
					fw = new FileWriter(file);
					fw.write(jsObj.toJSONString());
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				dsGDVang.clear();
				dsGDTien.clear();
			}
		});
		btnNewButton.setBounds(318, 258, 89, 23);
		contentPane.add(btnNewButton);
	}
}
