package by.epam.concurrent.locks.readWriteLock;

public class Main {

	public static void main(String[] args) {
		ReadWriteLockDemo concurrentObject = new ReadWriteLockDemo();
		
		ThreadDemo t1 = new ThreadDemo(concurrentObject, true);
		ThreadDemo t2 = new ThreadDemo(concurrentObject, true);
		ThreadDemo t3 = new ThreadDemo(concurrentObject, false);
		ThreadDemo t4 = new ThreadDemo(concurrentObject, false);
		ThreadDemo t5 = new ThreadDemo(concurrentObject, true);
		
		new Thread(t1).start();
		new Thread(t2).start();
		new Thread(t3).start();
		new Thread(t4).start();
		new Thread(t5).start();
		
		try {
			Thread.sleep(5000);
			t1.stopRunning();
			t2.stopRunning();
			t3.stopRunning();
			t4.stopRunning();
			t5.stopRunning();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
