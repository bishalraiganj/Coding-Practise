import java.util.Arrays;

public class RadixSort5 {

	public static void main(String... args)
	{
		int[] intArr = {2342,4523,6321,3979,5843,0033,9453,3434,1364,8032};


		radixSort(intArr,10,4);
		System.out.println(Arrays.toString(intArr));


		System.out.println(getDigit(0033,1,10));
		System.out.println(33/10);
		System.out.println((int) Math.pow(10,1));

	}



	// numbers must be strictly of width for like 2445 , not 0023 , numbers starting with 0 are treated in in java as octal numbers / base 8
	public static void radixSort(int[] arr,int radix, int width)
	{
		for(int i = 0 ; i < width ; i++)
		{
			radixSingleSort(arr,i,radix);
		}
	}


	public static void radixSingleSort(int[] arr, int position , int radix)
	{
		int[] counts = new int[radix];

		for(int value : arr)
		{
			counts[getDigit(value,position,radix)]++;
		}
		System.out.println(Arrays.toString(counts));

		for(int i = 1 ; i < counts.length ; i++)
		{
			counts[i] += counts[i-1];
		}


		int[] tempArr = new int[arr.length];
		for(int i = arr.length-1 ; i >= 0 ; i--)
		{
			tempArr[(counts[getDigit(arr[i],position,radix)]--) - 1] = arr[i];
		}

		System.arraycopy(tempArr,0,arr,0,tempArr.length);

	}


	public static int getDigit(int value,int position,int radix)
	{

		int intQuotient = value / ( (int) Math.pow(10,position) );


		return (intQuotient <= 9) ? intQuotient : intQuotient %  radix;
	}

}
