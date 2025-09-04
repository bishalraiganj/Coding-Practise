package algorithms_practise12;

import java.util.Arrays;

public class QuickSort12 {



	public static void main(String... args)
	{

		int[] intArr = { 2,55,32,69,9,-35,0,-32,-323};
		quickSort(intArr,0,intArr.length);
		System.out.println(Arrays.toString(intArr));



	}

	public static void quickSort(int[] arr,int start,int end) {

		if (end - start < 2)
		{
			return;
		}

		int pivotIndex = pivotSort(arr,start,end);

		quickSort(arr,start,pivotIndex);
		quickSort(arr,pivotIndex+1,end);

	}

	public static int pivotSort(int[] arr,int start,int end)
	{
		int pivot = arr[start];

		int i = start;
		int j = end;

		while(   i < j)
		{
			while( i < j  && pivot<=arr[--j]);
			if(i < j)
			{
				arr[i] = arr[j];
			}
			while( i < j && pivot > arr[++i]);

			if( i < j)
			{
				arr[j] = arr[i];
			}
		}

		arr[j] = pivot;
		return j;
	}


}
