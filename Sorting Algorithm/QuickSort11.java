import java.util.Arrays;

public class QuickSort11 {



	public static void main(String... args)
	{
		int[] intArr = {2,5,45,22,94,9,-23,-32,-3,0};

		quickSort(intArr,0,intArr.length);
		System.out.println(Arrays.toString(intArr));

	}

	//Pivot is the first value in the array
	public static void quickSort(int[] arr,int start,int end)
	{

		if( end - start < 2)
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


		while(i < j)
		{

			while( i < j && arr[--j] >= pivot);
			if(i < j)
			{
				arr[i] = arr[j];
			}

			while( i < j && arr[++i] <= pivot );
			if(i < j)
			{
				arr[j] = arr[i];
			}

		}

		arr[j] = pivot;

		return j;

	}



}
