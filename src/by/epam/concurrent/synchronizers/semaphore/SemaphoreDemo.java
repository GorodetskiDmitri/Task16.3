package by.epam.concurrent.synchronizers.semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;

import org.apache.log4j.Logger;

public class SemaphoreDemo {
	
	private static final Logger logger = Logger.getRootLogger();
	private Semaphore semaphore = new Semaphore(3);
	
	public void useShareResource() throws InterruptedException {
		logger.debug(Thread.currentThread().getName() + " try to use shared resource.");
		semaphore.acquire();
		
		Random random = new Random();
		int time = random.nextInt(2000); 
		logger.debug(Thread.currentThread().getName() + " using shared resource during " + time + " ms.");
		Thread.sleep(time);
		
		semaphore.release();
		logger.debug(Thread.currentThread().getName() + " finish using share resource.");
	}
}
