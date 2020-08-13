package main;

public class MyMain {

	public static void main(String[] args) {

		final Object resource1 = "resource1";
		final Object resource2 = "resource2";

		Thread t1 = new Thread(() -> {
			synchronized (resource1) {
				System.out.println("Thread 1: locked " + resource1);
				synchronized (resource2) {
					System.out.println("Thread 1: locked " + resource2);
				}
			}

		});

		Thread t2 = new Thread(() -> {
			synchronized (resource2) {
				System.out.println("Thread 2: locked " + resource2);
				synchronized (resource1) {
					System.out.println("Thread 2: locked " + resource1);
				}
			}

		});

		t1.start();
		t2.start();

	}
}

  // Ex.2)https://gist.github.com/jirkapinkas/ce1285df9a06d7ba094eb78997942563
