package thucHanh;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Vd2 {
	public static void main(String[] args) {
		List<String> ds = new ArrayList<>();
		ds.add("mai");
		ds.add("lan");
		ds.add("cuc");
		ds.add("truc");

		System.out.println("Xuat List ds ra man hinh");
		for (String s : ds) {
			System.out.println(s);
		}

		System.out.println("Xuat ra man hinh dung forEach");
		ds.forEach(s -> System.out.println(s));

		Map<String, String> td = new TreeMap<>();
		td.put("one", "Mot");
		td.put("two", "Hai");
		td.put("three", "Ba");
		td.put("four", "Bon");
		td.put("five", "Nam");
		td.put("six", "Sau");
		td.put("seven", "Bay");
		System.out.println("Xuat map td ra man hinh dung for");
		for (String key : td.keySet()) {
			System.out.println(key + " ->" + td.get(key));
		}
		System.out.println("Xuat map td ra man hinh dung forEach");
		td.forEach((key, value) -> System.out.println(key + "->" + value));

	}
}
