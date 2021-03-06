package com.nagrikar.algorithm;

/**
 * This class sort an array by using insertion sort method
 * 
 * @author sneha
 * 
 */
public class InsertionSort {
	public int[] sort(int[] array) {
		int key, j;
		for (int i = 1; i < array.length; i++) {
			key = array[i];
			for (j = i - 1; j >= 0 && array[j] > key; j--) {
				array[j + 1] = array[j];
			}
			array[j + 1] = key;
		}

		return array;
	}

	public void printArray(int[] result) {
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.print("\n");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("insertion_sort");
		InsertionSort sorter = new InsertionSort();
		sorter.printArray(sorter.sort(new int[] { 1, 5, 2, 0, 9, 15, -20, -1, 1 }));
		sorter.printArray(sorter.sort(new int[] { 50, 49, 39, 29, 20, 1, 5, 10 }));
		sorter.printArray(sorter.sort(new int[] { 99, 100, 50, 50, 41, 56 }));
	}

}
