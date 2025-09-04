package algorithms_practise12;

import java.util.Arrays;

public class MergeSort12 {


	public static void main(String... args)
	{
		int[] intArr = {2,5,2,667,74,22,7,345,25,0,-45,-32};
		mergeSort(intArr,0,intArr.length);

		System.out.println(Arrays.toString(intArr));





	}


	public static void mergeSort(int[] arr,int start,int end)
	{
		if(end - start < 2)
		{
			return;
		}

		int mid = (end + start) / 2;
		mergeSort(arr,start,mid);
		mergeSort(arr,mid,end);
		merge(arr,start,mid,end);

	}

	public static void merge(int[] arr,int start,int mid, int end)
	{
		if(arr[mid-1] <= arr[mid])
		{
			return;
		}

		int i = start;
		int j = mid;

		int[] temp = new int[end - start];
		int counter = 0;

		while( i < mid && j < end)
		{
			temp[counter++] = (arr[i] <= arr[j]) ? arr[i++] : arr[j++];
		}

		if(i < mid)
		{
			System.arraycopy(arr,i,arr,start+counter,mid - i);
		}

		System.arraycopy(temp,0,arr,start,counter);

	}





}
