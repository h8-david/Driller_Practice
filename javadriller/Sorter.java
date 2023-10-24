package javadriller;

import interfaces.Comparator;

public class Sorter
{
	// https://www.interviewbit.com/tutorial/quicksort-algorithm/
	/**
	 * Swaps the position of two items in array
	 * 
	 * @param array - array of items
	 * @param i - item 1
	 * @param j - item 2
	 */
	private static <T> void swap(ResizableArray<T> array, int i, int j) {

	}
	
	/**
	 * Swaps the positions of elements in the array such that
	 * after all swaps have occured, to the left of the pivot
	 * all elements are smaller than it, and all elements to
	 * the right are larger than it
	 * 
	 * @param array - array to be sorted
	 * @param left - leftmost position in array being partitioned
	 * @param right - rightmost position in array being partitioned (considered the pivot)
	 * @param comparator - determines item equality
	 * @return index of pivot after partitioning
	 */
	private static <T> int partition(ResizableArray<T> array, int left, int right, Comparator<T> comparator) {
		return 0; //stub
	}
		
	/**
	 * Implements quick sort
	 * Partitions the array and recursively sorts left and right of pivot
	 * 
	 * @param array - array to be sorted
	 * @param left - leftmost position of array to be sorted
	 * @param right - rightmost position of array to be sorted
	 * @param comparator - determines item equality
	 */
	private static <T> void quicksort(ResizableArray<T> array, int left, int right, Comparator<T> comparator) {

	}
	
	/**
	 * Sorts the array
	 * 
	 * @param array - array to be sorted
	 * @param comparator - determines item equality
	 */
	public static <T> void sort(ResizableArray<T> array, Comparator<T> comparator) {
		
	}
}
