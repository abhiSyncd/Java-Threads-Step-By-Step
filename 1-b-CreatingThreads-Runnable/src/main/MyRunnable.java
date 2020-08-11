package main;

public class MyRunnable implements Runnable {
	@Override
	public void run() {
	  try {
	     Thread.sleep(2000L); // Perform Long Running Task
	     System.out.println("Response from Database from seperate thread : " + Thread.currentThread().getName());
          } catch (InterruptedException e) {
	     e.printStackTrace();
	    }	
	}
}
