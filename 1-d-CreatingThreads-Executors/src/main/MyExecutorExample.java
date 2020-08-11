package main;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class MyExecutorExample {

	public static void main(String[] args) {

		Runnable task1 = new MyRunnableTask1();
		Runnable task2 = new MyRunnableTask2();

		/**
		 * I - Sequential Execution of Child Threads : 
		 * 
		 * Output : Main Thread
		 *          Task 1 completed  - in 3 seconds
		 *          Task 2 completed  - in 2 seconds
		 * 
		*/
		   ExecutorService executor = Executors.newSingleThreadExecutor();
		   executor.submit(task1);
		   executor.submit(task2);
		   executor.shutdown();
		   
		   System.out.println("Main Thread");
		   
		   
		 
		

		
		
		/**
		 * II - Parallel Execution of Child Threads
		 * 
		 * Output : Main Thread
		 *          Task 2 completed  - in 2 seconds
		 *          Task 1 completed  - in 3 seconds
		 * 
		 *
		
		   ExecutorService executor = Executors.newCachedThreadPool(); // or newFixedThreadPool(10)
		   executor.submit(task1);
		   executor.submit(task2);
		   executor.shutdown();
		   
		   System.out.println("Main Thread");
		  
		 
		  */
		
		
		

		/**
		 * III - Execute A Runnable Task After specified Delay(2 seconds)
		 * 
		 * Output : Main Thread 
		 *          <Delay of 2 seconds>
		 *          Task 1 completed - in 2 seconds  
		 *  
		 * 
		
		   ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
		   executor.schedule(task1, 2 , TimeUnit.SECONDS);
		   executor.shutdown();
		   
		   System.out.println("Main Thread");
		 
		   
		 */
		
		
		
		
	       /**
		* IV - Execute A Runnable Task After specified Delay(1 second) and periodically(2 seconds)
		* 
		* Output : Main Thread 
		*          <delay of 1 second>
		*          Task 1 completed - in 2 seconds 
		*          Task 1 completed - in 2 seconds and so on after every 2 seconds
		* 


		  ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
			  executor.scheduleAtFixedRate(task1, 1, 2, TimeUnit.SECONDS);

			  System.out.println("Main Thread");


		*/
		  
	}

}
