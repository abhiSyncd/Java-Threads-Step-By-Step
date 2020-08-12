
##  1 - Using Thread-Class as separate Class  

     public class MyThreadExample {
       public static void main(String[] args) {
       
          Thread thread = new MyThread();
          thread.start(); // Run a separate thread Asynchronously i.e Main Thread is Not Blocked
	  
          System.out.println("Main Thread executing : " + Thread.currentThread().getName());
	  
       }
     }
     
     ---------------------------------------------------------------------------------------
     
     public class MyThread extends Thread {
       public void run() {
            System.out.println("Response from Database from seperate thread : " + Thread.currentThread().getName());
       }
     }
     
     Output : 
     Main Thread executing : main
     Response from Database from seperate thread : Thread-0
     
     Note : 
      - main() method                   : 'main' thread starts and put into it  'RUNNABLE' state
      - Thread t1 = new MyThread()      : creates a separate thread 't1' and put it into 'NEW' state
      - t1.start()                      : That separate thread is put it into 'RUNNABLE' state
      - Now two threads 'main' and 't1' : are in 'RUNNABLE' state.

        There’s no guarantee of which thread runs first as they are both started concurrently
        As JVM schedular makes descision about which runnable threads will go into 'RUNNING' state.
	If you run this program again for several times, you will see sometimes the thread Thread-0 runs first, sometimes the thread main runs first.
	 
	 

##  2 - Using Thread Class as Anonymous Inner Class 

     public class MyThreadExample {
       public static void main(String[] args) {
       
          new Thread(){
             public void run() {
               System.out.println("Response from Database from seperate thread : " + Thread.currentThread().getName());
             }
          }.start();    

         System.out.println("Main Thread executing : " + Thread.currentThread().getName());
	 
       }
     }  



##  3 - Using Lambda  
    
     public class MyThreadExample {
       public static void main(String[] args) {
       
           new Thread(() -> {
              System.out.println("Response from Database from seperate thread : " + Thread.currentThread().getName());
           }).start();

           System.out.println("Main Thread executing : " + Thread.currentThread().getName());
       }
     }
     
