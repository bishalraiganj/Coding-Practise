import java.util.Arrays;

public class QuickSort5 {


	public static void main(String... args)
	{

		int[] intArr = {2,4,6,24,67,2,45,77,12,-24,-21,-43,-19};

		quickSort(intArr,0,intArr.length);
		System.out.println(Arrays.toString(intArr));

	}


	public static void quickSort(int[] arr, int start, int end)
	{
		if(end - start < 2)
		{
			return;
		}

		int pivotSortedIndex = pivotSort(arr,start,end);

		quickSort(arr,start,pivotSortedIndex);
		quickSort(arr,pivotSortedIndex+1,end);

	}

	public static int pivotSort(int[] arr, int start, int  end)
	{
		int pivot=arr[start];

		int i = start;
		int j = end ;



		while( i < j)
		{
			while(i < j && arr[--j] >= pivot);
			if( i < j)
			{
				arr[i] = arr[j];

			}

			while(i < j && arr[++i] <= pivot);
			if(i < j)
			{
				arr[j] = arr[i];
 			}


			//{5,15,6,3,6,3,3,4,6}
		}

		arr[j] = pivot;

		return j;


	}
}
