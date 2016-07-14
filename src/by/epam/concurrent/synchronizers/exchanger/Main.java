package by.epam.concurrent.synchronizers.exchanger;

public class Main {

	public static void main(String[] args) {
		ExchangerDemo concurrentObject = new ExchangerDemo();
		
		ThreadDemo t1 = new ThreadDemo(concurrentObject);
		ThreadDemo t2 = new ThreadDemo(concurrentObject);
		
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
