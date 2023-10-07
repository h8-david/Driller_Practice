package unittests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.InvalidDrillingRecordComparatorColumnException;
import interfaces.Comparator;
import javadriller.DrillingRecord;
import javadriller.DrillingRecordComparator;

class DrillingRecordComparatorTest {
	
	private DrillingRecord record1;
	private DrillingRecord record2;
	private Comparator<DrillingRecord> comparator;

	@BeforeEach
	void init()
	{
		record1 = new DrillingRecord();
		record2 = new DrillingRecord();
	}
	
	@Test
	void testCompareString()
	{
		comparator = new DrillingRecordComparator();
		record1.setString("00:00:01", 0);
		record2.setString("00:00:02", 0);
		assertEquals(-1, comparator.compare(record1, record2));
		assertEquals(0, comparator.compare(record1, record1));
		assertEquals(1, comparator.compare(record2, record1));
	}
	
	@Test
	void testCompareDouble()
	{
		comparator = new DrillingRecordComparator(2);
		record1.setNum(1.0, 0);
		record2.setNum(2.0, 0);
		assertEquals(-1, comparator.compare(record1, record2));
		assertEquals(0, comparator.compare(record1, record1));
		assertEquals(1, comparator.compare(record2, record1));
	}
	
	@Test
	void testInvalidColumn()
	{
		assertThrows(InvalidDrillingRecordComparatorColumnException.class,
				() -> comparator = new DrillingRecordComparator(18));
		assertThrows(InvalidDrillingRecordComparatorColumnException.class,
				() -> comparator = new DrillingRecordComparator(-1));
	}

}
