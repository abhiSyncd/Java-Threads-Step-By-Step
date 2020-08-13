package main;

public class a_Problem_UsingSynchronized {

	public static void main(String[] args) {

		final Object resource1 = "resource1";
		final Object resource2 = "resource2";

		Thread t1 = new Thread(() -> {
			synchronized (resource1) {
				System.out.println("Thread 1 locked: " + resource1);
				synchronized (resource2) {
					System.out.println("Thread 1 locked: " + resource2);
				}
			}

		});

		Thread t2 = new Thread(() -> {
			synchronized (resource2) {
				System.out.println("Thread 2 locked: " + resource2);
				synchronized (resource1) {
					System.out.println("Thread 2 locked: " + resource1);
				}
			}

		});

		t1.start();
		t2.start();

	}
}
