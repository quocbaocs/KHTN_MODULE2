package thucHanh;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Vd1 {
	public static void main(String[] args) {
		String regEx, input;
		regEx = "abc[";
		input = "abc";
		try {
			Pattern pt = Pattern.compile(regEx);
			Matcher mcMatcher = pt.matcher(input);
			if (mcMatcher.matches()) {
				System.out.println("Hop mau");
			} else {
				System.out.println("Khong hop mau");
			}
		} catch (PatternSyntaxException e) {
			System.out.println("Bi loi: " + e.getMessage());
		}

	}
	

}
