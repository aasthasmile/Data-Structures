package Heap;

 class Heap {
	    int count;
	    int capacity;
	    int heap_size;
	    int[] array;
	    
	    	    
	    int parent(int i){
	    	return (i-1)/2;
	    }
	    int leftchild(int i){
	    	int l= 2*i+1;
	    	if(this.count>this.capacity)
	    		return -1;
	    	return l;
	    				
	    }
	    int rightchild(int i){
	    	int r= 2*i+2;
	    	if(this.count>this.capacity)
	    		return -1;
	    	return r;
	    }
	    
	    public void MaxHeapify(int i){
	    	int l,r,max=i;
	    	l=leftchild(i);
	    	r=rightchild(i);
	    	if(l!=-1 && this.array[l]>this.array[max])
	    		max=l;
	    	else
	    		max=i;
	    	if(l!=-1 && this.array[r]>this.array[max])
	    		max=r;
	    	if(max!=i){
	    		int temp=this.array[i];
	    		this.array[i]=this.array[max];
	    		this.array[max]=temp;
	    	}
	    	MaxHeapify(max);
	    }
	    
}
