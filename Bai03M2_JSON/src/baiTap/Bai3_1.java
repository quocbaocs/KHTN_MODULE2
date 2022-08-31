package baiTap;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Bai3_1 {
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		JSONParser jsPaser = new JSONParser();
		JSONObject jsObj = (JSONObject) jsPaser.parse(new FileReader("src/baiTap/QLCT_1.json"));
		JSONArray jsArrTT = (JSONArray) jsObj.get("CONG_TY");
		JSONArray jsArrDV = (JSONArray) jsObj.get("CONG_TY");

		
		JSONObject jsObjTT = (JSONObject) jsArrTT.get(0);
		JSONObject jsObjDV = (JSONObject) jsArr.get(0);
		System.out.println("Thông tin công ty");
		System.out.println("Tên công ty: " + jsObjTT.get("Dia_chi"));
		System.out.println("Địa chỉ: " +jsObjTT.get("Dia_chi"));
		System.out.println("Mail: "+jsObjTT.get("Mail"));
		System.out.println("Điện thoại: "+jsObjTT.get("Dien_thoai"));
		System.out.println("Tổng số đơn vị: "+jsObjTT.get("Dia_chi"));
		System.out.println("Tổng số nhân viên: "+jsObjTT.get("Dia_chi"));
		System.out.println("*****Thông tin đơn vị******");
		System.out.println("Tên đơn vị: ");
		System.out.println("Số nhân viên: ");
	}

}
