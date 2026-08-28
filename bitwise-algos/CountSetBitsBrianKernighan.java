public class CountSetBitsBrianKernighan {

	
	static int[] tbl = new int[256];

	public static void main(String... args)
	{
//		toBinaryUtility(4);
		toBinaryUtility(28);
		count(28);

		System.out.println();
		toBinaryUtility(55);
		count(55);
	}

	public static void count(int n)
	{
		preProcess();
		System.out.print(countSetBits(n));
	}

	public static void preProcess()
	{


		// Brian  Kernighan's algorithm  :-)
		tbl[0] = 0;
		for(int i = 1 ; i < 256 ; i++)
		{
			tbl[i] = tbl[ i & (i - 1)] + 1;
 		}
	}

	public static int countSetBits(int n)
	{
		return tbl[ n & 255]
			+ tbl [ (n >> 8) & 255]
			+ tbl [ (n >> 16) & 255]
			+ tbl [ n >> 24 & 255];
	}

	public static void toBinaryUtility(int n)
	{
		StringBuilder binary = new StringBuilder();

		while(n > 0)
		{
			if((n & 1) != 0) binary.append("1");
			else binary.append("0");
			n >>= 1;
		}
		System.out.println(binary.reverse());

	}


	
}
