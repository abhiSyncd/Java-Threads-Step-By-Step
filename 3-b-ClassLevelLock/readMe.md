Class level lock prevents multiple threads to enter in synchronized block in any of all available instances of the class on runtime.

This means if in runtime there are 100 instances of DemoClass,
then only one thread will be able to execute demoMethod() in any one of instance at a time, and 
all other instances will be locked for other threads.

-----------------------------------------------------------------------------------------------------

## 1 - Using synchronized keywords in Methods

    public class DemoClass{
      public synchronized static void demoMethod(){
        //other thread safe code
      }
    }
 

## 2 - Using synchronized keyword in Code-Block

    public class DemoClass{
    
     public void demoMethod()
       synchronized (DemoClass.class){
          //other thread safe code
     }
       
     }
    }
    

