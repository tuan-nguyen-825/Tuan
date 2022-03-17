
public class Main {

	public static void main(String[] args) {
		// Create objects
		FibIteration fibIteration = new FibIteration();
		FibIteration fibRecursion = new FibIteration();
		
		long startTimeIteration = System.nanoTime();
		System.out.println("Fibonacci number is: " + fibIteration.getFibNumber(10));
		long stopTimeIteration = System.nanoTime();
		long executionTimeIteration = stopTimeIteration - startTimeIteration;
		System.out.println("Executive time using iteration is: " + executionTimeIteration);
		System.out.println("-------------------------------------");
		
		long startTimeRecursion = System.nanoTime();
		System.out.println("Fibonacci number is: " + fibRecursion.getFibNumber(100));
		long stopTimeRecursion = System.nanoTime();
		long executionTimeRecursion = stopTimeRecursion - startTimeRecursion;
		System.out.println("Executive time using recursion is: " + executionTimeIteration);


		

		
	}

}
