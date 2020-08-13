

## 1 - What is Deadlock : 
    
     Race Condition is a problem that arises when multiple threads access and WRITE on  
     the same resource (Variable | Arrays | ObjectDatabase | web-services) at the same time.
     
     Deadlock is a problem arises when there are Thwo Threads, both of which are holding an Object that other thread is waiting for.
     So both the threads will simply wait, wait and wait.

   
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
   
   **[3-I-Lock Ordering](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/blob/master/5-b-Deadlock/src/main/b_Solution_UsingSynchronized.java)**
     
   
   **[3-II-Lock Timeout](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/blob/master/5-b-Deadlock/src/main/d__Solution_UsingReetrantLock.java)**
   
   **[3-III-Deadlock Detection ]**
   
   
