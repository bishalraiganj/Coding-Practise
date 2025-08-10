import java.util.Arrays;

public class InsertionSort3 {


	public static void main(String... args)
	{

		int[] intArr = { 3,5,6,7,-3,55,645,-5554};
		insertionSort(intArr);
		System.out.println(Arrays.toString(intArr));

	}


	public static void insertionSort(int[] arr) {

		for (int i = 1; i < arr.length; i++)
		{

			int temp = arr[i];
			int k = i;

			while(k > 0 && temp < arr[k-1] )
			{
				arr[k] = arr[k-1];
				k--;
			}
			arr[k]=temp;

		}
	}


}
