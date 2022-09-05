package thucHanh;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DocDsKhoa {
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		// Tạo ra bộ xây dựng tài liệu mới
		DocumentBuilder db = dbf.newDocumentBuilder();

		// Phân tích
		Document doc = db.parse(new File("dskhoa.xml"));

		NodeList nodeList1 = doc.getElementsByTagName("khoa");

		for (int i = 0; i < nodeList1.getLength(); i++) {
			Node node1 = nodeList1.item(i);
			NodeList nodeList2 = node1.getChildNodes();
			String tk = "", mk = "";
			for (int j = 0; j < nodeList2.getLength(); j++) {
				Node node2 = nodeList2.item(j);
				if (node2.getNodeName().equals("makh")) {
					mk = node2.getTextContent();
				} else {
					tk = node2.getTextContent();
				}
				System.out.println(tk + " - " + mk);
			}
		}

	}

}
