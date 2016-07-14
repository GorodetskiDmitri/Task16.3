package by.epam.concurrent.locks.readWriteLock;

public class ThreadDemo implements Runnable {
	
	private volatile boolean stop = false;
	private boolean isReading;
	private ReadWriteLockDemo readWriteLockDemo;
		
	public ThreadDemo(ReadWriteLockDemo readWriteLockDemo, boolean isReading) {
		this.readWriteLockDemo = readWriteLockDemo;
		this.isReading = isReading;
	}
	
	@Override
	public void run() {
		if (isReading) {
			while (!stop) {
				try {
					readWriteLockDemo.read();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} else {
			while (!stop) {
				try {
					readWriteLockDemo.write();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void stopRunning() {
		stop = true;
	}
}
