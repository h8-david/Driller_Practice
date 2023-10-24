package javadriller;

import interfaces.Comparator;

/**
 * Defines a comparator of integers
 * @author David
 */
public class IntegerComparator implements Comparator<Integer>
{
	/**
	 * see {@code Comparator}
	 */
	@Override
	public int compare(Integer item1, Integer item2)
	{
		return item1 < item2 ? -1 : item1 == item2 ? 0 : 1;
	}
}
