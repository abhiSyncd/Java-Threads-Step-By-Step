

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
				System.out.println("Thread 1: locked resource 1");
				synchronized (resource2) {
					System.out.println("Thread 1: locked resource 2");
				}
			}

		});

		Thread t2 = new Thread(() -> {
			synchronized (resource2) {
				System.out.println("Thread 2: locked resource 2");
				synchronized (resource1) {
					System.out.println("Thread 2: locked resource 1");
				}
			}

		});

		t1.start();
		t2.start();

	}
	 
  
## 2 - SOLUTION :   
    
    - Lock Ordering
    - Lock Timeout : Not possible in Intrinsic Lock but possible in Extrinsic Lock
    - Deadlock Detection           


	 
