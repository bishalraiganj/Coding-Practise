public class CheckKthBitNormal2 {

	public static void main(String... args)
	{
		toBinary(9);
		kth(9,3);

	}

	public static void kth(int n, int k)
	{
		for(int i  = 0 ; i < k-1 ; i++)
		{
			n /=2;
		}
		if( (n & 1)!=0) System.out.println("yes");
		else  System.out.println("no");
	}

	public static void toBinary(int n)
	{

		if(n == 0 ) System.out.println("0");
		StringBuilder binary = new StringBuilder();

		while(n > 0)
		{
			if( (n & 1) != 0) binary.append("1");
			else binary.append("0");
			n >>= 1;

		}
		System.out.println(binary.reverse());
	}
}
