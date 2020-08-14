package main;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class e__Solution_2_UsingReetrantLock_TryLock_with_Timeout {

	public static void main(String[] args) {

		final Object resource1 = "resource1";
		final Object resource2 = "resource2";

		Lock lock1 = new ReentrantLock();
		Lock lock2 = new ReentrantLock();

		Thread t1 = new Thread(() -> {
			try {
				if (lock1.tryLock(1, TimeUnit.SECONDS)) {
					System.out.println("Thread 1 locked: " + resource1);
					try {
						if (lock2.tryLock(1, TimeUnit.SECONDS)) {
							System.out.println("Thread 1 locked: " + resource2);
						}
					} finally {
						lock2.unlock();
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock1.unlock();
			}
		});

		Thread t2 = new Thread(() -> {
			try {
				if (lock1.tryLock(1, TimeUnit.SECONDS)) {
					System.out.println("Thread 2 locked: " + resource2);
					try {
						if (lock2.tryLock(1, TimeUnit.SECONDS)) {
							System.out.println("Thread 2 locked: " + resource1);
						}
					} finally {
						lock1.unlock();
					}

				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock2.unlock();
			}
		});

		t1.start();
		t2.start();

	}
}

/**
 * 
 *   Output : 
 *  
 *   Thread 1 locked: resource1
 *   Thread 1 locked: resource2
 *   Thread 2 locked: resource1
 *   Thread 2 locked: resource2
 *
 */ 
