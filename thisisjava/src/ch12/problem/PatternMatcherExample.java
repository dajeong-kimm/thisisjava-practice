package ch12.problem;

import java.util.regex.Pattern;

public class PatternMatcherExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String id = "5Angel1004";
		String regExp = "[a-zA-Z][a-zA-Z0-9]{7,11}";
		boolean isMatch = Pattern.matches(regExp, id);
		
		if(isMatch) {
			System.out.println("ID ok");
		}else {
			System.out.println("Not allow use");
		}

	}

}
