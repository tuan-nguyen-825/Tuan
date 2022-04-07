package single_thread;

import java.util.Locale;

public class TestSingleThread {

	public static void main(String[] args) {
		//Create 2 objects and 2 arrays
		SingleThreadDemo T1 = new SingleThreadDemo();
		SingleThreadDemo T2 = new SingleThreadDemo();
		int[] firstArray = new int[200_000_000];
		//int[] secondArray = new int[200_000_000];

		//Calculate time run for T1
		long startTimeT1 = System.nanoTime();
		T1.generateRandomNoToArray(firstArray, 10);
		T1.sumArray(firstArray);
		long endTimeT1 = System.nanoTime();
		long totalTimeT1 = endTimeT1 - startTimeT1;
		System.out.printf(Locale.US, "Total time run for T1: %,d %n \n\n", totalTimeT1);
		
		//Calculate time run for T2
		long startTimeT2 = System.nanoTime();
		T2.generateRandomNoToArray(firstArray, 10);
		T2.sumArray(firstArray);
		long endTimeT2 = System.nanoTime();
		long totalTimeT2 = endTimeT2 - startTimeT2;
		System.out.printf(Locale.US, "Total time run for T2: %,d %n", totalTimeT2);

	}

}
