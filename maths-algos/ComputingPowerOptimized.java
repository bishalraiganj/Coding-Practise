public class ComputingPowerOptimized {



	public static void main(String... args)
	{
		System.out.println(cp(2,4));
		System.out.println(cp(3,4));
	}

	
	
	// The theorem is that , pow(x,n) = pow(x,n/2) * pow(x,n/2) if n is even and pow(x,n-1) * x
	public static int cp(int x, int n)
	{
		if(n == 0)
		{
			return 1;
		}

		int tmp = cp(x, n/2);
		tmp *= tmp;
		if( n % 2 == 0)
		{
			return tmp; 
		}
		else{
			return tmp * x; // here , mathematically this is equal to pow(x,n-1) * x see the below explanations why
		}
	}

	/*
	*if n is odd that means ,
	*  n = 2k + 1
	* means , x^2k  * x
	* so , this term x^2k is even which equal to tmp only mathematically,
	*
	*
	*
	* */


	//BETTER EXPLANATIONS IN THE FOLLOWING :-) Bishal Adhikary


	/*
	 *
	 * ================================================================
	 *                  COMPUTING POWER OPTIMIZED
	 *                EXPONENTIATION BY SQUARING
	 * ================================================================
	 *
	 *
	 * The purpose of this algorithm is to calculate:
	 *
	 *                         x^n
	 *
	 * efficiently.
	 *
	 * A naive approach would multiply x by itself n times:
	 *
	 *     x^n = x * x * x * ... * x
	 *
	 * This requires O(n) multiplications.
	 *
	 * The optimized approach uses the fact that an exponent can be
	 * divided by 2 and therefore reduces the problem from n to n/2
	 * at every recursive call.
	 *
	 * This gives a time complexity of:
	 *
	 *                         O(log n)
	 *
	 *
	 * ================================================================
	 * 1. THE BASIC EXPONENT LAWS USED
	 * ================================================================
	 *
	 * The algorithm relies mainly on:
	 *
	 *
	 *     x^a * x^b = x^(a+b)
	 *
	 *
	 * and:
	 *
	 *
	 *     (x^a)^b = x^(a*b)
	 *
	 *
	 * These laws allow us to rewrite a large exponent in terms of
	 * smaller exponents.
	 *
	 *
	 * ================================================================
	 * 2. BASE CASE
	 * ================================================================
	 *
	 * The code contains:
	 *
	 *
	 *     if(n == 0)
	 *     {
	 *         return 1;
	 *     }
	 *
	 *
	 * This follows directly from the mathematical identity:
	 *
	 *
	 *                         x^0 = 1
	 *
	 *
	 * This is also called the multiplicative identity because:
	 *
	 *
	 *                         x * 1 = x
	 *
	 *
	 * The recursion must eventually reach n == 0.
	 *
	 *
	 * ================================================================
	 * 3. THE MOST IMPORTANT IDEA: EVEN EXPONENT
	 * ================================================================
	 *
	 * Suppose n is even.
	 *
	 * Then we can write:
	 *
	 *
	 *                         n = 2k
	 *
	 *
	 * Therefore:
	 *
	 *
	 *     x^n
	 *     = x^(2k)
	 *
	 *
	 * Using the exponent rule:
	 *
	 *
	 *     x^a * x^b = x^(a+b)
	 *
	 *
	 * we can split 2k into k + k:
	 *
	 *
	 *     x^(2k)
	 *     = x^(k+k)
	 *     = x^k * x^k
	 *
	 *
	 * Therefore:
	 *
	 *
	 *                    x^n = x^(n/2) * x^(n/2)
	 *
	 *
	 * or:
	 *
	 *
	 *                    x^n = (x^(n/2))^2
	 *
	 *
	 * This is the reason for:
	 *
	 *
	 *     int tmp = cp(x, n / 2);
	 *
	 *     tmp *= tmp;
	 *
	 *
	 * The first statement calculates:
	 *
	 *
	 *     tmp = x^(n/2)
	 *
	 *
	 * and the second statement calculates:
	 *
	 *
	 *     tmp = x^(n/2) * x^(n/2)
	 *
	 *
	 * which is:
	 *
	 *
	 *     tmp = x^n
	 *
	 *
	 * when n is even.
	 *
	 *
	 * ================================================================
	 * 4. WHY DO WE CHECK n % 2?
	 * ================================================================
	 *
	 * The algorithm has to distinguish between two cases:
	 *
	 *
	 *     n is even
	 *
	 *     n is odd
	 *
	 *
	 * because the mathematical decomposition is slightly different.
	 *
	 *
	 * ------------------------------------------------
	 * EVEN CASE
	 * ------------------------------------------------
	 *
	 * If:
	 *
	 *     n = 2k
	 *
	 * then:
	 *
	 *     x^n = (x^k)^2
	 *
	 *
	 * Therefore after:
	 *
	 *     tmp = cp(x, n / 2);
	 *     tmp *= tmp;
	 *
	 *
	 * tmp already contains x^n.
	 *
	 * So:
	 *
	 *     if(n % 2 == 0)
	 *     {
	 *         return tmp;
	 *     }
	 *
	 *
	 * is correct.
	 *
	 *
	 * ================================================================
	 * 5. THE ODD EXPONENT CASE
	 * ================================================================
	 *
	 * Now suppose n is odd.
	 *
	 * Any odd number can be written as:
	 *
	 *
	 *                         n = 2k + 1
	 *
	 *
	 * Therefore:
	 *
	 *
	 *                         n - 1 = 2k
	 *
	 *
	 * Notice that n - 1 is EVEN.
	 *
	 *
	 * For example:
	 *
	 *
	 *     n = 5
	 *
	 *     n - 1 = 4
	 *
	 *
	 *     n = 7
	 *
	 *     n - 1 = 6
	 *
	 *
	 *     n = 9
	 *
	 *     n - 1 = 8
	 *
	 *
	 * Since n - 1 is even, we can square the half-power to obtain
	 * x^(n-1).
	 *
	 *
	 * ================================================================
	 * 6. THE THEOREM FOR THE ODD CASE
	 * ================================================================
	 *
	 * For any positive odd n:
	 *
	 *
	 *                         x^n = x^(n-1) * x
	 *
	 *
	 * Why?
	 *
	 *
	 *     x^n
	 *     = x^(n-1) * x^1
	 *     = x^((n-1)+1)
	 *     = x^n
	 *
	 *
	 * This is simply the exponent multiplication law:
	 *
	 *
	 *     x^a * x^b = x^(a+b)
	 *
	 *
	 * The important question is:
	 *
	 *
	 *     "How does the algorithm obtain x^(n-1)?"
	 *
	 *
	 * The answer is:
	 *
	 *
	 *     int tmp = cp(x, n / 2);
	 *
	 *     tmp *= tmp;
	 *
	 *
	 * ================================================================
	 * 7. WHY tmp BECOMES x^(n-1) WHEN n IS ODD
	 * ================================================================
	 *
	 * Let:
	 *
	 *
	 *                         n = 2k + 1
	 *
	 *
	 * Since Java integer division is being used:
	 *
	 *
	 *                         n / 2 = k
	 *
	 *
	 * Therefore:
	 *
	 *
	 *     int tmp = cp(x, n / 2);
	 *
	 *
	 * mathematically means:
	 *
	 *
	 *     tmp = x^k
	 *
	 *
	 * Then the algorithm executes:
	 *
	 *
	 *     tmp *= tmp;
	 *
	 *
	 * which means:
	 *
	 *
	 *     tmp = x^k * x^k
	 *
	 *
	 * Using:
	 *
	 *
	 *     x^a * x^b = x^(a+b)
	 *
	 *
	 * we get:
	 *
	 *
	 *     tmp = x^(k+k)
	 *
	 *
	 *     tmp = x^(2k)
	 *
	 *
	 * But because:
	 *
	 *
	 *     n = 2k + 1
	 *
	 *
	 * we know:
	 *
	 *
	 *     2k = n - 1
	 *
	 *
	 * Therefore:
	 *
	 *
	 *                         tmp = x^(n-1)
	 *
	 *
	 * THIS IS THE MOST IMPORTANT CONNECTION.
	 *
	 *
	 * So when n is odd, the code:
	 *
	 *
	 *     int tmp = cp(x, n / 2);
	 *     tmp *= tmp;
	 *
	 *
	 * has effectively calculated:
	 *
	 *
	 *                         tmp = x^(n-1)
	 *
	 *
	 * Therefore the final statement:
	 *
	 *
	 *     return tmp * x;
	 *
	 *
	 * is mathematically equivalent to:
	 *
	 *
	 *     return x^(n-1) * x;
	 *
	 *
	 * which gives:
	 *
	 *
	 *     x^n
	 *
	 *
	 * ================================================================
	 * 8. COMPLETE ODD CASE DERIVATION
	 * ================================================================
	 *
	 * Let:
	 *
	 *                         n = 2k + 1
	 *
	 *
	 * Then:
	 *
	 *
	 *     n / 2 = k
	 *
	 *
	 * because integer division is used.
	 *
	 *
	 * Recursive call:
	 *
	 *
	 *     tmp = cp(x, n / 2);
	 *
	 *
	 * gives:
	 *
	 *
	 *     tmp = x^k
	 *
	 *
	 * Then:
	 *
	 *
	 *     tmp *= tmp;
	 *
	 *
	 * gives:
	 *
	 *
	 *     tmp = x^k * x^k
	 *
	 *
	 *     tmp = x^(2k)
	 *
	 *
	 * Since:
	 *
	 *
	 *     n = 2k + 1
	 *
	 *
	 * therefore:
	 *
	 *
	 *     2k = n - 1
	 *
	 *
	 * so:
	 *
	 *
	 *     tmp = x^(n-1)
	 *
	 *
	 * Finally:
	 *
	 *
	 *     return tmp * x;
	 *
	 *
	 * becomes:
	 *
	 *
	 *     return x^(n-1) * x
	 *
	 *
	 * which becomes:
	 *
	 *
	 *     return x^((n-1)+1)
	 *
	 *
	 *     return x^n
	 *
	 *
	 * Therefore the algorithm is mathematically correct.
	 *
	 *
	 * ================================================================
	 * 9. EXAMPLE: n = 5
	 * ================================================================
	 *
	 * Consider:
	 *
	 *
	 *                         x^5
	 *
	 *
	 * Since 5 is odd:
	 *
	 *
	 *     5 = 2(2) + 1
	 *
	 *
	 * Therefore:
	 *
	 *
	 *     5 / 2 = 2
	 *
	 *
	 * Recursive call:
	 *
	 *
	 *     tmp = cp(x, 5 / 2);
	 *
	 *
	 *     tmp = cp(x, 2);
	 *
	 *
	 * Eventually this calculates:
	 *
	 *
	 *     tmp = x^2
	 *
	 *
	 * Then:
	 *
	 *
	 *     tmp *= tmp;
	 *
	 *
	 * gives:
	 *
	 *
	 *     tmp = x^2 * x^2
	 *
	 *
	 *     tmp = x^4
	 *
	 *
	 * Notice:
	 *
	 *
	 *     4 = 5 - 1
	 *
	 *
	 * Therefore:
	 *
	 *
	 *     tmp = x^(5-1)
	 *
	 *
	 *     tmp = x^4
	 *
	 *
	 * Then:
	 *
	 *
	 *     return tmp * x;
	 *
	 *
	 * becomes:
	 *
	 *
	 *     return x^4 * x
	 *
	 *
	 *     return x^5
	 *
	 *
	 * Therefore:
	 *
	 *
	 *     x^5 = (x^2)^2 * x
	 *
	 *
	 * ================================================================
	 * 10. EXAMPLE: n = 7
	 * ================================================================
	 *
	 * Consider:
	 *
	 *
	 *                         x^7
	 *
	 *
	 * Since:
	 *
	 *
	 *     7 / 2 = 3
	 *
	 *
	 * recursive call gives:
	 *
	 *
	 *     tmp = x^3
	 *
	 *
	 * Squaring:
	 *
	 *
	 *     tmp *= tmp;
	 *
	 *
	 * gives:
	 *
	 *
	 *     tmp = x^3 * x^3
	 *
	 *
	 *     tmp = x^6
	 *
	 *
	 * Notice:
	 *
	 *
	 *     6 = 7 - 1
	 *
	 *
	 * Therefore:
	 *
	 *
	 *     tmp = x^(7-1)
	 *
	 *
	 * Finally:
	 *
	 *
	 *     return tmp * x;
	 *
	 *
	 * gives:
	 *
	 *
	 *     x^6 * x
	 *
	 *
	 *     = x^7
	 *
	 *
	 * Therefore:
	 *
	 *
	 *     x^7 = (x^3)^2 * x
	 *
	 *
	 * ================================================================
	 * 11. EXAMPLE: n = 8
	 * ================================================================
	 *
	 * Now consider an even exponent:
	 *
	 *
	 *                         x^8
	 *
	 *
	 * Since:
	 *
	 *
	 *     8 / 2 = 4
	 *
	 *
	 * recursive call:
	 *
	 *
	 *     tmp = cp(x, 8 / 2);
	 *
	 *
	 * gives:
	 *
	 *
	 *     tmp = x^4
	 *
	 *
	 * Then:
	 *
	 *
	 *     tmp *= tmp;
	 *
	 *
	 * gives:
	 *
	 *
	 *     tmp = x^4 * x^4
	 *
	 *
	 *     tmp = x^8
	 *
	 *
	 * Since 8 is even:
	 *
	 *
	 *     if(n % 2 == 0)
	 *
	 *
	 * is true, so:
	 *
	 *
	 *     return tmp;
	 *
	 *
	 * No additional multiplication by x is required.
	 *
	 *
	 * ================================================================
	 * 12. THE TWO IDENTITIES USED BY THE ALGORITHM
	 * ================================================================
	 *
	 * The entire algorithm can be summarized using two identities.
	 *
	 *
	 * EVEN n:
	 *
	 *
	 *     n = 2k
	 *
	 *
	 *     x^n
	 *     = x^(2k)
	 *     = x^k * x^k
	 *     = (x^k)^2
	 *
	 *
	 * Therefore:
	 *
	 *
	 *     x^n = (x^(n/2))^2
	 *
	 *
	 *
	 * ODD n:
	 *
	 *
	 *     n = 2k + 1
	 *
	 *
	 *     x^n
	 *     = x^(2k+1)
	 *     = x^(2k) * x
	 *     = (x^k)^2 * x
	 *
	 *
	 * Therefore:
	 *
	 *
	 *     x^n = (x^(n/2))^2 * x
	 *
	 *
	 * where n/2 is INTEGER DIVISION.
	 *
	 *
	 * ================================================================
	 * 13. VERY IMPORTANT CONNECTION TO THE CODE
	 * ================================================================
	 *
	 * The code:
	 *
	 *
	 *     int tmp = cp(x, n / 2);
	 *
	 *
	 * means:
	 *
	 *
	 *     tmp = x^(n/2)
	 *
	 *
	 * Then:
	 *
	 *
	 *     tmp *= tmp;
	 *
	 *
	 * means:
	 *
	 *
	 *     tmp = (x^(n/2))^2
	 *
	 *
	 * For EVEN n:
	 *
	 *
	 *     tmp = x^n
	 *
	 *
	 * For ODD n:
	 *
	 *
	 *     tmp = x^(n-1)
	 *
	 *
	 * Therefore:
	 *
	 *
	 *     if(n % 2 == 0)
	 *         return tmp;
	 *
	 *
	 * returns x^n directly for the even case.
	 *
	 *
	 * But:
	 *
	 *
	 *     else
	 *         return tmp * x;
	 *
	 *
	 * adds the one remaining factor of x for the odd case.
	 *
	 *
	 * Therefore the final line:
	 *
	 *
	 *     return tmp * x;
	 *
	 *
	 * is NOT independently calculating x^(n-1).
	 *
	 * It is multiplying the already-calculated:
	 *
	 *
	 *     tmp = x^(n-1)
	 *
	 *
	 * by the remaining x:
	 *
	 *
	 *     x^(n-1) * x
	 *
	 *
	 * to obtain:
	 *
	 *
	 *     x^n
	 *
	 *
	 * ================================================================
	 * 14. WHY THE EXPONENT IS REDUCED BY HALF
	 * ================================================================
	 *
	 * The recursive call is:
	 *
	 *
	 *     cp(x, n / 2)
	 *
	 *
	 * rather than:
	 *
	 *
	 *     cp(x, n - 1)
	 *
	 *
	 * This is what makes the algorithm efficient.
	 *
	 *
	 * The sequence of exponents is approximately:
	 *
	 *
	 *     n
	 *     n/2
	 *     n/4
	 *     n/8
	 *     n/16
	 *     ...
	 *     1
	 *     0
	 *
	 *
	 * We keep dividing the exponent by 2 until it reaches 0.
	 *
	 *
	 * Therefore the number of recursive levels is:
	 *
	 *
	 *                         O(log n)
	 *
	 *
	 * and because each level performs only a constant number of
	 * arithmetic operations, the time complexity is:
	 *
	 *
	 *                         O(log n)
	 *
	 *
	 * The recursive call stack also requires:
	 *
	 *
	 *                         O(log n)
	 *
	 * auxiliary space.
	 *
	 *
	 * ================================================================
	 * 15. FINAL SUMMARY
	 * ================================================================
	 *
	 * The algorithm follows this exact mathematical logic:
	 *
	 *
	 *     if n == 0:
	 *         x^0 = 1
	 *
	 *
	 *     if n is even:
	 *         x^n = (x^(n/2))^2
	 *
	 *
	 *     if n is odd:
	 *         x^n = (x^(n/2))^2 * x
	 *
	 *
	 * The most important fact for understanding the odd case is:
	 *
	 *
	 *     n = 2k + 1
	 *
	 *
	 *     n/2 = k
	 *
	 *
	 *     (x^(n/2))^2
	 *     = (x^k)^2
	 *     = x^(2k)
	 *     = x^(n-1)
	 *
	 *
	 * Therefore:
	 *
	 *
	 *     tmp *= tmp;
	 *
	 *
	 * has already produced:
	 *
	 *
	 *     tmp = x^(n-1)
	 *
	 *
	 * and consequently:
	 *
	 *
	 *     return tmp * x;
	 *
	 *
	 * is exactly:
	 *
	 *
	 *     return x^(n-1) * x;
	 *
	 *
	 * which gives:
	 *
	 *
	 *     return x^n;
	 *
	 *
	 * ================================================================
	 * CORE IDEA TO REMEMBER
	 * ================================================================
	 *
	 *
	 *             n EVEN
	 *
	 *             x^n
	 *              |
	 *              v
	 *          x^(n/2)
	 *              |
	 *           square
	 *              |
	 *              v
	 *             x^n
	 *
	 *
	 *
	 *             n ODD
	 *
	 *             x^n
	 *              |
	 *              v
	 *          x^(n/2)
	 *              |
	 *           square
	 *              |
	 *              v
	 *           x^(n-1)
	 *              |
	 *            * x
	 *              |
	 *              v
	 *             x^n
	 *
	 *
	 * In code:
	 *
	 *
	 *     int tmp = cp(x, n / 2);
	 *
	 *     tmp *= tmp;
	 *
	 *     if(n % 2 == 0)
	 *         return tmp;
	 *     else
	 *         return tmp * x;
	 *
	 *
	 * This is exponentiation by squaring.
	 *
	 */
}
