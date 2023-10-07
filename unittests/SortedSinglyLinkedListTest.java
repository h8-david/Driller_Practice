package unittests;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
		linkedList = new SortedSinglyLinkedList<>(new DrillingRecordComparator(1));
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
		assertFalse(linkedList.insert(null));
		//-------------------------------------------------------------------------
		assertTrue(linkedList.insert(record4)); // test first insert
		assertEquals("00:00:04", linkedList.getFirst().getString(1));
		assertEquals(1L, linkedList.getSize());
		//-------------------------------------------------------------------------
		assertTrue(linkedList.insert(record1)); // test new first insert
		assertEquals("00:00:01", linkedList.getFirst().getString(1));
		assertEquals(2L, linkedList.getSize());
		//-------------------------------------------------------------------------
		assertTrue(linkedList.insert(record5)); // test append
		assertEquals(3L, linkedList.getSize());
		//-------------------------------------------------------------------------
		assertTrue(linkedList.insert(record2)); // test insert in middle
		assertEquals(4L, linkedList.getSize());
		//-------------------------------------------------------------------------
		DrillingRecord dupRecord = new DrillingRecord(); // make dup
		dupRecord.setString("00:00:02", 1);
		assertFalse(linkedList.insert(dupRecord)); // test duplicate insertion
		assertEquals(4L, linkedList.getSize());
		//-------------------------------------------------------------------------
		assertTrue(linkedList.insert(record3)); // add one more for other tests
		assertEquals(5L, linkedList.getSize());
	}
	
	@Test
	void testInsertAll()
	{
		ArrayList<DrillingRecord> drillingRecords = null;
		assertFalse(linkedList.insertAll(drillingRecords)); // test null collection
		//-------------------------------------------------------------------------
		drillingRecords = new ArrayList<>(5);
		drillingRecords.add(record4);
		drillingRecords.add(record1);
		drillingRecords.add(record5);
		drillingRecords.add(record2);
		drillingRecords.add(record3);
		assertTrue(linkedList.insertAll(drillingRecords)); // test collection with all unique elements
		//-------------------------------------------------------------------------
		linkedList.clear();
		drillingRecords.clear();
		drillingRecords.add(record5);
		drillingRecords.add(record5);
		assertFalse(linkedList.insertAll(drillingRecords)); // test collection with non unique elements
	}
	
	@Test
	void testRemove()
	{
		assertFalse(linkedList.remove(new DrillingRecord())); // remove when first is null
		//-------------------------------------------------------------------------
		testInsert();
		assertFalse(linkedList.remove(null)); // remove null 
		//-------------------------------------------------------------------------
		assertFalse(linkedList.remove(new DrillingRecord())); // remove non-existent element
		//-------------------------------------------------------------------------
		assertTrue(linkedList.remove(record1)); // remove first element
		assertEquals(4L, linkedList.getSize());
		enumerator = linkedList.enumerator();
		String[] expectedList = new String[] {"00:00:02", "00:00:03", "00:00:04", "00:00:05"};
		String[] actualList = new String[(int)linkedList.getSize()];
		assertEquals(expectedList.length, actualList.length);
		int index = 0;
		while(enumerator.hasNext())
		{
			actualList[index] = enumerator.next().getString(1);
			++index;
		}
		assertTrue(Arrays.equals(expectedList, actualList));
		//-------------------------------------------------------------------------
		assertTrue(linkedList.remove(record5)); // remove last element
		assertEquals(3L, linkedList.getSize());
		enumerator = linkedList.enumerator();
		expectedList = new String[] {"00:00:02", "00:00:03", "00:00:04"};
		actualList = new String[(int)linkedList.getSize()];
		assertEquals(expectedList.length, actualList.length);
		index = 0;
		while(enumerator.hasNext())
		{
			actualList[index] = enumerator.next().getString(1);
			++index;
		}
		assertTrue(Arrays.equals(expectedList, actualList));
		//-------------------------------------------------------------------------
		assertTrue(linkedList.remove(record3)); // remove middle element
		assertEquals(2L, linkedList.getSize());
		enumerator = linkedList.enumerator();
		expectedList = new String[] {"00:00:02", "00:00:04"};
		actualList = new String[(int)linkedList.getSize()];
		assertEquals(expectedList.length, actualList.length);
		index = 0;
		while(enumerator.hasNext())
		{
			actualList[index] = enumerator.next().getString(1);
			++index;
		}
		assertTrue(Arrays.equals(expectedList, actualList));
	}
	
	@Test
	void testPullFirst()
	{
		assertEquals(null, linkedList.pullFirst());
		testInsert();
		//-------------------------------------------------------------------------
		assertEquals(linkedList.getFirst().getString(1), linkedList.pullFirst().getString(1));
		//-------------------------------------------------------------------------
		assertEquals(4L, linkedList.getSize());
		//-------------------------------------------------------------------------
		assertEquals("00:00:02", linkedList.getFirst().getString(1));
	}
	
	@Test
	void testClear()
	{
		testInsert();
		linkedList.clear();
		assertEquals(0L, linkedList.getSize());
		assertEquals(null, linkedList.getFirst());
	}
	
	@Test
	void testReplace()
	{
		assertFalse(linkedList.replace(null));
		//-------------------------------------------------------------------------
		assertFalse(linkedList.replace(new DrillingRecord()));
		//-------------------------------------------------------------------------
		testInsert();
		DrillingRecord replace1 = new DrillingRecord();
		replace1.setString("00:00:01", 1);
		replace1.setString("replace1", 0);
		//-------------------------------------------------------------------------
		assertTrue(linkedList.replace(replace1));
		assertEquals("replace1", linkedList.getFirst().getString(0));
		assertEquals("00:00:01", linkedList.getFirst().getString(1));
		//-------------------------------------------------------------------------
		DrillingRecord replace2 = new DrillingRecord();
		replace2.setString("00:00:03", 1);
		replace2.setString("replace2", 0);
		assertTrue(linkedList.replace(replace2));
		//-------------------------------------------------------------------------
		DrillingRecord replace3 = new DrillingRecord();
		replace3.setString("00:00:05", 1);
		replace3.setString("replace3", 0);
		assertTrue(linkedList.replace(replace3));
		//--------------------------------------------------------------------------
		assertFalse(linkedList.replace(new DrillingRecord()));
	}
	
	@Test
	void testContains()
	{
		assertFalse(linkedList.contains(new DrillingRecord()));
		testInsert();
		assertFalse(linkedList.contains(null));
		assertTrue(linkedList.contains(record1));
		assertTrue(linkedList.contains(record3));
		assertTrue(linkedList.contains(record5));
		assertFalse(linkedList.contains(new DrillingRecord()));	
	}
	
	@Test
	void testFind()
	{
		assertEquals(null, linkedList.find(new DrillingRecord()));
		testInsert();
		assertEquals(null, linkedList.find(null));
		assertEquals(record1, linkedList.find(record1));
		assertEquals(record3, linkedList.find(record3));
		assertEquals(record5, linkedList.find(record5));
		assertEquals(null, linkedList.find(new DrillingRecord()));	
	}
}