package javadriller;

/**
 * Node Record that points to only 1 node, the next node
 * @author David
 * @param <T> the data type that a node stores data of
 */
public class Node<T>
{	
	private T data;       // stored data
	private Node<T> next; // pointer to the next node
	
	/**
	 * When creating a node, set the data and create next node
	 * @param data - data to be stored
	 */
	public Node(T data)
	{
		setData(data);
		next = null;
	}
	
	/**
	 * Get the data
	 * @return the data in the node
	 */
	public T getData()
	{
		return data;
	}
	
	/**
	 * Get the next node
	 * @return the next node
	 */
	public Node<T> getNext()
	{
		return next;
	}
	
	/**
	 * set the next node
	 * @param next - node to point to
	 */
	public void setNext(Node<T> next)
	{
		this.next = next;
	}
	
	/**
	 * set the data stored in this node
	 * @param data - data to be stored
	 */
	public void setData(T data)
	{
		this.data = data;
	}
}
