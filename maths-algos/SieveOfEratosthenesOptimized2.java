import java.util.Arrays;

public class SieveOfEratosthenesOptimized2 {

	public static void main(String... args)
	{
			sieve(10);

			sieve(99);
	}
	public static void sieve(int n)
	{

		System.out.println();
		if( n <= 2) System.out.print(2);

		System.out.print(2 + " ");
		boolean[] prime = new boolean[n+1];

		for(int i= 3 ; i * i <= n ; i+=2)
		{
			if(!prime[i] )
			{
				for(int j = i * i ; j <= n ; j+= 2 * i)
				{
					prime[j] = true;
				}
			}
		}

//		System.out.println(Arrays.toString(prime));
		for(int i = 3 ; i <= n ; i+= 2)
		{	if(!prime[i])
			System.out.print(i + " ");
		}
	}
}
