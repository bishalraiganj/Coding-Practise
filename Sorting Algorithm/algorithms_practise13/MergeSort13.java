package algorithms_practise13;

import java.util.Arrays;

public class MergeSort13 {



	public static void main(String... args)
	{

		int[] intArr = {2,56,6,2,7,7,2,24,64,73,78,-3,-2,-34};
		mergeSort(intArr,0,intArr.length);
		System.out.println(Arrays.toString(intArr));


	}
	public static void mergeSort(int[] arr,int start, int end)
	{
		if(end -  start < 2)
		{
			return;
		}

		int mid =  (end +  start )  / 2 ;

		mergeSort(arr,start,mid);
		mergeSort(arr,mid,end);
		merge(arr,start,mid,end);

	}


	public static void merge(int[] arr,int start, int mid, int end)
	{
		if(arr[mid-1] <= arr[mid])
		{
			return ;
		}

		int i = start;
		int j = mid;

		int[] tempArr = new int[end - start ];
		int counter = 0;

		while( i < mid && j < end)
		{

			tempArr[counter++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];

		}

		if(i < mid)
		{
			System.arraycopy(arr,i,arr,start+counter,mid-i);
		}

		System.arraycopy(tempArr,0,arr,start,counter);






	}

}
