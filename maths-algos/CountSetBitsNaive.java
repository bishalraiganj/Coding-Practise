public class CountSetBitsNaive {


	public static void main(String... args)
	{
		toBinary(229);
		toBinary(18);
		toBinary(30);

		count(229);
		count(18);
		count(30);
	}

	public static void count(int n)
	{

		int count = 0;
		while( n > 0)
		{
			if ( (n & 1) != 0) count++;
			n >>= 1;
		}
		System.out.println(count);
	}

	public static void toBinary(int n)
	{
		StringBuilder binary = new StringBuilder();
		while( n > 0)
		{
			if( (n & 1) != 0) binary.append(1);
			else binary.append(0);
			n >>= 1;
		}
		System.out.println(binary.reverse());
	}
}
