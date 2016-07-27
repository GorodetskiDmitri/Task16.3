package by.epam.concurrent.synchronizers.countDownLatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

import org.apache.log4j.Logger;

public class CountDownLatchDemo {
	private static final Logger logger = Logger.getRootLogger();
	private CountDownLatch countDownLatch = new CountDownLatch(5);
	
	public void useShareResource() throws InterruptedException {
		this.doAction1();
		countDownLatch.countDown();
		countDownLatch.await();
		this.doAction2();
	}
	
	public void doAction1() throws InterruptedException {
		logger.debug(Thread.currentThread().getName() + " start action 1.");
		
		Random random = new Random();
		int time = random.nextInt(2000);
		Thread.sleep(time);
		
		logger.debug(Thread.currentThread().getName() + " finish action 1 after " + time + " ms.");
	}
	
	public void doAction2() throws InterruptedException {
		logger.debug(Thread.currentThread().getName() + " start action 2.");
		
		Random random = new Random();
		int time = random.nextInt(2000);
		Thread.sleep(time);
		
		logger.debug(Thread.currentThread().getName() + " finish action 2 after " + time + " ms.");
	}
}
