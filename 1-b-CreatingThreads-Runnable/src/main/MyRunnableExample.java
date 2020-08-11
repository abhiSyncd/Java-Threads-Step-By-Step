package main;

public class MyRunnableExample {
	public static void main(String[] args) throws InterruptedException {

		Runnable runnable = new MyRunnable();
		Thread thread1 = new Thread(runnable, "Thread 1");

		thread1.start(); // Run the thread Asynchronously, I.e Main Thread is not blocke
        
		System.out.println("Main Thread : " + Thread.currentThread().getName());
	}
}
