

      https://www.youtube.com/watch?v=ErNre5varF8
      https://engineering.zalando.com/posts/2019/04/how-to-set-an-ideal-thread-pool-size.html
   
   
   
# 1 - Need 
   
    /** Thread Pool constructor */
    public ThreadPoolExecutor(
                  int corePoolSize,
                  int maximumPoolSize,
                  long keepAliveTime,
                  TimeUnit unit,
                  BlockingQueue workQueue) {...}
 
     /** Cached Thread Pool */
    public static ExecutorService newCachedThreadPool() {
           return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                                         60L, TimeUnit.SECONDS,
                                         new SynchronousQueue());
    }


    Here,
    Do you see this SynchronousQueue? 
    It means that each new task will create a new thread if all existing threads are busy. 
    In the case of high load, at best we will get a thread "starvation" situation, at worst OutOfMemoryError.

    It is better to maintain control and not allow clients to "DDoS/throttle" our service.


# 2 - Thread Pool Size Considerations 

   **(a) CPU Bound Tasks**

     Tasks which involves mathematical calculations.
     
     CPU Core
     A single core CPU will run one thread at a time.
     A normal desktop generally is a quad core that means there are four cores in a CPU. 
     While a cloud or server may have as many as cores in CPU.
     
     
     
     
   **(b) IO Bound Tasks**

     - Database Calls
       For example if a worker thread depends on a database, 
       the thread pool is limited by the database's connection pool size. 
       Does it make any sense to have 1000 running threads in front of a database connection pool with 100 connections?
     
     - Service Calls
       If a worker thread calls an external service which can handle only a few requests simultaneously, 
       the thread pool is limited by the throughput of this service as well
     
     
# 3 - 

    Number of threads = Number of Available Cores * (1 + Wait time / Service time)
    
    Ideal thread Count= Number of Cores * [ 1+ (wait time/CPU time)]
    
    
    Here,
    Waiting time : Time spent waiting for IO bound tasks to complete, say waiting for HTTP response from remote service.
                   Not only IO bound tasks, it could be time waiting to get monitor lock or time when thread is in WAITING/TIMED_WAITING state
    
    Service time : Time spent being busy, say processing the HTTP response, marshaling/unmarshaling, any other transformations etc. 
    
    
    
    
    
    Number of threads = Number of Available Cores * Target CPU utilization * (1 + Wait time / Service time)
   
    Here,
    
   


