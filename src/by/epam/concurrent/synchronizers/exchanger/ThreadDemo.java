package by.epam.concurrent.synchronizers.exchanger;

public class ThreadDemo implements Runnable {
	
	private volatile boolean stop = false;
	private ExchangerDemo exchangerDemo;
	
	public ThreadDemo(ExchangerDemo exchangerDemo) {
		this.exchangerDemo = exchangerDemo;
	}
	
	@Override
	public void run() {
		while (!stop) {
			try {
				exchangerDemo.useShareResource();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void stopRunning() {
		stop = true;
	}
}
