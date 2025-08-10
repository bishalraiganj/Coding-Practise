import java.util.Arrays;

public class RadixSort6 {



	public static void main(String... args)
	{

		int[] intArr = {19433,24984,50880,93431,31242,81134,26323,63442,12244};
		radixSort(intArr,10,5);
		System.out.println(Arrays.toString(intArr));
	}



	public static void radixSort(int[] arr, int radix,int width)
	{
		for(int i=0; i < width ; i++)
		{
			radixSingleSort(arr,i,radix);
		}

	}

	public static void radixSingleSort(int[] arr,int position,int radix)
	{

		int[] counts = new int[radix];

		for(int value : arr)
		{
			counts[getValue(value,position,radix)]++;
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


	public static int getValue(int value,int position,int radix)
	{
//		if(position == 0) {
//			System.out.println((value / (int) Math.pow(10, position)) % radix);
//		}
		return ( value / (int) Math.pow(10,position)) % radix;
	}
}
