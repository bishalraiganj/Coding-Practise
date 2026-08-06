public class LcmNaive {

	public static void main(String... args)
	{
		System.out.println("LCM Naive : " + lcm(3,4));
		System.out.println("LCM  Naive Optimized : " + lcmOptimized(9,21));

	}

	public static int lcm(int a , int b)
	{
		int res = Math.max(a,b);

		while ( true)
		{
			if(res % a == 0 && res % b == 0)
			{
				return res;
			}
			res++;
		}
	}

	// If max(a,b) itself is not the LCM,
// then there cannot be another common multiple
// between max(a,b) and 2*max(a,b),
// because the next multiple of max(a,b) is exactly 2*max(a,b).
	public static int lcmOptimized(int a , int b)
	{
		int max = Math.max(a,b);
		if( max % a == 0 &&   max % b ==0) return max;
		for ( int i  = 2 * max ; i <= a * b ; i+=max)
		{
			if( i % a == 0 &&  i % b == 0)
			{
				return i;
			}
		}

		return a * b;
	}

}
