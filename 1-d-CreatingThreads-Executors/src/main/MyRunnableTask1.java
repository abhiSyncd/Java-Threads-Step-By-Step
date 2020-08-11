package main;

public class MyRunnableTask1 implements Runnable {
	@Override
	public void run() {
		try {
			Thread.sleep(3000L);
			System.out.println("Task 1 completed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


