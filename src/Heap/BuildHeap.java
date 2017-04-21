package Heap;

import java.util.Scanner;

public class BuildHeap {

	public static void main(String[] args) {

		calculateMedianInAStream();
		

		
	}

	private static void calculateMedianInAStream() {
		
		Heap minheap = new Heap(10, Heap.MIN_HEAP);
		Heap maxheap = new Heap(10, Heap.MAX_HEAP);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the total numbers in the stream :");
		int num = Integer.parseInt(sc.nextLine());

		int stream[] = new int[num];
		int effectiveMedian = Integer.MAX_VALUE;
		
		for (int i = 0; i < num; i++) {
			System.out.print("Enter "+(i+1)+" number :");
			stream[i] = sc.nextInt();

			if (stream[i] > effectiveMedian)
				minheap.Insert(stream[i]);
			else
				maxheap.Insert(stream[i]);

			if(Math.abs(minheap.count-maxheap.count)>1){
			if (minheap.count > maxheap.count) {
				int peek=minheap.array[0];
				maxheap.Insert(minheap.delete());
		        maxheap.MaxHeapify(peek);
                     
			}
			else if(maxheap.count>minheap.count){
				int peek=maxheap.array[0];
				minheap.Insert(maxheap.delete());
		        minheap.MinHeapify(peek);
			}
			}
				if(minheap.count==maxheap.count)
					effectiveMedian =(minheap.array[0]+maxheap.array[0])/2;
				else if(minheap.count>maxheap.count)
					effectiveMedian=minheap.array[0];
				else
					effectiveMedian=maxheap.array[0];
		
			System.out.println(effectiveMedian);

		}
	}

}
