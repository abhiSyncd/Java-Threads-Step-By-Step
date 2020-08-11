package main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyMain {

	public static void main(String[] args) {

		// Create a shared Object
		BlockingQueue sharedQ = new LinkedBlockingQueue<>();

		// Create Producer and Consumer
		Runnable pThread = new Producer(sharedQ);
		Runnable cThread = new Consumer(sharedQ);

		Thread producer = new Thread(pThread, "Producer");
		Thread consumer = new Thread(cThread, "Consumer");

		// Start both producer and consumer
		producer.start();
		consumer.start();

	}
}

