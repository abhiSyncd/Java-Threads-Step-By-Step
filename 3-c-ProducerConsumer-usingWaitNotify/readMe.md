
## Section 1 - Problem Statement 
    Producer-consumer problem (also known as the Bounded-Buffer-Problem) is an example of a 
    multi-process synchronization problem, where
      
    Problem Statement : 
    Producer and the consumer, which share a common, fixed-size buffer used as a queue.
     - Producer Thread cannot put items into the buffer if the buffer is full 
     - Consumer Thread cannot take out items from the buffer, if the buffer is empty
     - Buffer is not accessed by the 2 Threads simultaneously.

## Section 2 - Solution 
    
   **I : Synatx**

    synchrnonized(lockObject){
    
      //Step-I : Calling Thread wait on LockedObject() : Shared-Queue(Buffer) is lockedObject here
      while(condition){
       lockObject.wait()
      }
      
      //Step-II : Perform Operation till condition Satisfies 
      - For Producer : Add to Shared-Queue(Buffer) till Full
      - For Consumer : Remove from  Shared-Queue(Buffer) till Empty
         
      //Step-III : Notify Calling Thread 
      lockObject.notifyAll();
      
    }
    
    Note 1: wait and notify method must be called from inside a synchronized context i.e synchrnonized(lockObject) { }
           If not called code will throw "IllegalMonitorException"
    
    Note 2 : use LOOP (while here) to check condition instead of IF-BLOCK
     
     
   **II : Output**
   
    Produced -> 0
    Produced -> 1
    Produced -> 2
    Produced -> 3
    Produced -> 4
   
    Consumed -> 0
    Consumed -> 1
    Consumed -> 2
    Consumed -> 3
    Consumed -> 4
    
    Note : Uncommenting while(true) in both Producer and Consumer 
           enables both Producer & Consumer to run forever 

## Section 3 - Inter Thread Communication

  **1 : How Threads Communicate with each Other**
  
     Using wait(), notify() or notifyAll()
      
  **2 : Why wait(), notify() and notifyAll() are inside Thread class not Object class**
     
     Since wait(), notify(), notifyAll() used for Locking ( lockObject.wait() |  lockObject.notifyAll() ) and 
     Java provides Lock on OBJECT-LEVEL not Thread-Level
     So, it makes sense to define it on OBJECT-CLASS
     
  
  **3 : Difference between wait and sleep**
  
    - sleep : Called on a Thread 
      wait  : Called on Object 
      
    - sleep : used to introduce pause for the specified time on a Thread execution
      wait  : used for locking an Object for Inter-thread-communication 
      
    - sleep : sleep releases the Lock after only after the specified time is over
      wait  : wait do not release lock untill, the lockObject calls notify() or notifyAll()
      

