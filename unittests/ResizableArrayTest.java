package unittests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.IllegalIndexException;
import javadriller.DrillingRecord;
import javadriller.ResizableArray;

class ResizableArrayTest {
	
	private ResizableArray<DrillingRecord> array;
	private ResizableArray<DrillingRecord> array2;
	private DrillingRecord record1;
	private DrillingRecord record2;
	private DrillingRecord record3;
	private DrillingRecord record4;
	private DrillingRecord record5;
	
	@BeforeEach
	void init()
	{
		// makes array
		array = new ResizableArray<>(5);
		// makes array with default constructor
		array2 = new ResizableArray<>();
		// makes all records
		record1 = new DrillingRecord();
		record1.setString("00:00:01", 1);
		record2 = new DrillingRecord();
		record2.setString("00:00:02", 1);
		record3 = new DrillingRecord();
		record3.setString("00:00:03", 1);
		record4 = new DrillingRecord();
		record4.setString("00:00:04", 1);
		record5 = new DrillingRecord();
		record5.setString("00:00:05", 1);
	}
	
	@Test
	void testConstructors() 
	{
		assertEquals(5, array.getCapacity()); // tests array with given size in constructor
		assertEquals(0, array.getSize());
		// -----------------------------------------------------------------//
		assertEquals(10, array2.getCapacity());  // tests default constructor
		assertEquals(0, array2.getSize());
	}
	
	@Test
	void testClear()
	{
		testAddandAddAt(); // adds elements to the list
		array.clear(); // clears everything out of list
		assertEquals(0, array.getSize());
		assertEquals(10, array.getCapacity()); // always resets to default capacity
	}
	
	@Test
	void testAddandAddAt()
	{
		array.add(record1); // tests adding one element to array
		assertEquals(1, array.getSize());
		assertEquals(record1, array.get(0));
		// --------------------------------------------------------//
		array.add(record3); // tests adding another element to the array
		assertEquals(2, array.getSize());
		DrillingRecord[] records = new DrillingRecord[] {record1, record3};
		for(int index = 0; index < array.getSize(); index++) // loops to verify order
		{
			assertEquals(records[index], array.get(index));
		}
		// --------------------------------------------------------//
		array.addAt(record2, 2); // tests that addAt works only when adding at size of array
		assertEquals(3, array.getSize());
		records = new DrillingRecord[] {record1, record3, record2};
		for(int index = 0; index < array.getSize(); index++)
		{
			assertEquals(records[index], array.get(index));
		}
		// --------------------------------------------------------//
		array.addAt(record5, 0); // tests shifting when using addAt
		assertEquals(4, array.getSize());
		records = new DrillingRecord[] {record5, record1, record3, record2};
		for(int index = 0; index < array.getSize(); index++)
		{
			assertEquals(records[index], array.get(index));
		}
		// --------------------------------------------------------//
		array.addAt(record4, 3); // tests shifting when using addAt
		assertEquals(5, array.getSize());
		records = new DrillingRecord[] {record5, record1, record3, record4, record2};
		for(int index = 0; index < array.getSize(); index++)
		{
			assertEquals(records[index], array.get(index));
		}
		assertEquals(5, array.getCapacity());
	}
	
	@Test
	void testAddAtExceptions()
	{
		// negative index
		assertThrows(IllegalIndexException.class,
				() -> array.addAt(new DrillingRecord(), -1));
		// trying to add at index greater than size
		assertThrows(IllegalIndexException.class,
				() -> array.addAt(new DrillingRecord(), 1));
	}
	@Test
	void testRemoveAtExceptions()
	{
		array.add(record1);
		// negative index
		assertThrows(IllegalIndexException.class,
				() -> array.removeAt(-1));
		// trying to remove at index greater than size
		assertThrows(IllegalIndexException.class,
				() -> array.removeAt(1));
	}
	
	@Test
	void testdoubleCapacityAdd()
	{
		testAddandAddAt(); // adds elements to array
		DrillingRecord record6 = new DrillingRecord();
		// try to add record such that size will be greater than capacity triggering double capacity
		array.add(record6);
		assertEquals(6, array.getSize());
		assertEquals(10, array.getCapacity()); // capacity doubled
		DrillingRecord[] records = new DrillingRecord[] {record5, record1, record3, record4, record2, record6};
		for(int index = 0; index < array.getSize(); index++)
		{
			assertEquals(records[index], array.get(index));
		}
	}
	
