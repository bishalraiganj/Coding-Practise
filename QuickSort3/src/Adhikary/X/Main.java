package Adhikary.X;

import java.util.Arrays;

public class Main {


	public static void main(String... args)
	{

		int[] arr = {2,234,535,-23,-224,-34,35,6664,643};
		quickSort(arr,0 ,arr.length);
		System.out.println(Arrays.toString(arr));

	}


	public static void quickSort(int[] arr , int start , int end)
	{
		if(end - start < 2)
		{
			return;
		}

		int pivotIndex = partition(arr,start,end);
		quickSort(arr,start,pivotIndex);
		quickSort(arr,pivotIndex+1,end);


	}

	public static int partition(int[] arr, int start, int end)
	{
		int pivot = arr[start];

		int i = start ;
		int j = end ;

		while( i < j )
		{

			while( i < j && arr[--j] >= pivot);

			if( i < j )
			{
				arr[i] = arr[j];
			}


			while( i < j && arr[++i] <= pivot);

			if( i < j )
			{
				arr[j] = arr[i];
			}


		}

		arr[j] = pivot;

		return  j ;





	}



}
