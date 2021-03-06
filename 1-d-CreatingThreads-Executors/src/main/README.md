

## Syntax :   
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            //Runnable Task
        });

        executor.shutdown();


        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(() -> {
            //Callable Task
        });


## Example :  

		Runnable task1 = new Runnable() {
		   public void run() {
		       try {
			    Thread.sleep(3000L);
			    System.out.println("Task 1 completed");
			} catch (Exception e) {
			    e.printStackTrace();
			}
		  }
		};


		 Runnable task2 = new Runnable() {
		   public void run() {
		       try {
			   Thread.sleep(2000L);
			   System.out.println("Task 2 completed");
			} catch (Exception e) {
			    e.printStackTrace();
			}
		  }
		};
        
        
	
	        /**
		 * I - Sequential Execution of Child Threads : 
		 * 
		 * Output : Main Thread
		 *          Task 1 completed  - in 3 seconds
		 *          Task 2 completed  - in 2 seconds
		 * 
		 */
		   ExecutorService executor1 = Executors.newSingleThreadExecutor();
		   executor1.submit(task1);
		   executor1.submit(task2);
		   executor1.shutdown();
		   
		   System.out.println("Main Thread");
		   
		   
		 
		

		
		
		/**
		 * II - Parallel Execution of Child Threads
		 * 
		 * Output : Main Thread
		 *          Task 2 completed  - in 2 seconds
		 *          Task 1 completed  - in 3 seconds
		 * 
		 *
		 */
		   ExecutorService executor2 = Executors.newCachedThreadPool(); // or newFixedThreadPool(10)
		   executor2.submit(task1);
		   executor2.submit(task2);
		   executor2.shutdown();
		   
		   System.out.println("Main Thread");
		  
		 
		  
		/**
		 * III - Execute A Runnable Task After specified Delay(2 seconds)
		 * 
		 * Output : Main Thread 
		 *          <Delay of 2 seconds>
		 *          Task 1 completed - in 2 seconds  
		 *  
		 * 
		 */
		
		   ScheduledExecutorService executor3 = Executors.newScheduledThreadPool(2);
		   executor3.schedule(task1, 2 , TimeUnit.SECONDS);
		   executor3.shutdown();
		   
		   System.out.println("Main Thread");
		 
		   
		
		
		
		
		
	       /**
		* IV - Execute A Runnable Task After specified Delay(1 second) and periodically(2 seconds)
		* 
		* Output : Main Thread 
		*          <delay of 1 second>
		*          Task 1 completed - in 2 seconds 
		*          Task 1 completed - in 2 seconds and so on after every 2 seconds
		* 
		*/
		  ScheduledExecutorService executor4 = Executors.newScheduledThreadPool(2);
			  executor4.scheduleAtFixedRate(task1, 1, 2, TimeUnit.SECONDS);
			  System.out.println("Main Thread");
		
                
                
        
