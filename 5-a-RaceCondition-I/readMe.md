
################################################################################################
## Section 1 - Race Condition 
################################################################################################
  
   **a)What is Race Condition**
     
       It is safe when multiple threads tries to READ any resource.
       Race Condition is a problem that arises when multiple threads access and WRITE on  
       the same resource (Variable | Arrays | ObjectDatabase | web-services) at the same time.

       Example : Race condition may occur when 2 user tries to book the same movie-ticket-seat at the same time 
       
       Refer : https://www.youtube.com/watch?v=cTECanJPaIc
       

   **b)Example**

        --------------------------------------------------------------------------------------------------------------
         
         public static void main(String[] args) throws InterruptedException {

          MyRunnable r = new MyRunnable();

          Thread thread1 = new Thread(r, "Thread1");
          Thread thread2 = new Thread(r, "Thread2");

          thread1.start(); 
          thread2.start();

          System.out.println("Main Thread :" + " Total Number-of-Count count-variable is accessed ->" + r.count);

        }
      
       --------------------------------------------------------------------------------------------------------------
       
       public class MyRunnable implements Runnable {

         public int count;

         @Override
         public void run() {
            for (int i = 0; i < 5; i++) {
                    count++;
            }

            //System.out.println(Thread.currentThread().getName() + " Final Count ->" + this.count);
         }
       }
    
       --------------------------------------------------------------------------------------------------------------
       
      Problem : 
        In Above example, count is an Instance variable as is stored in HEAP-AREA.
        All Threads share the HEAP-AREA, which makes it Not-Thread-Safe.

        Now, if 2-more threads shares an object and if 1-more thread updates variable in that shared object race condition will occur.

        Here, Each thread increments the Instance variable "count" by 5 Times.
        Since, we have 2 threads, the Final count after both the threads finish executing must be 10.

        But, when you will run the above eaxample multiple times, you will notice that count value is varying 6,7,8.
        This is happening because "count++" is not an ATMOIC operation.
      
     Solution : 
       Allow Only 1 Thread to access a resource at a time and blocks all threads.
       The thread which access the resource is in RUNNABLE state and all other threads will be in WAIT state.
     
       

################################################################################################
## Section 2 - Solution :  
################################################################################################

    
**Way 1 - Intrinsic Locks : Using Synchronized keyword (Block)**
      
    public class MyRunnable implements Runnable {

       public volatile int count;

       @Override
       public void run() {
        synchronized (this) {                 // Aquire a Lock Here
         for (int i = 0; i < 5; i++) {
          count++;
         } 
        }                                    // Release a Lock here
       }
      }
      
      Output : 
      Main Thread : Total Number-of-Count count-variable is accessed = 10
      
      Note : 
        First acquire the lock and then increment the count variable.
        When it’s done incrementing the variable, it can release the lock so that other threads waiting for the lock can acquire it.



**Way 2 -Extrinsic Lock  : Using ReentrantLock** 

    public class MyRunnable implements Runnable {

     public volatile int count;

     ReentrantLock lock = new ReentrantLock();

     @Override
     public void run() {
      try {
        lock.lock();                          // Aquire a Lock Here
        for (int i = 0; i < 5; i++) {
          count++;
        }
      } finally {
         lock.unlock();                       // Release a Lock here
      }
     }
    }
    
     Output : 
     Main Thread : Total Number-of-Count count-variable is accessed = 10
     
     Note : Must when using Loop API 
       - Try Catch Block 
       - Release lock in finally block : 
         to ensure no matter what happens while accessing the resource 
         You will always unlock the lock so that other threads can access it.
       - First acquire the lock and then increment the count variable.
         When it’s done incrementing the variable, it can release the lock so that other threads waiting for the lock can acquire it.
        
    

**Way 3 - Using Atomic Variable**

        public class MyRunnable implements Runnable {

         public AtomicInteger count = new AtomicInteger();

         @Override
         public void run() {
          for (int i = 0; i < 5; i++) {
           count.getAndIncrement();
          }
         }
       }

        Output : 
        Main Thread : Total Number-of-Count count-variable is accessed = 10
    
    
    

