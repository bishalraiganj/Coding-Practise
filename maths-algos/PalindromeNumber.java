public class PalindromeNumber {

	public static void main(String... args)
	{

		System.out.println(isPalindrome(123));
		System.out.println(isPalindrome(121));
		System.out.println(isPalindrome(1));
//		System.out.println(1%10);
	}


	//Time complexity theta (d) where d is the number of digits in the input number
	public static boolean isPalindrome(int number)
	{
		int rev = 0 ;
		int tmp = number;
		while( tmp != 0)
		{
			rev = rev * 10 + ( tmp % 10);
			tmp /= 10;
		}
		return Integer.valueOf(rev).equals(number);
	}
}
