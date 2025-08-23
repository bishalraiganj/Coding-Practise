import java.util.Arrays;

public class CountingSort11 {


	public static void main(String... args)
	{

		int[] intArr = {23,4,5,55,88,97,90,92,81,100};

//		int[] intArr2 = {1,23,5,7,0,8,3,4,2,86,97,233};


		countingSort(intArr,4,233);
		System.out.println(Arrays.toString(intArr));


	}



	 public static void countingSort(int[] arr,int start,int end) {


		 int[] counts = new int[end - start + 1];

		 int[] tempArr = new int[arr.length];

		 int tempCounter = 0;


		 for (int val : arr) {
			 counts[ val - start ]++;
		 }

		 for (int i = 0; i < counts.length; i++) {

			 while (counts[i] > 0)
			 {
				 tempArr[tempCounter++] = i + start;
				 counts[i]--;
			 }
		 }


		 System.arraycopy(tempArr,0,arr,0,tempCounter);




	 }


}
