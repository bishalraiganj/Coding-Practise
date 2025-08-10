import java.util.Arrays;

public class RadixSort3 {


	//radix sort for numerics
	public static void main(String... args)
	{

		int[] intArr = {1342,5326,7455,7485,8943,8852,8666,9832,3221,2023,1111,8853,1112};
		radixSort(intArr,10,4);
		System.out.println(Arrays.toString(intArr));


	}


	public static void radixSort(int[] arr,int radix, int width)
	{
		for(int i = 0 ; i < width ; i++)
		{
			radixSingleSort(arr,i,radix);

		}
	}

	public static void radixSingleSort(int[] arr,int position, int radix)
	{


		int[] counts = new int[radix];

		for(int value : arr)
		{
			counts[getValue(value,position,radix)]++;
		}


		if(position==0) {
			System.out.println(Arrays.toString(counts));
		}
		for(int i = 1 ; i < counts.length ; i++)
		{
			counts[i] += counts[i-1];
		}


		int[] tempArr = new int[arr.length];

		for(int i = arr.length-1 ; i >= 0 ; i--)
		{
			tempArr[(counts[getValue(arr[i],position,radix)]--)-1] = arr[i];
		}

		System.arraycopy(tempArr,0,arr,0,tempArr.length);




	}

//   1342
	public static int getValue(int value , int position , int radix)
	{

		return (value /  (int) Math.pow(10,position)  ) % radix;

	}

}
