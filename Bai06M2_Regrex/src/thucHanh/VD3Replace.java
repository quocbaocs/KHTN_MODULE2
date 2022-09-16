package thucHanh;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VD3Replace {
	
	
	public static void main2(String[] args) {
		String REGREX = "dog";
		String INPUT = "The dog say meow. " + " All dos say meow.";
		String REPLACE = "cat";
		Pattern pattern = Pattern.compile(REGREX);
		// Get all matcher object
		Matcher m = pattern.matcher(INPUT);
		INPUT = m.replaceAll(REPLACE);
		System.out.println(INPUT);
		
	}
}
