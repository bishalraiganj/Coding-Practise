package Algorithms_Practise_14;

import java.util.Arrays;

public class RadixSort_Practise_14 {

	public static void main(String... args)
	{
		int[] intArr = {23453,21111,63323,10353,35333,87323};

		radixSort(intArr,5,10);
		System.out.println(Arrays.toString(intArr));

	}

	public static void radixSort(int[] arr, int width, int radix)
	{
		for(int i=0 ; i < width ; i++)
		{
			radixSingleSort(arr,i,radix);
		}

	}

	public static void radixSingleSort(int[] arr,int indexFromLast , int radix)
	{
		int[] counts = new int[radix];

		for(int val : arr)
		{
			counts[getValue(val,indexFromLast,radix)]++;
		}


		for(int i = 1 ; i < counts.length ; i++)
		{
			counts[i] += counts[i-1];
		}

		int[] temp = new int[arr.length];

		for(int i = arr.length - 1 ; i >= 0 ; i--)
		{
			temp[counts[getValue(arr[i],indexFromLast,radix)]-- - 1] = arr[i];
		}

		System.arraycopy(temp,0,arr,0,arr.length);

	}


	public static int getValue(int val , int indexFromLast, int radix)
	{
		return  (  val / (int) Math.pow(10,indexFromLast)) % radix;
	}


}
