package main;

public class MyRunnable implements Runnable {
	@Override
	public void run() {

		String[] array = { "My", "Name", "is", "Abhishek" };

		for (String str : array) {
			try {
				Thread.sleep(2000L);
				System.out.println(Thread.currentThread().getName() + "-->" + str);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}



