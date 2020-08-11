package main;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class MyMain {
	public static void main(String[] args) {

		final  CyclicBarrier checkPoint  = new CyclicBarrier(3 , new Runnable() {
			@Override
			public void run() {
				//Executed when all Bikers(Threads) reaches the Checkpoint(Barrier)
				System.out.println("All Bikers Arrived at checkpoint,Let's refill the Petrol");  
			}
		});
		
		Runnable biker1 = new Biker(checkPoint);
		Runnable biker2 = new Biker(checkPoint);
		Runnable biker3 = new Biker(checkPoint);
		
		Thread bThread1 = new Thread(biker1,"Biker1");
		Thread bThread2 = new Thread(biker2,"Biker2");
		Thread bThread3 = new Thread(biker3,"Biker3");
		
		
		bThread1.start();
		bThread2.start();
		bThread3.start();
	}

}
