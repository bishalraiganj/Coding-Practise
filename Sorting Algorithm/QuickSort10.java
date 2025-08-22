import java.util.Arrays;

public class QuickSort10 {



	public static void main(String... args)
	{
		int[] intArr = { -3,-35,-2,-56,3,12,6,2,1,56,21,98};
		quickSort(intArr,0,intArr.length);
		System.out.println(Arrays.toString(intArr));

	}


	public static void quickSort(int[] arr,int start , int end)
	{
		if(end - start < 2)
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

		while ( i < j)
		{
			while(  i < j && arr[--j] >= pivot );
			if( i < j)
			{
				arr[i] = arr[j];
			}
			while( i < j && arr[++i] <= pivot);
			if( i < j)
			{
				arr[j] = arr[i];
			}

		}

		arr[j] = pivot;
		return j;

	}


}
