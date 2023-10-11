package abstractclasses;

import java.util.Collection;

import exceptions.LinkedListAccessException;
import exceptions.NullInsertionException;
import interfaces.Comparator;
import interfaces.Enumerator;
import interfaces.SortedLinkedList;
import javadriller.Node;

public abstract class AbstractSortedLinkedList<T> implements SortedLinkedList<T>
{
	protected Comparator<T> comparator;  // comparator that determines the list order and item equality
	protected Node<T> first;             // pointer to first element of linked list
	protected Node<T> last;              // pointer to last element of linked list
	protected int size;                  // number of elements in linked list
	
	// sets the comparator
	public AbstractSortedLinkedList(Comparator<T> comparator)
	{
		this.comparator = comparator;
	}
	
	/**
	 * see {@code SortedLinkedList}
	 */
	public abstract boolean insert(T item)
			throws NullInsertionException;
	
	/**
	 * see {@code SortedLinkedList}
	 */
	public abstract boolean insertAll(Collection<? extends T> collection)
			throws NullInsertionException;
	
	/**
	 * Try to append and element to the linked list
	 * @param item - element to append to linked list
	 * @return true if element was appended to linked list
	 * 		   false if element was not appended to linked list
	 */
	protected abstract boolean append(T item);
	
	/**
	 * see {@code SortedLinkedList}
	 */
	public abstract boolean replace(T item)
			throws NullInsertionException, LinkedListAccessException;
	
	/**
	 * see {@code SortedLinkedList}
	 */
	public abstract boolean remove(T item)
			throws LinkedListAccessException;
	
	/**
	 * see {@code SortedLinkedList}
	 */
	@Override
	public T getFirst() throws LinkedListAccessException
	{
		if(first == null)
		{
			throw new LinkedListAccessException();
		}
		return first.getData();
	}
	
	/**
	 * see {@code SortedLinkedList}
	 */
	@Override
	public T pullFirst() throws LinkedListAccessException
	{
		if(first == null)
		{
			throw new LinkedListAccessException();
		}
		T item = getFirst();
		removeFirst();
		return item;
	}
	
	/**
	 * Tries to remove the first element of the linked list
	 * @return true if element was removed from the linked list
	 *         false if element was not removed from the linked list
	 */
	protected boolean removeFirst()
	{
		return remove(first.getData());
	}
	
	/**
	 * see {@code SortedLinkedList}
	 */
	public abstract boolean contains(T item)
			throws LinkedListAccessException;
	
	/**
	 * see {@code SortedLinkedList}
	 */
	public abstract T find(T item)
			throws LinkedListAccessException;
	
	/**
	 * see {@code SortedLinkedList}
	 */
	public abstract void clear();
	
	/**
	 * see {@code SortedLinkedList}
	 */
	@Override
	public int getSize()
	{
		return size;
	}
	
	/**
	 * see {@code SortedLinkedList}
	 */
	public abstract Enumerator<T> enumerator();
}