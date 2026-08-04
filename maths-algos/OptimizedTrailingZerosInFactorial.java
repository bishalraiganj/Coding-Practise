public class OptimizedTrailingZerosInFactorial {

	public static void main(String... args)
	{
		System.out.println(trailingZerosInFactorial(5));
		System.out.println(trailingZerosInFactorial(6));
		System.out.println(trailingZerosInFactorial(12));
		System.out.println(trailingZerosInFactorial(4));


	}


	// The number of trailing zero's are the pair's of 5 and 2 factors in the prime factorization of the number's factorial
/*
		so, consider the general factors of the factorial
		say for the number 28 it is : 1 * 2 * 3 * 4 * 5 * 6 *  7 * 8 * 9 * 10 * 11 * 12..... until 25 * 26 * 27 * 28
		notice that every 5 position will definitely have one 5 , and then from every 25th position theres another 5 ,
		and so on 125th position 3 5's

		so if we divide the number 28 by each position we will get the count of corresponding 5 for that position ,
		because dividing 28/5 gives the  number of first 5 , then dividing 28/5 gives the second 5's count and so on

		for example at position 5 in the general factor we have the number 5 then at position 10 , 15 , 20 , 25 we all have the first 5's
		then at position 25 only we have the number 25 in the general factors of n factorial right so 5 * 5 so the second 5 is here
		so we just have to sum up the 5's count at each position this way
 */

	public static int trailingZerosInFactorial(int n)
	{

		int fiveCount = 0 ;


		for(int i = 5; i <= n ; i*=5)
		{
			fiveCount += n/i;
		}
		return fiveCount;
	}



}


