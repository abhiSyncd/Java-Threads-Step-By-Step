package main;

public class MyMain {

	String resource1 = "Java";
	String resource2 = "UNIX";

	Thread trd1 = new Thread("My Thread 1") {
		public void run() {
			synchronized (resource1) {
				System.out.println("Thread 1 ->" + resource1);
				synchronized (resource2) {
					System.out.println("Thread 1 ->" + resource1 + resource2);
				}
			}
		}
	};

	Thread trd2 = new Thread() {
		public void run() {
			synchronized (resource2) {
				System.out.println("Thread 2 ->" + resource2);
				synchronized (resource1) {
					System.out.println("Thread 2 ->" + resource2 + resource1);
				}
			}
		}
	};

	public static void main(String a[]) {
		MyMain mdl = new MyMain();
		mdl.trd1.start();
		mdl.trd2.start();
	}

}

  // Ex.2)https://gist.github.com/jirkapinkas/ce1285df9a06d7ba094eb78997942563
