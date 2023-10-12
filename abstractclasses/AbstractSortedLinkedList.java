package abstractclasses;

import exceptions.LinkedListAccessException;
import interfaces.Comparator;
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
	 * Try to append and element to the linked list
	 * @param item - element to append to linked list
	 * @return true if element was appended to linked list
	 * 		   false if element was not appended to linked list
	 */
	protected abstract boolean append(T item);
	
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
	@Override
	public int getSize()
	{
		return size;
	}
}