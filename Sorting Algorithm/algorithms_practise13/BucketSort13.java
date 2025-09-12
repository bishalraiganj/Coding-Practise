package algorithms_practise13;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;

public class BucketSort13 {



	public static void main(String... args)
	{

		int[] intArr = {2,45,22,56,21,4,22,63,63};
		bucketSort(intArr);
		System.out.println(Arrays.toString(intArr));

	}



	//Lower values must be in lower buckets compared to higher values at higher buckets
	//other wise this sort does not work
	public static void bucketSort(int[] arr)
	{

		LinkedList<Integer>[] bucket = new LinkedList[100];
		for(int val : arr)
		{
			int hashValue = hash(val);
			if(bucket[hashValue] == null)
			{
				LinkedList<Integer> list = new LinkedList<>();
				bucket[hashValue] = list;
				list.add(val);
			}
			else
			{
				bucket[hashValue].add(val);
			}
		}



		int indexCounter = 0;

		for(LinkedList<Integer> list : bucket)
		{

			if(list != null)
			{

				Collections.sort(list);
				ListIterator<Integer> iterator = list.listIterator();
				while (iterator.hasNext()) {
					arr[indexCounter++] = iterator.next();
				}
			}

		}


	}

	public static int hash(int val)
	{
		return Math.abs( val % 100 );
	}

}
