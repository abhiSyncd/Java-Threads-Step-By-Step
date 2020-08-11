package main;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyCallableExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		Callable<String> callable = new MyCallable();

		
		ExecutorService executor = Executors.newFixedThreadPool(10);         // Parallel Execution if Multiple Callable Tasks are submitted to Executor's Thread Pool
		Future<String> future    = executor.submit(callable);                
		                                                                      
		
		System.out.println("Response From Callable Task : " + future.get()); // future.get() waits for Callable task to complete and then run the main Thread

		
		executor.shutdown();		                                         // Shut the Executor service once callable task finishes the task
		

		System.out.println("Main Function");

	}
}

/**
 * 
 * Output  : Response From Callable Task : Response from Database  <took 2 seconds to complete>
 *			 Main Function
 *			     
 * Note : Main Threads wait for the Callable thread to finish : 
 *        Since Future is synchronous 
 *        So use CompletableFuture introduced in Java 8 instead of Future
 *        
 *        CompletableFuture is used for asynchronous programming in Java.
 *        
 *        Asynchronous programming is a means of writing non-blocking code by running a task on a separate thread than the main application thread and 
 *        notifying the main thread about its progress, completion or failure.
 *
 *        This way, your main thread does not block/wait for the completion of the task and it can execute other tasks in parallel.
 * 
 */

