package Algorithms_Practise_14;


import java.util.Arrays;

class MaxHeap{

	int[] heap;
	int size = 0;

	public MaxHeap(int size)
	{
		heap = new int[size];
	}


	public void insert(int val)
	{
		if(size == heap.length)
		{
			throw new IndexOutOfBoundsException(" Heap is Full ! ");
		}
		heap[size] = val;
		fixHeapAbove(size);
		size++;
	}

	public int delete(int i)
	{


		if(isEmpty() || i>= size)
		{
			throw new IndexOutOfBoundsException(" Empty Heap  or invalid index ! ");
		}

		if( i == 0  )
		{
			return maxExtract();
		}



		int deletedVal = heap[i];
		if(i == size - 1)
		{
			heap[i] = 0; // for cleanliness but it does not matter as we reduce the size
			// , so now element at size is ignored anyways
			size--;
			return deletedVal;
		}

		heap[i] = heap[size - 1];
		heap[size - 1] = 0; // for cleanliness but it does not matter as we reduce the size
		// , so now element at size is ignored anyways
		size--;
		if(heap[i] > heap[getParent(i)])
		{
			fixHeapAbove(i);
		}
		else
		{
			fixHeapBelow(i);
		}
		return deletedVal;

	}




	public int maxExtract()
	{
		if(isEmpty())
		{
			throw new IndexOutOfBoundsException(" Empty Heap ! ");
		}
		int max = heap[0];
		heap[0] = heap[size - 1];
		fixHeapBelow(0);
		heap[size - 1 ] = 0;// for cleanliness but it does not matter as we reduce the size
		// , so now element at size is ignored anyways
		size--;
		return max;
	}


	//Optimized with hole-insertion
	public void fixHeapAbove(int i)
	{
		int replacement = heap[i];
		while(i > 0 && replacement > heap[getParent(i)])
		{
			heap[i] = heap[getParent(i)];
			i = getParent(i);
		}
		heap[i] = replacement;
	}


	//Un-Optimized without hole-insertion
	public void fixHeapAbove2(int i)
	{
		while( i > 0 && heap[i] > heap[ ( i - 1) / 2])
		{
			swap(i,(i - 1) /2);
			i = (i - 1) /2;
		}
	}


	public void fixHeapBelow(int i)
	{

		while(( 2 * i) + 1 < size)
		{
			int j =  ( 2 * i ) + 1;
			if(j + 1 < size && heap[j+1] > heap[j]) j++;
			if(heap[i] >= heap[j]) break;
			swap(i,j);
			i = j;
		}
	}


	public void swap(int i, int j)
	{
		int temp  = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}

	public int getParent(int index)
	{
		return (index - 1) / 2;
	}

	public int getChild(int index, boolean left)
	{
		return left ? ( 2 * index ) + 1 : ( 2 * index) + 2;
	}

	public boolean isEmpty()
	{
		return size == 0;
	}


	@Override
	public String toString()
	{
		return Arrays.toString(heap);
	}
}




public class HeapSort_Practise_14 {


	public static void main(String... args)
	{
		MaxHeap heap = new MaxHeap(30);
		heap.insert(9);
		heap.insert(5);
		heap.insert(8);
		heap.insert(7);
		heap.insert(4);
		heap.insert(3);

		System.out.println(heap);

//		System.out.println(heap.delete(1));
//
//		System.out.println(heap);

		System.out.println(heap.maxExtract());
		System.out.println(heap);

		System.out.println("-".repeat(50));

		int[] intArr = {12,-243,-23,-2,1,223,4,55,217,87,344};
		heapSort(intArr);
		System.out.println(Arrays.toString(intArr));

	}



	 public static void heapSort(int[] arr)
	 {
			MaxHeap heap = new MaxHeap(arr.length);
		 for(int val : arr)
		 {
			 heap.insert(val);
		 }


		 System.out.print("=".repeat(50) + " [Heap Backing Array]");
		 for(int i = arr.length - 1; i >=0 ; i--)
		 {
			 int val = heap.maxExtract();
			 arr[i] = val;
			 System.out.print(val + " ");

		 }
		 System.out.println("=".repeat(50));


	 }


}
