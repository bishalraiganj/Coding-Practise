package algorithms_practise13;

import java.util.Arrays;

public class QuickSort13 {



	public static void main(String... args)
	{
		int[] intArr = {2,45,3,3,6,31,3,86,-34,-32,-18,-2,-1,-54};
//		int[] intArr = {1,0,-2,-5,-6};
		quickSort(intArr,0,intArr.length);
		System.out.println(Arrays.toString(intArr));


	}
public static void quickSort(int[] arr,int start,int end)
{
	if( end - start < 2)
	{
		return;
	}

	int pivotIndex = start; // taking extra memory we can directly pass the local
	// variable to pivotSort in the following instruction
	int pivotSortedPositionIndex =  pivotSort(arr,pivotIndex,start,end);

	quickSort(arr,start,pivotSortedPositionIndex);
	quickSort(arr,pivotSortedPositionIndex+1,end);

}

public static int pivotSort(int[] arr,int pivotIndex,int start,int end)
	{

		int i = start;
		int pivot = arr[pivotIndex];
		int j = end;





		while( i < j)
		{
			while(  i < j && pivot <= arr[--j]   );

			if(i < j)
			{
				arr[i] = arr[j]; // here ,after this point , j is empty
			}

			while(i < j && pivot >= arr[++i]);

			if(i < j)
			{
				arr[j++] = arr[i];
			}


		}


		arr[j]  =  pivot;

		return j;


	}



}
