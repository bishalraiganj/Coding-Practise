package algorithms_practise12;

import java.util.Arrays;

public class CountingSort12 {



	public static void main(String... args)
	{


		int[] intArr = {3,64,345,324,675,33,65,95,88,356,443,321};
		countingSort(intArr,3,675);
		System.out.println(Arrays.toString(intArr));
	}


	public static void countingSort(int[] arr,int rangeStart,int rangeEnd)
	{
		int[] counts = new int[rangeEnd - rangeStart + 1 ];

		for(int val : arr)
		{
			counts[val-rangeStart]++;
		}

		int[] temp = new int[arr.length];
		int counter =0 ;
		for(int i = 0 ; i < counts.length ; i++)
		{
			int iterations = counts[i];
			while(iterations-- > 0)
			{
				temp[counter++] = i + rangeStart;
			}

		}

		System.arraycopy(temp,0,arr,0,temp.length);
	}


}
