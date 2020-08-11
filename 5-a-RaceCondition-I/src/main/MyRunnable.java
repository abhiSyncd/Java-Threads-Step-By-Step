package main;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class MyRunnable implements Runnable {

	public int count;

	
	//-------------------------- Code to Generate Race Condition -----------------------
	
	@Override
	public void run() {

		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(100L);
				count++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println(Thread.currentThread().getName() + " Final Count ->" + this.count);
	}
}

/**
 
 //--------------------   Prevention I - using Synchronized Method -------------------------------
   
    private int count;

	@Override
	public synchronized void run() {

		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(100L);
				count++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " Final Count ->" + count);
	}
	
	
//--------------------   Prevention Way II - using Synchronized Block/Statement -------------------------------
	 
	 
    private volatile int count;

	@Override
	public void run() {

		synchronized (this) {
			for (int i = 0; i < 5; i++) {
				try {
					Thread.sleep(100L);
					count++;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + " Final Count ->" + this.count);
		}
	}
	
	
//--------------------   Prevention Way III - using Reentrant Lock  -------------------------------
		
		
    private volatile int count;

	ReentrantLock lock = new ReentrantLock();

	@Override
	public void run() {
		try {
			lock.lock();

			for (int i = 0; i < 5; i++) {
				try {
					Thread.sleep(100L);
					count++;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} finally {
			System.out.println(Thread.currentThread().getName() + " Final Count ->" + this.count);
			lock.unlock();

		}
	}
 

 
 **/
