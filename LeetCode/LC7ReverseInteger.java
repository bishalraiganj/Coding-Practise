public class LC7ReverseInteger {


	public static void main(String... args)
	{
		reverse(123);
		reverse(121);
		reverse(44442);
	}

	public static void reverse(int x) {

		int rev = 0;
		while(x > 0)
		{
			rev = rev * 10 + ( x & 1 );
			x /= 10;
		}
		System.out.println(rev);
	}
}
