package main;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {

	private List<Integer> sharedQ;

	public Consumer(List<Integer> sharedQ) {
		super();
		this.sharedQ = sharedQ;
	}

	@Override
	public void run() {

		// while (true) {
		synchronized (sharedQ) {

			// i-Calling threads wait on the Locked Object(taskQueue) till its empty
			while (sharedQ.size() == 0) {
				try {
					sharedQ.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			// ii-Perform operation till taskQueue.size()==0
			Iterator<Integer> iter = sharedQ.iterator();
			while (iter.hasNext()) {
				try {
					Integer s = iter.next(); // must be called before you can call iter.remove(),else
												// java.lang.IllegalStateException
					iter.remove();
					TimeUnit.SECONDS.sleep(1);
					System.out.println("Consumed -> " + s);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

			// iii-Notify waiting Thread on taskQueue when taskQueue.size()==5
			sharedQ.notifyAll();
		}
		// }
	}

}
