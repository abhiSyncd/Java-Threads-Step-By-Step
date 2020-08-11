package main;

import java.util.concurrent.CountDownLatch;

public class MyMain {
	
	public static void main(String[] args) {

		final CountDownLatch latch = new CountDownLatch(3);
		
		Runnable passenger1 = new Passenger(latch);
		Runnable passenger2 = new Passenger(latch);
		Runnable passenger3 = new Passenger(latch);
		
		Thread pThread1 = new Thread(passenger1,"Thread1");
		Thread pThread2 = new Thread(passenger2,"Thread2");
		Thread pThread3 = new Thread(passenger3,"Thread3");
		
		
		pThread1.start();
		pThread2.start();
		pThread3.start();
		
		
		try {
			 latch.await();
			 System.out.println("Main Thread Resumes : All Passenger Boarded,Driver started the car");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}

}
