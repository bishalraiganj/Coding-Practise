public class PowerOfTwoBrianKernighan {

	public static void main(String... args)
	{
		isPowerOfTwo(10);
		isPowerOfTwo(2);
		isPowerOfTwo(4);
		isPowerOfTwo(8);
		isPowerOfTwo(12);
		isPowerOfTwo(1);
	}

	public static void isPowerOfTwo(int n)
	{
		if ( n == 0) System.out.println(false);
		int res = n &  (n-1) ;
		System.out.println( res == 0);
	}
}
