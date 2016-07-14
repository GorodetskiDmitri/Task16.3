package by.epam.concurrent.locks.lock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;

public class LockDemo {
	
	private static final Logger logger = Logger.getRootLogger();
	private Lock lock = new ReentrantLock();
	
	public void useShareResource() throws InterruptedException {
		logger.debug(Thread.currentThread().getName() + " try to use shared resource.");
		lock.lock();
		
		Random random = new Random();
		int time = random.nextInt(2000); 
		logger.debug(Thread.currentThread().getName() + " using shared resource during " + time + " ms.");
		Thread.sleep(time);
		
		lock.unlock();
		logger.debug(Thread.currentThread().getName() + " finish using share resource.");
	}
}
