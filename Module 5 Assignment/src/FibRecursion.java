
public class FibRecursion {
	//Declare variable
	int fib;
	//Find Fibonacci using recursion method
	public int getFibNumber(int n)
	{
		if (n == 1) return 0;
		if (n == 2) return 1;
		return fib = getFibNumber(n - 1) + getFibNumber(n-2);
	}

}
