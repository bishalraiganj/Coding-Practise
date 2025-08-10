import java.util.Arrays;

public class MergeSort1 {


	public static void main(String... args)
	{

		int[] intArr = {20,-2,3,7,2,33,444,55,66,23,256,3423,6442,6453,645,64343,443,5434,7777,45543,3443,1,55,6};


		mergeSort(intArr,0,intArr.length);
		System.out.println(Arrays.toString(intArr));
	}



	//{ 20 , -2 , 3 , 7 ,1, 55 , 6 }
	public static void mergeSort(int[] arr , int start , int end)
	{
		if(end - start < 2)
		{
			return ;
		}

		int mid =  (start + end) / 2 ;

		mergeSort(arr,start,mid);
		mergeSort(arr,mid,end);
		merge(arr,start,mid,end);

	}

	// {20,-2,3,7,1,55,6}
	public static void merge(int[] arr, int start , int mid ,  int end)
	{
		if(arr[mid-1] <= arr[mid] )
		{
			return;
		}

		int i = start;
		int j = mid;
		int counter = 0;
		int[] tempArr = new int[end-start];

		while(i < mid && j < end)
		{
			tempArr[counter++]= (arr[i] <= arr[j]) ? arr[i++] : arr[j++];
		}

		// { 20, 24 , 21,22 }
		if(i < mid)
		{

			System.arraycopy(arr,i,arr,start+counter,mid - i);


		}
		System.arraycopy(tempArr,0,arr,start,counter);

	}

}
