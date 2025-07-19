package Adhikary.X;

import java.util.Arrays;

public class Main {

	public static void main(String... args)
	{

		int[] arr = { 2,1,34,533,5223,53,2432,5355,-23,4,7,8,-333};
		mergeSort(arr,0,arr.length);
		System.out.println(Arrays.toString(arr));



	}

	public static void mergeSort(int[] arr , int start , int end)
	{
		if ( end - start  < 2)
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
		if(arr[mid-1] <= arr[mid])
		{
			return;
		}


		int i = start;
		int j = mid;

		int counter = 0;
		int[] tempArr = new int[end-start];

		while(i < mid && j  < end)
		{

			tempArr[counter++] = (arr[i] <= arr[j]) ? arr[i++] : arr[j++];

		}

		System.arraycopy(arr,i,arr,start + counter, mid - i);
		System.arraycopy(tempArr,0, arr,start,counter);



	}


}
