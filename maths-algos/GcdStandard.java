public class GcdStandard {

	public static void main(String... args)
	{
		System.out.println(gcd(3,6));
		System.out.println(gcd(3,9));
		System.out.println(gcd(9,9));
	}


	public static int gcd(int a, int b)
	{


		int small = a <= b? a : b ;
//		int big = a <= b ? b : a;
//		if(big % small == 0 ) return a;

		for(int i = small ; i >= 1 ; i--)
		{
			if( a % i == 0 && b % i == 0)
			{
				return i;
			}
		}
		return 1;

	}
}
