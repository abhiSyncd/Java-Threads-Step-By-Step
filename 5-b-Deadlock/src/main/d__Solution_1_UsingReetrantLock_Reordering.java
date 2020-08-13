package main;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class d__Solution_1_UsingReetrantLock_Reordering {

	public static void main(String[] args) {

		final Object resource1 = "resource1";
		final Object resource2 = "resource2";

		Lock lock1 = new ReentrantLock();
		Lock lock2 = new ReentrantLock();

		Thread t1 = new Thread(() -> {
			try {
				lock1.lock();
				System.out.println("Thread 1 locked: " + resource1);
				try {
					lock2.lock();
					System.out.println("Thread 1 locked: " + resource2);
				} finally {
					lock2.unlock();
				}
			} finally {
				lock1.unlock();
			}
		});

		Thread t2 = new Thread(() -> {
			try {
				lock1.lock();
				System.out.println("Thread 2 locked: " + resource2);
				try {
					lock2.lock();
					System.out.println("Thread 2 locked: " + resource1);
				} finally {
					lock2.unlock();
				}
			} finally {
				lock1.unlock();
			}
		});

		t1.start();
		t2.start();

	}

}
