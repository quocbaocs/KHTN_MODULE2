package thucHanh;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DocThongTinCaNhan {
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		// Tạo đối tượng phân tích

		JSONParser parser = new JSONParser();

		// Bước 2: phân tích từ tập tin thongtincanhan.json thành đối tượng JSON
		JSONObject jsObj = (JSONObject) parser.parse(new FileReader("thongtincanhan.json"));

		// BƯớc 3: đọc tên và trả về giá trị
//		String name, address;
//		long age;
//		List<String> courses;
//
//		name = jsObj.get("name").toString();
//		address = jsObj.get("address").toString();
//		age = (long) jsObj.get("age");
//		courses = (List<String>) jsObj.get("courses");
//
//		// Xuat ket qua ra man hinh
//		System.out.println("THONG TIN CA NHAN");
//		System.out.println("------------");
//		System.out.println("Ten : " + name);
//		System.out.println("Dia chi: " + address);
//		System.out.println("TUoi :" + age);
//		System.out.println("Hoc cac mon");
//		courses.stream().forEach(s -> System.out.println("\t" + s));
//
//		
		
		String name, address;
		int age;
		JSONArray courses;

		name = jsObj.get("name").toString();
		address = jsObj.get("address").toString();
		age = Integer.parseInt(jsObj.get("age").toString());
		courses = (JSONArray) jsObj.get("courses");

		// Xuat ket qua ra man hinh
		System.out.println("THONG TIN CA NHAN");
		System.out.println("------------");
		System.out.println("Ten : " + name);
		System.out.println("Dia chi: " + address);
		System.out.println("TUoi :" + age);
		System.out.println("Hoc cac mon");
		courses.forEach(s -> System.out.println("\t" + s));

	}

}
