package main;

public class MyMain {

	public static void main(String[] args) throws InterruptedException {

		Runnable runnable = () -> {
			String[] array = { "My", "Name", "is", "Abhishek" };

			for (String str : array) {
				try {
					Thread.sleep(2000L);
					System.out.println(Thread.currentThread().getName() + "-->" + str);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Thread thread1 = new Thread(runnable, "Thread1");
		Thread thread2 = new Thread(runnable, "Thread2");
		Thread thread3 = new Thread(runnable, "Thread3");

		thread1.start();
		thread1.join(); // Start thread2, once thread1 is finished
		thread2.start();
		thread2.join(); // Start thread3, once thread1 is finished
		thread3.start();
		thread3.join(); // Start Main Thread,once thread 3 is finished

		System.out.println("Main Thread");

	}
}
