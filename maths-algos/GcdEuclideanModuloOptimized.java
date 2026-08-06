public class GcdEuclideanModuloOptimized {

	public static void main(String... args)
	{
		System.out.println(gcd(3,6));
		System.out.println(gcd(3,9));
		System.out.println(gcd(9,9));
		System.out.println(gcd(8,16));
		System.out.println(gcd(4,30));
	}



/*
* 	Euclidean modulo is similar to subtraction because modulo simply does the same subtraction multiple times as much as possible
*
* because , modulo is just repeated subtraction when a > b, then a % b is multiple subtractions until remainder  < b
*
* NOTE : Stein's binary gcd algorithm optimizes even further and is a better algorithm
*
* */
	public static int gcd(int a, int b)
	{
		if (b == 0)
		{
			return a;
		}
		return gcd(b, a % b);
	}
}
