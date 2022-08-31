package thucHanh;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DocKhoa {
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		//Bước 1: tạo đối tượng phân tích
		JSONParser parser = new JSONParser();

//		 Phân tích từ tập tin trả về đối tượng Json
		JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("khoa.json"));

//		Bước 3: Dọc tên trả về giá trị
		String mk, tk;
		mk = String.valueOf(jsonObject.get("makh"));
		tk = jsonObject.get("tenkh").toString();
		System.out.println(mk + " - " + tk);

	}

}
