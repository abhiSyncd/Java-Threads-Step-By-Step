package main;

public class MyRunnableTask2 implements Runnable {
	@Override
	public void run() {
		try {
			Thread.sleep(2000L);
			System.out.println("Task 2 completed");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
