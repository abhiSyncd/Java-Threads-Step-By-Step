# Java-Threads-Step-By-Step : Overview 

 Process vs Threads 
 
###################################################################################
## Section 1 - Creating Threads 
###################################################################################


**1 - [Thread Class](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/tree/master/1-a-CreatingThreads-Thread)**

      - Using Thread-Class as separate Class 
      - Using Thread Class as Anonymous Inner Class 
      - Using Lambda 
    
**2 - [Runnable Interface](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/tree/master/1-b-CreatingThreads-Runnable)**

      - Using Runnable-Interface as separate Class  
      - Using Runnable-Interface as Anonymous Inner Class 
      - Using Lambda 
	   
**3 - [Callable Interface](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/tree/master/1-c-CreatingThreads-Callable-with-Future)**

       i) Difference Thread vs Runnable 
	   
      ii) Difference Runnable and Callable
      
      iii)Creating Callable Threads
         - Using Callable-Interface as separate Class  
         - Using Callable-Interface as Anonymous Inner Class 
         - Using Lambda 
		
     
	     
**4 - [Executor-Framework](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/tree/master/1-d-CreatingThreads-Executors)**

      i) Need of Executor|Thread Pool
      
     ii) Potential Risks of Using a Thread Pool : 
     
    iii) Ideal Thread Pool Size : https://www.youtube.com/watch?v=ErNre5varF8
      
     iv) Java Implementation of Thread Pools
           - The Executors class and Executor interface
           - Fork-Join Pool 
		   
     v) Types of Thread Pool in Executors class
           - newSingleThreadExecutor()
           - newFixedThreadPool(int poolsize)
           - newCachedThreadPool()
           - newScheduledThreadPool(int poolsize)
    		   
     vi) Types of Methods in ExecutorService to execute Threads : 
           - execute(Runnable)         : Multiple runnables can be submitted to MULTIPLE execute() methods 
           - submit(Runnable)          : Multiple runnables can be submitted to MULTIPLE submit() methods
           - submit(Callable)          : Multiple callables can be submitted to MULTIPLE submit() methods
           - invokeAll(List<Callable>) : List<callables> can be submitted to ONE invokeAll() method
                                         Returns a List<Future> holding their status and results when ALL Tasks completes
           - invokeAny(List<Callable>) : List<callables> can be submitted to ONE invokeAny() method


###################################################################################
## Section 2 - Others Information
###################################################################################

 **1 - Thread Priority**
    
 **2 - [Create-start-pause-interrupt-and-join Threads](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/tree/master/2-b-Start-Pause-Interupt-Join-Threads)**

###################################################################################
## Section 3 - Multi Threading :  Problem & Solution 
###################################################################################

**1 - [Race Condition](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/tree/master/5-a-RaceCondition-I)**

    i)What is Race Condition 
    
    ii)Solution 
       - Intrinsic Locks : Using Synchronized (Block | Method) 
       - Extrinsic Lock  : Using ReentrantLock | ReadWriteLock | StampedLock (Java 8)
       - Atomic Variable
       
    iii)Synchronize vs ReetrantLock
  
    iv)Lock API : Types of Extrinsic Lock in Java
       - ReentrantLock
       - ReadWriteLock
       - StampedLock (Java 8)

**2 - [DeadLocks](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/tree/master/5-b-Deadlock)**

     - What is DeadLock
    
     - Problem : Creating Deadlock
    
     - Solution
    
**3 - [Starvation](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/tree/master/5-c-Starvation)**

     - Problem
    
     - Solution 

**4 - [Livelock](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/tree/master/5-d-Livelocks)** 

**5 - Memory consistency errors | Visibility Problem** 
    
    Problem : 
    Given 
    >Dual Core Processor 
    >Thread-1 running and having its own Local-Cache in core-1
    >Thread-2 running and having its own Local-Cache in core-2
    >Both Core-1 and Core-2 shares a common-shared-main-memory
    >A variable v1

    Change in v1 by Thread-1 is not visible by Thread-2


    Solution : Make the variable v1 Volatile
  
    - This indicates JVM and Thread 
      That do not cache value of the variable v1 in the local cache and 
      always read it from the common-shared-main-memory 


**6 - Other** 

    Given : 
    An object that is not thread-safe (say SimpleDateFormat)
    You want to avoid synchronizing access to that object
    Instead, you want to give each thread its own instance of the object.

    Solution : Thread Local 
    The ThreadLocal class is used to create thread local variables,
    which can only be read and written by the same thread. 
    For example, if two threads are accessing code having reference to same threadLocal variable 
    then each thread will not see any modification to threadLocal variable done by other thread
    

###################################################################################
## Section 4 - More on Synchronization of Threads
###################################################################################

**1 - Synchronize**

   - [Object Level Lock](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/tree/master/3-a-ObjectLevelLock)
   - [Class Level Lock](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/tree/master/3-b-ClassLevelLock)
 
**2 - Producer Consumer : Inter Thread Communication**

   - [Using Wait & Notify](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/tree/master/3-c-ProducerConsumer-usingWaitNotify)
   - [Using Blocking Queue](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/tree/master/4-b-CountdownLatch)
   - [Using Extrinsic Lock and Condition Class](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/tree/master/3-e-ProducerConsumer-usingLock%26Condition) 
      
     https://www.youtube.com/watch?v=N0mMm5PF5Ow
  
  
**3 - Types of Synchronizers**

   - [CountingSemaphore](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/tree/master/4-a-CountingSemaphore)
   - [CountdownLatch](https://github.com/abhiLinkd/Java-Threads-Step-By-Step/tree/master/4-b-Synchornizers-CountdownLatch)
   - [CyclicBarrier](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/tree/master/4-c-CyclicBarrier)
   - Exchanger
   - Phaser

###################################################################################
## Section 5 - [Immutable Class](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/tree/master/6-a-ImmutableClasses-ThreadSafe)
###################################################################################

      1 - What is an Immutable Class
      2 - Advantage
      3 - Use case 
      4 - How to make a class Immutable
           - Steps 
           - Immutable Class with Mutable Reference


###################################################################################
## Section 6 - [Java Memory Model](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/tree/master/7-a-Java-Memory-Model)
###################################################################################
     
      1 - Stack vs Heap
      2 - Garbage Collection 
      3 - Types of Garbage Collectors
 
###################################################################################
## Section 7 - Implementation Examples | Use Cases MultiThreading
###################################################################################

**1 - [LRU Cache](https://github.com/abhiLinkd/Java-Threads-Step-By-Step/tree/master/7-a-LRUCache-usingHashMap%26DoubleLinkedList)**

**2 - Rate Limiting**

**3 - [Custom Thread Poo](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/tree/master/7-b-LRUCache-usingHashMap%26DoubleLinkedList)**
    
    - https://way2java.com/multithreading/realtime-examples-of-multithreading/
    - Gathering information from different web services running in parallel : CompletableFuture, which uses Fork-Join Pool by Default



