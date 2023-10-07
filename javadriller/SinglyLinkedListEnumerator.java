package javadriller;
import exceptions.EnumerationBeyondEndException;
import interfaces.Enumerator;

/**
 * A Singly Linked List enumerator that starts from the first element of the linked list
 * @author David
 * @param <T> Data type stored in the Linked list
 */
public class SinglyLinkedListEnumerator<T> implements Enumerator<T>
{	
	private Node<T> current;  // pointer to node the enumerator is currently looking at

	/**
	 * Creates a enumerator that starts from the first node in the linked list
	 * @param first
	 */
	public SinglyLinkedListEnumerator(Node<T> first)
	{
		// TODO method stub
	}
	
	/**
	 * if current is null, next doesn't exist
	 */
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * returns current value of the enumerator then moves to next value
	 * throws exception if there is no next
	 */
	@Override
	public T next() throws EnumerationBeyondEndException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * returns current value of the enumerator while peeking at next
	 * throws exception if there is no next
	 */
	@Override
	public T peek() throws EnumerationBeyondEndException {
		// TODO Auto-generated method stub
		return null;
	}
}