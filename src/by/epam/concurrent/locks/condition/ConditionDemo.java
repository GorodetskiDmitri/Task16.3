package by.epam.concurrent.locks.condition;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;

public class ConditionDemo {
	private static final Logger logger = Logger.getRootLogger();
	private final Lock lock = new ReentrantLock();
	private Condition condition1 = lock.newCondition();
	private Condition condition2 = lock.newCondition();
	private boolean isCondition1Made = false;
	
	public void doAction1() {
		logger.debug(Thread.currentThread().getName() + " try to do action 1.");
		lock.lock();
		
		try {
			if (isCondition1Made) {
				condition2.await();
			}
			Random random = new Random();
			int time = random.nextInt(2000); 
			logger.debug(Thread.currentThread().getName() + " start to do action 1 and use shared resource during " + time + " ms.");
			Thread.sleep(time);
			
			isCondition1Made = true;
			logger.debug(Thread.currentThread().getName() + " has done action 1.");
			condition1.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void doAction2() {
		logger.debug(Thread.currentThread().getName() + " try to do action 2.");
		lock.lock();
		
		try {
			if (!isCondition1Made) {
				condition1.await();
			}
			Random random = new Random();
			int time = random.nextInt(2000); 
			logger.debug(Thread.currentThread().getName() + " start to do action 2 and use shared resource during " + time + " ms.");
			Thread.sleep(time);
			
			isCondition1Made = false;
			logger.debug(Thread.currentThread().getName() + " has done action 2.");
			condition2.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}
