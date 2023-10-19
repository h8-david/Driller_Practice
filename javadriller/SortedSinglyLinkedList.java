package javadriller;
import java.util.Collection;

import abstractclasses.AbstractSortedLinkedList;
import exceptions.LinkedListAccessException;
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
	 * hint: break it up, first, last, somewhere in the middle
	 */
	@Override
	public boolean insert(T item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertAll(Collection<? extends T> collection) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void append(T item) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean replace(T item) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * hint: break it up, first, last, somewhere in the middle
	 */
	@Override
	public boolean remove(T item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(T item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T find(T item) throws LinkedListAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
	}

	/**
	 * hint: SinglyLinkedList can only traverse in one direction
	 */
	@Override
	public Enumerator<T> enumerator() {
		// TODO Auto-generated method stub
		return null;
	}
}