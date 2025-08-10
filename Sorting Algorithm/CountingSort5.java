import java.util.Arrays;

public class CountingSort5 {
	public static void main(String... args)
	{


		int[] intArr = {0,2,5,6,3,6,7,3,5,4,2,5,7,3,9,3,5,7,0};

		int[] intArr2 = {3455,3460,3470,3401};
		countingSort(intArr,0,9);

		countingSort(intArr2,3401,3470);
		System.out.println(Arrays.toString(intArr));
		System.out.println("-".repeat(50));
		System.out.println(Arrays.toString(intArr2));
	}


	public static void countingSort(int[] arr,int min,int max)
	{
		int[] counts = new int[max-min+1];
		for(int value: arr)
		{
			counts[value-min]++;
		}

		int temp = 0;
		int[] tempArr = new int[arr.length];

		for(int i = 0 ; i <counts.length ; i++)
		{

			while(counts[i]-- >0)
			{
				tempArr[temp++] =  i + min;
			}
		}

		System.arraycopy(tempArr,0,arr,0,tempArr.length);


	}
}
