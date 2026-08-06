public class GcdEuclideanSubtraction {

	public static void main(String... args)
	{
		System.out.println(gcd(3,6));
		System.out.println(gcd(3,9));
		System.out.println(gcd(9,9));
		System.out.println(gcd(8,16));
		System.out.println(gcd(4,30));
	}

	public static int gcd(int a , int b)
	{
		while( a != b)
		{
			if(a > b)
			{
				a = a - b;
			}else{
				b = b - a;
			}
		}
		return a;
	}
}
