public class TwoOddOccuring {

	public static void main(String... args)
	{
		int[] arr1 = {1,2,2,3,3,4,4,4,4,5,5,9}; // 1,9
		int[] arr2 = {2,2,5,5,6,6,6,6,8,8,8,11,11,11,11,11}; // 8,11
		int[] arr3 = {2,2,16,23,16,8,5,5,5,5,5,5,9,9,8,10,10,10}; // 10,23
		occuring(arr1);
		occuring(arr2);
		occuring(arr3);
	}

	public static void occuring(int[] arr)
	{
		int n = arr[0];
		for(int i = 1 ; i < arr.length ; i++)
		{
			n ^= arr[i];
		}

		int k =  n & ( ~(n-1));

		int firstOddOccuring = 0;
		for(int i = 0 ; i < arr.length ; i++)
		{
			if( (arr[ i ] & k) != 0)
			{
				firstOddOccuring ^= arr[i];
			}
		}

		int secondOddOccuring = 0 ;
		for(int i = 0 ; i < arr.length ; i++)
		{
			if( (arr[i] & k) == 0)
			{
				secondOddOccuring ^= arr[i];
			}
		}
		System.out.println(firstOddOccuring + " " + secondOddOccuring);


	}

}
