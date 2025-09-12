package algorithms_practise13;

import java.util.Arrays;

public class CountingSort13 {

	public static void main(String... args)
	{

		int[] intArr = {2,535,63,22,97,9,30,3,23,4,355};
		countingSort(intArr,2,535);
		System.out.println(Arrays.toString(intArr));


	}


	public static void countingSort(int[] arr,int rangeStart,int rangeEnd)
	{
		int[] counts = new int[rangeEnd - rangeStart + 1 ];

		for(int val : arr)
		{

			counts[val -  rangeStart]++;
		}

		int indexCounter = 0;

		for(int i = 0 ; i < counts.length ; i++)
		{
			while(counts[i]-- > 0)
			{
				arr[indexCounter++] = i + rangeStart;
			}
		}


	}



}
