package single_thread;

import java.util.Locale;

public class SingleThreadDemo {
	/**
	 * Generate random numbers and fill in to array.
	 * Note: random()*n: generate a random No. from 0 to n - 1
	 * 
	 */
	public static void generateRandomNoToArray(int[] array, int arrayRange) {

		int myArray[] = array;
		int n = arrayRange;

		for(int i = 0; i < myArray.length; i++ ) {
			myArray[i] = (int) ((Math.random() * n) + 1);
		}

		for(int j = 0; j < myArray.length; j++) {
			System.out.print("Array index " + j + " : ");
			System.out.println(myArray[j]);
		}
	}//end generateRandomNoToArray()

	//Calculate array sum
	public static int sumArray(int[] array) {
		int sum = 0;
		int myArray[] = array; 

		for(int z = 0; z < myArray.length; z++) {
			sum += myArray[z];
		}

		System.out.println("\nSum of the array is: " + sum);
		return sum;
	}//end sumArray()


}//end class

