public class OneOddOccuring {

	public static void main(String... args)
	{
		int[] arr1 = {1,2,2,3,3,4,4,4,4,5,5}; // 1
		int[] arr2 = {2,2,5,5,6,6,6,6,8,8,8}; // 8
		int[] arr3 = {2,2,16,16,8,5,5,5,5,5,5,9,9,8,10,10,10}; // 10
		occuring(arr1);
		occuring(arr2);
		occuring(arr3);
	}


	public static void occuring(int[] arr)
	{
		int res = arr[0];

		for(int i = 1 ; i < arr.length ; i++)
		{
			res ^= arr[i];
		}
		System.out.println(res);
	}
}
