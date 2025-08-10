package out;

import java.util.Arrays;

public class MergeSort4 {

	public static void main(String... args)
	{
		int[] intArr = {-34,-3443,-5,-4,343,453,23,34553,432324};
		mergeSort(intArr,0,intArr.length);
		System.out.println(Arrays.toString(intArr));

	}


	public static void mergeSort(int[] arr,int start , int end)
	{
		if( end - start < 2)
		{
			return;
		}

		int mid = ( start + end ) / 2 ;

		mergeSort(arr,start,mid);
		mergeSort(arr,mid,end);

		merge(arr,start,mid,end);

	}

	public static void merge(int[] arr, int start , int mid , int end )
	{
		if( arr[mid-1] <= arr[mid])
		{
			return;
		}

		int i = start;
		int j = mid;

		int counter = 0 ;
		int[] tempArr = new int[end - start];

		while( i < mid && j < end)
		{
			tempArr[counter++] = ( arr[i] <= arr[j]) ? arr[i++] : arr[j++];
		}

		System.arraycopy(arr, i , arr,start + counter , mid - i);

		System.arraycopy(tempArr,0,arr,start,counter);
	}
}
