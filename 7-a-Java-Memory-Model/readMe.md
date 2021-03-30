  
# 1 - JVM divides memory into stack and heap memory   
     
  ## i) Stack Area
   
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
   
   
   ## ii) Heap Area  
       
       a) All Threads share the HEAP-AREA,
          which makes it Not-Thread-Safe

       b) HEAP-AREA contains 
          - Object (Instance-Variable)
          - Class Defination + Static Variables 

       c) If heap space is full, Java throws java.lang.OutOfMemoryError

       d) Slower compared to STACK-AREA

  
# 2 - Garbage Collector
     
   ## i) HEAP AREA further divided into 
    
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
	   
	   
   ## ii) Garbage Collector Steps
   
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


 ## iii) Garbage Collector Types 
        
	a)A serial Collector 

	b)Concurrent Collector 

	c)Parallel Collector 
	
	When use what : https://www.youtube.com/watch?v=2AZ0KKeXJSo&t=655s
       
 
