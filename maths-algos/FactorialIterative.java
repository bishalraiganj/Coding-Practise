public class FactorialIterative {


	public static void main(String... args)
	{
		System.out.println(factorial(12));
	}

	public static int factorial(int num)
	{
		int res = 1;
		for ( int i = 1 ; i <= num ; i++)
		{
			res *= i;
		}
		return res;
	}
}
