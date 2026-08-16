public class checkKthBitNormal {

	public static void main(String... args)
	{
		toBinary(0);
		toBinary(1);
		toBinary(2);
		toBinary(3);
		toBinary(4);
		toBinary(18);
		toBinary(198);
		System.out.println("-".repeat(50));

		checkKthBitNormal(198,3);

	}

	public static void checkKthBitNormal( int n , int k)
	{
		int x = 1;
		for( int i = 0 ; i < k-1 ; i++)
		{
			x *= 2;
		}

		if( (n & x) !=0 ) System.out.println( "yes");
		else System.out.println( "no");
	}

	public static void toBinary(int n)
	{
		StringBuilder binaryString  =  new StringBuilder();
		if(n== 0)System.out.println("0");

		while(n > 0)
		{
//			if(n % 2 == 1) {
			if( (n & 1) == 1) {
				binaryString.append("1");
			}
			else binaryString.append("0");
			n >>= 1;
		}
		System.out.println(binaryString.reverse());

	}

}
