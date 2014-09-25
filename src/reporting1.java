import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;


public class reporting1 {

	/**
	 * Runs through a sorted array 3 times, reversed array 3 times, and a
	 * randomized array 10 times, prints out the time and variance values
	 * for heap sort, quick sort, and merge sort for each type of arrays.
	 * Exports them in a .xls file named Table(size of array).xls so that
	 * they can be opened in excel. Size of array can be changed by changing
	 * the size of the first array.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException{
		long heapSortTime;
		long quickSortTime;
		long mergeSortTime;
		long time;
		LinkedList<Long> hsTimes = new LinkedList<Long>();
		LinkedList<Long> qsTimes = new LinkedList<Long>();
		LinkedList<Long> msTimes = new LinkedList<Long>();
		//size of this array sets the size for all other arrays
		int array1[] = new int[1000000];
		int array2[] = new int[array1.length];
		int array3[] = new int[array1.length];
		
		for(int i = 0; i < array1.length; i++)
			array1[i] = (int)(Math.random()* 1048576);
		//.xls extension means it will be exported as an excel file so that numbers can be farther 
		//edited 
		BufferedWriter bw = new BufferedWriter(new FileWriter("Table" + array1.length + ".xls"));
		
		bw.write("heap sort" + "\t" + "quick sort" + "\t" + "merge sort" );
		bw.newLine();
		
		bw.write("SORTED ARRAY");
		bw.newLine();
		
		Sorting.quickSort(array1);
		
		
		for(int k = 0; k < 3; k++){
			time = System.nanoTime();
			Sorting.heapSort(array1);
			heapSortTime = System.nanoTime() - time;
			hsTimes.add(heapSortTime);
		
			time = System.nanoTime();
			Sorting.quickSort(array1);
			quickSortTime = System.nanoTime() - time;
			qsTimes.add(quickSortTime);
		
			time = System.nanoTime();
			Sorting.mergeSort(array1);
			mergeSortTime = System.nanoTime() - time;
			msTimes.add(mergeSortTime);
		
		
			bw.write(heapSortTime + "\t" + quickSortTime + "\t" + mergeSortTime );
			bw.newLine();
		}
		bw.newLine();
		bw.write("VarienceHS\tVareinceQS\tVarienceMS");
		bw.newLine();
		bw.write(varienceVal(hsTimes) + "\t" + varienceVal(qsTimes) + "\t" + varienceVal(msTimes));
		bw.newLine();
		hsTimes = new LinkedList<Long>();
		qsTimes = new LinkedList<Long>();
		msTimes = new LinkedList<Long>();
		
		bw.write("REVERSED ARRAY");
		bw.newLine();
		for(int j = 0; j < 3; j++){
			for(int i = 0, k = array1.length; i < array1.length; i++){
				array2[--k] = array1[i];
				array3[k] = array1[i];
			}
			for(int i = 0; i < array1.length; i++)
				array1[i] = array2[i];
		
			time = System.nanoTime();
			Sorting.heapSort(array1);
			heapSortTime = System.nanoTime() - time;
			hsTimes.add(heapSortTime);

			time = System.nanoTime();
			Sorting.quickSort(array2);
			quickSortTime = System.nanoTime() - time;
			qsTimes.add(quickSortTime);
		
			time = System.nanoTime();
			Sorting.mergeSort(array3);
			mergeSortTime = System.nanoTime() - time;
			msTimes.add(mergeSortTime);

			bw.write(heapSortTime + "\t" + quickSortTime + "\t" + mergeSortTime );
			bw.newLine();
		}
		bw.newLine();
		bw.write("VarienceHS\tVareinceQS\tVarienceMS");
		bw.newLine();
		bw.write(varienceVal(hsTimes) + "\t" + varienceVal(qsTimes) + "\t" + varienceVal(msTimes));
		bw.newLine();
		hsTimes = new LinkedList<Long>();
		qsTimes = new LinkedList<Long>();
		msTimes = new LinkedList<Long>();
		
		bw.write("RANDOM ARRAY");
		bw.newLine();
		for(int k = 0; k < 10; k++){
		
			for(int i = 0; i < array1.length; i++)
				array1[i] = (int)(Math.random()* 1048576);
		
			for(int i = 0; i < array1.length;i++){
				array2[i] = array1[i];
				array3[i] = array1[i];	
			}
			
			time = System.nanoTime();
			Sorting.heapSort(array1);
			heapSortTime = System.nanoTime() - time;
			hsTimes.add(heapSortTime);
		
			time = System.nanoTime();
			Sorting.quickSort(array2);
			quickSortTime = System.nanoTime() - time;
			qsTimes.add(quickSortTime);
		
			time = System.nanoTime();
			Sorting.mergeSort(array3);
			mergeSortTime = System.nanoTime() - time;
			msTimes.add(mergeSortTime);
		
			bw.write(heapSortTime + "\t" + quickSortTime + "\t" + mergeSortTime + "\t");
			bw.newLine();	
		}
		bw.newLine();
		bw.write("VarienceHS\tVareinceQS\tVarienceMS");
		bw.newLine();
		bw.write(varienceVal(hsTimes) + "\t" + varienceVal(qsTimes) + "\t" + varienceVal(msTimes));
		bw.newLine();
		
		bw.close();
		
		System.exit(0);
	}
	
	/**
	 * helper method used to determine the average value
	 * @param list
	 * @return
	 */
	private static long meanVal(LinkedList<Long> list){
		long val = 0;
		for(Long k : list)
			val += k;
		return val / list.size();
	}
	/**
	 * helper method used to compute the variance
	 * @param list
	 * @return
	 */
	private static double varienceVal(LinkedList<Long> list){
		int length = list.size();
		long mean = meanVal(list);
		long varience = 0;
		for(Long k : list)
			varience += ((k - mean) * (k - mean));

		return  (varience * (1.0 / (length - 1)));
	}

}
