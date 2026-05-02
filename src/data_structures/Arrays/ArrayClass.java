package data_structures.Arrays;

/**
 * Arrays Practices
 * Demonstrates array operations, utility methods, and best practices
 */
import java.util.Arrays;
import java.util.List;

/**
 * Arrays Learning: Core array operations and utility methods
 * Covers: creation, traversal, insertion, deletion, sorting, searching, and transformations
 */
public class ArrayClass {
	
	/**
	 * Main method - demonstrates all array operations and utility methods
	 * @param args command line arguments (not used)
	 */
	public static void main(String[] args) {
		int[] array = { 1, 2, 4, 5, 6, 7, 8, 9, 10, 0 };

		// Step 1: Get and print array length
		System.out.println(array.length);

		// Step 2: Traversal - Display array using different loop techniques
		showUsingForLoop(array, "Initial array (for loop)");
		showUsingAdvancedForLoop(array, "Initial array (enhanced for loop)");

		// Step 3: Insertion - Add element at specific index
		insert(array);

		// Step 4: Deletion - Remove element at specific index
		delete(array);

		// Step 5: Sorting - Arrange elements in ascending order
		Arrays.sort(array); // Sorts: [0, 1, 2, 4, 5, 6, 7, 8, 9, 10] 
		/*
		 * Arrays.sort() Algorithm Details:
		 *   - For primitives: Dual-Pivot QuickSort
		 *   - For objects: TimSort (hybrid of merge sort and insertion sort)
		 *   - Time Complexity: O(n log n) average and worst case
		 *   - Space Complexity: O(log n) for primitives, O(n) for objects
		 */
		showUsingAdvancedForLoop(array, "After sort"); 
		
// Step 6: Searching - Binary search (requires sorted array, O(log n))
		int search = 4;
		int index = Arrays.binarySearch(array, search);
		System.out.println(
			    (index >= 0) 
			    ? "Value " + search + " found at index " + index + " using binarySearch method."
			    : "Value not found"
		);

		// Step 7: Conversion to String - Convert array to human-readable format
		System.out.println("toString : "+Arrays.toString(array));
		int[][] arr = {{1,2},{3,4}};
		System.out.println("deepToString : "+Arrays.deepToString(arr)); // For multi-dimensional arrays
		
		// Step 8: Comparison - Compare array contents
		int[] a = {1,2};
		int[] b = {1,2};
		System.out.println("equals : "+Arrays.equals(a, b)); // true - compares contents
		
		int[][] arr1 = {{1,2},{3,4}};
		System.out.println("deepEquals : "+Arrays.deepEquals(arr, arr1)); // true - compares multi-dimensional arrays
		
		// Step 9: Fill - Initialize array with specific value
		int[] c = new int[5];
		Arrays.fill(c, 10);
		System.out.println("fill : "+Arrays.toString(c));
		
		// Step 10: Copy - Create a copy with new length (pads with null/default if larger)
		int[][] newArr = Arrays.copyOf(arr,5);
		System.out.println("copyOf : "+Arrays.deepToString(newArr));
		
		// Step 11: Copy Range - Copy specific range of elements
		int[][] sub = Arrays.copyOfRange(arr, 1, 4);
		System.out.println("copyOfRange : "+Arrays.deepToString(sub));
		
		// Step 12: Convert to List - Bridge between arrays and collections
		Integer[] ar = {1,2,3};
		List<Integer> list = Arrays.asList(ar);
		System.out.println("asList : "+list);
		
		//Arrays.stream(array).forEach(System.out::print); // 01245678910 - converting array to stream
		
		//Arrays.parallelSort(array); // [0, 1, 2, 4, 5, 6, 7, 8, 9, 10] - Faster sorting using multi-threading
		
		// Step 13: Mismatch - Find first index where arrays differ
		int[] a1 = {1,2,3};
		int[] b1 = {1,2,4};
		System.out.println("mismatch : "+Arrays.mismatch(a1, b1));
		
		// Step 14: Compare - Lexicographical comparison (-1, 0, or 1)
		System.out.println("compare : "+Arrays.compare(a1, b1));
		
		// Step 15: SetAll - Initialize using a function (lambda expression)
		int[] arrSetAll = new int[5];
		Arrays.setAll(arrSetAll, i -> i * 2);
		System.out.println("setAll : "+Arrays.toString(arrSetAll));

		// Step 16: ParallelPrefix - Cumulative/prefix sum operation (multi-threaded)
		Arrays.parallelPrefix(array, (i,j)->i+j);
		System.out.println("parallelPrefix : "+Arrays.toString(array));
	}

	/**
	 * Display array elements using traditional for loop
	 * @param arr the array to display
	 * @param s descriptive label for output
	 */
	public static void showUsingForLoop(int[] arr, String s) {
		System.out.print(s + " : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	/**
	 * Display array elements using enhanced for loop (for-each loop)
	 * More concise and cleaner syntax than traditional for loop
	 * @param arr the array to display
	 * @param s descriptive label for output
	 */
	public static void showUsingAdvancedForLoop(int[] arr, String s) {
		System.out.print(s + " : ");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	/**
	 * Insert a value at a specific index by shifting elements right
	 * Time Complexity: O(n) where n is array length
	 * @param array the array to modify
	 * @return the modified array
	 */
	public static int[] insert(int[] array) {
		int j = 2;
		System.out.println("Enter index to insert: "+j);
		int v = 3;
		System.out.println("Enter Value to insert at index " + j + " : "+v);
		int i = array.length - 1;
		while (i > j) {
			array[i] = array[i - 1];
			i--;
		}
		array[j] = v;
		showUsingAdvancedForLoop(array, "After insertion");
		return array;
	}

	/**
	 * Delete element at a specific index by shifting elements left
	 * Time Complexity: O(n) where n is array length
	 * @param array the array to modify
	 * @return the modified array
	 */
	public static int[] delete(int[] array) {
		int v = 2;
		System.out.println("Enter index to delete: "+v);
		for (int i = v; i < array.length - 1; i++) {
			array[i] = array[i + 1];
		}
		array[array.length - 1] = 0;
		showUsingAdvancedForLoop(array, "After Deletion");
		return array;
	}
}
