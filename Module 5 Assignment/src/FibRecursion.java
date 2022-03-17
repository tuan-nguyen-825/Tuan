/**
 * Class to find a Fibonacci number using recursion method.
 * 
 * @author Tuan Nguyen
 *
 */
public class FibRecursion {
	//Declare variable
	int fib;
	/**
	 * Method to find Fibonacci number using recursion approch
	 * 
	 * @param fib fibonacci number at a given nth nubmer
	 * @return fib
	 */
	public int getFibNumber(int n)
	{
		if (n == 1) return 0;
		if (n == 2) return 1;
		return fib = getFibNumber(n - 1) + getFibNumber(n-2);
	}

}
