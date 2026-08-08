public class PrimeFactorsOptimized {


	public static void main(String... args)
	{
		// primeFactors(14);   // 14 = 2 × 7
		primeFactors(450);     // 450 = 2 × 3 × 3 × 5 × 5
		// primeFactors(84);   // 84 = 2 × 2 × 3 × 7
		// primeFactors(13);   // 13 is itself prime
		// primeFactors(1);    // 1 has no prime factors
	}



	// It does find out the prime factorization of a number n,
	/*
	* if there is a first prime factor for n then it is definitely in the range from 2 to sqaure root of n
	* because , every number is a product of primes powers so even if the first factor before square root of n is composite
	* it is still product of primes
	* so eventually if there exists a factor for n it is definitely a prime also before 2 to square root of n
	* and if not factors exist , that means the number itself is prime
	* and  one one prime factor after square root of n can exist because ,
	* think , two prime factors greater than square root of n exists that means their product is greater than n itself which
	* is not possible so , we can conclude ,
	* if there exists a first prime factor  it is definitely in the range 2 to square root of n
	* and after square root of n only one bigger prime can exist , that is why we have those extra checks at the end of the loops
	* in our prime factorization algorithms
	* */
	public static void primeFactors2(int n)
	{
		if( n <= 1) return;

		while( n % 2 == 0)
		{
			System.out.println(2);
			n /= 2;
		}

		while( n % 3 == 0 )
		{
			System.out.println(3);
			n /= 3;
		}

		for( int i = 5  ; i * i <= n ; i+=6)
		{
			while(n % i == 0  ) {
				System.out.println(i);
				n /= i;
			}
			while( n % (i + 2) == 0) {
				System.out.println(i);
				n /= i +2;
			}

		}

		if(n > 3)
		{
			System.out.println(n);
		}

	}


	//commented out very detailed  explained version :-) Bishal Adhikary


	/*
	 * ================================================================
	 * PRIME FACTORIZATION
	 * ================================================================
	 *
	 * Goal:
	 *
	 * Given n, print the prime factors of n, including repeated
	 * occurrences according to their powers.
	 *
	 * Examples:
	 *
	 * 12 = 2² × 3
	 * output: 2, 2, 3
	 *
	 * 50 = 2 × 5²
	 * output: 2, 5, 5
	 *
	 * 450 = 2 × 3² × 5²
	 * output: 2, 3, 3, 5, 5
	 *
	 *
	 * ================================================================
	 * IMPORTANT: PRIME FACTORIZATION vs FACTOR PAIRS
	 * ================================================================
	 *
	 * There are two related but different ideas:
	 *
	 * 1. Finding ALL factor pairs of n.
	 *
	 *    Example:
	 *
	 *    36:
	 *
	 *    (1, 36)
	 *    (2, 18)
	 *    (3, 12)
	 *    (4, 9)
	 *    (6, 6)
	 *
	 *    The smaller member of every pair is <= √n.
	 *
	 *    Therefore, if our goal were to find ALL factor pairs,
	 *    we only need to search up to √n. Once we find the smaller
	 *    factor, its corresponding larger factor is automatically:
	 *
	 *        n / smallerFactor
	 *
	 *
	 * 2. Finding the PRIME FACTORIZATION of n.
	 *
	 *    Here we are NOT trying to enumerate all factor pairs.
	 *
	 *    Instead, we repeatedly remove prime factors from n:
	 *
	 *        n
	 *        ↓ remove a prime factor
	 *        smaller n
	 *        ↓ remove another prime factor
	 *        smaller n
	 *        ↓ ...
	 *
	 *    until nothing remains except possibly one final prime.
	 *
	 *
	 * ================================================================
	 * THE FUNDAMENTAL FACTOR-PAIR THEOREM
	 * ================================================================
	 *
	 * If n is composite, then:
	 *
	 *        n = a × b
	 *
	 * for some integers a and b greater than 1.
	 *
	 * Assume a <= b.
	 *
	 * Since:
	 *
	 *        a × b = n
	 *
	 * and a <= b, we have:
	 *
	 *        a × a <= a × b
	 *
	 * therefore:
	 *
	 *        a² <= n
	 *
	 * and hence:
	 *
	 *        a <= √n
	 *
	 *
	 * Therefore:
	 *
	 *      EVERY COMPOSITE NUMBER HAS AT LEAST ONE FACTOR
	 *      THAT IS <= √n.
	 *
	 *
	 * This is the fundamental reason √n appears in:
	 *
	 * - prime checking
	 * - finding factors
	 * - this prime-factorization algorithm
	 * - Sieve of Eratosthenes
	 *
	 *
	 * ================================================================
	 * WHY DOES THIS APPLY TO PRIME FACTORIZATION?
	 * ================================================================
	 *
	 * Suppose the current n is composite.
	 *
	 * Because n is composite, it has a proper factor <= √n.
	 *
	 * That factor might itself be composite.
	 *
	 * Example:
	 *
	 *        36 = 4 × 9
	 *
	 * Here 4 is <= √36, but 4 is not prime.
	 *
	 * However:
	 *
	 *        4 = 2 × 2
	 *
	 * Therefore, if a composite factor exists, it ultimately contains
	 * prime factors.
	 *
	 * In particular, a composite n must have at least one PRIME FACTOR
	 * <= √n.
	 *
	 * Another way to see this:
	 *
	 * Every integer greater than 1 can be represented as a product
	 * of prime powers:
	 *
	 *        n = p1^a1 × p2^a2 × ... × pk^ak
	 *
	 * where p1, p2, ... are prime numbers.
	 *
	 * If n is composite, at least two prime factors (counting
	 * multiplicity) exist.
	 *
	 * At least one of those prime factors must be <= √n.
	 *
	 *
	 * ================================================================
	 * VERY IMPORTANT: PRIME FACTORS CAN BE GREATER THAN √n
	 * ================================================================
	 *
	 * This DOES NOT mean:
	 *
	 *        "All prime factors of n are <= √n."
	 *
	 * That statement is FALSE.
	 *
	 * Example:
	 *
	 *        14 = 2 × 7
	 *
	 *        √14 ≈ 3.74
	 *
	 * Here:
	 *
	 *        2 < √14
	 *        7 > √14
	 *
	 * So 7 is definitely a prime factor greater than √14.
	 *
	 *
	 * ================================================================
	 * THEN WHY DO WE ONLY SEARCH UP TO √n?
	 * ================================================================
	 *
	 * Because there can be AT MOST ONE factor greater than √n.
	 *
	 * Suppose there were TWO prime factors p and q such that:
	 *
	 *        p > √n
	 *        q > √n
	 *
	 * Then:
	 *
	 *        p × q > √n × √n
	 *
	 * therefore:
	 *
	 *        p × q > n
	 *
	 * But p and q are both factors of n, so their product cannot
	 * exceed n.
	 *
	 * Contradiction.
	 *
	 * Therefore:
	 *
	 *        AT MOST ONE prime factor can be greater than √n.
	 *
	 *
	 * ================================================================
	 * THIS IS WHERE "REDUCING n" BECOMES IMPORTANT
	 * ================================================================
	 *
	 * We are NOT finding all factor pairs of the ORIGINAL n.
	 *
	 * We are repeatedly changing n.
	 *
	 * Example:
	 *
	 *        14
	 *        ↓ divide by 2
	 *        7
	 *
	 * The original number was 14 and:
	 *
	 *        7 > √14
	 *
	 * But after removing 2, the CURRENT n is 7.
	 *
	 * Now 7 is simply the remaining number.
	 *
	 * We do not need to search for 7.
	 *
	 * Since no smaller factor remains, 7 must be prime.
	 *
	 * Therefore:
	 *
	 *        14 = 2 × 7
	 *
	 *
	 * This is the key difference between:
	 *
	 *      "finding all factor pairs"
	 *
	 * and
	 *
	 *      "finding the prime-factor product of n."
	 *
	 *
	 * ================================================================
	 * WHY CAN THE FINAL n BE PRINTED?
	 * ================================================================
	 *
	 * After repeatedly removing all smaller prime factors, suppose
	 * some n > 1 remains.
	 *
	 * The loop has already checked possible factors up to √n.
	 *
	 * If the remaining n were composite, it MUST have some factor
	 * <= √n.
	 *
	 * But no such factor was found.
	 *
	 * Therefore the remaining n cannot be composite.
	 *
	 * Hence:
	 *
	 *        remaining n > 1  =>  remaining n is PRIME
	 *
	 * So this final n is printed directly.
	 *
	 * This is exactly how we catch cases such as:
	 *
	 *        14 = 2 × 7
	 *        84 = 2² × 3 × 7
	 *        35 = 5 × 7
	 *
	 * The final large prime factor does not need to be explicitly
	 * searched for.
	 *
	 *
	 * ================================================================
	 * EXAMPLE: n = 14
	 * ================================================================
	 *
	 * Initially:
	 *
	 *        n = 14
	 *
	 * i = 2
	 *
	 * 2² <= 14
	 *
	 * 2 divides 14.
	 *
	 * Print 2.
	 *
	 *        n = 14 / 2 = 7
	 *
	 * Now:
	 *
	 *        n = 7
	 *
	 * The loop condition eventually fails because:
	 *
	 *        i² > 7
	 *
	 * We stop searching.
	 *
	 * But n > 1.
	 *
	 * Therefore the remaining n = 7 must be prime.
	 *
	 * Print 7.
	 *
	 * Final result:
	 *
	 *        2, 7
	 *
	 *
	 * ================================================================
	 * EXAMPLE: n = 84
	 * ================================================================
	 *
	 *        84
	 *        ↓ /2
	 *        42
	 *        ↓ /2
	 *        21
	 *        ↓ /3
	 *        7
	 *
	 * Now 7 remains.
	 *
	 * The loop does not need to search for 7.
	 *
	 * Since 7 > 1 and no smaller factor remains,
	 * 7 must be prime.
	 *
	 * Therefore:
	 *
	 *        84 = 2 × 2 × 3 × 7
	 *
	 *
	 * ================================================================
	 * WHY DO WE DIVIDE A PRIME FACTOR REPEATEDLY?
	 * ================================================================
	 *
	 * A prime factor may occur with a power greater than one.
	 *
	 * Example:
	 *
	 *        450 = 2 × 3² × 5²
	 *
	 * Therefore:
	 *
	 *        450 = 2 × 3 × 3 × 5 × 5
	 *
	 * Once we find a prime factor i, we keep dividing while:
	 *
	 *        n % i == 0
	 *
	 * This removes ALL copies of that prime factor.
	 *
	 * For example:
	 *
	 *        450 / 2 = 225
	 *
	 * Then:
	 *
	 *        225 / 3 = 75
	 *        75  / 3 = 25
	 *
	 * Then:
	 *
	 *        25 / 5 = 5
	 *        5  / 5 = 1
	 *
	 * Therefore:
	 *
	 *        450 = 2 × 3² × 5²
	 *
	 *
	 * ================================================================
	 * WHY DO WE HANDLE 2 AND 3 SEPARATELY?
	 * ================================================================
	 *
	 * Every prime greater than 3 is of the form:
	 *
	 *        6k - 1
	 *
	 * or
	 *
	 *        6k + 1
	 *
	 * because every integer belongs to one of these six residue
	 * classes:
	 *
	 *        6k
	 *        6k + 1
	 *        6k + 2
	 *        6k + 3
	 *        6k + 4
	 *        6k + 5
	 *
	 * Numbers:
	 *
	 *        6k       -> divisible by 2 and 3
	 *        6k + 2   -> divisible by 2
	 *        6k + 3   -> divisible by 3
	 *        6k + 4   -> divisible by 2
	 *
	 * So the only possible prime positions greater than 3 are:
	 *
	 *        6k + 1
	 *        6k + 5
	 *
	 * and 6k + 5 is the same as 6(k+1) - 1.
	 *
	 * Therefore, after handling 2 and 3 explicitly, we only need
	 * to check:
	 *
	 *        5, 7, 11, 13, 17, 19, 23, 25, ...
	 *
	 * More precisely, we test:
	 *
	 *        i
	 *        i + 2
	 *
	 * and then increase i by 6.
	 *
	 * IMPORTANT:
	 *
	 * Numbers of the form 6k ± 1 are NOT necessarily prime.
	 *
	 * For example:
	 *
	 *        25 = 6(4) + 1
	 *
	 * but 25 is composite.
	 *
	 * So 6k ± 1 is a necessary condition for primes > 3,
	 * NOT a sufficient condition.
	 *
	 *
	 * ================================================================
	 * LOOP CONDITION: i * i <= n
	 * ================================================================
	 *
	 * Instead of calculating:
	 *
	 *        i <= √n
	 *
	 * we use:
	 *
	 *        i * i <= n
	 *
	 * This is mathematically equivalent for positive integers and
	 * avoids explicitly calculating a square root.
	 *
	 * Notice that n is the CURRENT remaining n.
	 *
	 * This is very important.
	 *
	 * n becomes smaller every time we remove a prime factor.
	 *
	 * Therefore the effective √n boundary also becomes smaller.
	 *
	 *
	 * ================================================================
	 * WHY DOES THE ALGORITHM STILL WORK AFTER n CHANGES?
	 * ================================================================
	 *
	 * Suppose we remove a prime factor p:
	 *
	 *        n = p × remaining
	 *
	 * and replace n by:
	 *
	 *        remaining
	 *
	 * We have completely removed p.
	 *
	 * All smaller candidates have already been tested because i
	 * increases from smaller values to larger values.
	 *
	 * Therefore, for the NEW n, we only need to continue searching
	 * from the current i.
	 *
	 * If the new n has another composite structure, it must have
	 * a factor <= √(new n).
	 *
	 * So the same √n theorem can be applied again to the reduced n.
	 *
	 *
	 * ================================================================
	 * WHY DON'T WE RESET i AFTER EVERY DIVISION?
	 * ================================================================
	 *
	 * Because once we have completely removed a prime factor p,
	 * we know that the current n is no longer divisible by p.
	 *
	 * Also, all values smaller than the current i have already
	 * been checked.
	 *
	 * Therefore there is no reason to start from 2 again.
	 *
	 * We simply continue forward.
	 *
	 *
	 * ================================================================
	 * SPECIAL CASES
	 * ================================================================
	 *
	 * n <= 1:
	 *
	 * There are no prime factors.
	 *
	 * 1 is NOT prime.
	 *
	 * 1 has no prime factorization.
	 *
	 *
	 * n itself is prime:
	 *
	 * Example:
	 *
	 *        n = 13
	 *
	 * No number from 2 to √13 divides 13.
	 *
	 * Therefore 13 is prime.
	 *
	 * At the end:
	 *
	 *        n > 3
	 *
	 * so we print 13.
	 *
	 *
	 * ================================================================
	 * TIME COMPLEXITY
	 * ================================================================
	 *
	 * In the worst case, n itself is prime.
	 *
	 * Then none of the inner while loops execute.
	 *
	 * We have to check candidates up to √n.
	 *
	 * Because we skip multiples of 2 and 3, we check approximately
	 * one third of the integers, but constants are ignored in
	 * asymptotic analysis.
	 *
	 * Therefore:
	 *
	 *        Time = Θ(√n)
	 *
	 * in the worst case.
	 *
	 * For composite numbers, n may become much smaller as factors
	 * are removed, so the practical number of iterations can be
	 * significantly lower.
	 *
	 *
	 * ================================================================
	 */
	public static void primeFactors(int n) {

		// 0 and 1 (and negative values, for this implementation)
		// do not have the positive prime-factorization we are looking for.
		if (n <= 1) {
			return;
		}


		/*
		 * ------------------------------------------------------------
		 * HANDLE PRIME FACTOR 2
		 * ------------------------------------------------------------
		 *
		 * We handle 2 separately because 2 is the only even prime.
		 *
		 * If n is divisible by 2, divide it repeatedly so that ALL
		 * powers of 2 are removed.
		 *
		 * Example:
		 *
		 *        40 -> 20 -> 10 -> 5
		 *
		 * therefore:
		 *
		 *        40 = 2³ × 5
		 */
		while (n % 2 == 0) {
			System.out.println(2);
			n /= 2;
		}


		/*
		 * ------------------------------------------------------------
		 * HANDLE PRIME FACTOR 3
		 * ------------------------------------------------------------
		 *
		 * We also handle 3 separately.
		 *
		 * After this point, n is guaranteed not to be divisible by
		 * either 2 or 3.
		 */
		while (n % 3 == 0) {
			System.out.println(3);
			n /= 3;
		}


		/*
		 * ------------------------------------------------------------
		 * CHECK POSSIBLE PRIME FACTORS OF THE FORM 6k ± 1
		 * ------------------------------------------------------------
		 *
		 * i takes the values:
		 *
		 *        5, 11, 17, 23, ...
		 *
		 * and i + 2 takes:
		 *
		 *        7, 13, 19, 25, ...
		 *
		 * Together:
		 *
		 *        5, 7, 11, 13, 17, 19, 23, 25, ...
		 *
		 * We test divisibility by both candidates.
		 *
		 *
		 * The condition:
		 *
		 *        i * i <= n
		 *
		 * means:
		 *
		 *        i <= √n
		 *
		 * for positive n.
		 *
		 * Again, this √n is based on the CURRENT remaining n,
		 * not necessarily the original n.
		 */
		for (int i = 5; i * i <= n; i += 6) {

			/*
			 * --------------------------------------------------------
			 * TEST i
			 * --------------------------------------------------------
			 *
			 * If i divides n, it is a prime factor candidate because
			 * all smaller possible prime factors have already been
			 * handled.
			 *
			 * Divide repeatedly to remove every occurrence of i.
			 */
			while (n % i == 0) {
				System.out.println(i);
				n /= i;
			}


			/*
			 * --------------------------------------------------------
			 * TEST i + 2
			 * --------------------------------------------------------
			 *
			 * i + 2 is the second possible prime position in the
			 * current block of six.
			 *
			 * IMPORTANT:
			 *
			 * We must print (i + 2), NOT i.
			 *
			 * Example:
			 *
			 *        i = 5
			 *        i + 2 = 7
			 *
			 * If 7 divides n, the factor we found is 7.
			 */
			while (n % (i + 2) == 0) {
				System.out.println(i + 2);
				n /= (i + 2);
			}
		}


		/*
		 * ------------------------------------------------------------
		 * FINAL REMAINING PRIME FACTOR
		 * ------------------------------------------------------------
		 *
		 * If n > 3 after the loop, n itself must be prime.
		 *
		 * Why?
		 *
		 * The loop has already checked all possible factors up to
		 * √n for the CURRENT remaining n.
		 *
		 * If n were composite, it would have a factor <= √n.
		 *
		 * Since no such factor remains, n cannot be composite.
		 *
		 * Therefore n itself is prime.
		 *
		 * This is how the algorithm handles a final prime factor
		 * that is larger than the √n boundary of the ORIGINAL number.
		 *
		 * Example:
		 *
		 *        14
		 *        ↓ remove 2
		 *        7
		 *
		 * 7 is greater than √14, but it is simply the remaining n.
		 *
		 * So we print it here.
		 */
		if (n > 3) {
			System.out.println(n);
		}
	}



}
