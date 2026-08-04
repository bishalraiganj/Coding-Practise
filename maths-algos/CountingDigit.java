public class CountingDigit {


	public static void main(String... args)
	{
		System.out.println(countDigits(10));
		System.out.println(countDigits(9));
		System.out.println(countDigits(887));
		System.out.println(countDigits(999));
		System.out.println(countDigits(9999));
		System.out.println(countDigits(0));

	}


	public static int countDigits(int n)
	{
		int res  = 0 ;

		while ( n > 0)
		{
			n = n/10;
			res ++ ;
		}
		return res;

	}
}
