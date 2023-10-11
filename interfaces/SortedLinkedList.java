package interfaces;

import java.util.Collection;

import exceptions.LinkedListAccessException;
import exceptions.NullInsertionException;

/**
 * Interface that defines a generic Sorted Linked List
 * @author David
 *
 * @param <T> Element type to be stored in the linked list
 */
public interface SortedLinkedList<T>
{
	/**
	 * The constructor for a class that extends this interface must have
	 * a comparator in a one args constuctor
	 * SortedLinkedList(Comparator<T> comparator)
	 * see {@code AbstractSortedLinkedList}
	 */
	
	/**
	 * Try to add an item to the linked list
	 * do not add duplicate values with insert
	 * @param item - element to be added
	 * @return true if item was inserted, false if item was not inserted
	 * @throws NullInsertionException when trying to insert null data
	 */
	boolean insert(T item)
			throws NullInsertionException;
	
	/**
	 * Try to insert as many elements in the collection as possible to the 
	 * linked list
	 * @param collection - list of elements to insert into the linked list
	 * @return true if every element of the collection was inserted to the linked list
	 * 		   false if not every element inserted
	 * @throws NullInsertionException when trying to insert null data
	 */
	boolean insertAll(Collection<? extends T> collection)
			throws NullInsertionException;
	
	/**
	 * Try to replace an item that already exists in the list
	 * @param item - element to replace
	 * @return true if element was replaced successfully, 
	 * 		   false if element was not replaced
	 * @throws NullInsertionException when trying to replace data
	 * 				with null data
	 * @throws LinkedListAccessException when trying to access an
	 * 				empty linked list
	 */
	boolean replace(T item)
			throws NullInsertionException, LinkedListAccessException;
	
	/**
	 * Try to remove an item from the list
	 * @param item - element to remove
	 * @return true if the element was successfully removed
	 * 		   false if the element was not removed
	 * @throws LinkedListAccessException when trying to access
	 * 				an empty linked list
	 */
	boolean remove(T item)
			throws LinkedListAccessException;
	
	/**
	 * Get the first element of the linked list
	 * @return first element of the linked list
	 * @throws LinkedListAccessException when trying to access
	 * 				a null first
	 */
	T getFirst()
			throws LinkedListAccessException;
	
	/**
	 * Get the first element of the linked list then remove it from the list
	 * @return the first element of the linked list
	 * @throws LinkedListAccessException when trying to access
	 * 				a null first
	 */
	T pullFirst()
			throws LinkedListAccessException;
	
	/**
	 * Check to see if an element exists in the linked list
	 * @param item - element to search for
	 * @return true if element was found in the linked list
	 * 		   false if the element was not found in the linked list
	 * @throws LinkedListAccessException when trying to access an
	 * 				empty linked list
	 */
	boolean contains(T item)
			throws LinkedListAccessException;
	
	/**
	 * Check to see if an element exists in the linked list and return it
	 * @param item - element to search for in the list
	 * @return the element in the linked list that was found
	 * @throws LinkedListAccessException when trying to find data
	 * 				that doesn't exist in linked list
	 */
	T find(T item)
		throws LinkedListAccessException;
	
	/**
	 * Empty the linked list
	 */
	void clear();
	
	/**
	 * Get the number of elements of the linked list
	 * @return the number of elements in the linked list
	 */
	int getSize();
	
	/**
	 * Create an enumerator for the linked list
	 * see {@code Enumerator}
	 * @return an enumerator of the linked list
	 */
	Enumerator<T> enumerator();
}