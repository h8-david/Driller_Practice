package javadriller;
import java.util.Collection;

import abstractclasses.AbstractSortedLinkedList;
import interfaces.Comparator;
import interfaces.Enumerator;

/**
 * A Sorted Singly Linked List is a linked list that has nodes that 
 * only point to the next node, there is no way to go backwards
 * It is sorted in order based off a comparator
 * @author David
 * @param <T> Objects to store in the linked list
 */
public class SortedSinglyLinkedList<T> extends AbstractSortedLinkedList<T>
{

	public SortedSinglyLinkedList(Comparator<T> comparator) {
		super(comparator);
	}
	
	/**
	 * insert an item into the linked list
	 * if the item was added, return true
	 * if not return false
	 * 
	 * hint: break it up, first insertion, new first, last, somewhere in the middle
	 */
	@Override
	public boolean insert(T item) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * add as many elements in the collection as possible into the linked list
	 * if every element is added, return true, if not every element is added return false
	 * if the collection is null, return false
	 */
	@Override
	public boolean insertAll(Collection<? extends T> collection) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * add item to end of the list
	 * if item is null return false
	 */
	@Override
	protected boolean append(T item) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * find the element in the list then replace the data then return true
	 * if item is null or doesnt exist in the list, return false
	 */
	@Override
	public boolean replace(T item) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * find the element in the list, remove it then decrement size
	 * if the item is null or doesn't exist in the list, return false
	 * 
	 * hint: break it up, first, last, somewhere in the middle
	 */
	@Override
	public boolean remove(T item) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * find the element in the list then return true
	 * if item is null or doesn't exist in the list return false
	 */
	@Override
	public boolean contains(T item) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * find the element in the list then return it
	 * if item is null or doesn't exist in the list return null
	 */
	@Override
	public T find(T item) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * sets all the data and next pointers to null
	 * sets the size to 0
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * creates an enumerator that starts from the first element in the linked list
	 * 
	 * hint: SinglyLinkedListEnumerator
	 */
	@Override
	public Enumerator<T> enumerator() {
		// TODO Auto-generated method stub
		return null;
	}
}