public class LcmOptimizedWithEuclidGcd {



	public static void main(String... args)
	{
		System.out.println( lcm(3,4));
		System.out.println(lcm(9,21));
	}


	public static int lcm(int a, int b)
	{
			return  (a * b) / euclidGcd(a,b);
	}


	public static int euclidGcd(int a, int b)
	{
		if(  b == 0)
		{
			return a;
		}
		return euclidGcd(b, a %b);
	}
}
