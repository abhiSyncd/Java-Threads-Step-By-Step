package main;

public class MyThread extends Thread {
	public void run() {
	  System.out.println("Response from Database from seperate thread : " + Thread.currentThread().getName());
	}
}
