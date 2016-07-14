package by.epam.concurrent.locks.lock;

public class Main {

	public static void main(String[] args) {
		LockDemo concurrentObject = new LockDemo();
		
		ThreadDemo t1 = new ThreadDemo(concurrentObject);
		ThreadDemo t2 = new ThreadDemo(concurrentObject);
		ThreadDemo t3 = new ThreadDemo(concurrentObject);
		ThreadDemo t4 = new ThreadDemo(concurrentObject);
		ThreadDemo t5 = new ThreadDemo(concurrentObject);
		
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
