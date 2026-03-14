package Sorting_Algorithms_practice_15;

import java.util.Arrays;

public class QuickSort_15 {

public static void  main(String... args)
{
	int[] arr ={ 34,21,2,13,522,53,12,1,-1,-23};
	quickSort(arr,0,arr.length);
	System.out.println(Arrays.toString(arr));
}


public static void quickSort(int[] arr, int start, int end)
{
	if( end - start < 2) return;

	int pivot  =  sortPivot(arr,start,end);


	quickSort(arr,start,pivot);
	quickSort(arr,pivot+1,end);

}

public static int sortPivot(int[] arr, int start, int end)
{
	int pivot = arr[start];

	int i = start;
	int j = end;

	while( i < j)
	{
		while( i < j && arr[--j] >= pivot);
		if(i < j)
		{
			arr[i] = arr[j];
		}
		while( i < j && arr[++i] <= pivot);
		if( i < j)
		{
			arr[j++] = arr[i];
		}

	}

	arr[j] = pivot;
	return j;

}

}
