package Algorithms_Practise_14;

import java.util.Arrays;

public class QuickSort_Practise_14 {



	public static void main(String... args)
	{
		int[] intArr = {-12,-2,34,5,2,1,2435};
		quickSort(intArr,0,intArr.length);
		System.out.println(Arrays.toString(intArr));



	}


	public static void quickSort(int[] arr,int start,int end)
	{
		if( end -  start < 2)
		{
			return;
		}

		int pivotSortedIndex = sortPivot(arr,start,end);

		quickSort(arr,start,pivotSortedIndex);
		quickSort(arr,pivotSortedIndex+1,end);
	}

	public static int sortPivot(int[] arr,int start, int end)
	{
		int pivot = arr[start];

		int i = start;
		int j = end;

		while( i < j)
		{

			while( i < j && arr[--j] >= pivot );
			if(i < j)
			{
				arr[i] = arr[j];
			}

			while( i < j && arr[++i] <= pivot);
			if(i < j)
			{
				arr[j++]= arr[i];
			}
		}

		arr[j] = pivot;
		return j;
	}

}
