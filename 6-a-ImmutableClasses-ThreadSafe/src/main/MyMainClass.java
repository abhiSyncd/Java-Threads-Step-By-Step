package main;

/**
 * https://www.thecuriousdev.org/achieve-thread-safety-immutability/   : Builder Pattern
 */
public class MyMainClass {

	public static void main(String[] args) {

		 ImmutableEmployee immutableEmployee = ImmutableEmployee.builder()
		            .setName("Abhishek")
		            .setCity("Bangalore")
		            .build();
		 
		 
		 
		new Thread(() -> {
			try {
				Thread.sleep(5); // Simulate some work
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ImmutableEmployee.builder()
            .setCity("Patna").build();
			
		}).start();

		
		new Thread(() -> {
			if ("Bangalore".equals(immutableEmployee.getCity())) {
				try {
					Thread.sleep(10); // Simulate some work
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Abhishek lives in " + immutableEmployee.getCity()); // Output : Abhishek lives in Bangalore
																			
			}

		}).start();

	}
}
