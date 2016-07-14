package by.epam.concurrent.synchronizers.exchanger;

import java.util.Random;
import java.util.concurrent.Exchanger;

import org.apache.log4j.Logger;

public class ExchangerDemo {
	private static final Logger logger = Logger.getRootLogger();
	private Exchanger<Integer> exchanger = new Exchanger<>();
	
	public void useShareResource() throws InterruptedException {
		Random random = new Random();
		int time = random.nextInt(2000); 
		logger.debug(Thread.currentThread().getName() + " using shared resource during " + time + " ms.");
		Thread.sleep(time);
		
		int value1 = new Random().nextInt(100);
		logger.debug(Thread.currentThread().getName() + " ready to exchange value " + value1);
		
		int value2 = exchanger.exchange(value1);
		logger.debug(Thread.currentThread().getName() + " get the exchanged value " + value2);
		
		time = random.nextInt(2000); 
		logger.debug(Thread.currentThread().getName() + " using shared resource during " + time + " ms.");
		Thread.sleep(time);
		
		logger.debug(Thread.currentThread().getName() + " finish using share resource.");
	}
}
