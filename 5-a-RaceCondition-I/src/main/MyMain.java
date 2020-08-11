package main;


public class MyMain {
	public static void main(String[] args) throws InterruptedException {

		MyRunnable r = new MyRunnable();

		Thread thread1 = new Thread(r, "Thread1");
		Thread thread2 = new Thread(r, "Thread2");

		thread1.start();
		thread2.start();
		
		//Sequential Execution : First Execute thread1 than execute thread2
		thread1.join();
		thread2.join();
		
		System.out.println("Main Thread :" + " Total Number-of-Count count-variable is accessed ->" + r.count);

	}
}


