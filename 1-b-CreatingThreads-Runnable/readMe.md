
##  1 - Using Runnable-Interface as separate Class  
   
        public class MyRunnableExample {
         public static void main(String[] args) throws InterruptedException {

          Runnable runnable = new MyRunnable();
          Thread thread1 = new Thread(runnable, "Thread 1");

          thread1.start(); // Run the thread Asynchronously, I.e Main Thread is not blocked

          System.out.println("Main Thread : " + Thread.currentThread().getName());
         }
        }
     
        ---------------------------------------------------------------------------------------
        
        public class MyRunnable implements Runnable {
         @Override
         public void run() {
           try {
              Thread.sleep(2000L); // Perform Long Running Task
              System.out.println("Response from Database from seperate thread : " + Thread.currentThread().getName());
                  } catch (InterruptedException e) {
              e.printStackTrace();
             }	
         }
        }
   
       ----------------------------------------------------------------------------------------------
       
       Output : 
        Main Thread : main
        Response from Database from seperate thread : Thread 1


##  2 - Using Runnable-Interface as Anonymous Inner Class 

       public static void main(String[] args) throws InterruptedException {
       
		Runnable runnable = new Runnable() {
		  public void run() {
		   System.out.println("Response from Database from seperate thread : " + Thread.currentThread().getName());
		  }
		};

		new Thread(runnable).start();

		System.out.println("Main Thread : " + Thread.currentThread().getName());
	}


##  3 - Using Lambda  
   
         public static void main(String[] args) throws InterruptedException {

		Runnable runnable = () -> {
		  System.out.println("Response from Database from seperate thread : " + Thread.currentThread().getName());
		};

		new Thread(runnable).start();

		System.out.println("Main Thread : " + Thread.currentThread().getName());
	 }



##  4 - Passing Data To Runnable 
        
  ### i) Using Using Runnable-Interface as separate Class  
  
        public static void main(String[] args) throws InterruptedException {
                Runnable runnable = new MyRunnable("Abhishek");
                Thread thread1 = new Thread(runnable, "Thread 1");
                thread1.start(); // Run the thread Asynchronously, I.e Main Thread is not blocked
                System.out.println("Main Thread : " + Thread.currentThread().getName());
        }
   
        ---------------------------------------------------------------------------------------
	
        public class MyRunnable implements Runnable {
	
		String str;

		public MyRunnable(String str) {
		  this.str = str;
		}

		@Override
		public void run() {
		   System.out.println("Response from Database from seperate thread : " + 
				      "Passed Parameter : " + str + " - " + 
				      Thread.currentThread().getName());
		}
      } 


   ### ii) Using Runnable-Interface as Anonymous Inner Class  | Lambda 
    
          - You can use Global Variable.
     
