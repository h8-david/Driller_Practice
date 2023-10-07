package interfaces;

import java.util.Collection;

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
	 */
	boolean insert(T item);
	
	/**
	 * Try to insert as many elements in the collection as possible to the 
	 * linked list
	 * @param collection - list of elements to insert into the linked list
	 * @return true if every element of the collection was inserted to the linked list
	 * 		   false if not every element inserted
	 */
	boolean insertAll(Collection<? extends T> collection);
	
	/**
	 * Try to replace an item that already exists in the list
	 * @param item - element to replace
	 * @return true if element was replaced successfully, 
	 * 		   false if element was not replaced
	 */
	boolean replace(T item);
	
	/**
	 * Try to remove an item from the list
	 * @param item - element to remove
	 * @return true if the element was successfully removed
	 * 		   false if the element was not removed
	 */
	boolean remove(T item);
	
	/**
	 * Get the first element of the linked list
	 * @return first element of the linked list
	 */
	T getFirst();
	
	/**
	 * Get the first element of the linked list then remove it from the list
	 * @return the first element of the linked list
	 */
	T pullFirst();
	
	/**
	 * Check to see if an element exists in the linked list
	 * @param item - element to search for
	 * @return true if element was found in the linked list
	 * 		   false if the element was not found in the linked list
	 */
	boolean contains(T item);
	
	/**
	 * Check to see if an element exists in the linked list and return it
	 * @param item - element to search for in the list
	 * @return the element in the linked list that was found
	 */
	T find(T item);
	
	/**
	 * Empty the linked list
	 */
	void clear();
	
	/**
	 * Get the number of elements of the linked list
	 * @return the number of elements in the linked list
	 */
	long getSize();
	
	/**
	 * Create an enumerator for the linked list
	 * see {@code Enumerator}
	 * @return an enumerator of the linked list
	 */
	Enumerator<T> enumerator();
}
