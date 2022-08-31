package thucHanh;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;

public class GhiKhoa {
	public static void main(String[] args) throws IOException {
		// Bước 1: tạo đối tượng Json
		JSONObject jsObj = new JSONObject();

		// Bước 2: thêm từng cập tên: giá trị
		jsObj.put("makh", "AV");
		jsObj.put("tenkh", "Anh Van");

		// Bước 3 : Ghi đối tượng Json ra tập tin
		FileWriter fw = new FileWriter("khoa2.json");
		fw.write(jsObj.toJSONString());
		fw.close();
	}

}
