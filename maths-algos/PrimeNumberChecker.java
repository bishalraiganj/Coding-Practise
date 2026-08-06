public class PrimeNumberChecker {

	public static void main(String... args)
	{
		System.out.println(isPrime(19));
		System.out.println(isPrime(21));
		System.out.println(isPrime(8));
		System.out.println(isPrime(17));

	}

	//Square root and 6k + r optimization
	public static boolean isPrime(int n)
	{
		if(n<=1)
		{
			return false;
		}

		if(n % 2  == 0 || n % 3 == 0 ) return false;

		for( int i = 5 ; i * i   <= n ; i += 6)
		{
			if(n % i == 0 || n % (i + 2) == 0)
			{
				return false;
			}
		}
		return true;
	}
}