################################################################################################
## Section 3 - Synchronize vs ReetrantLock
################################################################################################

   **Intrinsic Lock** 
   
      Every object in Java has an intrinsic lock associated with it.
      synchronized' keyword uses intrinsic locks or monitors. 

      Whenever a thread tries to access a 
       - synchronized-instance-method : it acquires the intrinsic lock or the monitor on that object.
       - synchronized-static-method   : it acquires the lock over all the class objects

      Since JVM manages the Intrinsic locking, 
      The lock is only released when the thread is done executing the method OR an exception is thrown in the method which is not handled/caught.

      As long as a thread owns an intrinsic lock, all other threads are blocked no other thread can acquire the same lock.
      Even Thread.sleep() inside the synchronized method doesn't release the lock.


   **Extrinsic Lock**
      
       Extrinsic locking idioms allow more fine grained control over the operations, as against intrinsic locks
       such as FAIRNESS, lock polling, timed lock waits, and interruptible lock waits
       
       use it when you actually need something it provides that synchronized doesn't, like 
       timed lock waits, interruptible lock waits, non-block-structured locks, multiple condition variables, or lock polling
       
       
   
   
   **Synchronize vs ReetrantLock** 
   
       a)Reetrant Locks performance is good in case we have large no. of threads accessing the shared resoource

       b) FAIRNESS : ReentrantLock lock = new ReentrantLock(true)
          Synchronze keyword is UNFAIR
          But Reetrant Locks can both be UNFAIR and FAIR.
             
       c) Timed | Polled Lock Acquisition
          - synchronized keyword, a thread can be blocked waiting for a lock, for an indefinite period of time and there was no way to control that.
             In Intrinsic-Lock (using synchronizeeyword ) Lock-Timeout is not possible
             
              Thread-1 acquires a lock on shared-object and if doesn’t unlock the data
              Thread-2-request-thread on WAIT state to acquire the same lock, either
                - Till specified Time and returns with an Exception thrown : Timed lock-acquisition
                - Poll it at specific time                                 : Polled lock-acquisition

          - This avoids "Deadlock"


       d) LOCK INTERRUPTIBILY : https://javarevisited.blogspot.com/2013/03/reentrantlock-example-in-java-synchronized-difference-vs-lock.html
          - synchronized keyword, a thread can be blocked waiting for a lock, for an indefinite period of time and there was no way to control that.
            ReentrantLock provides a method called lockInterruptibly(), which can be used to interrupt thread when it is waiting for lock.
         
        



################################################################################################
## Section 4 - ReetrantLock 
################################################################################################




 **1 - What is Reetrant Lock**
     
     - ReentrantLock is an exclusive lock, which allows only one thread to access at the same time. 
     
     - Example
     
       ReentrantLock lock = new ReentrantLock();
       try {
              lock.lock();
              // Write operation on resource shared by multiple threads : Thread safe Code to execute
            } finally {
               lock.unlock();
            }

      Note : Try-Catch-Finally Block must be used
             What if there is an exception while accessing the resource after Locking it
             Then lock.unlock() method will never be called.
             As a result Threads who are waiting to aquire the lock will always be in WAITing state.
             So we must always Release the lock in finally block, so that other waiting threads can continue its processing

      
 **2 - Fairness**  
 
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
          
 
  **3 - Timed and polled lock-acquisition**  : https://www.callicoder.com/java-locks-and-atomic-variables-tutorial/
         It lets you regain control if you cannot acquire all the required locks, release the ones you have acquired and retry.
         
         
         The second difference between synchronized and Reentrant lock is tryLock() method. ReentrantLock provides a convenient tryLock() method, which acquires lock only if its available or not held by any other thread. This reduces the blocking of thread waiting for lock-in Java application.


https://www.baeldung.com/java-concurrent-locks
https://gist.github.com/vikasverma787/9acfb081c4f4364b8100557635cc6178

Read more: https://javarevisited.blogspot.com/2013/03/reentrantlock-example-in-java-synchronized-difference-vs-lock.html#ixzz6UAKfxgmo


         
  
  
################################################################################################
## Section 5 - Types of Extrinsic Lock : Lock API 
################################################################################################
  
  a)ReetrantLock
  b)ReetrantReadWriteLock
  c)Stamped Lock(Java 8) :  https://www.educative.io/courses/java-8-lambdas-stream-api-beyond/JYBojJkLlPo
   