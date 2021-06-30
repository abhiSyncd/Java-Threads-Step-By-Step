package main;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
   Person-1 (Thread-1) : wants to Transafer 200 FROM Account-1 TO Account-2
   Person-2 (Thread-2) : wants to Transafer 100 FROM Account-2 TO Account-1
  
   A transfer between accounts needs to lock both accounts,
   
   Person-1 acquires the lock on Account-1
   Person-2 acquires the lock on Account-2
   
   Now, each must acquire the lock on their “TO” account: 
   So 
   Person-1 is waiting for B to release the Account-2 lock, and 
   Person-2 is waiting for A to release the Account-1 lock.

*/
public class c_Problem_UsingReetrantLock {
	public static void main(String[] args)  {
		
		
		final Object resource1 = "resource1";   // Axxount 1 
		final Object resource2 = "resource2";   // Account 2 
		
		 Lock lock1 = new ReentrantLock();
		 Lock lock2 = new ReentrantLock();

		
		Thread t1 = new Thread(() -> {
			try {
			    lock1.lock();
			    System.out.println("Thread 1 locked: "  + resource1);
			    try {
				    lock2.lock();                          
				    System.out.println("Thread 1 locked: " + resource2);
				  } finally {
					  lock2.unlock();                      
				  }
			  } finally {
				  lock1.unlock();                       
			  }
		});
		
		
		Thread t2 = new Thread(() -> {
			try {
			    lock2.lock();
			    System.out.println("Thread 2 locked: " + resource2 );
			    try {
				    lock1.lock();                          
				    System.out.println("Thread 2 locked: " + resource1);
				  } finally {
					  lock1.unlock();                      
				  }
			  } finally {
				  lock2.unlock();                       
			  }
		});
		
		
		t1.start();
		t2.start();

		
	}
}
