package ch12.sec05;

import java.util.StringTokenizer;

public class StringTokenizerExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String data1 = "apple&banana,carrot";
		String[] arr = data1.split("&|,");
		for (String token : arr) {
			System.out.println(token);
		}
		System.out.println();
		
		String data2 = "홍길동/이수홍/박연수";
		StringTokenizer st = new StringTokenizer(data2,"/");
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.println(token);
		}

	}

}