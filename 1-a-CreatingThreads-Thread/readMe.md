
##  1 - Using Thread-Class as separate Class  

     public class MyThreadExample {
       public static void main(String[] args) {
       
          Thread thread = new MyThread();
          thread.start(); // Run the thread Asynchronously i.e Main Thread is Not Blocked
	  
          System.out.println("Main Thread : " + Thread.currentThread().getName());
	  
       }
     }
     
     ---------------------------------------------------------------------------------------
     
     public class MyThread extends Thread {
     
       public void run() {
          try {
            Thread.sleep(2000L);
            System.out.println("Response from Database from seperate thread : " + Thread.currentThread().getName());
          }catch (InterruptedException e) {
            e.printStackTrace();
           }
       }
       
     }
     
     Output : 
       Main Thread : main
       Response from Database from seperate thread : Thread-0


##  2 - Using Thread Class as Anonymous Inner Class 

     public class MyThreadExample {
       public static void main(String[] args) {
       
          new Thread(){
             public void run() {
               System.out.println("Response from Database from seperate thread : " + Thread.currentThread().getName());
             }
          }.start();

         System.out.println("Main Thread : " + Thread.currentThread().getName());
	 
       }
     }  


##  3 - Using Lambda  
    
     public class MyThreadExample {
       public static void main(String[] args) {
           new Thread(() -> {
              System.out.println("Response from Database from seperate thread : " + Thread.currentThread().getName());
           }).start();

           System.out.println("Main Thread : " + Thread.currentThread().getName());
       }
     }
