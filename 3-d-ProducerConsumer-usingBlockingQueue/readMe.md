## Section 1 - Problem Statement 
    Producer-consumer problem (also known as the Bounded-Buffer-Problem) is an example of a 
    multi-process synchronization problem, where
      
    Problem Statement : 
    Producer and the consumer, which share a common, FIXED-SIZE-BUFFER used as a QUEUE.
     - PUT  : Producer Thread cannot put items into the buffer      : IF-BUFFER-IS-FULL
     - TAKE : Consumer Thread cannot take out items from the buffer : IF-BUFFER-IS-EMPTY
     - Buffer is not accessed by the 2 Threads simultaneously.

## Section 2 - Solution 
    
   **I : Refer Example**
   
   **II : Output**
    
    Produced -> 0
    Consumed -> 0
    
    Produced -> 1   
    Consumed -> 1
    
    Produced -> 2  
    Consumed -> 2
    
    Produced -> 3   
    Consumed -> 3
    
    Produced -> 4   
    Consumed -> 4
 
    
    Note : Uncommenting while(true) in both Producer and Consumer 
           enables both Producer & Consumer to run forever 
 
 
 ## Blocking Queue Interface 
    
    - A BlockingQueue is a commonly used data structure in production/consumer mode. 
    - Implementation Classes : 
      a) ArrayBlockingQueue
      b) LinkedBlockingQueue
      c) SynchronousQueue     : Same as Blocking-Queue but with size of 1
    
    
     
     
 ## Section 4 - Other Concurrent Collection used can be
    - Blocking Qeueue
    - ConcurrentHashMap
    - Counting Semaphore
    - Countdown Latch
    - Cyclic Barrier etc
