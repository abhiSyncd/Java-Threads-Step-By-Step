
#  1 - Need of Executor Framework | Thread Pool


    Every time a task is executed a Thread is created 
    Creating and starting a thread can be an expensive process
   
    Example : Below code creates 100 separate OS threads
              for(i=0;i<100;i++){
                thread.start()
              }
   
    Thread Pool Advantage :
    So,Create a fixed number of threads in a Thread-Pool,say 10 threads created in a thread Pool.
    Submit 100 tasks to them ,
    All 10 threads execute the task and returns back to Pool.
    These IDLE threads in the pool can be reused to execute pending tasks

    This mechanism is especially helpful in systems that execute a large number of small tasks.




#  2 -  Potential Risks of Using a Thread Pool :


    Although thread pools provide significant advantages, you can also encounter several problems while using one, 
    such as:

     i) Using a thread pool that is too large or too small – if the thread pool contains too many threads, 
        this can significantly affect the performance of the application; 
        On the other hand, a thread pool that is too small may not bring the performance gain that you would expect

     ii) Deadlock can happen just like in any other multi-threading situation; for example, 
         a task may be waiting for another task to complete, with no available threads for this latter one to execute; 
         That’s why it’s usually a good idea to avoid dependencies between tasks

    iii) Queuing a very long task – to avoid blocking a thread for too long, 
         you can specify a maximum wait time after which the task is rejected or re-added to the queue


#  3 -  [Thraed Pool Size](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/tree/master/8-a-Custom_Thread_Pool) :

         To mitigate these risks, you have to choose the thread pool type and parameters carefully, 
         according to the tasks that they will handle.
 
    

#  4 - Java Implementation of Thread Pools :     

    
   **I) The Executors class and Executor interface**  
   
        Discussed in Next Section

   **II) Fork-Join Pool**
    
        The fork/join framework is based on a “work-stealing algorithm”. 
        In simple terms, what this means is that threads that run out of tasks can “steal” work from other busy threads.
        This “steal” work algorithm ensures that all CPUs are optimally used.
	  
	 
   **III) Comparing ThreadPoolExecutor and ForkJoinPool**
      
       - ThreadPoolExecutor provides more control over the number of threads and 
         the tasks that are executed by each thread. 
         This makes it more suitable for cases when you have a smaller number of larger tasks 
         that are executed on their own threads.
         
       - ForkJoinPool is based on threads “stealing” tasks from other threads. 
         Because of this, 
         It is best used to speed up work in cases when tasks can be broken up into similar kind of smaller tasks.
    



#  5 - Types of Thread Pool in Executors class : 

 
**I) newSingleThreadExecutor()**
 
    - Creates an Executor woth only One single worker thread
  
    - Use case : 
     : As you have only one Thread to handle all your request
       You want to execute the submitted tasks in a SEQUENCE (i.e Order in which it is submitted).
       Alternative : [Using Joins](https://github.com/abhiLinkd/Java-Threads-Step-By-Step/tree/master/2-a-MultipleThreads-SequentialExecution-UsingJoin)
   
     : ExecutorService executor = Executors.newSingleThreadExecutor();

 **II) newFixedThreadPool(int poolsize)**
 
    - Creates a Fixed thread pool that 
      Reuses a Fixed number of threads i.e 
      Only 10 threads are created and a thread is used again only if IDLE.
   
    - Use case : 
     : Can configure for CPU Intensive tasks : 

     : Integer coreCount = Runtime.getRuntime().availableProcessors();
       ExecutorService executor = Executors.newFixedThreadPool(coreCount);
   
   
 **III) newCachedThreadPool()**
 
    - Creates a Expandable having an expandable thread pool that 
      CREATES A NEW THREAD ONLY WHEN none of the previous created thread are IDLE, but
      will reuse previously constructed threads if IDLE
   
    - Use case :
      : suitable for applications that launch many short-lived tasks.
      : ExecutorService executor = Executors.newCachedThreadPool(); 


**IV) newScheduledThreadPool(int poolsize)**
 
    - Creates a thread pool that can schedule commands to run after a given delay, or to execute periodically.

    - Use case : 
      ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);

     - Executing runnable after a fixed delay 
       executor.schedule(runnable, 2 , TimeUnit.SECONDS) :     
   
     - Executing runnable after a fixed delay and periodically
       executor.scheduleAtFixedRate(runnable, 2 ,2, TimeUnit.SECONDS); :
    
 

#  6 - Types of Methods in ExecutorService to execute Threads  : 
 
**I) Methods** 
   
    ExecutorService executor = Executors.newSingleThreadExecutor() OR
                               Executors.newCachedThreadPool()
                               Executors.newFixedThreadPool(coreCount);
                                           
    Methods that can be called using 'executor' instance  
     - execute(Runnable)         : Multiple runnables can be submitted to MULTIPLE execute() methods 
     - submit(Runnable)          : Multiple runnables can be submitted to MULTIPLE submit() methods
     - submit(Callable)          : Multiple callables can be submitted to MULTIPLE submit() methods
     - invokeAll(List<Callable>) : List<callables> can be submitted to ONE invokeAll() method
                                   Returns a List<Future> holding their status and results when ALL Tasks completes
     - invokeAny(List<Callable>) : List<callables> can be submitted to ONE invokeAny() method

**I) Example : invokeAll()**

    ExecutorService executorService = Executors.newSingleThreadExecutor();

    Set<Callable<String>> callables = new HashSet<Callable<String>>();

      //Task 1 : Takes 5 Second to complete
      callables.add(new Callable<String>() {
        public String call() throws Exception {
          Thread.sleep(5000);
          return "Task 1 completed";
        }
      });
		
		
      //Task 2 : Takes 2 Second to complete
      callables.add(new Callable<String>() {
        public String call() throws Exception {
          Thread.sleep(2000);
          //throw new Exception();
          return "Task 2 completed";
        }
      });
	
	
      //Task 3 : Takes 10 Second to complete
      callables.add(new Callable<String>() {
        public String call() throws Exception {
          Thread.sleep(10000);
	  return "Task 3 completed";
        }
      });

      //Submit all Tasks 
       List<Future<String>> futures  = executorService.invokeAll(callables);;
       for(Future<String> future : futures){
         System.out.println("future.get = " + future.get());  
       }

       executorService.shutdown();

       System.out.println("Main Thread : Blocked since Future.get is Blocking operation");
    
    
       Output :
       future.get = Task 2 completed
       future.get = Task 3 completed
       future.get = Task 1 completed
       Main Thread : Blocked since Future.get is Blocking operation
	
       Note : 
       Since 
       Task 1 takes : 5 seconds to complete
       Task 2 takes : 2 seconds to complete
       Task 3 takes : 10 seconds to complete
	 
       submitted to invokeAll(List<Callable>).
       The result returns a List<Future> after 10 seconds (i.e when ALL Tasks completes)
	
