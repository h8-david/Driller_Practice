package javadriller;

import exceptions.IllegalIndexException;

public class ResizableArray<T>
{
	private final int DEFAULT_ARRAY_CAPACITY = 10;  // capacity used in no arg constructor
	private int capacity = DEFAULT_ARRAY_CAPACITY;  // maximum capacity, in items
	private int size = 0;                           // actual number of items currently in array
	private T[] data = null;                        // array of data
	
	/**
	 * constructs array with default capacity
	 */
	public ResizableArray() {
		
	}
	
	/**
	 * constructs array with specified capacity
	 * @param capacity - initial capacity of array
	 */
	public ResizableArray(int capacity) {
		
	}
	
	 /**
	  * adds item, increments size, doubles capacity as necessary
	  * @param item - data to be added to array
	  */
	public void add(T item) {

	}
	
	/**
	 * adds item at index, shifts following, doubles capacity as necessary
	 * cannot addAt an index outside the capacity at the time of insertion
	 * restrict addAt to only occur when insert in between entries or after the right-most entry
	 * @param item - data to be added to array
	 * @param index - index to add data to
	 * @throws IllegalIndexException when index is less than zero, or attempted insertion to
	 * 		   index that is outside the capacity at the time of insertion, or if insertion 
	 * 		   into index that is not between two entries or after the right-most entry
	 */
	public void addAt(T item, int index) throws IllegalIndexException {

	}
	
	/**
	 * replaces item at index, otherwise unchanged
	 * @param item - data to be added to array
	 * @param index - index to replace data at
	 * @throws IllegalIndexException
	 */
	public void replaceAt(T item, int index) throws IllegalIndexException {

	}
	
	/**
	 * removes item at index, shifts following back
	 * @param index - index of data to remove
	 * @throws IllegalIndexException
	 */
	public void removeAt(int index) throws IllegalIndexException {

	}
	
	/**
	 * returns (copy of) item at index
	 * @param index - index of data to get
	 * @return data at given index
	 * @throws IllegalIndexException
	 */
	public T get(int index) throws IllegalIndexException {
		return null; //stub
	}
	
	/**
	 * returns number of items currently in array
	 * @return current size of array
	 */
	public int getSize() {
		return 0; //stub
	}
	
	/**
	 * returns the current capacity of the array
	 * @return current capacity of array
	 */
	public int getCapacity() {
		return 0; //stub
	}
	
	 /**
	  * removes all items from array, resets to default capacity, set size to 0
	  */
	public void clear() {
		
	}   
	
	/**
	 * method to double array capacity
	 */
	private void doubleCapacity() {

	}
	
	 /**
	  *  method to halve array capacity
	  */
	private void halveCapacity() {

	}
}
