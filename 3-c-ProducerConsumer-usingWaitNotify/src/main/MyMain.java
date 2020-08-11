package main;

import java.util.ArrayList;
import java.util.List;

public class MyMain {

	public static void main(String[] args) {
                
		//Create a Shared-Queue : which is shared both by Producer and consumer
		List<Integer> sharedQ = new ArrayList<>();

		//Create Both Producer and Consumer Thread
		Runnable pThread = new Producer(sharedQ);
		Runnable cThread = new Consumer(sharedQ);

		Thread producer = new Thread(pThread, "Producer");
		Thread consumer = new Thread(cThread, "Consumer");

		//Start Both Producer and Consumer Thread
		producer.start();
		consumer.start();

	}
}

// NOTE : while(true) in both Producer and Consumer class enables it to run forever
/**
   Output : 
   Produced -> 0
   Produced -> 1
   Produced -> 2
   Produced -> 3
   Produced -> 4
   
   Consumed -> 0
   Consumed -> 1
   Consumed -> 2
   Consumed -> 3
   Consumed -> 4
 */