	@Test
	void testdoubleCapacityAddAt()
	{
		testAddandAddAt(); // adds elements to array
		DrillingRecord record6 = new DrillingRecord();
		// try to add record such that size will be greater than capacity triggering double capacity at the valid index
		array.addAt(record6, 1);
		assertEquals(6, array.getSize());
		assertEquals(10, array.getCapacity()); // capacity doubled
		DrillingRecord[] records = new DrillingRecord[] {record5, record6, record1, record3, record4, record2};
		for(int index = 0; index < array.getSize(); index++)
		{
			assertEquals(records[index], array.get(index));
		}
	}
	
	@Test
	void testGet()
	{
		// negative index
		assertThrows(IllegalIndexException.class,
				() -> array.get(-1));
		// getting from empty array
		assertThrows(IllegalIndexException.class,
				() -> array.get(0));
		array.add(record1);
		// getting from unaccessible index
		assertThrows(IllegalIndexException.class,
				() -> array.get(1));
		assertSame(record1, array.get(0));
	}
	
	@Test
	void testRemoveAtAndhalveCapacity()
	{
		// add 10 records
		array2.add(record1);
		array2.add(record2);
		array2.add(record3);
		array2.add(record4);
		array2.add(record5);
		array2.add(record5);
		array2.add(record4);
		array2.add(record3);
		array2.add(record2);
		array2.add(record1);
		assertEquals(10, array2.getSize());
		assertEquals(10, array2.getCapacity());
		//-----------------------------------------------//
		array2.removeAt(0); // remove first index
		assertEquals(9, array2.getSize());
		assertEquals(10, array2.getCapacity());
		DrillingRecord[] records = new DrillingRecord[] {record2, record3, record4, record5, record5, record4, record3, record2, record1};
		for(int index = 0; index < array2.getSize(); index++)
		{
			assertEquals(records[index], array2.get(index));
		}
		//-----------------------------------------------//
		array2.removeAt(4); // remove some index in the middle
		assertEquals(8, array2.getSize());
		assertEquals(10, array2.getCapacity());
		records = new DrillingRecord[] {record2, record3, record4, record5, record4, record3, record2, record1};
		for(int index = 0; index < array2.getSize(); index++)
		{
			assertEquals(records[index], array2.get(index));
		}
		//-----------------------------------------------//
		array2.removeAt(7); // remove last index
		assertEquals(7, array2.getSize());
		assertEquals(10, array2.getCapacity());
		records = new DrillingRecord[] {record2, record3, record4, record5, record4, record3, record2};
		for(int index = 0; index < array2.getSize(); index++)
		{
			assertEquals(records[index], array2.get(index));
		}
		//-----------------------------------------------//
		array2.removeAt(2); // remove some index in the middle
		assertEquals(6, array2.getSize());
		assertEquals(10, array2.getCapacity());
		records = new DrillingRecord[] {record2, record3, record5, record4, record3, record2};
		for(int index = 0; index < array2.getSize(); index++)
		{
			assertEquals(records[index], array2.get(index));
		}
		//-----------------------------------------------//
		array2.removeAt(3); // remove some index in the middle
		assertEquals(5, array2.getSize());
		assertEquals(5, array2.getCapacity());
		records = new DrillingRecord[] {record2, record3, record5, record3, record2};
		for(int index = 0; index < array2.getSize(); index++)
		{
			assertEquals(records[index], array2.get(index));
		}
	}
	
	@Test
	void testReplaceAt()
	{
		DrillingRecord replace = new DrillingRecord();
		// negative index
		assertThrows(IllegalIndexException.class,
				() -> array.replaceAt(replace, -1));
		// replace from empty array
		assertThrows(IllegalIndexException.class,
				() -> array.replaceAt(replace, 0));
		array.add(record1);
		// replacing from unaccessible index
		assertThrows(IllegalIndexException.class,
				() -> array.replaceAt(replace, 1));
		array.replaceAt(replace, 0); // do a valid replace call
		assertSame(replace, array.get(0));
	}
}
