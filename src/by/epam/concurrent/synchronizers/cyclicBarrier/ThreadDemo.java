package by.epam.concurrent.synchronizers.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;

public class ThreadDemo implements Runnable {
	
	private CiclicBarrierDemo cyclicBarrierDemo;
	
	public ThreadDemo(CiclicBarrierDemo cyclicBarrierDemo) {
		this.cyclicBarrierDemo = cyclicBarrierDemo;
	}
	
	@Override
	public void run() {
		try {
			cyclicBarrierDemo.useShareResource();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
