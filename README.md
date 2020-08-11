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

 **1 - Thread Priority** : Thread Scheduling 
    
 **2 - [Stopping Threads](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/tree/master/2-b-StoppingThreads)**

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
  
    iv)Types of Extrinsic Lock in Java : L ock
       - ReentrantLock
       - ReadWriteLock
       - StampedLock (Java 8)

**2 - [DeadLocks](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/tree/master/5-b-Deadlock)**

    i)What is DeadLock
    
    ii)Solution 
    
**3 - [Starvation](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/tree/master/5-c-Starvation)** 

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
      That do not cache value of the variable v1 in the local cache and always read it from the common-shared-main-memory 


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

   - [Object Level Lock](https://github.com/abhiLinkd/Java-Threads-Step-By-Step/tree/master/3-a-Synchronization-ObjectLevelLock)
   - [Class Level Lock](https://github.com/abhiLinkd/Java-Threads-Step-By-Step/tree/master/3-b-Synchronization-ClassLevelLock)
 
**2 - Producer Consumer : Inter Thread Communication**

   - [Using Wait & Notify](https://github.com/abhiLinkd/Java-Threads-Step-By-Step/tree/master/3-c-Synchronization-ProducerConsumer-usingWaitNotify)
   - [Using Blocking Queue](https://github.com/abhiLinkd/Java-Threads-Step-By-Step/tree/master/3-d-Synchronization-ProducerConsumer-usingBlockingQueue)
   - [Using Extrinsic Lock and Condition Class](https://www.youtube.com/watch?v=N0mMm5PF5Ow)
  
**3 - Types of Synchronizers**

   - [CountingSemaphore](https://github.com/abhiLinkd/Java-Threads-Step-By-Step/tree/master/4-a-Synchornizers-CountingSemaphore)
   - [CountdownLatch](https://github.com/abhiLinkd/Java-Threads-Step-By-Step/tree/master/4-b-Synchornizers-CountdownLatch)
   - [CyclicBarrier](https://github.com/abhiLinkd/Java-Threads-Step-By-Step/tree/master/4-c-Synchornizers-CyclicBarrier)
   - Exchanger
   - Phaser

###################################################################################
## Section 5 - [Immutable Class](https://github.com/abhiLinkd/Java-Threads-Step-By-Step/tree/master/6-a-ImmutableClasses-ThreadSafe)
###################################################################################

      1 - What is an Immutable Class
      2 - Advantage
      3 - Use case 
      4 - How to make a class Immutable
           - Steps 
           - Immutable Class with Mutable Reference


###################################################################################
## Section 6 - Java Memory Model
###################################################################################
  
  **1 - JVM divides memory into stack and heap memory.**    
     
   ***i) - Stack Area***
   
      a) Whenever a new method is invoked by a Thread 
         A Thread creates its own THREAD-STACK, which is invisible to all other threads.
         which makes STACK-AREA Thread Safe, as each thread operates in its own stack

      b) THREAD-STACK contains 
        - Local variables
           > Primitive Type
           > Reference Variables of the Objects-stored-in-Heap

       - Method - Parameters + Return values of each method the thread has invoked. 


      c) STACK-AREA automatically allocated and deallocated when method finishes execution
         If this memory is full, Java throws java.lang.StackOverFlowError

      d) Faster compared to HEAP-AREA
   
   
   ***ii) - Heap Area***  
       
       a) All Threads share the HEAP-AREA,
          which makes it Not-Thread-Safe

       b) HEAP-AREA contains 
          - Object (Instance-Variable)
          - Class Defination + Static Variables 

       c) If heap space is full, Java throws java.lang.OutOfMemoryError

       d) Slower compared to STACK-AREA

  
   **2 - Garbage Collector**
     
   ***i) HEAP AREA further divided into***   
    
	 a)YOUNG-GENERATION  
	   - this is where all new objects are allocated and aged. A minor Garbage collection occurs when this fills up
	   - Consists of 
	      >One Eden Space
	      >Many Survivor Spaces (s1, s2)

	 B)OLD-GENERATION 
	   - this is where long surviving objects are stored. 
	     When objects are stored in the Young Generation, a threshold for the object's age 
	     is set and when that threshold is reached, the object is moved to the old generation

	 C)PERMANENT-GENERATION 
	   - this consists of JVM metadata for the runtime classes
	   - Note : PermGenSpace vs Metaspace(Java 8)
	   
	   
   ***ii) Garbage Collector Steps***  
   
	 a) YOUNG GENERATION
	 
	  - New created objects are allocated in eden-space
	  
	  - Mean while application runs, some objects in eden-space becomes
	    >LIVE : reachable, refrenced by someone else
	    >DEAD : unreachable, not referenced from anywhere
		
	  - If eden-space = full
	     >Trigger 1st-cycle-of-Minor-GC 
	     >Mark all Live-objects in eden-space and copy it over to Survivor-Space s1, 
	      which servived 1st-cycle-of-MINOR-GC  
	     >make eden-space = empty


	b) OLD-GENERATION
	
	 - Objects which are LIVE and survived few-cycles-of-MINOR-GC in eden-space
	   are shifted to old-generation
	   
	 - If old-genetaion == full 
		- Trigger a MAJOR-GC
		- which performs following operations 
		   > Mark       : JVM looks over all Heap space and marks the reachable-bjects
		   > Delete     : JVM then delete the unreachable-objects
		   > Compacting : Compact the memory by moving around the objects and 
		                  make the Fragment-allocation a Contiguous-allocation 
   
	   
         Source : https://www.youtube.com/watch?v=UnaNQgzw4zY


 ***iii) Garbage Collector Types*** 
        
	a)A serial Collector 

	b)Concurrent Collector 

	c)Parallel Collector 
	
	When use what : https://www.youtube.com/watch?v=2AZ0KKeXJSo&t=655s
       
 
 
###################################################################################
## Section 7 - Implementation Examples | Use Cases MultiThreading
###################################################################################

**1 - [LRU Cache](https://github.com/abhiLinkd/Java-Threads-Step-By-Step/tree/master/7-a-LRUCache-usingHashMap%26DoubleLinkedList)**

**2 - Rate Limiting**

**3 - Custom Thread Pool**
    
    - https://way2java.com/multithreading/realtime-examples-of-multithreading/
    - Gathering information from different web services running in parallel : CompletableFuture, which uses Fork-Join Pool by Default



