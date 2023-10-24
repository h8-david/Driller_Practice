package unittests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import interfaces.Comparator;
import javadriller.DrillingRecord;
import javadriller.DrillingRecordComparator;
import javadriller.ResizableArray;
import javadriller.Search;
import javadriller.Sorter;

class SearchTest
{
	private ResizableArray<DrillingRecord> array;
	private Comparator<DrillingRecord> comparator;
	private DrillingRecord record0;
	private DrillingRecord record1;
	private DrillingRecord record2;
	private DrillingRecord record3;
	private DrillingRecord record4;
	private DrillingRecord record5;
	private DrillingRecord record6;
	private DrillingRecord record7;
	private DrillingRecord record8;
	private DrillingRecord record9;
	
	@BeforeEach
	void fillArray()
	{
		// make records
		record0 = new DrillingRecord(); record0.setString("00:00:00", 1);
		record1 = new DrillingRecord(); record1.setString("00:00:01", 1);
		record2 = new DrillingRecord(); record2.setString("00:00:02", 1);
		record3 = new DrillingRecord(); record3.setString("00:00:03", 1);
		record4 = new DrillingRecord(); record4.setString("00:00:04", 1);
		record5 = new DrillingRecord(); record5.setString("00:00:05", 1);
		record6 = new DrillingRecord(); record6.setString("00:00:06", 1);
		record7 = new DrillingRecord(); record7.setString("00:00:07", 1);
		record8 = new DrillingRecord(); record8.setString("00:00:08", 1);
		record9 = new DrillingRecord(); record9.setString("00:00:09", 1);
		
		// make array and comparator
		array = new ResizableArray<>();
		comparator = new DrillingRecordComparator(1);
		
		// add records to array
		array.add(record6);
		array.add(record9);
		array.add(record2);
		array.add(record5);
		array.add(record7);
		array.add(record8);
		array.add(record1);
		array.add(record4);
		array.add(record3);
		array.add(record0);
	}

	//@Test
	void testBinarySearch_Unsorted()
	{
		assertSame(-1, Search.binarySearch(record9, array, comparator));
		assertSame(-1, Search.binarySearch(record0, array, comparator));
		assertSame(-1, Search.binarySearch(record6, array, comparator));
		assertSame(-1, Search.binarySearch(record8, array, comparator));
	}
	
	@Test
	void testBinarySearch_Sorted()
	{
		Sorter.sort(array, comparator);
		assertSame(9, Search.binarySearch(record9, array, comparator));
		assertSame(0, Search.binarySearch(record0, array, comparator));
		assertSame(3, Search.binarySearch(record3, array, comparator));
		assertSame(6, Search.binarySearch(record6, array, comparator));
	}
}
