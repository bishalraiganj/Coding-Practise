package algorithms_practise13;

import java.util.Arrays;

public class RadixSort13 {


	public static void main(String... args)
	{
		int[] intArr = {2353,3563,6743,9732,9032,8503,9022,2945,4033,1044,3522,2043,3255,2034,1035};
		radixSort(intArr,10,4);
		System.out.println(Arrays.toString(intArr));



	}


	public static void radixSort(int[] arr,int radix,int width )
	{
		for(int i = 0 ; i < width ; i++)
		{
			radixSingleSort(arr,i,radix);
		}

	}



	public static void radixSingleSort(int[] arr,int index,int radix)
	{
		int[] counts = new int[radix];

		for(int val : arr)
		{
			counts[getValue(val,index,radix)]++;
		}


		for(int i = 1 ; i < counts.length ; i++ )
		{
			counts[i] += counts[i-1];
		}


		int[] tempArr = new int[arr.length];


		for(int i = arr.length - 1 ; i >= 0 ; i--)
		{
			tempArr[--counts[getValue(arr[i],index,radix)]] = arr[i] ;

		}

		System.arraycopy(tempArr,0,arr,0,arr.length);

	}




	public static int getValue(int val, int index, int radix)
	{
		return (val / (int) (Math.pow(10,index))) % radix;
	}


}
