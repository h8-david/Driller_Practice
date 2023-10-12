package javadriller;

/**
 * Node Record that points to only 1 node, the next node
 * @author David
 * @param <T> the data type that a node stores data of
 */
public class Node<T>
{	
	public T data;              // stored data
	public Node<T> next = null; // pointer to the next node
	
	/**
	 * When creating a node, set the data and create next node
	 * @param data - data to be stored
	 */
	public Node(T data)
	{
		this.data = data;
	}
}