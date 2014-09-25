
public class Test {

	public static void main(String[] args) {
		
		
		int array[] = new int[1000000];
		for(int i = 0; i < array.length; i++){
			array[i] = (int)(Math.random()* 100);
		}
		
		/*for(int i = 0; i < array.length; i++){
			System.out.println(array[i]);
		}*/
	
		System.out.println("sorting");
		Sorting.heapSort(array);
		System.out.println("sorted");
		
		
		System.out.println(Sorting.isSorted(array));
		System.exit(0);

	}

}
