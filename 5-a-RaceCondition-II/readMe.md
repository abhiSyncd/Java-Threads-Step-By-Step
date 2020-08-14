


        Threads - T0 DO 

        Design a Custom Thread Pool : https://www.javacodemonk.com/implement-custom-thread-pool-in-java-without-executor-framework-ca10e61d


        lock()                                       :  The lock() method locks the Lock instance if possible. If the Lock instance is already locked, the thread calling lock() is blocked until the Lock is unlocked

        tryLock()                                    :  lock the Lock instance immediately. 
                                                        It returns true if the locking succeeds, false if Lock is already locked. 
                                This method never blocks.

        The tryLock(long timeout, TimeUnit timeUnit) :  works like the tryLock() method, except it waits up the given timeout before giving up trying to lock the Lock.


        lockInterruptibly()                          : ReentrantLock class hold the lock until or unless the current thread is interrupted.

                                                      it allows the thread to immediately react to the interrupt signal sent to it from another thread.
                                 For example, it can be used to kill a contingent of threads in a pool which are all waiting to aquire a lock.


        https://www.javacodemonk.com/what-is-deadlock-in-java-how-to-troubleshoot-and-how-to-avoid-deadlock-2526a14f
