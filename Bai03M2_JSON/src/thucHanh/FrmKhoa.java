package thucHanh;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FrmKhoa extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		setTitle("Doc ghi DS Khoa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 23, 384, 124);
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
		
		JLabel lblNewLabel = new JLabel("M\u00E3 khoa");
		lblNewLabel.setBounds(62, 207, 86, 14);
		contentPane.add(lblNewLabel);
		
		txtMaKH = new JTextField();
		txtMaKH.setBounds(158, 204, 86, 20);
		contentPane.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EAn khoa");
		lblNewLabel_1.setBounds(62, 244, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		txtTenKH = new JTextField();
		txtTenKH.setBounds(158, 241, 208, 20);
		contentPane.add(txtTenKH);
		txtTenKH.setColumns(10);
		
		JButton btnGhi = new JButton("Ghi");
		btnGhi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File("dskhoa3.json");
				JSONParser jsPar = new JSONParser();
				JSONObject jsObj = null;
				JSONArray jsArr = null;
				if(file.isFile()) {
					try {
						//co tap tin thi phan tich tu tap tin
						jsObj = (JSONObject) jsPar.parse(new FileReader(file,Charset.forName("utf-8")));
						jsArr = (JSONArray) jsObj.get("dskhoa");
					} catch (IOException | ParseException e1) {
						e1.printStackTrace();
					}
				}else {
					//chua co tap tin thi tao moi
					jsObj = new JSONObject();
					jsArr = new JSONArray();
				}

				String makh, tenkh;
				makh = txtMaKH.getText();
				tenkh = txtTenKH.getText();
				if(makh.isEmpty() || tenkh.isEmpty()) {
					JOptionPane.showMessageDialog(rootPane, "Vui long nhap du lieu day du");
					txtMaKH.grabFocus();
					return;
				}
				JSONObject jsObj2 = new JSONObject();
				jsObj2.put("makh", makh);
				jsObj2.put("tenkh", tenkh);
				
				jsArr.add(jsObj2);
				
				jsObj.put("dskhoa", jsArr);

				try {
					FileWriter fw = new FileWriter(file,Charset.forName("utf-8"));
					fw.write(jsObj.toJSONString());
					fw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
			
		});
		btnGhi.setBounds(169, 288, 89, 23);
		contentPane.add(btnGhi);
		
		JButton btnDoc = new JButton("\u0110\u1ECDc");
		btnDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				dtm.setRowCount(0);
				
				JSONParser jsPar = new JSONParser();
				try {
					Path path = Paths.get("dskhoa3.json");
					if(!Files.exists(path)) {
						JOptionPane.showMessageDialog(rootPane, "Tap tin dskhoa3.json chua co");
						return;
					}
					JSONObject jsObj = (JSONObject) jsPar.parse(new FileReader("dskhoa3.json",Charset.forName("utf-8")));
					JSONArray jsArr = (JSONArray) jsObj.get("dskhoa");
					String makh, tenkh;
					for(int i=0; i<jsArr.size(); i++) {
						JSONObject jsObj2 = (JSONObject) jsArr.get(i);
						makh = jsObj2.get("makh").toString();
						tenkh = jsObj2.get("tenkh").toString();
						dtm.addRow(new String[] {makh,tenkh});
					}
				} catch (ParseException | IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnDoc.setBounds(297, 158, 89, 23);
		contentPane.add(btnDoc);
	}
}
