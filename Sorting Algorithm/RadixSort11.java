import java.util.Arrays;

public class RadixSort11 {




	public static void main(String... args)
	{


		int[] intArr = {12232,20234,33867,42412,50503,40343,33414,54543};
		radixSort(intArr,10,5);
		System.out.println(Arrays.toString(intArr));



	}




	public static void radixSort(int[] arr,int radix,int width)
	{
		for(int i = 0 ; i < width ; i++)
		{
			radixSingleSort(arr,radix,i);
		}
	}

	public static void radixSingleSort(int[] arr,int radix,int indexFrmLst)
	{


		int[] counts = new int[radix];
		int[] tempArr = new int[arr.length];

		for(int val : arr)
		{
			counts[getValue(val,radix,indexFrmLst)]++;
		}

		for(int i = 1 ; i < counts.length; i++)
		{
			counts[i] += counts[i-1];
		}

		for( int i = arr.length - 1 ; i >= 0 ; i--)
		{
			tempArr[(counts[getValue(arr[i],radix,indexFrmLst)]--) - 1 ] = arr[i];
		}

		System.arraycopy(tempArr,0,arr,0,arr.length);


	}


	public static int getValue(int value,int radix,int indexFrmLst)
	{

		return    (value / (int) Math.pow(10,indexFrmLst)) % radix;

	}
}
