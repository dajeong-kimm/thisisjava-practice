package ch13.sec02;

public class GenericExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Box box1 = new Box();
		box1.content = "100";
		
		Box box2 = new Box();
		box2.content = "100";
		
		Box box3 = new Box();
		box3.content = 100;
		
		boolean result = box1.compare(box2);
		System.out.println("result1: " + result);
		
		boolean result2 = box1.compare(box3);
		System.out.println("result2: "+result2);

	}

}
