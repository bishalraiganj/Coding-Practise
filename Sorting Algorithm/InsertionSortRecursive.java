import java.util.Arrays;

public class InsertionSortRecursive {

	public static void main(String... args)
	{

		int[] intArr = {2,34,53,255,26,5,-34,-43,-4343};
		insertionSortRecursive(intArr,1);
		System.out.println(Arrays.toString(intArr));

	}

	public static void insertionSortRecursive(int[] arr, int lastUnsortedIndex)
	{


		if( lastUnsortedIndex >= arr.length)
		{
			return;
		}

		insert(arr,lastUnsortedIndex);
		lastUnsortedIndex++;
		insertionSortRecursive(arr,lastUnsortedIndex);


	}

	public static void insert(int[] arr, int lastUnsortedIndex)
	{

		int temp = arr[lastUnsortedIndex];
		int k = lastUnsortedIndex;
		while(k > 0 && temp < arr[k-1])
		{
			arr[k] = arr[k-1];
			k--;
		}
		arr[k] = temp;


	}



}
