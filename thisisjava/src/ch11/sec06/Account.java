package ch11.sec06;

public class Account {
	private long balance;
	
	public Account() {}
	
	public long getBalance() {
		return balance;
	}
	
	public void deposit(int money) {
		balance += money;
	}
	
	public void withdraw(int money) throws InsufficientException{
		if(balance < money) {
			throw new InsufficientException("a lack of balance: "+(money-balance));
		}
		
		balance -= money;
	}

}
