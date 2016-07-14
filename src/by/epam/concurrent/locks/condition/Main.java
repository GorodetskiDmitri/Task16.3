package by.epam.concurrent.locks.condition;

public class Main {

	public static void main(String[] args) {
		ConditionDemo concurrentObject = new ConditionDemo();
		
		ThreadDemo t1 = new ThreadDemo(concurrentObject, 1);
		ThreadDemo t2 = new ThreadDemo(concurrentObject, 2);
		
		new Thread(t1).start();
		new Thread(t2).start();
		
		try {
			Thread.sleep(5000);
			t1.stopRunning();
			t2.stopRunning();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
