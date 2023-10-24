package javadriller;

import interfaces.Comparator;

/**
 * Binary Search Implementation
 * Binary Search takes an array and splits it down the middle and determines which
 * side of the array it should search through, then it will do the same search
 * recursively until it finds the element it is looking for
 * 
 * @author David
 */
public class Search
{	
	
	/**
	 * Implements Binary Search
	 * 
	 * @param item - look up data item
	 * @param array - sorted array to be searched
	 * @param comparator - determines item equality
	 * @return index of item, -1 if item is not in array
	 */
	public static <T> int binarySearch(T item, ResizableArray<T> array, Comparator<T> comparator)
	{
		return 0; //stub
	}
}
