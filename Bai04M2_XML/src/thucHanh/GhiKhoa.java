package thucHanh;

import java.io.File;

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
import org.w3c.dom.Text;

public class GhiKhoa {
	public static void main(String[] args) throws ParserConfigurationException, TransformerException {
//		Tạo đối tượng XML DOM trong bộ nhớ

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();

		Document doc = db.newDocument();

		Element nodeKhoa = doc.createElement("khoa");
		doc.appendChild(nodeKhoa);

		Element nodeMaKH = doc.createElement("makh");
		nodeKhoa.appendChild(nodeMaKH);

		// Tạo text
		Text textMaKH = doc.createTextNode("AV");
		nodeMaKH.appendChild(textMaKH);

		// Tạo phần tử tiếp theo
		Element nodeTenKH = doc.createElement("tenkh");
		nodeKhoa.appendChild(nodeTenKH);

		Text textTenKH = doc.createTextNode("Anh Van");
		nodeKhoa.appendChild(textTenKH);

		// Biến đổi đối tượng XML DOM trọng bộ nhớ ra tập tin
		TransformerFactory tff = TransformerFactory.newInstance();
		Transformer tf = tff.newTransformer();

		// Tạo ra đối tượng nguồn document trong bộ nhớ

		Source source = new DOMSource(doc);
		Result result = new StreamResult(new File("khoa2.xml"));

		tf.transform(source, result);

	}

}
