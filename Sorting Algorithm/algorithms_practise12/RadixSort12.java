package algorithms_practise12;

import java.util.Arrays;

public class RadixSort12 {




	public static void main(String... args)
	{

		int[] intArr = {24533,12423,23452,99999,22424,32555,68733,97403,93474,92836};
		radixSort(intArr,10,5);
		System.out.println(Arrays.toString(intArr));


//		System.out.println(getValue(12324,3,10));


	}

	public static void radixSort(int[] arr,int radix, int width)
	{
		for(int i = 0 ; i < width ; i++)
		{
			radixSingleSort(arr,i,radix);
		}

	}

	public static void radixSingleSort(int[] arr,int fromLastIndex,int radix)
	{

		int[] counts = new int[radix];

		for(int val : arr)
		{
			counts[getValue(val,fromLastIndex,radix)]++;
		}


		for(int i = 1 ; i < counts.length ; i++)
		{
			counts[i] += counts[i-1];
		}
		System.out.println(Arrays.toString(counts));



		int[] temp = new int[arr.length];
		for(int i = arr.length-1; i >= 0 ; i--)
		{
			int val = arr[i];
			temp[counts[getValue(val,fromLastIndex,radix)]-- - 1] = val;

		}


		System.arraycopy(temp,0,arr,0,temp.length);

	}






	public static int getValue(int num,int fromLastIndex ,int radix)
	{

		return (num / (int) Math.pow(radix,fromLastIndex)) % radix;

	}



}
