package thucHanh;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DocKhoa {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		// Tạo ra bộ xây dựng tài liệu mới
		DocumentBuilder db = dbf.newDocumentBuilder();

		// Phân tích
		Document doc = db.parse(new File("khoa.xml"));

		// Đọc phần tử gốc (rootNode)
		Element nutGoc = doc.getDocumentElement();

		System.out.println("Ten nut: " + nutGoc.getNodeName());
		System.out.println("Kieu nut: " + nutGoc.getNodeType());
		System.out.println("Gia tri: " + nutGoc.getNodeValue());
		System.out.println("Noi dung: " + nutGoc.getTextContent());// Lấy tất cả text của các nút con cháu

		// Doc cac nut con cua Node gốc - > trả về danh sách
		String mk = "", tk = "";
		NodeList dsNut = nutGoc.getChildNodes();
		for (int i = 0; i < dsNut.getLength(); i++) {
			Node nut = dsNut.item(i);
			if (nut.getNodeName().equals("makh")) {
				mk = nut.getTextContent();
			} else {
				tk = nut.getTextContent();
			}
		}
		System.out.println(mk + " - " + tk);
	}
}
