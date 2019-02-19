package javacore;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class TestClass {
	public static void main(String[] args) {
		String str="（&& 生态养殖类";
		String stringFilter = StringFilter(str);
		System.out.println(stringFilter);
	}
	
	 public static String StringFilter(String str) throws PatternSyntaxException { 
		// 只允许字母和数字 // String regEx ="[^a-zA-Z0-9]"; 
		// 清除掉所有特殊字符 
		String regEx="[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]"; 
		Pattern p = Pattern.compile(regEx); 
		Matcher m = p.matcher(str);
		return m.replaceAll("").trim();
		} 
	
	
	 
}
