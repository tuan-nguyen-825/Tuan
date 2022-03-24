import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//Declare variable
		int n = 0;
		
		// Create objects
		Scanner input = new Scanner(System.in);
		FibIteration fibIteration = new FibIteration();
		FibIteration fibRecursion = new FibIteration();
		
		try {
		System.out.println("Enter a positive integer: ");
		n = input.nextInt();
		}catch(Exception e){
			System.out.println("Wrong number!");
		}
		//Iteration: time execution
		long startTimeIteration = System.nanoTime();
		System.out.println("Fibonacci number of " + n + " is: " + fibIteration.getFibNumber(n));
		long stopTimeIteration = System.nanoTime();
		long executionTimeIteration = stopTimeIteration - startTimeIteration;
		System.out.println("Executive time using iteration is: " + executionTimeIteration);
		System.out.println("-------------------------------------");
		
		//Recursion: time execution
		long startTimeRecursion = System.nanoTime();
		System.out.println("Fibonacci number of " + n + " is: " + fibRecursion.getFibNumber(n));
		long stopTimeRecursion = System.nanoTime();
		long executionTimeRecursion = stopTimeRecursion - startTimeRecursion;
		System.out.println("Executive time using recursion is: " + executionTimeIteration);

	}

}
