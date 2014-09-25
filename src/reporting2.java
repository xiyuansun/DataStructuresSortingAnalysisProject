import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * takes a file name as the argument and converts that file of of integers
 * into an array and then prints out the file.
 * @author AdamC
 *
 */
public class reporting2 {

	public static void main(String[] args) throws IOException {
		String inputFile = args[0];
		int length = 0;
		int k = 0;
		long heapSortTime;
		long quickSortTime;
		long mergeSortTime;
		long time;
		int[] arr1;
		int[] arr2;
		int[] arr3;
		LinkedList<Integer> list = new LinkedList<Integer>();
		BufferedWriter bw1 = new BufferedWriter(new FileWriter("mxr136HS"));
		BufferedWriter bw2 = new BufferedWriter(new FileWriter("mxr136QS"));
		BufferedWriter bw3 = new BufferedWriter(new FileWriter("mxr136MS"));
		Scanner scanner = new Scanner(new FileReader(inputFile));
		
		while(scanner.hasNext()){
			list.add(Integer.parseInt(scanner.nextLine()));
			length++;
		}
		scanner.close();

		arr1 = new int[length];
		arr2 = new int[length];
		arr3 = new int[length];
		
		for(int i : list){
			arr1[k] = i;
			arr2[k] = i;
			arr3[k++] = i;
		}
		
		time = System.nanoTime();
		Sorting.heapSort(arr1);
		heapSortTime = System.nanoTime() - time;
	
		time = System.nanoTime();
		Sorting.quickSort(arr2);
		quickSortTime = System.nanoTime() - time;
	
		time = System.nanoTime();
		Sorting.mergeSort(arr3);
		mergeSortTime = System.nanoTime() - time;
		
		for(int i = 0; i < arr1.length; i++){
			bw1.write("" + arr1[i]);
			bw2.write("" + arr2[i]);
			bw3.write("" + arr3[i]);
			
			bw1.newLine();
			bw2.newLine();
			bw3.newLine();
		}
		
		bw1.write("adc82HS = " + heapSortTime);
		bw2.write("adc82QS = " + quickSortTime);
		bw3.write("adc82MS = " + mergeSortTime);
		bw1.close();
		bw2.close();
		bw3.close();
		
		System.exit(0);
	}

}
