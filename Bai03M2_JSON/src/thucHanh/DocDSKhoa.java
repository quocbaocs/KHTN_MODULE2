package thucHanh;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DocDSKhoa {
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		// Buoc 1: Tạo đối tượng phân tích
		JSONParser parser = new JSONParser();

		// Bước 2: phân tích từ tập tin json thành đối tượng JsonObject
		JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("khoa.json"));

		// Bước 3: đọc tên trả về giá trị
		JSONArray jsonArr = (JSONArray) jsonObject.get("dskhoa");

		// Duyệt qua các phần tử mảng
		String makh, tenkh;
//		for(int i=0; i <jsonArr.size(); i++) {
//			JSONObject jsObj2 = (JSONObject) jsonArr.get(i);
//			makh = jsObj2.get("makh").toString();
//			tenkh = jsObj2.get("tenkh").toString();
//			System.out.println(makh +" - "+tenkh);
//		}
//		
//		for(Object obj: jsonArr) {
//			JSONObject jsObj2 = (JSONObject) obj;
//			makh = jsObj2.get("makh").toString();
//			tenkh = jsObj2.get("tenkh").toString();
//			System.out.println(makh +" - "+tenkh);
//		}

		List<JSONObject> lst = (List<JSONObject>) jsonArr;
		lst.stream().forEach(obj -> System.out.println(obj.get("makh") + " - " + obj.get("tenkh")));

	}

}
