package Adhikary.X;

import java.util.Arrays;

public class Main {

	public static void main(String... args)
	{
		int[] arr = {2,3,5,6,6,3,6,0,9,10};
		countingSort(arr,0,10);

		System.out.println(Arrays.toString(arr));



	}



	public static void countingSort(int[] arr, int min ,  int max)
	{

		int[] countArr = new int[max - min + 1];

		for(int i = 0 ; i < arr.length ; i++)
		{
			countArr[arr[i] - min ]++;
		}


		int counter = 0 ;

		for(int i = min ; i <= max ; i++ )
		{
			while(countArr[i-min] > 0)
			{
				arr[counter++] = i;
				countArr[i-min]--;
			}


		}




	}



}
