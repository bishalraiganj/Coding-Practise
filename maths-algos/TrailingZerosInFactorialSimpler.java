public class TrailingZerosInFactorialSimpler {


	public static void main(String... args)
	{
		System.out.println(trailingZerosInFactorial(500));
		System.out.println(trailingZerosInFactorial(120));
		System.out.println(trailingZerosInFactorial(1200));
		System.out.println(trailingZerosInFactorial(12000));
		System.out.println(trailingZerosInFactorial(12));
	}


	public static int trailingZerosInFactorial(int n)
	{
		int fact = factorial(n);
		int res = 0;

		while(  n % 10 == 0)
		{
			n /= 10;
			res++;
		}

		return res;
	}

	public static int factorial(int num)
	{
		int res = 1;

		for(int i = 1 ; i <=num ; i++)
		{
			res *= i;
		}

		return res;
	}
}
