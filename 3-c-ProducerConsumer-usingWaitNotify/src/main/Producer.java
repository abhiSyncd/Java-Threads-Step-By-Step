package main;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Producer implements Runnable {

	private List<Integer> sharedQ;

	public Producer(List<Integer> sharedQ) {
		super();
		this.sharedQ = sharedQ;
	}

	@Override
	public void run() {

		//while (true) {                                                                           
			synchronized (sharedQ) {

				// i-Calling threads wait on the Locked Object(taskQueue) till its full
				while (sharedQ.size() == 5) {
					try {
						sharedQ.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				// ii-Perfrom operation till taskQueue.size()==5
				for (int i = 0; i < 5; i++) {
					try {
						sharedQ.add(i);
						TimeUnit.SECONDS.sleep(1);
						System.out.println("Produced->" + sharedQ.get(i));
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
				}

				// iii-Notify waiting Thread on taskQueue when taskQueue.size()==5
				sharedQ.notifyAll();
			}
		//}                                                                                                                                                                                               
	}

}
