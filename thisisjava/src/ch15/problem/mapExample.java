package ch15.problem;

import java.util.HashMap;
import java.util.Map;

public class mapExample {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("blue", 98);
		map.put("hong", 86);
		map.put("white", 92);
		
		String name = null;
		int maxScore=0;
		int totalScore=0;
		
		for(Map.Entry<String, Integer> e : map.entrySet()) {
			int score = e.getValue();
			totalScore += score;
			
			if(e.getValue()>maxScore) {
				name = e.getKey();
				maxScore=e.getValue();
			}
		}
		double averageScore = (double) totalScore / map.size();
		
		System.out.printf("average score: %.1f\n",averageScore);
		System.out.println("max score: "+maxScore);
		System.out.println("ID of max score: "+name);

	}

}
