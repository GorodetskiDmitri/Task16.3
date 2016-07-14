package by.epam.concurrent.locks.condition;

public class ThreadDemo implements Runnable {
	
	private volatile boolean stop = false;
	private ConditionDemo conditionDemo;
	private int actionNum;
	
	public ThreadDemo(ConditionDemo conditionDemo, int actionNum) {
		this.conditionDemo = conditionDemo;
		this.actionNum = actionNum;
	}
	
	@Override
	public void run() {
		switch (actionNum) {
		case 1:
			while (!stop) {
				conditionDemo.doAction1();
			}
			break;
		case 2:
			while (!stop) {
				conditionDemo.doAction2();
			}
			break;
		}
	}
	
	public void stopRunning() {
		stop = true;
	}
}
