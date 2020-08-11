

     CountDownLatch : Synchronizer which allows one Thread to wait for one-or-more thread , before processing

     Problem : 
     3 employees shares a common cab while leaving for office.
     Driver will drive the cab only when all 3 passengers take their seats in the car 

     Solution 
     CountDownLatch must be set to 3, One for the each passengers 
     Main Thread : Driver, resumes|Drives the car only when all Other-Threads|Passengers arrives
     
    -------------------------------------------------------------------------------------------------
    
      public class Passenger implements Runnable {

      private final CountDownLatch latch;

      public Passenger(CountDownLatch latch) {
        this.latch = latch;
      }

      @Override
      public void run() {
        System.out.println(Thread.currentThread().getName() + " reached.");
          latch.countDown(); //reduce count of CountDownLatch by 1    
      }

    }

    -------------------------------------------------------------------------------------------------
     
     public static void main(String[] args) {

      final CountDownLatch latch = new CountDownLatch(3);

      Runnable passenger1 = new Passenger(latch);
      Runnable passenger2 = new Passenger(latch);
      Runnable passenger3 = new Passenger(latch);

      Thread pThread1 = new Thread(passenger1,"Thread1");
      Thread pThread2 = new Thread(passenger2,"Thread2");
      Thread pThread3 = new Thread(passenger3,"Thread3");


      pThread1.start();
      pThread2.start();
      pThread3.start();


      try {
         latch.await();
         System.out.println("Main Thread Resumes : All Passenger Boarded,Driver started the car");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }
    
    Output : 
    Thread2 reached.
    Thread1 reached.
    Thread3 reached.
    Main Thread Resumes : All Passenger Boarded,Driver started the car
    
    

   Source : https://codepumpkin.com/countdownlatch-java-concurrency/

