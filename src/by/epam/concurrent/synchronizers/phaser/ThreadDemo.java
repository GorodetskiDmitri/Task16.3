package by.epam.concurrent.synchronizers.phaser;

public class ThreadDemo implements Runnable {
	
	private volatile boolean stop = false;
	private PhaserDemo phaserDemo;
	
	public ThreadDemo(PhaserDemo phaserDemo) {
		this.phaserDemo = phaserDemo;
	}
	
	@Override
	public void run() {
		while (!stop) {
			try {
				phaserDemo.useShareResource();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void stopRunning() {
		stop = true;
	}
}
