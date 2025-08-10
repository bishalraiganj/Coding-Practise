import java.util.Arrays;

public class RadixSort9 {


	public static void main(String... args)
	{


//		System.out.println(getValue(1219,3,10));




		int[] intArr = {2212,4042,4524,1121,8996,2445,6807,2022,1122,2213};
		radixSort(intArr,10,4);

		System.out.println(Arrays.toString(intArr));



	}



	public static void radixSort(int[] arr,int radix,int width)
	{
		for(int i = 0; i < width ; i++)
		{
			radixSingleSort(arr,i,radix);
		}


	}


	public static void radixSingleSort(int[] arr,int position,int radix) {
		int[] count = new int[radix];

		for (int a : arr) {
			count[getValue(a, position, radix)]++;
		}
//		if (position == 0) {
//			System.out.println(Arrays.toString(count));
//		}

		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}

//		if(position == 0)
//		{
//			System.out.println(Arrays.toString(count));
//		}

		int[] tempArr = new int[arr.length];

		for (int i = arr.length - 1; i >= 0; i--) {
			tempArr[(count[getValue(arr[i], position, radix)]--)  - 1] = arr[i];
		}

		System.arraycopy(tempArr, 0, arr, 0, arr.length);
//		if (position == 0)
//		{
//			System.out.println(Arrays.toString(arr));
//		}

	}






	public static int getValue(int number,int position,int radix)
	{
		return  (number / (int) Math.pow(10,position)  ) % radix;
	}

}
