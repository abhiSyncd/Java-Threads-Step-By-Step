package main;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Biker implements Runnable {

	private final CyclicBarrier checkPoint;

	public Biker(CyclicBarrier checkPoint) {
		this.checkPoint = checkPoint;
	}

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " has left Manali.");
			
			checkPoint.await();                                                    
			System.out.println(Thread.currentThread().getName() + " Reached 1st Checkpoint.");

			checkPoint.await();                                                   
			System.out.println(Thread.currentThread().getName() + " Reached 2nd Checkpiont.");
			
			checkPoint.await();                                                   
			System.out.println(Thread.currentThread().getName() + " has reached LEH!!!");
			
			
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

}