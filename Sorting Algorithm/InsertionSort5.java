import java.util.Arrays;

public class InsertionSort5 {

	public static void main(String... args)
	{
		int[] intArr = {23323,43,54,646,32,74,7,3,-23,-354,-35};

		insertionSort(intArr);

		System.out.println(Arrays.toString(intArr));
	}


	public static void insertionSort(int[] arr)
	{


		for(int i = 1 ; i <arr.length ; i++)
		{
			int k = i;

			int temp = arr[i];
			while(k > 0 && arr[k-1] >temp)
			{
				arr[k] = arr[k-1];
				k--;
			}

			arr[k] = temp;

		}


	}
}
