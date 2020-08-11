package main;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
	@Override
	public String call() throws Exception{
		// Perform Long Running Task
		Thread.sleep(2000L);
		return ("Response from Database");
	}
}


/**
  Note : difference Runnable and Callable
  >call() can return type unlike run()
  >call() can throw exception unlike run()
 */
