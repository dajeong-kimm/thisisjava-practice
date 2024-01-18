package ch09.problem;

public class Anonymous {
	
	Vehicle field = new Vehicle() {
		@Override
		public void run() {
			System.out.println("Taxi");
		}
	};
	
	void method1() {
		Vehicle localVar = new Vehicle() {
			@Override
			public void run() {
				System.out.println("Bus");
			}
		};
				
		localVar.run();
	}
	
	void method2(Vehicle v) {
		v.run();
	}

}
