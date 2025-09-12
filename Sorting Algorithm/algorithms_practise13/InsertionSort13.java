package algorithms_practise13;

import java.util.Arrays;

public class InsertionSort13 {


	public static void main(String... args)
	{

		int[] intArr = {2,53,54,2,6,32,321,31,61,134,-34,-321,-222};
		insertionSort(intArr);
		System.out.println(Arrays.toString(intArr));

	}

	public static void insertionSort(int[] arr)
	{
		for(int i = 1 ; i < arr.length ; i++)
		{
			int j = i;
			int val = arr[i];

			while(j > 0 && arr[--j] > val)
			{
				arr[j+1] = arr[j];
				arr[j] = val;
			}

		}


	}





}
