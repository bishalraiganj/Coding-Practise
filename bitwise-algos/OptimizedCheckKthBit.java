public class OptimizedCheckKthBit {


	public static void main(String... args)
	{
		toBinary(29);
		kthLeftShift(29,2);


	}

	public static void kthLeftShift(int n, int k)
	{
		int ls = 1 << k -1 ;

		if((n & ls) != 0) System.out.println("yes");
		else System.out.println("no");


	}

	public static void toBinary(int n)
	{
		StringBuilder binary = new StringBuilder();

		while(n > 0)
		{
			if( (n & 1) != 0 ) binary.append(1);
			else binary.append(0);
			n >>= 1;
		}
		System.out.println(binary.reverse());
	}
}
