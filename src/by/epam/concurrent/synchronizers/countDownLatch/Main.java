package by.epam.concurrent.synchronizers.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class Main {
	
	public static void main(String[] args) {
		CountDownLatchDemo concurrentObject = new CountDownLatchDemo();
		CountDownLatch countDownLatch = concurrentObject.getCountDownLatch();
		
		ThreadDemo t1 = new ThreadDemo(concurrentObject);
		ThreadDemo t2 = new ThreadDemo(concurrentObject);
		ThreadDemo t3 = new ThreadDemo(concurrentObject);
		ThreadDemo t4 = new ThreadDemo(concurrentObject);
		ThreadDemo t5 = new ThreadDemo(concurrentObject);
		
		new Thread(t1).start();
		new Thread(t2).start();
		new Thread(t3).start();
		new Thread(t4).start();
		new Thread(t5).start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		countDownLatch.countDown();
	}

}
