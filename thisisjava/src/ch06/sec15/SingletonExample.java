package ch06.sec15;

public class SingletonExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Singleton obj1 = new Singleton(); 
		//compile error
		
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();
		
		if(obj1 == obj2) {
			System.out.println("same object");
		}
		else {
			System.out.println("different object");
		}

	}

}
