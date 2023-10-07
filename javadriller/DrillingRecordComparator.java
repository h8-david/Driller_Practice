package javadriller;

import exceptions.InvalidDrillingRecordComparatorColumnException;
import interfaces.Comparator;

/**
 * Comparator for drilling records
 * see (@code DrillingRecord}
 * Equivalence is defined by the column be compared against
 * @author David
 */
public class DrillingRecordComparator implements Comparator<DrillingRecord>
{	
	private int column = 0;  // the column to compare
	
	/**
	 * Default constructor defines a comparator based off of
	 * drilling records first string (strings[0])
	 */
	public DrillingRecordComparator() {}
	
	/**
	 * Set the column to compare off of
	 * @param column - index to compare off of
	 * @throws InvalidDrillingRecordComparatorColumnException 
	 */
	public DrillingRecordComparator(int column) throws InvalidDrillingRecordComparatorColumnException
	{
		if(column < 0 || column > 17)
		{
			throw new InvalidDrillingRecordComparatorColumnException();
		}
		this.column = column;
	}
	
	/**
	 * when column is < 2, compares the strings of the drilling record
	 * when column is >= 2, compares the nums of the drilling record
	 * 		note since the strings and nums arrays are seperate,
	 * 		must shift the column to offset this
	 */
	@Override
	public int compare(DrillingRecord item1, DrillingRecord item2)
	{
		try
		{
			if(column < 2)
			{
				return item1.getString(column).compareTo(item2.getString(column));
			}
			else
			{
				return item1.getNum(column - 2) < item2.getNum(column - 2) ? -1 
					   : item1.getNum(column - 2) == item2.getNum(column - 2) ? 0 
					   : 1;
			}
		}
		catch(Exception e) // this case is impossible
		{ return 0; }
	}

}
