package javadriller;

import exceptions.DrillingRecordIndexOutOfRangeException;
import exceptions.IllegalIndexException;

/**
 * Drilling Record defines a record of data that contains 2 strings and 16 numbers
 * for the purposes of testing this, the data that goes into each record
 * don't actually mean anything special
 * 
 * In the actual implementation of this the first string was a date (drilling date)
 * The second was a time stamp (drilling time)
 * All the doubles in the nums array are drilling data
 * 
 * When referring to a drilling record the string and double arrays are considered combined
 * so when trying to compare DrillingRecord[0] or DrillingRecord[1], it refers to the 
 * string array, while 2 - 17 refers to the double array
 * see {@code DrillingRecordComparator}
 * @author David
 */
public class DrillingRecord
{
	private final int MAX_NUMS = 16;					 // the maximum numeric fields in each record
	private final int MAX_STRINGS = 2;					 // the maximum string fields in each record
	private final double[] nums = new double[MAX_NUMS];  // holds the numeric data, in column order
	private int numCtr = 0;								 // counts the number of numbers added to the record
	private String strings[] = new String[MAX_STRINGS];  // holds the string data, in column order
	private int strCtr = 0;								 // count the number of strings added to the record
	
	/**
	 * initializes all nums to 0.0 and all strings to " "
	 */
	public DrillingRecord()
	{
		for(int index = 0; index < MAX_NUMS; ++index)
		{
			nums[index] = 0.0;
		}
		strings[0] = strings[1] = "";
	}

	/**
	 * puts num in array, increments the number counter
	 * this function throws an exception if trying to add more elements than MAX_NUMS
	 * @param num - value to be added
	 * @throws DrillingRecordIndexOutOfRangeException
	 */
	public void addNum(double num) throws DrillingRecordIndexOutOfRangeException
	{
		if(numCtr == MAX_NUMS)
		{
			throw new DrillingRecordIndexOutOfRangeException(
					String.format("Cannot add more than %d nums to a drilling record", MAX_NUMS));
		}
		nums[numCtr] = num;
		++numCtr;
	}		
	
	/**
	 * puts string in array, increments counter
	 * this function throws an exception if trying to add more elements than MAX_STRINGS
	 * @param string - string to be added
	 * @throws DrillingRecordIndexOutOfRangeException
	 */
	public void addString(String string) throws DrillingRecordIndexOutOfRangeException
	{
		if(strCtr == MAX_STRINGS)
		{
			throw new DrillingRecordIndexOutOfRangeException(
					String.format("Cannot add more than %d nums to a drilling record", MAX_STRINGS));
		}
		strings[strCtr] = string;
		++strCtr;
	}

	/**
	 * returns (copy of) num at index in num array
	 * this function throws an exception if trying to access an invalid index
	 * @param index - index to get num from
	 * @return the num at the index given
	 * @throws DrillingRecordIndexOutOfRangeException
	 * @throws IllegalIndexException
	 */
	public double getNum(int index) throws DrillingRecordIndexOutOfRangeException, IllegalIndexException
	{
		if(index >= MAX_NUMS)
		{
			throw new DrillingRecordIndexOutOfRangeException(
					String.format("A drilling record contains %d nums, index cannot exceed %d", MAX_NUMS, MAX_NUMS - 1));
		}
		
		if(index < 0)
		{
			throw new IllegalIndexException("Index must be positve");
		}
		return nums[index];
	}
	
	/**
	 * returns (copy of) string at index in string array
	 * this function throws an exception if trying to access an invalid index
	 * @param index - index to get string from
	 * @return the string at the index given
	 * @throws DrillingRecordIndexOutOfRangeException
	 * @throws IllegalIndexException
	 */
	public String getString(int index) throws DrillingRecordIndexOutOfRangeException, IllegalIndexException
	{
		if(index >= MAX_STRINGS)
		{
			throw new DrillingRecordIndexOutOfRangeException(
					String.format("A drilling record contains %d strings, index cannot exceed %d", MAX_STRINGS, MAX_STRINGS - 1));
		}
		
		if(index < 0)
		{
			throw new IllegalIndexException("Index must be positve");
		}
		return strings[index];
	}
	
	/**
	 * sets nums[index] to num, doesn't change counter
	 * this function throws an exception if trying to access an invalid index
	 * @param num - value to be added
	 * @param index - location to set num
	 * @throws DrillingRecordIndexOutOfRangeException
	 * @throws IllegalIndexException
	 */
	public void setNum(double num, int index) throws DrillingRecordIndexOutOfRangeException, IllegalIndexException
	{
		if(index >= MAX_NUMS)
		{
			throw new DrillingRecordIndexOutOfRangeException(
					String.format("A drilling record contains %d nums, index cannot exceed %d", MAX_NUMS, MAX_NUMS - 1));
		}
		
		if(index < 0)
		{
			throw new IllegalIndexException("Index must be positve");
		}
		nums[index] = num;
	}
	
	/**
	 * sets strings[index] to string, doesn't change counter
	 * this function throws an exception if trying to access an invalid index
	 * @param string - string to be added
	 * @param index - location to set string
	 * @throws DrillingRecordIndexOutOfRangeException
	 * @throws IllegalIndexException
	 */
	public void setString(String string, int index) throws DrillingRecordIndexOutOfRangeException, IllegalIndexException
	{
		if(index >= MAX_STRINGS)
		{
			throw new DrillingRecordIndexOutOfRangeException(
					String.format("A drilling record contains %d strings, index cannot exceed %d", MAX_STRINGS, MAX_STRINGS - 1));
		}
		
		if(index < 0)
		{
			throw new IllegalIndexException("Index must be positve");
		}
		strings[index] = string;
	}
	
	/**
	 * Overrides the toString method of Object to display a drilling record in order
	 * strings then nums separated by ;
	 */
	@Override
	public String toString()
	{
		StringBuilder drillingRecord = new StringBuilder();
		drillingRecord.append(strings[0]);
		drillingRecord.append(";");
		drillingRecord.append(strings[1]);
		for(int ctr = 0; ctr < MAX_NUMS; ++ctr)
		{
			drillingRecord.append(";");
			drillingRecord.append(nums[ctr]);
		}
		return drillingRecord.toString();
	}
}
