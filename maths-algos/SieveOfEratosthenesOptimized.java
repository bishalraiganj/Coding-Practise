import java.security.PublicKey;
import java.util.Arrays;
import java.util.Arrays;

public class SieveOfEratosthenesOptimized {

	public static void main(String... args)
	{
//		sieve(15);
		sieve(98);

	}

	public static void sieve(int n)
	{
		boolean[] isPrime = new boolean[n+1];
		Arrays.fill(isPrime,true);
		
		for(int i = 2 ; i * i <= n ; i++)
		{
			if( isPrime[i])
			{

				//This optimization , is because all the numbers before i * i such as i * (i -1) , i * (i -2) are numbers
				//smaller than i , so since we already processed all these smaller numbers multiples these are already covered
				//which is also the similar reason for which we only  need to run our outer loop till sqaure root of n only
				// because after square root the numbers are limited to certain multiples only and those are have factors smaller than
				// this number so , ultimately those are covered as well :-) Bishal Adhikary 2026 , Learning complex algorithms
				for(int j = i * i ; j <= n ; j += i)
				{
					isPrime[j] = false;
				}
			}
		}

		for(int i = 2 ; i <= n ; i++)
		{
			if(isPrime[i])
			{
				System.out.print(i + " ");
			}
		}

		//BETTER EXPLANATIONS BELOW :-) Bishal Adhikary



		/*
		 * ========================================================================
		 *                  SIEVE OF ERATOSTHENES
		 *                     DETAILED NOTES
		 * ========================================================================
		 *
		 *
		 * The Sieve of Eratosthenes is an algorithm used to find ALL prime
		 * numbers from 2 through n.
		 *
		 *
		 * The important distinction is:
		 *
		 *     Trial division:
		 *         Usually tests whether ONE particular number is prime.
		 *
		 *     Sieve of Eratosthenes:
		 *         Finds ALL primes in the range [2, n].
		 *
		 *
		 * The algorithm works by repeatedly identifying a prime number and
		 * marking all of its multiples as composite.
		 *
		 *
		 * ========================================================================
		 * 1. WHAT IS A PRIME NUMBER?
		 * ========================================================================
		 *
		 * A prime number is an integer greater than 1 that has exactly two
		 * positive divisors:
		 *
		 *     1
		 *     itself
		 *
		 *
		 * Examples:
		 *
		 *     2
		 *     3
		 *     5
		 *     7
		 *     11
		 *     13
		 *     17
		 *
		 *
		 * A composite number is an integer greater than 1 that has more than
		 * two positive divisors.
		 *
		 *
		 * Examples:
		 *
		 *     4  = 2 * 2
		 *     6  = 2 * 3
		 *     8  = 2 * 4
		 *     9  = 3 * 3
		 *     10 = 2 * 5
		 *
		 *
		 * IMPORTANT FACT:
		 *
		 * Every composite number greater than 1 has at least one prime factor.
		 *
		 *
		 * ========================================================================
		 * 2. THE CENTRAL IDEA OF THE SIEVE
		 * ========================================================================
		 *
		 * Suppose we know that i is prime.
		 *
		 * Then every multiple of i greater than i itself is composite.
		 *
		 *
		 * For example, if i = 3:
		 *
		 *     3 * 2 = 6
		 *     3 * 3 = 9
		 *     3 * 4 = 12
		 *     3 * 5 = 15
		 *     3 * 6 = 18
		 *
		 *
		 * Therefore:
		 *
		 *     6
		 *     9
		 *     12
		 *     15
		 *     18
		 *
		 * are all composite.
		 *
		 *
		 * Why?
		 *
		 * Because each number has 3 as a proper factor.
		 *
		 *
		 * For example:
		 *
		 *     15 = 3 * 5
		 *
		 *
		 * Therefore 15 cannot be prime because it has a divisor 3 other than
		 * 1 and itself.
		 *
		 *
		 * The Sieve of Eratosthenes repeatedly uses this fact:
		 *
		 *
		 *     If p is prime, every multiple of p greater than p is composite.
		 *
		 *
		 * ========================================================================
		 * 3. WHAT DOES THE BOOLEAN ARRAY REPRESENT?
		 * ========================================================================
		 *
		 * The code:
		 *
		 *     boolean[] isPrime = new boolean[n + 1];
		 *
		 *
		 * creates an array with indexes:
		 *
		 *     0, 1, 2, 3, ..., n
		 *
		 *
		 * Each index represents the number at that index.
		 *
		 *
		 * For example, if n = 10:
		 *
		 *     index:
		 *
		 *     0   1   2   3   4   5   6   7   8   9   10
		 *
		 *
		 * Therefore:
		 *
		 *     isPrime[2]
		 *
		 * represents whether 2 is currently considered prime.
		 *
		 *
		 *     isPrime[7]
		 *
		 * represents whether 7 is currently considered prime.
		 *
		 *
		 *     isPrime[10]
		 *
		 * represents whether 10 is currently considered prime.
		 *
		 *
		 * We need n + 1 elements because index n itself must exist.
		 *
		 *
		 * ========================================================================
		 * 4. WHY DO WE INITIALLY FILL THE ARRAY WITH TRUE?
		 * ========================================================================
		 *
		 * The code:
		 *
		 *     Arrays.fill(isPrime, true);
		 *
		 *
		 * initially marks every number as a candidate prime.
		 *
		 *
		 * Conceptually:
		 *
		 *     "We initially do not know that these numbers are composite."
		 *
		 *
		 * Then the algorithm progressively eliminates numbers that are proven
		 * to be composite.
		 *
		 *
		 * Whenever we find that a number has a divisor other than 1 and itself,
		 * we set:
		 *
		 *     isPrime[number] = false;
		 *
		 *
		 * IMPORTANT:
		 *
		 * This initial true value does NOT mean that 0 and 1 are actually prime.
		 *
		 * 0 and 1 are not prime numbers.
		 *
		 * We simply never process them because our loops start from 2.
		 *
		 *
		 * ========================================================================
		 * 5. WHY DOES THE OUTER LOOP START FROM 2?
		 * ========================================================================
		 *
		 * The smallest prime number is:
		 *
		 *     2
		 *
		 *
		 * Therefore 2 is the first useful number for eliminating composite
		 * numbers.
		 *
		 *
		 * When i = 2, we mark:
		 *
		 *     4
		 *     6
		 *     8
		 *     10
		 *     12
		 *     ...
		 *
		 *
		 * as composite.
		 *
		 *
		 * Then when i = 3, we mark:
		 *
		 *     9
		 *     12
		 *     15
		 *     18
		 *     ...
		 *
		 *
		 * Then i = 5 marks:
		 *
		 *     25
		 *     30
		 *     35
		 *     ...
		 *
		 *
		 * and so on.
		 *
		 *
		 * ========================================================================
		 * 6. WHY DO WE CHECK isPrime[i]?
		 * ========================================================================
		 *
		 * The code:
		 *
		 *     if(isPrime[i])
		 *
		 *
		 * means:
		 *
		 *     "Only use i as a marking factor if i is still known to be prime."
		 *
		 *
		 * Suppose:
		 *
		 *     i = 6
		 *
		 *
		 * 6 is composite because:
		 *
		 *     6 = 2 * 3
		 *
		 *
		 * Therefore:
		 *
		 *     isPrime[6] == false
		 *
		 *
		 * when the algorithm reaches 6.
		 *
		 *
		 * We do not need to process 6 as a factor.
		 *
		 *
		 * Why?
		 *
		 * Because the prime factors of 6 have already been processed:
		 *
		 *     2
		 *     3
		 *
		 *
		 * For example:
		 *
		 *     12 = 2 * 6
		 *
		 *
		 * was already marked by 2.
		 *
		 *
		 * Therefore processing composite i values would only perform
		 * unnecessary redundant work.
		 *
		 *
		 * ========================================================================
		 * 7. WHY DOES THE INNER LOOP START AT i * i?
		 * ========================================================================
		 *
		 * The code is:
		 *
		 *     for(int j = i * i; j <= n; j += i)
		 *
		 *
		 * A simple implementation could instead start at:
		 *
		 *     for(int j = 2 * i; j <= n; j += i)
		 *
		 *
		 * But the optimized Sieve of Eratosthenes starts at:
		 *
		 *     i * i
		 *
		 *
		 * This avoids marking multiples of i that have already been marked
		 * by smaller prime factors.
		 *
		 *
		 * ========================================================================
		 * 8. EXAMPLE: WHY i * i IS USED
		 * ========================================================================
		 *
		 * Suppose:
		 *
		 *     i = 5
		 *
		 *
		 * The multiples of 5 are:
		 *
		 *     5 * 2 = 10
		 *     5 * 3 = 15
		 *     5 * 4 = 20
		 *     5 * 5 = 25
		 *     5 * 6 = 30
		 *     ...
		 *
		 *
		 * We might think we need to start from 10.
		 *
		 * But look carefully.
		 *
		 *
		 * 10:
		 *
		 *     10 = 2 * 5
		 *
		 * It has the smaller prime factor 2.
		 *
		 * Therefore 10 was already marked when i = 2.
		 *
		 *
		 * 15:
		 *
		 *     15 = 3 * 5
		 *
		 * It has the smaller prime factor 3.
		 *
		 * Therefore 15 was already marked when i = 3.
		 *
		 *
		 * 20:
		 *
		 *     20 = 4 * 5
		 *
		 * and:
		 *
		 *     4 = 2 * 2
		 *
		 * Therefore:
		 *
		 *     20 = 2 * 2 * 5
		 *
		 *
		 * It was already marked by 2.
		 *
		 *
		 * Therefore:
		 *
		 *     10
		 *     15
		 *     20
		 *
		 * do not need to be marked again when i = 5.
		 *
		 *
		 * The first multiple that needs to be considered for i = 5 is:
		 *
		 *     5 * 5 = 25
		 *
		 *
		 * Therefore:
		 *
		 *     j = i * i
		 *
		 * is the optimized starting point.
		 *
		 *
		 * ========================================================================
		 * 9. GENERAL PROOF FOR STARTING AT i * i
		 * ========================================================================
		 *
		 * Suppose i is prime.
		 *
		 * Consider any multiple of i:
		 *
		 *     i * k
		 *
		 * where:
		 *
		 *     k > 1
		 *
		 *
		 * Now consider the multiples where:
		 *
		 *     k < i
		 *
		 *
		 * These are:
		 *
		 *     i * 2
		 *     i * 3
		 *     i * 4
		 *     ...
		 *     i * (i - 1)
		 *
		 *
		 * Because k < i, k is a smaller number than i.
		 *
		 *
		 * If k is prime, then k itself is a smaller prime factor.
		 *
		 *
		 * If k is composite, then k has some prime factor p where:
		 *
		 *     p < k < i
		 *
		 *
		 * Therefore in either case, i * k has a prime factor smaller than i.
		 *
		 *
		 * That smaller prime factor was already processed by the sieve.
		 *
		 *
		 * Therefore i * k has already been marked composite.
		 *
		 *
		 * Consequently:
		 *
		 *     i * 2
		 *     i * 3
		 *     ...
		 *     i * (i - 1)
		 *
		 *
		 * are already covered.
		 *
		 *
		 * The first multiple that is not automatically covered by a smaller
		 * factor in this way is:
		 *
		 *     i * i
		 *
		 *
		 * Therefore:
		 *
		 *     for(int j = i * i; j <= n; j += i)
		 *
		 *
		 * is safe and avoids redundant work.
		 *
		 *
		 * ========================================================================
		 * 10. IMPORTANT CLARIFICATION ABOUT i * (i - 1)
		 * ========================================================================
		 *
		 * It is NOT sufficient to say:
		 *
		 *     "i * (i - 1) is smaller than i * i, so it is already covered."
		 *
		 *
		 * Being smaller than i * i alone does not prove that a number is
		 * already marked.
		 *
		 *
		 * The real reason is:
		 *
		 *     i * k
		 *
		 * with:
		 *
		 *     k < i
		 *
		 * has a factor k smaller than i.
		 *
		 *
		 * If k is composite, k itself has a prime factor smaller than k,
		 * and therefore smaller than i.
		 *
		 *
		 * That smaller prime factor would already have been processed.
		 *
		 *
		 * Therefore i * k was already marked.
		 *
		 *
		 * This is the rigorous mathematical reason that the inner loop can
		 * begin at:
		 *
		 *     i * i
		 *
		 *
		 * ========================================================================
		 * 11. WHY DOES THE OUTER LOOP STOP AT sqrt(n)?
		 * ========================================================================
		 *
		 * The outer loop uses:
		 *
		 *     for(int i = 2; i * i <= n; i++)
		 *
		 *
		 * This condition is equivalent to:
		 *
		 *     i <= sqrt(n)
		 *
		 *
		 * because i and n are non-negative.
		 *
		 *
		 * The important theorem is:
		 *
		 *
		 *     EVERY COMPOSITE NUMBER n > 1 HAS A FACTOR
		 *     LESS THAN OR EQUAL TO sqrt(n).
		 *
		 *
		 * In fact, we can strengthen this:
		 *
		 *
		 *     EVERY COMPOSITE NUMBER n > 1 HAS A PRIME FACTOR
		 *     LESS THAN OR EQUAL TO sqrt(n).
		 *
		 *
		 * This theorem is the fundamental reason why the outer loop can stop
		 * at sqrt(n).
		 *
		 *
		 * ========================================================================
		 * 12. PROOF THAT EVERY COMPOSITE NUMBER HAS A FACTOR <= sqrt(n)
		 * ========================================================================
		 *
		 * Let n be composite.
		 *
		 * Therefore n can be written as:
		 *
		 *     n = a * b
		 *
		 *
		 * where:
		 *
		 *     1 < a <= b
		 *
		 *
		 * We want to prove:
		 *
		 *     a <= sqrt(n)
		 *
		 *
		 * Since:
		 *
		 *     a <= b
		 *
		 *
		 * multiplying both sides by a gives:
		 *
		 *     a * a <= a * b
		 *
		 *
		 * Therefore:
		 *
		 *     a^2 <= n
		 *
		 *
		 * Taking the square root of both sides:
		 *
		 *     a <= sqrt(n)
		 *
		 *
		 * Therefore every composite number has at least one factor
		 * less than or equal to sqrt(n).
		 *
		 *
		 * ========================================================================
		 * 13. WHY CAN WE SAY THE FACTOR CAN BE PRIME?
		 * ========================================================================
		 *
		 * Suppose n is composite.
		 *
		 * From the previous theorem, n has some factor:
		 *
		 *     a <= sqrt(n)
		 *
		 *
		 * If a is already prime, then we are finished.
		 *
		 *
		 * If a is composite, then a itself has a prime factor p.
		 *
		 *
		 * Since p divides a:
		 *
		 *     p <= a
		 *
		 *
		 * Therefore:
		 *
		 *     p <= a <= sqrt(n)
		 *
		 *
		 * Hence n has a PRIME factor:
		 *
		 *     p <= sqrt(n)
		 *
		 *
		 * This is a stronger and extremely useful theorem:
		 *
		 *
		 *     Every composite n > 1 has a prime divisor <= sqrt(n).
		 *
		 *
		 * ========================================================================
		 * 14. WHY IS THE sqrt(n) THEOREM IMPORTANT FOR THE SIEVE?
		 * ========================================================================
		 *
		 * Suppose we are finding all primes up to n.
		 *
		 *
		 * Any number m <= n that is composite must have a prime factor:
		 *
		 *     p <= sqrt(m)
		 *
		 *
		 * Since:
		 *
		 *     m <= n
		 *
		 *
		 * we also have:
		 *
		 *     sqrt(m) <= sqrt(n)
		 *
		 *
		 * Therefore:
		 *
		 *     p <= sqrt(n)
		 *
		 *
		 * So every composite number <= n must be divisible by some prime
		 * that is <= sqrt(n).
		 *
		 *
		 * Therefore, if we process all prime factors up to sqrt(n), every
		 * composite number in the entire range [2, n] will be marked.
		 *
		 *
		 * Once that has happened, any number still marked true must be prime.
		 *
		 *
		 * ========================================================================
		 * 15. VERY IMPORTANT: PRIMES CAN EXIST AFTER sqrt(n)
		 * ========================================================================
		 *
		 * This is a very common point of confusion.
		 *
		 *
		 * Suppose:
		 *
		 *     n = 100
		 *
		 *
		 * Then:
		 *
		 *     sqrt(100) = 10
		 *
		 *
		 * There are many primes greater than 10:
		 *
		 *     11
		 *     13
		 *     17
		 *     19
		 *     23
		 *     29
		 *     ...
		 *
		 *
		 * Therefore this statement is FALSE:
		 *
		 *
		 *     "There are no primes after sqrt(n)."
		 *
		 *
		 * The correct statement is:
		 *
		 *
		 *     "We do not need to USE numbers greater than sqrt(n)
		 *      as factors to identify composite numbers up to n."
		 *
		 *
		 * This is completely different.
		 *
		 *
		 * Primes greater than sqrt(n) still exist and are still part of the
		 * final answer.
		 *
		 *
		 * ========================================================================
		 * 16. WHY ARE PRIMES GREATER THAN sqrt(n) STILL FOUND?
		 * ========================================================================
		 *
		 * Look at the final loop:
		 *
		 *     for(int i = 2; i <= n; i++)
		 *     {
		 *         if(isPrime[i])
		 *         {
		 *             System.out.print(i + " ");
		 *         }
		 *     }
		 *
		 *
		 * Notice that THIS loop goes all the way to n.
		 *
		 *
		 * The sqrt(n) restriction applies only to the OUTER MARKING LOOP.
		 *
		 *
		 * It does NOT apply to the final loop that prints the primes.
		 *
		 *
		 * Therefore for n = 100:
		 *
		 *     outer loop:
		 *
		 *         i <= sqrt(100)
		 *
		 *         i <= 10
		 *
		 *
		 * but final loop:
		 *
		 *         i <= 100
		 *
		 *
		 * Therefore numbers such as:
		 *
		 *     11
		 *     13
		 *     17
		 *     19
		 *
		 * are still examined and printed.
		 *
		 *
		 * ========================================================================
		 * 17. WHY CAN THE REMAINING TRUE NUMBERS BE CALLED PRIME?
		 * ========================================================================
		 *
		 * Suppose after the sieve finishes, some number m >= 2 is still:
		 *
		 *     isPrime[m] == true
		 *
		 *
		 * Assume for contradiction that m is composite.
		 *
		 *
		 * By the theorem:
		 *
		 *
		 *     Every composite m has a prime factor p <= sqrt(m).
		 *
		 *
		 * Since:
		 *
		 *     m <= n
		 *
		 *
		 * we have:
		 *
		 *     sqrt(m) <= sqrt(n)
		 *
		 *
		 * Therefore:
		 *
		 *     p <= sqrt(n)
		 *
		 *
		 * The outer loop processes every possible prime factor up to sqrt(n).
		 *
		 *
		 * Therefore p would have been processed.
		 *
		 *
		 * Since p divides m, m would have been marked:
		 *
		 *     isPrime[m] = false;
		 *
		 *
		 * But we assumed:
		 *
		 *     isPrime[m] == true
		 *
		 *
		 * This is a contradiction.
		 *
		 *
		 * Therefore m cannot be composite.
		 *
		 *
		 * Since m >= 2, the only remaining possibility is:
		 *
		 *     m is prime.
		 *
		 *
		 * Therefore every number still marked true after the sieve is prime.
		 *
		 *
		 * ========================================================================
		 * 18. EXAMPLE WITH n = 30
		 * ========================================================================
		 *
		 * Let:
		 *
		 *     n = 30
		 *
		 *
		 * Then:
		 *
		 *     sqrt(30) is approximately 5.47
		 *
		 *
		 * Therefore the outer loop processes:
		 *
		 *     i = 2
		 *     i = 3
		 *     i = 4
		 *     i = 5
		 *
		 *
		 * It stops after that because:
		 *
		 *     6 * 6 > 30
		 *
		 *
		 * ------------------------------------------------
		 * i = 2
		 * ------------------------------------------------
		 *
		 * 2 is prime.
		 *
		 *
		 * Start at:
		 *
		 *     2 * 2 = 4
		 *
		 *
		 * Mark:
		 *
		 *     4
		 *     6
		 *     8
		 *     10
		 *     12
		 *     14
		 *     16
		 *     18
		 *     20
		 *     22
		 *     24
		 *     26
		 *     28
		 *     30
		 *
		 *
		 * as composite.
		 *
		 *
		 * ------------------------------------------------
		 * i = 3
		 * ------------------------------------------------
		 *
		 * 3 is prime.
		 *
		 *
		 * Start at:
		 *
		 *     3 * 3 = 9
		 *
		 *
		 * Mark:
		 *
		 *     9
		 *     12
		 *     15
		 *     18
		 *     21
		 *     24
		 *     27
		 *     30
		 *
		 *
		 * Some values such as 12, 18, 24, and 30 were already marked by 2.
		 *
		 * That is fine.
		 *
		 * The important optimization is that we did not start from:
		 *
		 *     3 * 2 = 6
		 *
		 *
		 * because 6 was already marked by 2.
		 *
		 *
		 * ------------------------------------------------
		 * i = 4
		 * ------------------------------------------------
		 *
		 * 4 is already false:
		 *
		 *     4 = 2 * 2
		 *
		 *
		 * Therefore:
		 *
		 *     if(isPrime[4])
		 *
		 *
		 * is false and the algorithm skips 4.
		 *
		 *
		 * ------------------------------------------------
		 * i = 5
		 * ------------------------------------------------
		 *
		 * 5 is prime.
		 *
		 *
		 * Start at:
		 *
		 *     5 * 5 = 25
		 *
		 *
		 * Mark:
		 *
		 *     25
		 *     30
		 *
		 *
		 * ------------------------------------------------
		 * i = 6
		 * ------------------------------------------------
		 *
		 * The condition:
		 *
		 *     i * i <= n
		 *
		 *
		 * becomes:
		 *
		 *     6 * 6 <= 30
		 *
		 *
		 * which is:
		 *
		 *     36 <= 30
		 *
		 *
		 * false.
		 *
		 *
		 * Therefore the outer loop stops.
		 *
		 *
		 * The remaining true values are:
		 *
		 *     2
		 *     3
		 *     5
		 *     7
		 *     11
		 *     13
		 *     17
		 *     19
		 *     23
		 *     29
		 *
		 *
		 * These are exactly the prime numbers <= 30.
		 *
		 *
		 * ========================================================================
		 * 19. TWO DIFFERENT OPTIMIZATIONS IN THIS CODE
		 * ========================================================================
		 *
		 *
		 * OPTIMIZATION 1:
		 *
		 *     for(int i = 2; i * i <= n; i++)
		 *
		 *
		 * This means:
		 *
		 *     Only process possible prime factors up to sqrt(n).
		 *
		 *
		 * Mathematical reason:
		 *
		 *     Every composite number <= n has a prime factor <= sqrt(n).
		 *
		 *
		 *
		 * OPTIMIZATION 2:
		 *
		 *     for(int j = i * i; j <= n; j += i)
		 *
		 *
		 * This means:
		 *
		 *     For a particular prime i, start marking at i^2.
		 *
		 *
		 * Mathematical reason:
		 *
		 *     All smaller multiples i * k where k < i have already been
		 *     marked by smaller prime factors.
		 *
		 *
		 * These are TWO DIFFERENT optimizations.
		 *
		 * They are related, but they should not be confused with each other.
		 *
		 *
		 * ========================================================================
		 * 20. WHY i * i AND sqrt(n) ARE RELATED
		 * ========================================================================
		 *
		 * The outer loop condition:
		 *
		 *     i * i <= n
		 *
		 *
		 * says:
		 *
		 *     i <= sqrt(n)
		 *
		 *
		 * The inner loop starts at:
		 *
		 *     i * i
		 *
		 *
		 * These two facts work together beautifully.
		 *
		 *
		 * Suppose:
		 *
		 *     i > sqrt(n)
		 *
		 *
		 * Then:
		 *
		 *     i * i > n
		 *
		 *
		 * Therefore there cannot be any multiple of i starting at i * i
		 * that is <= n.
		 *
		 *
		 * So once i passes sqrt(n), there is no useful new marking work
		 * remaining.
		 *
		 *
		 * ========================================================================
		 * 21. WHY DOES i * i SOMETIMES EXCEED n?
		 * ========================================================================
		 *
		 * Suppose:
		 *
		 *     n = 20
		 *
		 *
		 * When:
		 *
		 *     i = 5
		 *
		 *
		 * we get:
		 *
		 *     i * i = 25
		 *
		 *
		 * which is already greater than n.
		 *
		 *
		 * Therefore 5 does not need to mark anything.
		 *
		 *
		 * More importantly, any composite number <= 20 already has a prime
		 * factor <= sqrt(20), which is approximately 4.47.
		 *
		 *
		 * Therefore processing 2 and 3 is enough.
		 *
		 *
		 * ========================================================================
		 * 22. TIME COMPLEXITY
		 * ========================================================================
		 *
		 * The classical Sieve of Eratosthenes has time complexity:
		 *
		 *
		 *                         O(n log log n)
		 *
		 *
		 * and space complexity:
		 *
		 *
		 *                         O(n)
		 *
		 *
		 * Space is O(n) because:
		 *
		 *     boolean[] isPrime = new boolean[n + 1];
		 *
		 *
		 * stores information for every integer from 0 through n.
		 *
		 *
		 * The sieve is very efficient when we want ALL primes up to a given
		 * limit n.
		 *
		 *
		 * ========================================================================
		 * 23. COMPARISON WITH TRIAL DIVISION
		 * ========================================================================
		 *
		 * Suppose we want to find all primes from:
		 *
		 *     2 through n
		 *
		 *
		 * A naive approach might test every number individually for primality.
		 *
		 *
		 * For each number m, we could try divisors up to sqrt(m).
		 *
		 *
		 * That performs a lot of repeated work.
		 *
		 *
		 * The Sieve avoids this repeated work by maintaining a shared array
		 * of information for the entire range.
		 *
		 *
		 * Instead of repeatedly asking:
		 *
		 *     "Is this number divisible by 2?"
		 *     "Is this number divisible by 3?"
		 *     "Is this number divisible by 5?"
		 *
		 *
		 * for every number independently, the sieve processes each relevant
		 * prime factor and marks ALL of its multiples at once.
		 *
		 *
		 * ========================================================================
		 * 24. IMPORTANT DISTINCTION: SINGLE NUMBER VS RANGE
		 * ========================================================================
		 *
		 * For a SINGLE number n:
		 *
		 *
		 *     If n is composite, it has a prime factor <= sqrt(n).
		 *
		 *
		 * Therefore to test whether n is prime, we only need to check
		 * divisibility up to sqrt(n).
		 *
		 *
		 * But the Sieve of Eratosthenes solves a DIFFERENT problem:
		 *
		 *
		 *     Find ALL prime numbers from 2 through n.
		 *
		 *
		 * Therefore:
		 *
		 *     The outer marking phase only needs prime factors <= sqrt(n).
		 *
		 *     The final output phase still examines every number from
		 *     2 through n.
		 *
		 *
		 * This distinction is extremely important.
		 *
		 *
		 * ========================================================================
		 * 25. IMPORTANT THEOREMS TO REMEMBER
		 * ========================================================================
		 *
		 *
		 * THEOREM 1:
		 *
		 * Every integer greater than 1 is either prime or composite.
		 *
		 *
		 *
		 * THEOREM 2:
		 *
		 * Every composite integer greater than 1 has at least one prime factor.
		 *
		 *
		 *
		 * THEOREM 3:
		 *
		 * Every composite integer n > 1 has a factor <= sqrt(n).
		 *
		 *
		 *
		 * THEOREM 4:
		 *
		 * Every composite integer n > 1 has a PRIME factor <= sqrt(n).
		 *
		 *
		 *
		 * THEOREM 5:
		 *
		 * If p is prime, every multiple of p greater than p is composite.
		 *
		 *
		 *
		 * THEOREM 6:
		 *
		 * If a number m >= 2 has no prime divisor <= sqrt(m), then m is prime.
		 *
		 *
		 *
		 * ========================================================================
		 * 26. COMPLETE CODE-TO-MATHEMATICS MAPPING
		 * ========================================================================
		 *
		 *
		 * CODE:
		 *
		 *     boolean[] isPrime = new boolean[n + 1];
		 *
		 *
		 * MATHEMATICAL/ALGORITHMIC MEANING:
		 *
		 *     Maintain a candidate primality status for every number
		 *     from 0 through n.
		 *
		 *
		 *
		 * CODE:
		 *
		 *     Arrays.fill(isPrime, true);
		 *
		 *
		 * MEANING:
		 *
		 *     Initially assume every number is a candidate prime.
		 *
		 *
		 *
		 * CODE:
		 *
		 *     for(int i = 2; i * i <= n; i++)
		 *
		 *
		 * MEANING:
		 *
		 *     Process possible prime factors only through sqrt(n).
		 *
		 *
		 *
		 * CODE:
		 *
		 *     if(isPrime[i])
		 *
		 *
		 * MEANING:
		 *
		 *     Only process i if i has not already been proven composite.
		 *
		 *
		 *
		 * CODE:
		 *
		 *     for(int j = i * i; j <= n; j += i)
		 *
		 *
		 * MEANING:
		 *
		 *     Visit every multiple of i starting from i^2.
		 *
		 *
		 *
		 * CODE:
		 *
		 *     isPrime[j] = false;
		 *
		 *
		 * MEANING:
		 *
		 *     j is definitely composite because i divides j and:
		 *
		 *         1 < i < j
		 *
		 *
		 *
		 * CODE:
		 *
		 *     for(int i = 2; i <= n; i++)
		 *
		 *
		 * MEANING:
		 *
		 *     Examine the COMPLETE range from 2 through n.
		 *
		 *
		 *
		 * CODE:
		 *
		 *     if(isPrime[i])
		 *
		 *
		 * MEANING:
		 *
		 *     If i survived all composite markings, then i is prime.
		 *
		 *
		 * ========================================================================
		 * 27. THE ENTIRE ALGORITHM IN ONE SHORT MATHEMATICAL STATEMENT
		 * ========================================================================
		 *
		 *
		 * For every prime p <= sqrt(n):
		 *
		 *
		 *     mark all multiples:
		 *
		 *         p^2
		 *         2p
		 *         3p
		 *         ...
		 *
		 *
		 * as composite, starting specifically at p^2 because all multiples
		 * below p^2 have already been covered by smaller prime factors.
		 *
		 *
		 * After all primes <= sqrt(n) have been processed:
		 *
		 *
		 *     every number from 2 through n still marked true is prime.
		 *
		 *
		 * ========================================================================
		 * 28. THE MOST IMPORTANT CONCEPT TO REMEMBER
		 * ========================================================================
		 *
		 *
		 * DO NOT confuse these two statements:
		 *
		 *
		 * WRONG:
		 *
		 *     "There are no primes after sqrt(n)."
		 *
		 *
		 * CORRECT:
		 *
		 *     "We do not need prime factors greater than sqrt(n) to
		 *      identify composite numbers <= n."
		 *
		 *
		 * For example:
		 *
		 *     n = 100
		 *
		 *     sqrt(n) = 10
		 *
		 *
		 * 11 is a prime greater than sqrt(100).
		 *
		 * But we do not need to use 11 as a factor to identify composites
		 * <= 100.
		 *
		 *
		 * Why?
		 *
		 * Because if a composite number <= 100 had 11 as one factor, its
		 * other factor would have to be:
		 *
		 *     <= 100 / 11
		 *
		 *     < 11
		 *
		 *
		 * Therefore that composite number would also have a smaller factor
		 * that the sieve has already processed.
		 *
		 *
		 * For example:
		 *
		 *     77 = 7 * 11
		 *
		 *
		 * We do not need to process 11.
		 *
		 * 77 is already marked when processing 7.
		 *
		 *
		 * ========================================================================
		 * 29. FINAL SUMMARY
		 * ========================================================================
		 *
		 *
		 * The Sieve of Eratosthenes finds all primes from 2 to n by:
		 *
		 *
		 *     1. Assuming every number is prime initially.
		 *
		 *
		 *     2. Starting with the smallest prime, 2.
		 *
		 *
		 *     3. Marking all multiples of each prime as composite.
		 *
		 *
		 *     4. Starting the marking from i * i because all smaller
		 *        multiples have already been covered by smaller factors.
		 *
		 *
		 *     5. Processing factors only while:
		 *
		 *            i * i <= n
		 *
		 *
		 *        because every composite number <= n has a prime factor
		 *        <= sqrt(n).
		 *
		 *
		 *     6. Finally scanning the COMPLETE range from 2 to n.
		 *
		 *
		 *     7. Every number still marked true is prime.
		 *
		 *
		 * The two most important optimized lines are:
		 *
		 *
		 *     for(int i = 2; i * i <= n; i++)
		 *
		 *
		 * and:
		 *
		 *
		 *     for(int j = i * i; j <= n; j += i)
		 *
		 *
		 * The first is based on:
		 *
		 *
		 *     Every composite n has a prime factor <= sqrt(n).
		 *
		 *
		 * The second is based on:
		 *
		 *
		 *     For a prime i, every multiple i * k where k < i
		 *     has already been marked by a smaller prime factor.
		 *
		 *
		 * Therefore the algorithm is both mathematically correct and
		 * significantly more efficient than checking every multiple
		 * repeatedly.
		 *
		 *
		 * ========================================================================
		 *                     END OF SIEVE NOTES
		 * ========================================================================
		 */
	}
}
