package by.epam.concurrent.synchronizers.cyclicBarrier;

public class Main {

	public static void main(String[] args) {
		CiclicBarrierDemo concurrentObject = new CiclicBarrierDemo();
		
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
	}

}
