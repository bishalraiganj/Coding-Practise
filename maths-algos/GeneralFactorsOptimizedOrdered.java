public class GeneralFactorsOptimizedOrdered {


	public static void main(String... args)
	{
//		factors(6);
//		factors(18);
//		factors(20);
//		factors(25);
		factors(15);
//		factors(13);
	}


	public static void factors(int n) {

		int i ;
		for ( i =1; i * i < n; i++)
		{
			if( n % i == 0)
			{
				System.out.print(i + " ");
			}
		}

		for( ; i >= 1 ; i-- )
		{
			if( n % i == 0)
			{
				System.out.print( n / i + " ");
			}
		}
	}
}
