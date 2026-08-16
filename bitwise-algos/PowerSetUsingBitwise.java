public class PowerSetUsingBitwise {

	public static void main(String... args)
	{
		System.out.println(computingPower(2,4));
		System.out.println(computingPower(3,4));
		System.out.println(computingPower(2,3));

		System.out.println("-".repeat(50));

		System.out.println(iterativePower(2,4));
		System.out.println(iterativePower(3,4));
		System.out.println(iterativePower(2,3));

		find("abc");
	}

	public static void find(String s)
	{

		int n  = s.length();
		int pSize = 1 <<  s.length();

		char[] arr = s.toCharArray();

		for(int i = 0 ; i < pSize ; i++)
		{
			for(int j = 0 ; j < n ; j++)
			{
				if( (i & ( 1 << j)) != 0 ) System.out.print(arr[j]);
			}
			System.out.println();
		}

	}


	//For practise i wrote these powering algorithms Bishal Adhikary :-)
	public static int computingPower(int x, int n)
	{
		if( n == 0 ) return 1;


		int tmp = computingPower(x, n/2);
		tmp *= tmp;
		if( (n & 1) == 0) return tmp;
		return tmp * x;
	}


	//Binary Exponentiation Bishal Adhikary :-)
	public static int iterativePower(int x, int n)
	{
		// 4 =  100
		int prod = x;
		int res = 1;

		while( n > 0)
		{


			if((n & 1) != 0 ) {
				res *= prod;
			}
			n >>= 1;
			prod *=prod;
//			System.out.println(prod);

		}
		return res;
	}
}
