package by.epam.concurrent.synchronizers.cyclicBarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import org.apache.log4j.Logger;

public class CiclicBarrierDemo {
	private static final Logger logger = Logger.getRootLogger();
	private CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
	
	public void useShareResource() throws InterruptedException, BrokenBarrierException {
		Thread.sleep(new Random().nextInt(2000));
		this.doAction1();
		Thread.sleep(new Random().nextInt(2000));
		this.doAction2();
	}
	
	public void doAction1() throws InterruptedException, BrokenBarrierException {
		logger.debug(Thread.currentThread().getName() + " start action 1.");
		
		Random random = new Random();
		int time = random.nextInt(2000);
		Thread.sleep(time);
		
		logger.debug(Thread.currentThread().getName() + " finish action 1 after " + time + " ms.");
		cyclicBarrier.await();
	}
	
	public void doAction2() throws InterruptedException {
		logger.debug(Thread.currentThread().getName() + " start action 2.");
		
		Random random = new Random();
		int time = random.nextInt(2000);
		Thread.sleep(time);
		
		logger.debug(Thread.currentThread().getName() + " finish action 2 after " + time + " ms.");
	}
}
