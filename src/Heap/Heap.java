package Heap;

import java.util.Arrays;

class Heap {
	int[] array;
	int count;
	int capacity; // size of the array

	String heap_type; // either it is a MIN_HEAP or a MAX_HEAP
	static final String MIN_HEAP = "MIN_HEAP";
	static final String MAX_HEAP = "MAX_HEAP";

	Heap(int capacity, String heapType) {
		this.capacity = capacity;
		this.count = 0;
		this.array = new int[capacity];
		this.heap_type = heapType;
	}

	int parent(int i) {
		if (i <= 0 || i >= this.count)
			return -1;
		return (i - 1) / 2;
	}

	int leftchild(int i) {
		int l = 2 * i + 1;
		if (l >= this.count)
			return -1;
		return l;

	}

	int rightchild(int i) {
		int r = 2 * i + 2;
		if (r >= this.count)
			return -1;
		return r;
	}

	public void MaxHeapify(int i) {
		int l, r, max = i;
		l = leftchild(i);
		r = rightchild(i);

		if (l != -1 && l <this.array.length && this.array[l] > this.array[max])
			max = l;
		else
			max = i;
		if (r != -1 && r<this.array.length && this.array[r] > this.array[max])
			max = r;
		if (max != i) {
			int temp = this.array[i];
			this.array[i] = this.array[max];
			this.array[max] = temp;
		}

		if (max!=0 && l != -1 && r != -1)
			MaxHeapify(max);
	}

	public void MinHeapify(int i) {
		int l, r, min = i;
		l = leftchild(i);
		r = rightchild(i);

		if (l != -1 && l <this.array.length && this.array[l] < this.array[min])
			min = l;
		else
			min = i;
		if (r != -1 && r <this.array.length&& this.array[r] < this.array[min])
			min = r;
		if (min != i) {
			int temp = this.array[i];
			this.array[i] = this.array[min];
			this.array[min] = temp;
		}

		if (l != -1 && r != -1)
			MinHeapify(min);
	}

	public void Insert(int data) {
		if (this.count == this.capacity)
			ResizeHeap();
		this.count++;
		int i = this.count - 1;
		int p = (i - 1) / 2;
		if (heap_type == MAX_HEAP) {
			while (i >= 0 && p > 0 && data > this.array[p]) {
				this.array[i] = this.array[(i - 1 / 2)];
				i = (i - 1) / 2;
			}
		} else if (heap_type == MIN_HEAP) {
			while (i >= 0 && p > 0 && data < this.array[p]) {
				this.array[i] = this.array[(i - 1 / 2)];
				i = (i - 1) / 2;
			}
		}
		this.array[i] = data;

		for (int k = (this.array.length - 1) / 2; k >=0; k--) {
			if (heap_type == MIN_HEAP)
				MinHeapify(k);
			else if (heap_type == MAX_HEAP)
				MaxHeapify(k);
		}

	}

	private void ResizeHeap() {
		int[] old_arr = new int[this.capacity];
		System.arraycopy(this.array, 0, old_arr, 0, this.count - 1);

		this.array = new int[2 * this.capacity];

		for (int i = 0; i < this.capacity; i++) {
			this.array[i] = old_arr[i];
		}
		this.capacity = this.capacity * 2; // doubling the capacity of the array
		old_arr = null;

	}

	public int delete() {
		if (this.count == 0)
			return -1;
		int data = this.array[0];
		this.array[0] = this.array[count - 1];
		this.array[count - 1] = 0;
		this.count = this.count - 1;

		if (heap_type == MAX_HEAP)
			MaxHeapify(0);
		else if (heap_type == MIN_HEAP)
			MinHeapify(0);

		return data;
	}

}
