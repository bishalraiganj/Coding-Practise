public class FactorialRecursive {


	public static void main(String... args)
	{
		System.out.println(recursiveFactorial(5));
		System.out.println(recursiveFactorial(6));
		System.out.println(recursiveFactorial(3));
		System.out.println(recursiveFactorial(12));
	}

	public static int recursiveFactorial(int num)
	{
		if(num == 0)
		{
			return 1;
		}
		return num * recursiveFactorial(num - 1);
	}
}
