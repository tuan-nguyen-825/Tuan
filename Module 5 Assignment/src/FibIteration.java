/**
 * This class use for calculating Fibonacci number at a given nth number.
 * Iterative method uses for loop to look for each fib number starting at n = 3 until meet F(n). 
 * The first two fib numbers in fib sequence is alway zero and 1, so no need to loop through them.
 * 
 * @author Tuan Nguyen
 *
 */
public class FibIteration {
	//Declare variable
	long prevFib1;
	long prevFib2;
	long currentFib;
	/**
	 * Method to find Fibonacci Number at a given nth number using iterative approach.
	 * Fibonacci sequence start with zero and 1.
	 * Next Fibonacci number is the sum of its two previous fib numbers.
	 * Iterative approach will loop through each fib number.
	 * After each iteration, the two preceding fib numbers will move forward by swap to next fib number. 
	 * 
	 * @param prevFib1 previous Fibonacci number at F(n-2)
	 * @param prevFib2 previous Fibonacci number at F(n-1)
	 * @param currentFib Fibonacci number at F(n)
	 * 
	 * 
	 * @return currentFib
	 * @author Tuan Nguyen
	 */
	//Finding nth Fibonacci Number
	public long getFibNumber (int n)
	{
		if(n == 1) return 0; //Fibonacci sequence start with zero and 1
		if(n == 2) return 1;
		
		//Loop through each F(n) by adding its preceding fib numbers
		//Move the preceding forward after each iteration
		prevFib1 = 0;
		prevFib2 = 1;
		for(int i = 3; i <= n; i++)
		{
			currentFib = prevFib1 + prevFib2;
			prevFib1 = prevFib2;
			prevFib2 = currentFib;
		}
		return currentFib;
		
	}
	
}
