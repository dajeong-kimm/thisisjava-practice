package ch14.sec09;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableExecuteExample {

	public static void main(String[] args) {
		String[][] mails = new String[1000][3];
		for(int i=0;i<mails.length;i++) {
			mails[i][0] = "admin@my.com";
			mails[i][1] = "member"+i+"@my.com";
			mails[i][2] = "신상품 입고";
		}
		
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		
		for(int i=0;i<1000;i++) {
			final int idx = i;
			executorService.execute(new Runnable() {
				@Override
				public void run() {
					Thread thread = Thread.currentThread();
					String from = mails[idx][0];
					System.out.println(thread.getName());
					
				}
			});
		}
		executorService.shutdown();

	}

}
