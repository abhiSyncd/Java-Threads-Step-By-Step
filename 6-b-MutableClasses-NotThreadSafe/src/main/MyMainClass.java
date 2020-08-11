package main;


public class MyMainClass {

	public static void main(String[] args) {

		MutableEmployee employee = new MutableEmployee("Abhishek", "Bangalore");

		new Thread(() -> {
			try {
				Thread.sleep(5); // Simulate some work
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			employee.setCity("Patna");
		}).start();

		
		new Thread(() -> {
			if ("Bangalore".equals(employee.getCity())) {
				try {
					Thread.sleep(10); // Simulate some work
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Abhishek lives in " + employee.getCity()); // Output : Abhishek lives in Patna
																				// we expect the employee’s city to be
																				// Bangalore' as well when printing it
																				// out.
			}

		}).start();

	}
}