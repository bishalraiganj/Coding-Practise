package algorithms_practise12;

import java.util.Arrays;

public class InsertionSort12 {



	public static void main(String... args)
	{

		int[] intArr = {23,55,632,63,2,56,3,6,-34,-32,-3,-289};
		insertionSort(intArr,0,intArr.length);
		System.out.println(Arrays.toString(intArr));




	}

	public static void insertionSort(int[] arr,int start,int end)
	{
		for(int i=++start; i < end ; i++) { // Looping from index 1 to end to compare and insert

			int j = i;
			int val = arr[i];

			while (j > 0 && arr[j - 1] > val) { // looping from current i value to index 0
				arr[j] = arr[j - 1];
				j--;
			}

			//When control comes here , three possibilities
			//1.previous value is smaller
			//2.previous value is equal
			//3.j < 0

			arr[j] = val;

		}








	}



}
