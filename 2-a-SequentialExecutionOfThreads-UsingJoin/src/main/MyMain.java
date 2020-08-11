package main;

public class MyMain {

	public static void main(String[] args) throws InterruptedException {

		Runnable r = new MyRunnable();

		Thread thread1 = new Thread(r, "Thread1");
		Thread thread2 = new Thread(r, "Thread2");
		Thread thread3 = new Thread(r, "Thread3");

		thread1.start();
		thread1.join(); // Start thread2, once thread1 is finished
		thread2.start();
		thread2.join(); // Start thread3, once thread1 is finished
		thread3.start();
		thread3.join(); // Start Main Thread,once thread 3 is finished

		System.out.println("Main Thread");

	}
}

