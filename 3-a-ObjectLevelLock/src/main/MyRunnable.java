package main;

public class MyRunnable implements Runnable {
	@Override
	public void run() {
		displayName();
	}

	public synchronized void displayName() {
		String[] array = { "My", "Name", "is", "Abhishek" };

		synchronized (this) {
			for (String str : array) {
				try {
					Thread.sleep(1000L);
					System.out.println(Thread.currentThread().getName() + "-->" + str);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}


//displayName() method is synchronized but Sequential-Execution-order is not maintained,as haven't used join() '
