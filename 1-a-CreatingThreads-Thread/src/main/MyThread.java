package main;

public class MyThread extends Thread {
	public void run() {
		try {
		   Thread.sleep(2000L);
		   System.out.println("Response from Database from seperate thread : " + Thread.currentThread().getName());
		} catch (InterruptedException e) {
		   e.printStackTrace();
		}
	}
}
