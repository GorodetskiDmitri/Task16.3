package by.epam.concurrent.synchronizers.countDownLatch;

public class ThreadDemo implements Runnable {
	
	private CountDownLatchDemo countDownDemo;
	
	public ThreadDemo(CountDownLatchDemo countDownLatchDemo) {
		this.countDownDemo = countDownLatchDemo;
	}
	
	@Override
	public void run() {
		try {
			countDownDemo.useShareResource();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
