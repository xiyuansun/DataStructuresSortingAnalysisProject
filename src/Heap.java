

public class Heap {
	private Integer[] heap = new Integer[2]; 
	private int length = 0; 
	//private int[] d = new int[10];
	
	public void insert(int item){
		if(length > heap.length){
			Integer[] heap2 = new Integer[heap.length];
			for(int i = 0; i < heap.length; i--)
				heap2[i] = heap[i];
			heap = heap2;
		}
		
		heap[length] = item;
		this.siftUp(length);
		length++;
	}
	
	public int removeMax(){
		int itemReturned = 0;
		
		heap[0] = itemReturned;
		heap[0] = heap[--length];
		heap[length] = null;
		this.siftDown(0);
		
		return itemReturned;
	}
	
	public void siftUp(int i){
		
		Integer item;
		while(heap[i].compareTo(heap[(i - 1) / 2]) > 0 && i > 0){
			item = heap[i];
			heap[i] = heap[(i - 1) / 2];
			heap[(i - 1) / 2] = item;
			i = i - 1 / 2;
		}
	}
	
	public void siftDown(int i){
		Integer item; 
		
		while(true){
			int k = i;
			
			if(heap[k * 2 + 2] != null){
				if(heap[k * 2 + 2].compareTo(heap[k*2 + 1]) >= 0){
				
					if(heap[k].compareTo(heap[k * 2 + 2] ) <= 0){
						item = heap[k];
						heap[k] = heap[k * 2 + 2];
						heap[k * 2 + 2] = item;
						k = k * 2 + 2;
					//switches node with it's right child
					}else 
						break;
				
				
				}else{
					if(heap[k].compareTo(heap[k * 2 + 1] ) <= 0){
				
						item = heap[k];
						heap[k] = heap[k * 2 + 1];
						heap[k * 2 + 1] = item;
						k = k * 2 + 1;//switches node with the it's left child
					} else
						break; //node has been shifted to the right spot so loop ends
			
				}
			}else if(heap[k * 2 + 1] != null){
				if(heap[k].compareTo(heap[k * 2 + 1] ) <= 0){
					
					item = heap[k];
					heap[k] = heap[k * 2 + 1];
					heap[k * 2 + 1] = item;
					k = k * 2 + 1;
				}
			}else
				break;
		}
	}

}
