package ch12.sec07;

import java.util.Arrays;
import java.util.Random;

public class RandomExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] selectNumber = new int[6];
		Random random = new Random(3);
		System.out.println("select number: ");
		for(int i=0;i<6;i++) {
			selectNumber[i] = random.nextInt(45) + 1;
			System.out.print(selectNumber[i] + " ");
		}
		System.out.println();
		
		
		int[] winningNumber = new int[6];
		random = new Random(5);
		System.out.println("winning number: ");
		for(int i=0;i<6;i++) {
			winningNumber[i] = random.nextInt(45)+1;
			System.out.print(winningNumber[i] + " ");
		}
		System.out.println();
		
		Arrays.sort(selectNumber);
		Arrays.sort(winningNumber);
		boolean result = Arrays.equals(selectNumber, winningNumber);
		System.out.println("winning or not: ");
		if(result) {
			System.out.println("You've won.");
		}else {
			System.out.println("You didn't win.");
		}
		

	}

}
