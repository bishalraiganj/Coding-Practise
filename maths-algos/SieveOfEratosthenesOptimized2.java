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

		for(int i= 3 ; i * i <= n ; i+=2) // This is going through only the odd numbers, skipping 2 and its multiples
		{
			if(!prime[i] )
			{
				for(int j = i * i ; j <= n ; j+= 2 * i) // here the i * i means that, smaller numbers before i already processed and so are this,
					//smaller numbers multiples right , which is why we have to do from after i * i
					//now about the optimization j+= 2 * i , see at bottom for explanation
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

/*
* 1. What would the normal Sieve do?

For a prime i, the normal sieve marks all multiples of i:

for (int j = i * i; j <= n; j += i)
    prime[j] = true;

For example, if i = 3:

9, 12, 15, 18, 21, 24, 27, 30, ...

But your algorithm has already decided to ignore all even numbers, because every even number greater than 2 is automatically composite.

So when i = 3, you don't need to mark:

12 ❌
18 ❌
24 ❌
30 ❌

They're already known to be composite because they're even.

You only need:

9, 15, 21, 27, 33, ...

Notice the difference between consecutive relevant multiples:

9 → 15 → 21 → 27
   +6   +6   +6

And 6 = 2 × 3.

Therefore:

j += 2 * i
2. Why exactly 2 * i?

You're starting with:

j = i * i

Since i itself is odd, i * i is odd.

Then:

i²
i² + 2i
i² + 4i
i² + 6i
...

Factor out i:

i(i)
i(i + 2)
i(i + 4)
i(i + 6)
...

Because i is odd and you're adding 2 to the other factor, every one of these remains odd.

For i = 5:

5² = 25
25 + 2(5) = 35
35 + 10 = 45
45 + 10 = 55
65
75
85
...

These are exactly the odd multiples of 5.

The even multiples:

10, 20, 30, 40, 50, 60, ...

are skipped entirely.

3. So your two optimizations work together

Your code:

for (int i = 3; i * i <= n; i += 2)

means:

Only consider odd possible primes.

And:

for (int j = i * i; j <= n; j += 2 * i)

means:

Only mark odd multiples of those odd primes.

So you're essentially removing all unnecessary work involving even numbers.

Think of it like this:

Normal sieve for i = 3:

9  12  15  18  21  24  27  30
✓   ✗   ✓   ✗   ✓   ✗   ✓   ✗

Your optimized sieve:

9  → 15 → 21 → 27 → 33
   +6   +6   +6   +6

6 = 2 × 3
4. Why 2 * i and not just 2?

Because you're moving from one multiple of i to the next multiple of i.

The distance between consecutive multiples of i is i:

i, 2i, 3i, 4i, 5i...

But you only want every second multiple because the others are even.

So you're taking:

1i, 3i, 5i, 7i...

The difference is:

3i - 1i = 2i
5i - 3i = 2i
7i - 5i = 2i

Hence:

j += 2 * i;
The one-line memory trick

i jumps between all multiples; 2*i jumps between odd multiples.

And because your entire algorithm has chosen to ignore evens, 2 * i is the correct jump.*/
