

STOPPING THREADS
https://praveer09.github.io/technology/2015/12/06/understanding-thread-interruption-in-java/
https://codepumpkin.com/interrupt-interrupted-isinterrupted-java-multithreading/

## 1 - Use Case 

    Thread Timeout : 
    A thread performing a long running task.
    Stop that thread if it takes more than a specified time 


## 2 - Problem : But Java Threads cannot be Stpped or killed
 
        Runnable runnable = () -> {
         //Long running task in a separate thread other than Main thread
        };
        new Thread(runnable).start();

        It's easy to start a thread in Java because you have a start() method but 
        it's difficult to STOP the thread because there is no stop() or Cancel() method in Thread Class.
        If you remember, 
        threads in Java start execution from run() method and 
        stop when it comes out of run() method, either normally or due to any exception

       ---------------------------------------------------------------------------------------------

       ExecutorService executor = Executors.newSingleThreadExecutor();
       executor.submit(() -> {
         //Long running Runnable task in a separate thread other than Main thread
       });

       executor.shutdown();  
         - No new task accepted
         - Previously submitted task are executed 
         
       executor.shutdownNow();
         - No new task accepted
         - Previously submitted task are executed 
         - Task being run by the thread(s) are ATTEMPTED to stop but no Guarantee that it will stop 
           Internally calls Thread.interrupt for all runnning threads
           
           
         

## 3 - Solution 

  ** 3-I-Using Interrupts 

  Source : https://www.youtube.com/watch?v=_RSAS-gIjGo

          a)Interrupts : https://codepumpkin.com/interrupt-interrupted-isinterrupted-java-multithreading/

          Runnable runnable = () -> {
              while (Thread.currentThread().isInterrupted()) {
                break;
              }
            };

            Thread thread = new Thread(runnable);
            thread.start();

            thread.interrupt();
  
  b)Volatile variable
  
  c)AtomicBoolean variable

