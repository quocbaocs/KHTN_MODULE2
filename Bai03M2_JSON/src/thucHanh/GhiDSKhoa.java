package thucHanh;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class GhiDSKhoa {
	public static void main(String[] args) throws IOException {
		//Tạo các đối tượng
		JSONObject jsObj1 = new JSONObject();
		jsObj1.put("makh", "AV");
		jsObj1.put("tenkh", "Anh Van");
		
		JSONObject jsObj2 = new JSONObject();
		jsObj2.put("makh", "TH");
		jsObj2.put("tenkh", "Tin Học");
		
		JSONObject jsObj3 = new JSONObject();
		jsObj3.put("makh", "VL");
		jsObj3.put("tenkh", "Vật Lí");
		
		//tạo mảng các đối tượng khoa
		JSONArray jsArr = new JSONArray();
		jsArr.add(jsObj1);
		jsArr.add(jsObj2);
		jsArr.add(jsObj3);
		
		//Tạo đối tượng json
		JSONObject jsObj = new JSONObject();
		jsObj.put("dskhoa",jsArr);
		
		//Ghi đối tượng ra tập tin
//		FileWriter fw = new FileWriter("dskhoa2.json");
		BufferedWriter fw = new BufferedWriter(new FileWriter("dskhoa2.json"));
		
		fw.write(jsObj.toJSONString());
		fw.close();
	}

}
