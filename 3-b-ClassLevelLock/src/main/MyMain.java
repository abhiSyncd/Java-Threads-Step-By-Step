package main;

public class MyMain {
	public static void main(String[] args) throws InterruptedException {

		Runnable r1 = new MyRunnable();
		Runnable r2 = new MyRunnable();
		Runnable r3 = new MyRunnable();

		Thread thread1 = new Thread(r1, "Thread1");
		Thread thread2 = new Thread(r2, "Thread2");
		Thread thread3 = new Thread(r3, "Thread3");

		thread1.start();
		thread2.start();
		thread3.start();

		System.out.println("Main Thread");
	}

}

/**
  Main Thread
  
  Thread1-->My
  Thread1-->Name
  Thread1-->is
  Thread1-->Abhishek
  
  Thread3-->My
  Thread3-->Name
  Thread3-->is
  Thread3-->Abhishek
  
  Thread2-->My
  Thread2-->Name
  Thread2-->is
  Thread2-->Abhishek
  
  Note : 
  Since, Haven't used join() method, 
  So, Sequential execution of thread(Thread1->Thread2->Thread3) is not maintained

 */


