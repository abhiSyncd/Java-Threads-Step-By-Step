

##  1 -  Difference Thread vs Runnable
    - When a class extend Thread class, that class can’t extend any other class 
    - A class can implement many interfaces 
    
    
##  2 -  Difference Runnable and Callable Interface
    i) Runnable's run() method 
        - return type is void
        - cannot throw checked exception 
	
    ii) Callable's call() method 
        - can return values
        - can throw checked exception 
          
	  
 ##  3 - Creating Callable Threads
   
   **3-I - Using Callable-Interface as separate Class  .**  
    
      public static void main(String[] args) throws InterruptedException, ExecutionException {

		Callable<String> callable = new MyCallable();
		
		ExecutorService executor = Executors.newFixedThreadPool(10);
		Future<String> future = executor.submit(callable);

		System.out.println("Response from seperate thread : "  + future.get()); 

		executor.shutdown();

		System.out.println("Main Thread Resumes : " + Thread.currentThread().getName());

	}
	
     ----------------------------------------------------------------------------------------------
	
      public class MyCallable implements Callable<String> {
            @Override
            public String call() throws Exception {
                return ("DB-RESPONSE");
            }
       }
    
     ----------------------------------------------------------------------------------------------
     
        Output : 
          Response from seperate thread : DB-RESPONSE
          Main Thread Resumes : main
	  
     ----------------------------------------------------------------------------------------------
     
        Note : 
         a)Here unlike Runnable-Interface 
            - can return values
            - can throw checked exception 
	    
         b)Future.get() is used to retrieve the result of computation.
           Main-Thread is blocked untill Future.get() is called
	       



  **3-II - Using Callable-Interface as Anonymous Inner Class**  
  
     public static void main(String[] args) throws InterruptedException, ExecutionException {

		Callable<String> callable = new Callable<String>() {
			@Override
			public String call() throws Exception {
				return ("DB-RESPONSE");
			}
		};

		ExecutorService executor = Executors.newFixedThreadPool(10);
		Future<String> future = executor.submit(callable);

		System.out.println("Response from seperate thread : " + future.get());

		executor.shutdown();

		System.out.println("Main Thread Resumes : " + Thread.currentThread().getName());

	}
  


 
  **3-III - Using Lambda** 
  
     public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService executor = Executors.newFixedThreadPool(10);
		Future<String> future = executor.submit(() -> {
			Thread.sleep(2000L);
			return ("DB-RESPONSE");
		});

		System.out.println("Response from seperate thread : " + future.get());

		executor.shutdown();

		System.out.println("Main Thread Resumes : " + Thread.currentThread().getName());

	}
