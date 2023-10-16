package interfaces;

/**
 * Interface that defines a generic Comparator
 * compares two objects
 * @author David
 *
 * @param <T> Object type to compare
 */
@FunctionalInterface
public interface Comparator<T>
{
	/**
	 * Compares two items of type T
	 * @param item1 - item to compare
	 * @param item2 - item to compare against
	 * @return 0 if the two items are equivalent,
	 * 		   1 or larger if item1 > item 2
	 * 		   -1 or less if item1 < item 2 
	 */
	 int compare(T item1, T item2);
}