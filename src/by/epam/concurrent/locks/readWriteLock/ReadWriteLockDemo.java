package by.epam.concurrent.locks.readWriteLock;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.log4j.Logger;

public class ReadWriteLockDemo {
	
	private static final Logger logger = Logger.getRootLogger();
	private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	
	public void read() throws InterruptedException {
		logger.debug(Thread.currentThread().getName() + " try to read.");
		readWriteLock.readLock().lock();
		
		Random random = new Random();
		int time = random.nextInt(2000); 
		logger.debug(Thread.currentThread().getName() + " do READ action during " + time + " ms.");
		Thread.sleep(time);
		
		readWriteLock.readLock().unlock();
		logger.debug(Thread.currentThread().getName() + " finish reading.");
	}
	
	public void write() throws InterruptedException {
		logger.debug(Thread.currentThread().getName() + " try to write.");
		readWriteLock.writeLock().lock();
		
		Random random = new Random();
		int time = random.nextInt(2000); 
		logger.debug(Thread.currentThread().getName() + " do WRITE action during " + time + " ms.");
		Thread.sleep(time);
		
		readWriteLock.writeLock().unlock();
		logger.debug(Thread.currentThread().getName() + " finish writing.");
	}
}
