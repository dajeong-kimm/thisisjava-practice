package ch12.problem;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(LocalDateTime.now().
				until(LocalDateTime.of(LocalDateTime.now().getYear(), 12,31,0,0,0), ChronoUnit.DAYS));

	}

}
