package ch09.sec07;

public class Home {
	
	private RemoteControl rc = new RemoteControl() {
		@Override
		public void turnOn() {
			System.out.println("Turn on the TV");
		}
		@Override
		public void turnOff() {
			System.out.println("Turn off the TV");
		}
	};
	
	public void use1() {
		rc.turnOn();
		rc.turnOff();
	}
	
	
	public void use2() {
		RemoteControl rc = new RemoteControl() {
			@Override
			public void turnOn() {
				System.out.println("Turn on air");
			}
			public void turnOff() {
				System.out.println("Turn off air");
			}
		};
		
		rc.turnOn();
		rc.turnOff();
	}
	
	public void use3(RemoteControl rc) {
		rc.turnOn();
		rc.turnOff();
	}

}
