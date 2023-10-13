package unittests;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.LinkedListAccessException;
import exceptions.NullInsertionException;
import interfaces.Enumerator;
import javadriller.DrillingRecord;
import javadriller.DrillingRecordComparator;
import javadriller.SortedSinglyLinkedList;

class SortedSinglyLinkedListTest {

	private SortedSinglyLinkedList<DrillingRecord> linkedList;
	private Enumerator<DrillingRecord> enumerator;
	private DrillingRecord record1;
	private DrillingRecord record2;
	private DrillingRecord record3;
	private DrillingRecord record4;
	private DrillingRecord record5;
	
	@BeforeEach
	void init()
	{
		// makes empty linked list with drilling record comparator
		linkedList = new SortedSinglyLinkedList<>(new DrillingRecordComparator(1));
		// makes drilling records and gives them testing data
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
	void testInsert()
	{
		assertThrows(NullInsertionException.class, ()-> linkedList.insert(null)); // tests null insertion
		//-------------------------------------------------------------------------
		assertTrue(linkedList.insert(record4)); // tests very first insert
		assertEquals(1, linkedList.getSize());
		enumerator = linkedList.enumerator();  // makes an enumerator off this linked list
		
		// create an arraylist of the elements that the enumerator will spit out
		// arraylist are resizable arrays basically, so it will expand if necessary
		ArrayList<DrillingRecord> actualList = new ArrayList<>();
		while(enumerator.hasNext()) // doing this ensures we can capture everything in the enumerator
		{
			actualList.add(enumerator.next());
		}
		// compare the two arrays to see if they have the same amount of elements in the same order
		// Arrays.equals(expected, actual)
		assertTrue(Arrays.equals(new DrillingRecord[] {record4}, actualList.toArray(new DrillingRecord[actualList.size()])));
		assertEquals(record4, linkedList.getFirst());
		//-------------------------------------------------------------------------
		assertTrue(linkedList.insert(record1)); // tests new first insert
		assertEquals(2, linkedList.getSize());
		actualList.clear(); // reset the actualList array list
		enumerator = linkedList.enumerator(); // reset the enumerator to the new linkedlist
		while(enumerator.hasNext())
		{
			actualList.add(enumerator.next());
		}
		assertTrue(Arrays.equals(new DrillingRecord[] {record1, record4}, actualList.toArray(new DrillingRecord[actualList.size()])));
		assertEquals(record1, linkedList.getFirst());	
		//-------------------------------------------------------------------------
		assertTrue(linkedList.insert(record5)); // tests append
		assertEquals(3, linkedList.getSize());
		actualList.clear(); // reset the actualList array list
		enumerator = linkedList.enumerator(); // reset the enumerator to the new linkedlist
		while(enumerator.hasNext())
		{
			actualList.add(enumerator.next());
		}
		assertTrue(Arrays.equals(new DrillingRecord[] {record1, record4, record5}, actualList.toArray(new DrillingRecord[actualList.size()])));
		//-------------------------------------------------------------------------
		assertTrue(linkedList.insert(record2)); // tests inserting in middle
		assertEquals(4, linkedList.getSize());
		actualList.clear(); // reset the actualList array list
		enumerator = linkedList.enumerator(); // reset the enumerator to the new linkedlist
		while(enumerator.hasNext())
		{
			actualList.add(enumerator.next());
		}
		assertTrue(Arrays.equals(new DrillingRecord[] {record1, record2, record4, record5}, actualList.toArray(new DrillingRecord[actualList.size()])));
		//-------------------------------------------------------------------------
		DrillingRecord dupRecord = new DrillingRecord(); // make dup
		dupRecord.setString("00:00:02", 1);
		assertFalse(linkedList.insert(dupRecord)); // test duplicate insertion
		assertEquals(4, linkedList.getSize());
		actualList.clear(); // reset the actualList array list
		enumerator = linkedList.enumerator(); // reset the enumerator to the new linkedlist
		while(enumerator.hasNext())
		{
			actualList.add(enumerator.next());
		}
		assertTrue(Arrays.equals(new DrillingRecord[] {record1, record2, record4, record5}, actualList.toArray(new DrillingRecord[actualList.size()])));
		//-------------------------------------------------------------------------
		assertTrue(linkedList.insert(record3)); // add one more for other tests
		assertEquals(5, linkedList.getSize());
		actualList.clear(); // reset the actualList array list
		enumerator = linkedList.enumerator(); // reset the enumerator to the new linkedlist
		while(enumerator.hasNext())
		{
			actualList.add(enumerator.next());
		}
		assertTrue(Arrays.equals(new DrillingRecord[] {record1, record2, record3, record4, record5}, actualList.toArray(new DrillingRecord[actualList.size()])));
	}
	
	@Test
	void testInsertAll()
	{
		final ArrayList<DrillingRecord> nullDrillingRecords = null;
		assertThrows(NullInsertionException.class, () -> linkedList.insertAll(nullDrillingRecords)); // tests null collection insertion
		//-------------------------------------------------------------------------
		ArrayList<DrillingRecord> drillingRecords = new ArrayList<>(5); // add all 5 records into a collection
		drillingRecords.add(record4);
		drillingRecords.add(record1);
		drillingRecords.add(record5);
		drillingRecords.add(record2);
		drillingRecords.add(record3);
		assertTrue(linkedList.insertAll(drillingRecords)); // tests collection with all unique elements
		
		ArrayList<DrillingRecord> actualList = new ArrayList<>(); // make an arraylist to store values from enumerator
		enumerator = linkedList.enumerator(); // make enumerator on this linkedlist
		while(enumerator.hasNext())
		{
			actualList.add(enumerator.next());
		}
		assertTrue(Arrays.equals(new DrillingRecord[] {record1, record2, record3, record4, record5}, actualList.toArray(new DrillingRecord[actualList.size()])));
		//-------------------------------------------------------------------------
		linkedList.clear(); // reset the linkedlist
		drillingRecords.clear(); // reset the arraylist
		drillingRecords.add(record5); // repopulate the arraylist
		drillingRecords.add(record5);
		assertFalse(linkedList.insertAll(drillingRecords)); // tests collection with non unique elements
		
		actualList.clear(); // reset the actual list arraylist
		enumerator = linkedList.enumerator(); // make enumerator on this linkedlist
		while(enumerator.hasNext())
		{
			actualList.add(enumerator.next());
		}
		assertTrue(Arrays.equals(new DrillingRecord[] {record5}, actualList.toArray(new DrillingRecord[actualList.size()])));
		//-------------------------------------------------------------------------
		linkedList.clear(); // reset the linkedlist
		drillingRecords.clear(); // reset the arraylist
		drillingRecords.add(null); // add a null value into the arraylist
		// try to add a null value into the linkedlist through a collection
		assertThrows(NullInsertionException.class, () -> linkedList.insertAll(drillingRecords));
	}
	
	@Test
	void testRemove()
	{
		assertThrows(LinkedListAccessException.class, () -> linkedList.remove(new DrillingRecord())); // try to remove when first is null
		//-------------------------------------------------------------------------
		testInsert(); // adds elements to the list
		assertThrows(LinkedListAccessException.class, () -> linkedList.remove(null)); // try to remove a null value
		//-------------------------------------------------------------------------
		assertFalse(linkedList.remove(new DrillingRecord())); // try to remove a non-existent element
		//-------------------------------------------------------------------------
		assertTrue(linkedList.remove(record1)); // removes first element
		assertEquals(4, linkedList.getSize());
		
		enumerator = linkedList.enumerator(); // make an enumerator of this linkedlist
		ArrayList<DrillingRecord> actualList = new ArrayList<>(); // make an arraylist to store values from enumerator
		while(enumerator.hasNext()) // doing this ensures we can capture everything in the enumerator
		{
			actualList.add(enumerator.next());
		}
		assertTrue(Arrays.equals(new DrillingRecord[] {record2, record3, record4, record5}, actualList.toArray(new DrillingRecord[actualList.size()])));
		assertEquals(record2, linkedList.getFirst());
		//-------------------------------------------------------------------------
		assertTrue(linkedList.remove(record5)); // removes last element
		assertEquals(3, linkedList.getSize());
		
		actualList.clear(); // reset the actualList array list
		enumerator = linkedList.enumerator(); // reset the enumerator to the new linkedlist
		while(enumerator.hasNext())
		{
			actualList.add(enumerator.next());
		}
		assertTrue(Arrays.equals(new DrillingRecord[] {record2, record3, record4}, actualList.toArray(new DrillingRecord[actualList.size()])));
		//-------------------------------------------------------------------------
		assertTrue(linkedList.remove(record3)); // removes middle element
		assertEquals(2, linkedList.getSize());
		
		actualList.clear(); // reset the actualList array list
		enumerator = linkedList.enumerator(); // reset the enumerator to the new linkedlist
		while(enumerator.hasNext())
		{
			actualList.add(enumerator.next());
		}
		assertTrue(Arrays.equals(new DrillingRecord[] {record2, record4}, actualList.toArray(new DrillingRecord[actualList.size()])));
	}
	
	@Test
	void testPullFirst()
	{
		assertThrows(LinkedListAccessException.class, () -> linkedList.pullFirst()); // tries pull first when first is null
		testInsert(); // adds elements to the list
		assertEquals(linkedList.getFirst(), linkedList.pullFirst()); // checks if first and pull first return same data
		assertEquals(4, linkedList.getSize());
		
		enumerator = linkedList.enumerator(); // make an enumerator of this linkedlist
		ArrayList<DrillingRecord> actualList = new ArrayList<>(); // make an arraylist to store values from enumerator
		while(enumerator.hasNext()) // doing this ensures we can capture everything in the enumerator
		{
			actualList.add(enumerator.next());
		}
		assertTrue(Arrays.equals(new DrillingRecord[] {record2, record3, record4, record5}, actualList.toArray(new DrillingRecord[actualList.size()])));
	}
	
	@Test
	void testClear()
	{
		testInsert(); // adds elements to the list
		linkedList.clear(); // removes all elements from the list
		assertEquals(0, linkedList.getSize());
		
		enumerator = linkedList.enumerator(); // make an enumerator of this linkedlist
		ArrayList<DrillingRecord> actualList = new ArrayList<>(); // make an arraylist to store values from enumerator
		while(enumerator.hasNext()) // doing this ensures we can capture everything in the enumerator
		{
			actualList.add(enumerator.next());
		}
		assertTrue(Arrays.equals(new DrillingRecord[] {}, actualList.toArray(new DrillingRecord[actualList.size()])));
	}
	
	@Test
	void testReplace()
	{
		assertThrows(LinkedListAccessException.class, () -> linkedList.replace(new DrillingRecord())); // try to replace when list is empty
		//-------------------------------------------------------------------------
		testInsert(); // adds elements to the linkedlist
		assertThrows(NullInsertionException.class, () -> linkedList.replace(null)); // try to replace with a null item
		//-------------------------------------------------------------------------
		DrillingRecord replace1 = new DrillingRecord(); // make a drillingrecord for replacing
		replace1.setString("00:00:01", 1);
		replace1.setString("replace1", 0);
	
		assertTrue(linkedList.replace(replace1)); // replace the first element of the linkedlist
		assertEquals("replace1", linkedList.getFirst().getString(0));
		assertEquals("00:00:01", linkedList.getFirst().getString(1));
		//-------------------------------------------------------------------------
		DrillingRecord replace2 = new DrillingRecord(); // make another drillingrecord for replacing
		replace2.setString("00:00:03", 1);
		replace2.setString("replace2", 0);
		
		assertTrue(linkedList.replace(replace2)); // replace the middle element of the linkedlist
		enumerator = linkedList.enumerator(); // make an enumerator of this linkedlist
		DrillingRecord middleRecord;
		middleRecord = enumerator.next(); // move enumerator to middle element
		middleRecord = enumerator.next();
		middleRecord = enumerator.next();
		assertEquals("replace2", middleRecord.getString(0));
		assertEquals("00:00:03", middleRecord.getString(1));
		//-------------------------------------------------------------------------
		DrillingRecord replace3 = new DrillingRecord(); // make a third drillingrecord for replacing
		replace3.setString("00:00:05", 1);
		replace3.setString("replace3", 0);
		
		assertTrue(linkedList.replace(replace3)); // replace the last element of the linkedlist
		enumerator = linkedList.enumerator(); // make an enumerator of this linkedlist
		DrillingRecord lastRecord;
		lastRecord = enumerator.next(); // move enumerator to last element
		lastRecord = enumerator.next();
		lastRecord = enumerator.next();
		lastRecord = enumerator.next();
		lastRecord = enumerator.next();
		assertEquals("replace3", lastRecord.getString(0));
		assertEquals("00:00:05", lastRecord.getString(1));
		//--------------------------------------------------------------------------
		assertFalse(linkedList.replace(new DrillingRecord())); // test replacing item not in the list
	}
	
	@Test
	void testContains()
	{
		assertThrows(LinkedListAccessException.class, ()-> linkedList.contains(new DrillingRecord())); // tries contains on empty list
		testInsert(); // adds elements to the linkedlist
		assertThrows(LinkedListAccessException.class, () -> linkedList.contains(null)); // tries contains with null data
		assertTrue(linkedList.contains(record1));
		assertTrue(linkedList.contains(record3));
		assertTrue(linkedList.contains(record5));
		assertFalse(linkedList.contains(new DrillingRecord()));	// tries contains with data not in the list
	}
	
	@Test
	void testFind()
	{
		assertThrows(LinkedListAccessException.class, () -> linkedList.find(new DrillingRecord())); // tries find on empty list
		testInsert(); // adds elements to the linkedlist
		assertThrows(LinkedListAccessException.class, ()-> linkedList.find(null)); // tries find with null data
		assertEquals(record1, linkedList.find(record1));
		assertEquals(record3, linkedList.find(record3));
		assertEquals(record5, linkedList.find(record5));
		assertThrows(LinkedListAccessException.class, () -> linkedList.find(new DrillingRecord())); // tries contains with data not in the list
	}
}