package multiple_threads;

import java.util.Locale;

public class MultiThreadDemo extends Thread{
	private Thread thread;
	private String threadName;

	//Constructor
	MultiThreadDemo(String name) {
		threadName = name;
		System.out.println("Creating " + threadName);
	}

	// run()
	public void run() {
		
		System.out.println("\nRunning " + threadName);
		
		int n = 10; // random() * n: random numbers from 0 to n-1
		int sum = 0;
		
		long startTime = System.nanoTime();
		try {
			//Create an array
			int[] myArray = new int[200_000];

			//Fill in random numbers to the array
			for(int i = 0; i < myArray.length; i++ ) {
				myArray[i] = (int) ((Math.random() * n) + 1);
			}
			Thread.sleep(50);

			//Display the array's elements
			for(int j = 0; j < myArray.length; j++) {
				System.out.print("Element index " + j + " of " + threadName + ": ");
				System.out.println(myArray[j]);
			}
			Thread.sleep(50);

			//Calculate array sum
			for(int z = 0; z < myArray.length; z++) {
				sum += myArray[z];
			}
			System.out.println("\nSum of " + threadName + " is: " + sum);

		} catch (InterruptedException e) {
			System.out.println(threadName + " is interrupted.");
		}
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;

		System.out.printf(Locale.US, "Total time run of %s is: %,d %n", threadName, totalTime);
		System.out.println("Exiting " + threadName + ". Completed.");
	}//end run

	// start()
	public void start()	{
		System.out.println("Starting " + threadName);
		if (thread == null) {
			thread = new Thread (this, threadName);
			thread.start();
		}
	}//end start()

}
