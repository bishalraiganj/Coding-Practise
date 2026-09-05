public class JosephusProblem {

	public static void main(String... args)
	{
		System.out.println(jos(5,3));
	}


	// n is the number of people and k is the number of the person being killed
	public static int jos(int n , int k)
	{
		if( n == 1) return 0;

		return (jos(n-1,k) + k ) % n;

	}
}
