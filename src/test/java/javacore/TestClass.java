package javacore;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class TestClass {
	public static void main(String[] args) {
		String str="��&& ��̬��ֳ��";
		String stringFilter = StringFilter(str);
		System.out.println(stringFilter);
	}
	
	 public static String StringFilter(String str) throws PatternSyntaxException { 
		// ֻ������ĸ������ // String regEx ="[^a-zA-Z0-9]"; 
		// ��������������ַ� 
		String regEx="[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~��@#��%����&*��������+|{}������������������������]"; 
		Pattern p = Pattern.compile(regEx); 
		Matcher m = p.matcher(str);
		return m.replaceAll("").trim();
		} 
	
	
	 
}
