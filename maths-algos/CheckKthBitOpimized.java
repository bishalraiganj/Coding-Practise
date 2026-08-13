public class CheckKthBitOpimized {

	public static void main(String... args)
	{
		toBinary(35);
		kth(35,6);
		kth(35,2);
		kth(35,3);
		kth(35,1);
	}

	public static void kth(int n , int k)
	{
		int rs = n >> k - 1;
		if( (rs & 1) != 0) System.out.println("yes");
		else System.out.println("no");
	}

	public static void toBinary(int n)
	{
		StringBuilder binary = new StringBuilder();
		while(n > 0)
		{
			if( (n & 1) != 0) binary.append("1");
			else binary.append("0");
			n >>= 1 ;
		}
		System.out.println(binary.reverse());
	}
}
