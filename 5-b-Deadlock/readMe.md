

## 1 - Deadlock Problem : 

   https://web.mit.edu/6.005/www/fa15/classes/23-locks/
     
     
    synchronized keyword can cause Deadlock.
    Deadlock occurs when there are Thwo Threads, both of which are holding an Object that other thread wants.
    So both the threads will simply wait, wait and wait.
    
    Refer : https://www.youtube.com/watch?v=B4IVu-2hCos 
            https://dzone.com/articles/investigating-deadlocks-%E2%80%93-part-1  
	    https://www.codejava.net/java-core/concurrency/understanding-deadlock-livelock-and-starvation-with-code-examples-in-java
    
    
   **Ex)**
     
	  public static void main(String[] args) {

		final Object resource1 = "resource1";
		final Object resource2 = "resource2";

		Thread t1 = new Thread(() -> {
			synchronized (resource1) {
				System.out.println("Thread 1: locked " + resource1);
				synchronized (resource2) {
					System.out.println("Thread 1: locked " + resource2);
				}
			}

		});

		Thread t2 = new Thread(() -> {
			synchronized (resource2) {
				System.out.println("Thread 2: locked " + resource2);
				synchronized (resource1) {
					System.out.println("Thread 2: locked " + resource1);
				}
			}

		});

		t1.start();
		t2.start();
          }

         Here, 
	 
         Thread-1 
	   - Acquires Lock on resource-a 
	   - waiting to acquire lock on resource-b But before it can acquire lock on resource-b 

	  Thread-2 
	   - Acquires Lock on resource-b
	   - waiting to acquire lock on resource-a But before it can acquire lock on resource-a, 
	     Thread-1 Acquires Lock on resource-a
    	 
  
## 2 - SOLUTION :   
    
    - Lock Ordering
    - Lock Timeout : Not possible in Intrinsic Lock but possible in Extrinsic Lock
    - Deadlock Detection           


	 
