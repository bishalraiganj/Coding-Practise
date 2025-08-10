import java.util.Arrays;

public class CountingSort {


	public static void main(String... args)
	{

		int[] intArr = {1,4,5,3,9,8,8,7,4,6,7,3,7,9,3,2,10};
		countingSort(intArr,1,10);
		System.out.println(Arrays.toString(intArr));
	}


	public static void countingSort(int[] arr,int min, int max)
	{
		int[] counts = new int[max-min+1];

		for(int value : arr)
		{
			counts[value-min]++;
		}

		int[] tempArr = new int[arr.length];

		int counter = 0;

		for(int i = 0 ; i < counts.length ; i++)
		{
			while(counts[i]--  > 0)
			{
				tempArr[counter++] = i + min;
			}
		}

		System.arraycopy(tempArr,0 ,arr,0,tempArr.length);


	}

}
