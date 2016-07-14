package by.epam.concurrent.synchronizers.semaphore;

public class ThreadDemo implements Runnable {
	
	private volatile boolean stop = false;
	private SemaphoreDemo semaphore;
	
	public ThreadDemo(SemaphoreDemo semaphore) {
		this.semaphore = semaphore;
	}
	
	@Override
	public void run() {
		while (!stop) {
			try {
				semaphore.useShareResource();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void stopRunning() {
		stop = true;
	}
}
