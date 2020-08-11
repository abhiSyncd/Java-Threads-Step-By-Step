    Problem : 
    3 Bikers have started driving from Manali to Leh.
    All of them are driving at different speed,they have decided some checkpoints in the route.

    After reaching 1st checkpoint, everybody waits for others to reach that checkpoint.

    When all 3 arrives,they will refill the petrol tanks resume their rides and drive untill their next checkpoint.

  ----------------------------------------------------------------------------------------------------

    public class Biker implements Runnable {

      private final CyclicBarrier checkPoint;

      public Biker(CyclicBarrier checkPoint) {
        this.checkPoint = checkPoint;
      }

      @Override
      public void run() {
        try {
          System.out.println(Thread.currentThread().getName() + " has left Manali.");

          checkPoint.await();                                                    
          System.out.println(Thread.currentThread().getName() + " Reached 1st Checkpoint.");

          checkPoint.await();                                                   
          System.out.println(Thread.currentThread().getName() + " Reached 2nd Checkpiont.");

          checkPoint.await();                                                   
          System.out.println(Thread.currentThread().getName() + " has reached LEH!!!");


        } catch (InterruptedException | BrokenBarrierException e) {
          e.printStackTrace();
        }
      }

    }

  ----------------------------------------------------------------------------------------------------
  
    public static void main(String[] args) {

      final  CyclicBarrier checkPoint  = new CyclicBarrier(3 , new Runnable() {
        @Override
        public void run() {
          //Executed when all Bikers(Threads) reaches the Checkpoint(Barrier)
          System.out.println("All Bikers Arrived at checkpoint,Let's refill the Petrol");  
        }
      });

      Runnable biker1 = new Biker(checkPoint);
      Runnable biker2 = new Biker(checkPoint);
      Runnable biker3 = new Biker(checkPoint);

      Thread bThread1 = new Thread(biker1,"Biker1");
      Thread bThread2 = new Thread(biker2,"Biker2");
      Thread bThread3 = new Thread(biker3,"Biker3");


      bThread1.start();
      bThread2.start();
      bThread3.start();
	}

  
  Soucre : https://codepumpkin.com/cyclicbarrier-java-concurrency-utilities/
   
   
