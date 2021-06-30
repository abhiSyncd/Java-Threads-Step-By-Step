

## 1 - What is Deadlock : 
    
     (a) What is Deadlock
         Race Condition is a problem that arises when multiple threads access and WRITE on  
         the same resource (Variable | Arrays | ObjectDatabase | web-services) at the same time.
     
         Deadlock is a problem arises when there are Thwo Threads, both of which are holding an Object that other thread is waiting for.
         So both the threads will simply wait, wait and wait.
     
     (b) Example
         Person-1 (Thread-1) : wants to Transafer 200 FROM Account-1 TO Account-2
         Person-2 (Thread-2) : wants to Transafer 100 FROM Account-2 TO Account-1
  
         A transfer between accounts needs to lock both accounts,
   
         Person-1 acquires the lock on Account-1
         Person-2 acquires the lock on Account-2
   
         Now, each must acquire the lock on their “TO” account: 
         So 
         Person-1 is waiting for B to release the Account-2 lock, and 
         Person-2 is waiting for A to release the Account-1 lock.
   

   
 ## 2 - Problem : Creating Deadlock
 
   **[2-I-Using synchrnized Keyword](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/blob/master/5-b-Deadlock/src/main/a_Problem_UsingSynchronized.java)**
   
   **[2-II-Using Reetrant Lock](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/blob/master/5-b-Deadlock/src/main/c_Problem_UsingReetrantLock.java)**
   
    Here In above both cases
   
         Thread-1 
	   - Acquires Lock on resource-a 
	   - waiting to acquire lock on resource-b But before it can acquire lock on resource-b 

	  Thread-2 
	   - Acquires Lock on resource-b
	   - waiting to acquire lock on resource-a But before it can acquire lock on resource-a, 
	     Thread-1 Acquires Lock on resource-a
	     
  
## 3 - SOLUTION : 
   
   **[3-I-Lock Ordering : Using Synchronized](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/blob/master/5-b-Deadlock/src/main/b_Solution_UsingSynchronized.java)**
   
   **[3-II-Lock Ordering : Using ReetrantLock's TryLock](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/blob/master/5-b-Deadlock/src/main/d__Solution_1_UsingReetrantLock_Reordering.java)**
            
   
   **[3-III-Lock Timeout : Using_ReetrantLock's TryLock_with_Timeout](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/blob/master/5-b-Deadlock/src/main/e__Solution_2_UsingReetrantLock_TryLock_with_Timeout.java)**
   
   **3-IV-Deadlock Detection**
   
   
