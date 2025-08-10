import java.util.Arrays;

public class CountingSort6 {



	public static void main(String... args)
	{
		int[] intArr = {1,2,5,3,6,2,7,4,-22,-3,-34,-312,-356,-43};
		countingSort(intArr,-356,10);
		System.out.println(Arrays.toString(intArr));

	}

	public static void countingSort(int[] arr,int min , int max)
	{
		int[] counts = new int[max-min+1];

		for(int value : arr)
		{
			counts[value - min]++;
		}

		int counter=0;
		int[] tempArr = new int[arr.length];

		for(int i = 0 ; i < counts.length ; i++)
		{
			while(counts[i]-- >0) {
				tempArr[counter++] = i + min;
			}

		}

		System.arraycopy(tempArr,0,arr,0,arr.length);

	}

}
