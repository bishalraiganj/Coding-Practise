package Algorithms_Practise_14;

import java.util.Arrays;

public class CountingSort_Practise_14 {


	public static void main(String... args)
	{
		int[] intArr = {-12,-23,-778,232,2,0,25};

		countingSort(intArr,-778,232);
		System.out.println(Arrays.toString(intArr));
	}

	public static void countingSort(int[] arr,int startOfRange, int endOfRange)
	{
		int[] counts = new int[endOfRange - startOfRange + 1];

		for(int val : arr)
		{
			counts[val - startOfRange]++;
		}

		int counter = 0;

		for(int i = 0 ; i < counts.length ; i++)
		{
			while(counts[i]-- > 0)
			{
				arr[counter++] = i + startOfRange;
			}
		}
	}


}
