package out;

import java.util.Arrays;

public class QuickSort4 {


	public static void main(String... args)
	{

		int[] intArr = {3,1,3,3,3,1,8,2,4,5,6};
		quickSort(intArr,0,intArr.length);
		System.out.println(Arrays.toString(intArr));
	}

	public static void quickSort(int[] arr,int start, int end)
	{

		if(end - start < 2)
		{
			return;
		}


		int pivotIndex = sortPivot(arr,start,end);

		quickSort(arr,start,pivotIndex);

		quickSort(arr,pivotIndex+1,end);


	}


	public static int sortPivot(int[] arr, int start, int end)
	{
		int pivot = arr[start];


		int i = start;
		int j = end;

		while( i < j)
		{

			while( i < j && arr[--j] >= pivot);
			if( i < j)
			{
				arr[i] = arr[j];
			}


			// {3,1,3,3,3,1,8,2,4,5,6} , j = 7 , i = 2 , arr[7] = arr[2]  then  {2,1,3,3,3,1,8,3,4,5,6}

			// j = 5 , i = 3 { 2, 1,1,3,3,1,8 ,3,4,5,6} this happens when in the following while arr[++i] < pivot

			// Since , pivot is always the element at start / index 0  , we will move the position at i to j if it is equal or
			while(i < j && arr[++i] < pivot);

			if( i < j)
			{
				arr[j] = arr[i];
			}

		}

		arr[j] = pivot;

		return j;






	}

}
