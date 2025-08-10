import java.util.Arrays;

public class QuickSort6 {


	public static void main(String... args)
	{

		int[] intArr = {34,-46,2,4,1,7,74,-3553,-32,-21,67};

		quickSort(intArr,0,intArr.length-1);
		System.out.println(Arrays.toString(intArr));



	}



	public static void quickSort(int[] arr,int start , int end)
	{

		if(end - start < 2)
		{
			return;
		}

		int pivotIndex = sortPivot( arr, start , end);

		quickSort(arr,start,pivotIndex);
		quickSort(arr,pivotIndex+1,end);

	}

	public static int sortPivot(int[] arr, int start, int end) {

		int pivot =  arr[start];

		int  i = start;
		int j = end;

		while(i < j)
		{
			while( i < j && arr[--j] >= pivot);
			if( i < j)
			{
				arr[i]= arr[j];
			}
			while( i < j && arr[++i] <= pivot);

			if(i < j)
			{
				arr[j] = arr[i];
			}

		}


		arr[j] = pivot;
		return j;
	}
}
