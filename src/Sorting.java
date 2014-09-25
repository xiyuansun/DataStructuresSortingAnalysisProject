
public class Sorting {
	
	/**
	 * Method used solely for testing determines if array is sorted from smallest to largest element
	 * @param arr
	 * @return
	 */
	public static boolean isSorted(int[] arr){
		for(int i = 0; i < arr.length - 1; i++){
			if(arr[i] > arr[i+1])
				return false;
		}
		return true;
	}
	/**
	 * Sort elements in an array using heap sort.
	 * @param arr
	 */
	public static void heapSort(int[] arr){	
		int num = 0;
		//builds the heap
		for(int i = arr.length / 2; i >= 0; i--){
			siftDown(i, arr, arr.length);
		}
		//removes max element puts it at the end of the heap and heapifies the rest of the array
		for(int j = arr.length - 1  ; j > 0; ){
			num = arr[0];
			arr[0] = arr[j];
			arr[j] = num;
			
			siftDown(0, arr, j--);	
		}
	}
	/**
	 * Helper method sifts down a element in array in order to create a heap
	 * @param i
	 * @param arr
	 * @param length
	 */
	private static void siftDown(int i, int arr[], int length){
		int k = i;
		int rightChild;
		int leftChild;
		int current;
		int kR;
		int kL;
		
		while(true){
			current = arr[k];
			kR = k * 2 + 2;
			kL = k * 2 + 1;

			if(kR < length){
				rightChild = arr[kR ];
				leftChild = arr[kL];
				if(rightChild >= leftChild && current < rightChild){ //if right child > left child
				 //switches the two and changes k
					arr[k] = rightChild;
					k = kR;						
					arr[k] = current;
					//switches node with it's right child
				
				
				}else if (current < leftChild){
					arr[k] = leftChild;
					k = kL;
					arr[k] = current;
				} else
					break; //node has been shifted to the right spot so loop ends
			}else if(kL < length){
				leftChild = arr[kL];
				if(current < leftChild){	
					arr[k] = leftChild;
					k = kL;
					arr[k] = current;
				}else
					break;
			
			}else
				break;
		}
	}
	
	/**
	 * Quick sort method that takes the average of the first middle and last elements
	 * in order to find determine the pivot
	 * @param arr
	 */
	public static void quickSort(int[] arr){
		partition(arr, 0, arr.length - 1);	
	}
	
	/**
	 * partitions the array and uses recursion to partition the other two halves that were formed 
	 * in the process
	 * @param arr
	 * @param first
	 * @param last
	 */
	private static void partition(int[] arr, int first, int last){
			
		int pivot = (arr[first] + arr[last] + arr[(last + first) / 2]) / 3;
		int i = first - 1;
		int j = last + 1;
		int num;
		while(true){
			do{
				i++;
			}while(arr[i] < pivot);
			do{
				j--;
			}while(arr[j] > pivot);
			if(i < j){
				num = arr[i];
				arr[i] = arr[j];
				arr[j] = num;
			}else
				break;		
		}
		if(first < j && j > 0)
			partition(arr, first, j);
		if(j + 1 < last)
			partition(arr, j + 1, last);	
	}
	
	/**
	 * Uses two arrays and splits it into powers of two and the remainder
	 * in order to merge.
	 * @param arr
	 */
	public static void mergeSort(int[] arr){
		int[] arr2 = new int[arr.length]; // Switches off arrays instead constantly creating new ones
		int factor = 1;
		int i = 0;// Beginning of first segment to merge
		int iEnd; // mark the end of the i partition
		int jEnd;//marks the end of the j partition
		int j = 0;//second segment of merges
		int k = 0; //keeps place in the other array
		
		//Loops through the whole array merging it as many times as it needs
		while(factor < arr.length){
			//Loops through each individual segment
			while(k < arr.length){ 
				i = j;
				j = i + factor;
				iEnd = j < arr.length ? j : arr.length ;
				jEnd = j + factor < arr.length ? j + factor : arr.length ;
						
				//Loops element in each segment and merges it as need be to the other array
				while(i < iEnd || j < jEnd){
						
					if(i < iEnd && j < jEnd)
						arr2[k++] = arr[i] < arr[j] ?  arr[i++] : arr[j++];
					else if(i < iEnd)
						arr2[k++] = arr[i++];
					else
						arr2[k++] = arr[j++];
				}
			}
			factor = factor * 2;
			k = 0;
			i = 0;
			j = 0;
			
			//Loops through each individual segment
			while(k < arr.length){
				i = j;
				j = i + factor;
				iEnd = j < arr.length ? j : arr.length;
				jEnd = j + factor < arr.length ? j + factor : arr.length;
				
				//Loops element in each segment and merges it as need be to the other array
				while(i < iEnd || j < jEnd){
						
					if(i < iEnd && j < jEnd)
						arr[k++] = arr2[i] < arr2[j] ?  arr2[i++] : arr2[j++];
					else if(i < iEnd)
						arr[k++] = arr2[i++];
					else 
						arr[k++] = arr2[j++];
				}		
			}
			k = 0;
			factor = factor * 2;
			k = 0;
			i = 0;
			j = 0;			
		}	
	}
}
	
	


