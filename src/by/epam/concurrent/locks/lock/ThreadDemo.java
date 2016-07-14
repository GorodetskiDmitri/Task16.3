package by.epam.concurrent.locks.lock;

public class ThreadDemo implements Runnable {
	
	private volatile boolean stop = false;
	private LockDemo lockDemo;
	
	public ThreadDemo(LockDemo lockDemo) {
		this.lockDemo = lockDemo;
	}
	
	@Override
	public void run() {
		while (!stop) {
			try {
				lockDemo.useShareResource();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void stopRunning() {
		stop = true;
	}
}
