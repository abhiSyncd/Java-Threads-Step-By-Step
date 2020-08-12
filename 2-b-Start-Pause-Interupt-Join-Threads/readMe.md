	   Thread States : 
	   NEW               : A thread not yet started
	   RUNNABLE          : A thread executing in JVM
	   RUNNING           : A Thread is Running 
	   WAITING           : A Thread waits for something to complete
	   BLOCKED           : covered in Race condition chapter 
	   TERMINATED        : A thread completed its execution | Exception occured while performing task
	   
	   

  ## 1)Starting Thread 
        
        public static void main(String[] args) {
	
			Thread t1 = new Thread(() -> {
				System.out.println("Response from Database from seperate thread : " + Thread.currentThread().getName());
			});
	
			t1.start();
	
			System.out.println("Main Thread executing : " + Thread.currentThread().getName());
		}
   
	   Output : 
	   Main Thread executing : main
	   Response from Database from seperate thread : Thread-0
	   
  
	  - main() method                   : 'main' thread starts and put into it  'RUNNABLE' state
	  - Thread t1 = new MyThread()      : creates a separate thread 't1' and put it into 'NEW' state
	  - t1.start()                      : That separate thread is put it into 'RUNNABLE' state
	  - Now two threads 'main' and 't1' : are in 'RUNNABLE' state.


  ## 2)Running Thread
  
     There’s no guarantee of which thread runs first as they are both started concurrently
     As JVM schedular makes descision about which runnable threads will go into 'RUNNING' state.
     If you run this program again for several times, you will see sometimes the thread Thread-0 runs first, 
     sometimes the thread main runs first.

	
  ## 3)Terminating a Thread 
  
     Thread-0     : terminates as soon as its run() method runs to complete or any exception occurs , and the thread 
	  main-thread  : terminates after the main() method completes its execution
	
	
  ## 4)WAITING a thread 
    
	
	**4-I-Using Thread class static sleep() method : Thread.sleep()
	
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ex) {
			// code to resume or terminate...
		}
		
		- Pauses the current thread for about 2 seconds (or 2000 milliseconds). 
		  After that amount of time, the thread returns to RUNNING state
		
		- InterruptedException is a checked exception so you must handle it. 
		  This exception is thrown when the thread is interrupted by another thread.
		
	**4-II-Using Thread class Instance method join() : t1.join()
  
  
  ## 5)Interrupting a Thread 
        
		- Problem : Stopping a thread
		  It's easy to start a thread in Java because you have a start() method but 
        it's difficult to STOP the thread because there is no stop() or cancel() method in Thread Class.
        If you remember, 
        threads in Java start execution from run() method and 
        stop when it comes out of run() method, either normally or due to any exception
		
      - Solution : Thread class's interrupt() method 
	