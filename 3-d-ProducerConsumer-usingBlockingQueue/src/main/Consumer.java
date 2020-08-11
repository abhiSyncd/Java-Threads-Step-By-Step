package main;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {

	private BlockingQueue sharedQ;

	public Consumer(BlockingQueue sharedQ) {
		super();
		this.sharedQ = sharedQ;
	}

	@Override
	public void run() {
		while (true) {
			try {
				TimeUnit.SECONDS.sleep(2);
				System.out.println("Consumed ->" + sharedQ.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
