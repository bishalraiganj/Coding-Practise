import java.util.Arrays;

public class MergeSort7 {



	public static void main(String... args)
	{
		int[] intArr = {-2,-3,-5,-23,-353,5,6,43,64,322};
		mergeSort(intArr,0,intArr.length);
		System.out.println(Arrays.toString(intArr));


	}

	public static void mergeSort(int[] arr, int start , int end)
	{

		if( end - start < 2)
		{
			return;
		}

		int mid  = ( start + end ) / 2 ;

		mergeSort(arr,start,mid);
		mergeSort(arr,mid,end);
		merge(arr,start,mid,end);

	}

	public static void merge(int[] arr,int start, int  mid , int end)
	{
		if( arr[mid-1] <= arr[mid] )
		{
			return;
		}

		int i = start;
		int j = mid;

		int counter = 0;
		int[] tempArr = new int[end-start];

		while(i < mid && j < end)
		{
			tempArr[counter++] = arr[i] <= arr[j] ?  arr[i++] : arr[j++];
		}

		if(i < mid)
		{
		System.arraycopy(arr,i,arr,start+counter,mid-i);
		}

		System.arraycopy(tempArr,0,arr,start,counter);

	}


}
