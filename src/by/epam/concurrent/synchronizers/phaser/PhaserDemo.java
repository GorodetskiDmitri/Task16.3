package by.epam.concurrent.synchronizers.phaser;

import java.util.Random;
import java.util.concurrent.Phaser;

import org.apache.log4j.Logger;

public class PhaserDemo {
	private static final Logger logger = Logger.getRootLogger();
	private Phaser phaser = new Phaser(5);
	
	public void useShareResource() throws InterruptedException {
		logger.debug(Thread.currentThread().getName() + " start to use shared resource.");
		
		Random random = new Random();
		int time = random.nextInt(2000); 
		logger.debug(Thread.currentThread().getName() + " using shared resource during " + time + " ms.");
		Thread.sleep(time);
		
		logger.debug(Thread.currentThread().getName() + " reachs first point and wait others.");
		phaser.arriveAndAwaitAdvance();
		
		time = random.nextInt(2000); 
		logger.debug(Thread.currentThread().getName() + " continue to use shared resource during " + time + " ms.");
		Thread.sleep(time);
		
		logger.debug(Thread.currentThread().getName() + " reachs second point and continue.");
		phaser.arrive();
		
		time = random.nextInt(2000); 
		logger.debug(Thread.currentThread().getName() + " continue to use shared resource during " + time + " ms.");
		Thread.sleep(time);
		
		logger.debug(Thread.currentThread().getName() + " finish using share resource.");
	}
}
