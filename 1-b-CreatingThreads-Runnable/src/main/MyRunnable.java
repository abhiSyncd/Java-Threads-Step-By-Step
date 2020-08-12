package main;

public class MyRunnable implements Runnable {
	@Override
	public void run() {
	     System.out.println("Response from Database from seperate thread : " + Thread.currentThread().getName());
	}
}
