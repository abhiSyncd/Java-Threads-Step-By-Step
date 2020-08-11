Object level lock is mechanism when we want to synchronize a non-static method or non-static code block 
such that only one thread will be able to execute the code block on given instance of the class. 

This should always be done to make instance level data thread safe.

-----------------------------------------------------------------------------------------------------

## 1 - Using synchronized keywords in Methods

    public class DemoClass{
        public synchronized void demoMethod(){}
    }


## 2 - Using synchronized keyword in Code-Block

    public class DemoClass{
        public void demoMethod(){
            synchronized (this){
                //other thread safe code
            }
        }
    }
