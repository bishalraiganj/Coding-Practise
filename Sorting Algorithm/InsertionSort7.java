import java.util.Arrays;

public class InsertionSort7 {



	public static void main(String... args)
	{
		int[] intArr = {-1,-53,-2,43,53,31,3,6,3,2,-3};
		insertionSort(intArr);
		System.out.println(Arrays.toString(intArr));
	}

	public static void insertionSort(int[] arr)
	{

		for(int i = 1 ; i < arr.length ; i++)
		{
			int tempVal = arr[i];
			int k = i;
			while( k > 0 && tempVal < arr[k-1])
			{
				arr[k] =  arr[k-1];
				k--;
			}

			arr[k] = tempVal;

		}
	}
}
