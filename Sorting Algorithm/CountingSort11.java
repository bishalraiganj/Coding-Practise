import java.util.Arrays;

public class CountingSort11 {


	public static void main(String... args)
	{

		int[] intArr = {2,43,5,23,5,3,0,100};


		countingSort(intArr,0,100);
		System.out.println(Arrays.toString(intArr));


	}



	 public static void countingSort(int[] arr,int start,int end) {


		 int[] counts = new int[end - start + 1];

		 int[] tempArr = new int[arr.length];

		 int tempCounter = 0;


		 for (int val : arr) {
			 counts[val]++;
		 }

		 for (int i = 0; i < counts.length; i++) {

			 while (counts[i] > 0)
			 {
				 tempArr[tempCounter++] = i;
				 counts[i]--;
			 }
		 }


		 System.arraycopy(tempArr,0,arr,0,tempCounter);




	 }


}
