   
   
# 1 - Basics

    A counting semaphore is a type of LOCK that allows you to limit the number of processes that can concurrently access a resource to some fixed number.
    ReetrantLock can behave as a counting semaphore with a limit of 1.
    
    Generally, counting semaphores are used to limit the amount of resources that can be used at one time
    
    It can be used as a RATE LIMITER : limit how many background Threads (Jobs) are allowed to run concurrently

    Semaphores – Restrict the number of threads that can access a resource. Example, limit max 10 connections to access a file simultaneously.

    Mutex – 
    Only one thread to access a resource at once. 
    Example, when a client is accessing a file, no one else should have access the same file at the same time.
    

# 2 - Working

    If semaphore count > 0, the thread acquires a permit, decrementing the semaphore’s count.

    Else, the thread is blocked until a permit can be acquired.

    When thread no longer needs access to a shared resource, it releases the permit, incrementing the semaphore count.

    If another thread is waiting for a permit, then that thread will acquire a permit at that time.

  
    
# Residuals

    E.x) Producer Consumer Using Semaphore : https://javarevisited.blogspot.com/2012/02/producer-consumer-design-pattern-with.html

     https://subscription.packtpub.com/book/application_development/9781788627900/3/ch03lvl1sec20/counting-semaphores

    You can use them to manage resource pools with more than one entry, or allow multiple consumer threads to block on a producer.

    With a resource pool, you set the count to its total size on intialization, decrement by one for each allocation, and 
    increment by one for each free. Any number of threads can block on the pool, but the number active can’t exceed the number of resources.

    In a producer/consumer situation you can associate a counting semaphore with a container (typically a queue), increment after insert, and decrement before removal.



