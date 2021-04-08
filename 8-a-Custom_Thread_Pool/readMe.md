   
# 1 - Need 
   
    To utilize the maximum CPU and increase the performance of java program
    
    - Thread Pool Executor constructor 
      > int corePoolSize     
      > int maximumPoolSize 
      > long keepAliveTime 
      > TimeUnit unit 
      > BlockingQueue workQueue
      > RejectedExecutionHandler handler


    Here 
    CorePoolSize = This will create 10 threads at the time of initialization

    BlockingQueue works on following rules:
    > Running Threads < CorePoolSize      : Executor creates a new thread
    > Running Threads = CorePoolSize      : Executor adds request in the queue rather than adding a new thread.
                                            If queue is full it will create 11th thread and will go till MaximumPoolSize                                  
    > Running Threads > MaximumPoolSize   : Requests cannot be Queued, Executor throws TaskRejected Exception.

   
    In the case of high load, at best we will get a thread "starvation" situation, at worst OutOfMemoryError.
    It is better to maintain control and not allow clients to "DDoS/throttle" our service.


# 2 - Thread Pool Size Considerations 

## (a)CPU Bound Tasks

     Tasks which involves mathematical calculations.
     
     CPU Core
     Single Core : CPU will run one thread at a time.
     Quad Core   : normal desktop generally has four cores in a CPU.
     Multi Core  : While a cloud or server may have as many as cores in CPU.
     Multi CPU   : Supercomputers     

## (b)IO Bound Tasks

**Database Calls**
 
    PROBLEM
    > A thread is blocked until DB response is returned.
    > The thread pool is limited by the database's connection pool size.
      Does it make any sense to have 1000 running threads in front of a database connection pool with 100 connections?
     
    SOLUTION 
    > Asynchronous call
    > Configure Hikari Pool size 
   
**Service Calls**

    PROBLEM 
    > A thread is blocked until DB response is returned.
    > The thread pool is limited by the throughput of this service as well.
    
    SOLUTION
    > Asynchronous call
    > Configure a Thread Pool Size

     
     
# 3 - Ideal Thread Pool Size Formula

**(a)**

    -  CPU Bound Task -> Ideal thread Count  = Number of Available Cores * [ 1 + (wait time/CPU time)]
    -  Io Bound Task  -> Ideal thread Count  = Number of Available Cores * [ 1 + (Wait time/Service time)]
    
    Here :
    Waiting time : Response Time i.e Time spent waiting for IO bound tasks to complete, 
                   say waiting for HTTP response from remote service.
    
    Service time : Time spent being busy, say processing the HTTP response, marshaling/unmarshaling, any other transformations etc. 
    
    But this example is oversimplified. Besides an HTTP connection pool, your application may have requests from JMS and probably a JDBC connection pool.
   

**(b)**

    If you have different classes of tasks it is best practice to use multiple thread pools, so each can be tuned according to its workload.
    In case of multiple thread pools, just add a target CPU utilization parameter to the formula.

    Target CPU utilization [0..1], 1 - means thread pull will keep the processors fully utilized).
    The formula becomes:
    Ideal thread Count = Number of Available Cores * Target CPU utilization * [ 1 + (Wait time / Service time)]

