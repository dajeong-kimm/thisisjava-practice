package ch09.sec07;

public class Car {
	private Tire tire1 = new Tire();
	
	private Tire tire2 = new Tire() {
		@Override
		public void roll() {
			System.out.println("anonymous child Tire object 1");
		}
	};
	
	public void run1() {
		tire1.roll();
		tire2.roll();
	}
	
	
	public void run2() {
		Tire tire = new Tire() {
			@Override
			public void roll() {
				System.out.println("anonymous child Tire object 2");
			}
		};
		tire.roll();
	}
	
	public void run3(Tire tire) {
		tire.roll();
	}

}
