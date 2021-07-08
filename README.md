
# Summary : What is covered in this Tutorial   


# 1 - [Thread States](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/tree/master/2-b-Start-Pause-Interupt-Join-Threads)

	NEW        : A thread not yet started
	RUNNABLE   : A thread executing in JVM
	RUNNING    : A Thread is Running 
	WAITING    : A Thread waits for something to complete
	BLOCKED    : covered in Race condition chapter 
	TERMINATED : A thread completed its execution | Exception occured while performing task


# 2 - Creating Threads

**(a) - [Thread Class](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/tree/master/1-a-CreatingThreads-Thread)**

      - Using Thread-Class as separate Class 
      - Using Thread Class as Anonymous Inner Class 
      - Using Lambda 
    
**(b) - [Runnable Interface](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/tree/master/1-b-CreatingThreads-Runnable)**

      - Using Runnable-Interface as separate Class  
      - Using Runnable-Interface as Anonymous Inner Class 
      - Using Lambda 
	   
**(c) - [Callable Interface](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/tree/master/1-c-CreatingThreads-Callable-with-Future)**

       i) Difference Thread vs Runnable 
	   
      ii) Difference Runnable and Callable
      
      iii)Creating Callable Threads
         - Using Callable-Interface as separate Class  
         - Using Callable-Interface as Anonymous Inner Class 
         - Using Lambda 
		
     
	     
**(d) - [Executor-Framework](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/tree/master/1-d-CreatingThreads-Executors)**

    1) Need of Executor|Thread Pool
      
    2) Potential Risks of Using a Thread Pool : 
     
    3) Ideal Thread Pool Size :
     
    5) Java Implementation of Thread Pools
       - The Executors class and Executor interface
       - Fork-Join Pool 
		   
    6) Types of Thread Pool in Executors class
       - newSingleThreadExecutor()
       - newFixedThreadPool(int poolsize)
       - newCachedThreadPool()
       - newScheduledThreadPool(int poolsize)
    		   
    7) Types of Methods in ExecutorService to execute Threads : 
       - execute(Runnable)         : Multiple runnables can be submitted to MULTIPLE execute() methods 
       - submit(Runnable)          : Multiple runnables can be submitted to MULTIPLE submit() methods
       - submit(Callable)          : Multiple callables can be submitted to MULTIPLE submit() methods
       - invokeAll(List<Callable>) : List<callables> can be submitted to ONE invokeAll() method
                                     Returns a List<Future> holding their status and results when ALL Tasks completes
       - invokeAny(List<Callable>) : List<callables> can be submitted to ONE invokeAny() method



# 3 - Multi Threading :  Problem & Solution 


**(a) - [Race Condition](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/tree/master/5-a-RaceCondition-I)**

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

**(b) - [DeadLocks](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/tree/master/5-b-Deadlock)**

     - What is DeadLock
    
     - Problem : Creating Deadlock
    
     - Solution
    
**(c) - [Starvation](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/tree/master/5-c-Starvation)**

     - Problem
    
     - Solution 

**(d) - [Livelock](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/tree/master/5-d-Livelocks)** 

**(e) - Memory consistency errors | Visibility Problem** 
    
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


**(f) - Other** 

    Given : 
    An object that is not thread-safe (say SimpleDateFormat)
    You want to avoid synchronizing access to that object
    Instead, you want to give each thread its own instance of the object.

    Solution : Thread Local 
    The ThreadLocal class is used to create thread local variables,
    which can only be read and written by the same thread. 
    For example, if two threads are accessing code having reference to same threadLocal variable 
    then each thread will not see any modification to threadLocal variable done by other thread
    


#  4 - More on Synchronization of Threads


**(a) - Synchronize**

   - [Object Level Lock](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/tree/master/3-a-ObjectLevelLock)
   - [Class Level Lock](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/tree/master/3-b-ClassLevelLock)
 
**(b) - Producer Consumer : Inter Thread Communication**

   - [Using Wait & Notify](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/tree/master/3-c-ProducerConsumer-usingWaitNotify)
   - [Using Blocking Queue](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/tree/master/4-b-CountdownLatch)
   - [Using Extrinsic Lock and Condition Class](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/tree/master/3-e-ProducerConsumer-usingLock%26Condition) 
      
     https://www.youtube.com/watch?v=N0mMm5PF5Ow
  
  
**(c) - Types of Synchronizers**

   - [CountingSemaphore](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/tree/master/4-a-CountingSemaphore)
   - [CountdownLatch](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/tree/master/4-b-CountdownLatch)
   - [CyclicBarrier](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/tree/master/4-c-CyclicBarrier)
   - Exchanger
   - Phaser


#  5 - [Immutable Class](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/tree/master/6-a-ImmutableClasses-ThreadSafe)


      1 - What is an Immutable Class
      2 - Advantage
      3 - Use case 
      4 - Why Strings are Immutable in Java
      5 - How to make a class Immutable
           - Steps 
           - Immutable Class with Mutable Reference




# 5 - More on Thread Safety 

  
    - Immutable objects are by default thread-safe because their state can not be modified once created. 
      Since String is immutable in Java, it's inherently thread-safe.
    
    - Read-only or final variables in Java are also thread-safe in Java.

    - Example of thread-safe class in Java: Vector, Hashtable, ConcurrentHashMap, String, etc.

    - Local variables are also thread-safe because each thread has there own copy and 
      using local variables is a good way to write thread-safe code in Java.

    - Static variables if not synchronized properly become a major cause of thread-safety issues.


# 7 - [Java Memory Model](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/tree/master/7-a-Java-Memory-Model)

     
      1 - Stack vs Heap
      2 - Garbage Collection 
      3 - Types of Garbage Collectors
 
<!--- 
###################################################################################
## Section 8 - Implementation Examples | Use Cases MultiThreading
###################################################################################

**1 - [LRU Cache](https://github.com/abhiSyncd/Java-Threads-Step-By-Step/tree/master/8-b-LRUCache-usingHashMap%26DoubleLinkedList)**

**2 - Rate Limiting**
    
    - https://way2java.com/multithreading/realtime-examples-of-multithreading/
    - Gathering information from different web services running in parallel : CompletableFuture, which uses Fork-Join Pool by Default

---> 

# 8 : Residuals : More on Threads
    
   **1) Daemon Threads**
      
          The JVM exits when all the running threads are daemon threads. So imagine you're writing a simple game where your main method loops until you decide to quit. 
          And imagine   that at the start of the game, you start a thread that will endlessly poll some website to trigger alerts. 
	  You would like the JVM to exit when you decide to end the game. 
	  You don't want the endless polling to prevent the game from ending. So you make this polling thread a daemon thread.
    

  **2) Object-level-lock vs Class-Level-Lock vs Singleton**
  
      (a) Object level lock
          When we want to synchronize a non-static-method-or-codeBlock such that 
	  Only one thread will be able to execute the code block ON GIVEN INSTANCE OF THAT CLASS.
	  
      (b) Class Level Lock 
          Prevents multiple threads to enter in synchronized-block in any of ALL AVAILABLE INSTANCES OF THE CLASS on runtime.
          This means if in runtime there are 100 instances of DemoClass, then only one thread will be able to execute demoMethod() in any one of instance at a time, and 
	  all other instances will be locked for other threads.

      (c) Singleton 
          Restricts the instantiation of a class to one object.
	  
          Please note singleton pattern will not apply lock on the object. 
	  For example 2 different threads are sharing the same single object reference and can call the different method on that single object simultaneously.
          To avoid this, we use DOUBLE-CHECK-LOCKING.





