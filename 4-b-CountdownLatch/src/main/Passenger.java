package main;

import java.util.concurrent.CountDownLatch;

public class Passenger implements Runnable {

	private final CountDownLatch latch;

	public Passenger(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " reached.");
	    latch.countDown(); //reduce count of CountDownLatch by 1    
	}

}
