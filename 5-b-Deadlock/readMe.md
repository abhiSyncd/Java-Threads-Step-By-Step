

## 1 - Deadlock Problem : 

   https://web.mit.edu/6.005/www/fa15/classes/23-locks/
     
     
    synchronized keyword can cause Deadlock.
    Deadlock occurs when there are Thwo Threads, both of which are holding an Object that other thread wants.
    So both the threads will simply wait, wait and wait.
    
    Refer : https://www.youtube.com/watch?v=B4IVu-2hCos 
            https://dzone.com/articles/investigating-deadlocks-%E2%80%93-part-1  
	    https://www.codejava.net/java-core/concurrency/understanding-deadlock-livelock-and-starvation-with-code-examples-in-java
    
    
   **Ex)**
    
    public class Main {

      String object1 = "Java";
      String object2 = "UNIX";

      Thread trd1 = new Thread("My Thread 1") {
        public void run() {
          synchronized (object1) {
            System.out.println("Thread 1 ->" + object1);
            synchronized (object2) {
              System.out.println("Thread 1 ->" + object1 + object2);
            }
          }
        }
      };

      Thread trd2 = new Thread() {
        public void run() {
          synchronized (object2) {
            System.out.println("Thread 2 ->" + object2);
            synchronized (object1) {
              System.out.println("Thread 2 ->" + object2 + object1);
            }
          }
        }
      };

      public static void main(String a[]) {
        Main mdl = new Main();
        mdl.trd1.start();
        mdl.trd2.start();
      }
    }
	 
  
## 2 - SOLUTION :   
    
    - Lock Ordering
    - Lock Timeout : Not possible in Intrinsic Lock but possible in Extrinsic Lock
    - Deadlock Detection           


	 
