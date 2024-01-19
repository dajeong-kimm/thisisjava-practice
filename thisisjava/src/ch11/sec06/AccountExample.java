package ch11.sec06;

public class AccountExample {
	public static void main(String[] args) {
		Account account = new Account();
		
		account.deposit(10000);
		System.out.println("deposit money: "+account.getBalance());
		
		try {
			account.withdraw(30000);
		}catch(InsufficientException e){
			String message = e.getMessage();
			System.out.println(message);
			
		}
	}

}
