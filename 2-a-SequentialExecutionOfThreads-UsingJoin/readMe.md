################################################################################################
## Section 1 - Example 
################################################################################################

    public class MyRunnable implements Runnable {
      @Override
      public void run() {

        String[] array = { "My", "Name", "is", "Abhishek" };

        for (String str : array) {
          try {
            Thread.sleep(1000L);
            System.out.println(Thread.currentThread().getName() + "-->" + str);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }
    
    ------------------------------------------------------------------------------
    
    public static void main(String[] args) throws InterruptedException {

		Runnable r = new MyRunnable();

		Thread thread1 = new Thread(r, "Thread1");
		Thread thread2 = new Thread(r, "Thread2");
		Thread thread3 = new Thread(r, "Thread3");

		thread1.start();
		thread1.join(); // Start thread2, once thread1 is finished
		thread2.start();
		thread2.join(); // Start thread3, once thread1 is finished
		thread3.start();
		thread3.join(); // Start Main Thread,once thread 3 is finished

		System.out.println("Main Thread");

	}

################################################################################################
## Section 2 -  Problem : Without Using join()
################################################################################################

    Normally we have more than one thread, 
    Thread scheduler schedules the threads, which does not guarantee the order of execution of threads.

    Ex)Output : (Without using Joins)
       Main Thread
       Thread3-->My
       Thread1-->My
       Thread2-->My
       Thread1-->Name
       Thread3-->Name
       Thread2-->Name
       Thread1-->is
       Thread3-->is
       Thread2-->is
       Thread3-->Abhishek
       Thread1-->Abhishek
       Thread2-->Abhishek

    Here, 
    We have three threads Thread1, Thread2 and Thread3.
    Even though we have started the threads in a sequential manner the thread scheduler does not start and 
    end them in the specified order. 
    Everytime you run this code, you may get a different result each time

################################################################################################
## Section 3 - Solution : Using join() : Executes Threads in Particular Order( Sequential Order)
################################################################################################

    Ex)Output : (using Joins)
    Thread1-->My
    Thread1-->Name
    Thread1-->is
    Thread1-->Abhishek

    Thread2-->My
    Thread2-->Name
    Thread2-->is
    Thread2-->Abhishek

    Thread3-->My
    Thread3-->Name
    Thread3-->is
    Thread3-->Abhishek

    Main Thread
    
    Note : Main Thread is Blocked unlike 'Ex in without using join()
