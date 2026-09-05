import java.util.Arrays;

public class PrintingPermutations {


	public static void main(String... args) {


		permute("ABC".toCharArray(),0);
	}


	// What happens is that  :
	/*
	* on each level of the recursion tree we are keeping each possible remaining char by swapping
	* so for the 0 th position the loop goes 4 times
	* 1 th position 3 times
	* 2 th position 2 times
	* 3 rd position loop goes 1 times ( base case returns immediately )
	* */
	public static void permute(char[] s, int i) {
		if (i == s.length - 1) System.out.println(Arrays.toString(s));

		for(int j = i; j < s.length; j++)
		{
			swap(s,i,j);
			permute(s,i+1);
			swap(s,j,i);
		}


	}

	public static void swap(char[] s, int i, int j)
	{
		char temp = s[i];
		s[i] = s[j];
		s[j] = temp;
	}
}
