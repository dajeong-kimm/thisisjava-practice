package ch09.sec07;

public class HomeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Home home = new Home();
		
		home.use1();
		
		home.use2();
		
		home.use3(new RemoteControl() {
			@Override
			public void turnOn(){
				System.out.println("Turn on the heating");
			}
			@Override
			public void turnOff() {
				System.out.println("Turn off the heating");
			}
		});

	}

}
