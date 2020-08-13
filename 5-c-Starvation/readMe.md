


## 1 - Problem : 

     Deadlock and Starvation both are the conditions where the processes requesting for a resource 
     has been delayed for a long|Indefinite time. 
    
     - Deadlock : 
       No Threads proceeds for execution and 
       each waits for shared-resources that have been acquired by the other Threads.
     
     - Starvation  
        Starvation occurs in priority scheduling algorithm. 
        Thread Priority can either be given by JVM while creating the thread or it can be given by programmer explicitly.
        
        In priority scheduling algorithm, 
        Higher-priority-Threads acquires a lock on a shared-resource.
        This prevents the lower-priority-threads from aquiring a lock on shared-resource and are 
        blocked indefinately waiting to enter a synchronized block  and they "starves to death"
        
      
        
## 2 - Solution : 

      Synchronze keyword is UNFAIR
      But Reetrant Locks can both be UNFAIR and FAIR.
      
      By Default Reetrant locks are UNFAIR :  ReentrantLock lock = new ReentrantLock() 
      Suppose Threads T1,T2,T3 comes at same time and 
      - T1 first aquires the lock using  lock.lock() and Becomes RUNNABLE ,
      - Then T2,T3 will go in WAIT State and will be put into a QUEUE(FIFO).
      - T1 completes and release the lock using lock.unlock() and gets into TERMINATED state 
      - Then at the same time a new thread T4 comes in and tries to aquire a lock.
        ReentrantLock Instead of putting it in a queue allows T5 to aquire a Lock, instead of T2,T3 is in a wait state

          
     But if we write : ReentrantLock lock = new ReentrantLock(true) , Then Lock becomes a Fair Lock.
     Suppose Threads t1,t2,t3 comes at same time and 
     - Thread t1 first aquires the lock using  lock.lock() and Becomes RUNNABLE ,
     - Then Threads t2,t3 will got in WAIT State and will be put into a QUEUE(FIFO).
     - Thread t1 completes and release the lock using lock.unlock() and gets into TERMINATED state 
     - Then the longest waiting thread will ge given a chance to aquire a lock.
          
     This avoids "Starvation" and thus increases performances
     
     
