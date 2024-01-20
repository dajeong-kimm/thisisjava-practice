package ch12.problem;

import java.util.HashSet;

public class StudentExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Student> hashSet = new HashSet<Student>();
		
		hashSet.add(new Student("1"));
		hashSet.add(new Student("2"));
		hashSet.add(new Student("2"));
		
		System.out.println("저장된 Student 수: "+hashSet.size());
	}

}
