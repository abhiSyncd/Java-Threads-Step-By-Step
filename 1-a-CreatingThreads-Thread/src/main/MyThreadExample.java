package main;

public class MyThreadExample {

	public static void main(String[] args) {
		
		Thread thread = new MyThread();
		thread.start(); // Run the thread Asynchronously i.e Main Thread is Not Blocked
		
		System.out.println("Main Thread : " + Thread.currentThread().getName());
	}
}

