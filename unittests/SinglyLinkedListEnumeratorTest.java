package unittests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.EnumerationBeyondEndException;
import interfaces.Enumerator;
import javadriller.DrillingRecord;
import javadriller.DrillingRecordComparator;
import javadriller.SortedSinglyLinkedList;

class SinglyLinkedListEnumeratorTest {
	
	private SortedSinglyLinkedList<DrillingRecord> linkedList;
	private Enumerator<DrillingRecord> enumerator;
	private DrillingRecord record;

	@BeforeEach
	void init()
	{
		linkedList = new SortedSinglyLinkedList<>(new DrillingRecordComparator());
		record = new DrillingRecord();
		linkedList.insert(record);
		enumerator = linkedList.enumerator();
	}
	
	@Test
	void testNext()
	{
		assertSame(record, enumerator.next());
		assertThrows(EnumerationBeyondEndException.class, () -> enumerator.next());
	}
	
	@Test
	void testPeek()
	{
		assertSame(record, enumerator.peek());
		enumerator.next();
		assertThrows(EnumerationBeyondEndException.class, () -> enumerator.peek());
	}
	
	@Test
	void testHasNext()
	{
		assertTrue(enumerator.hasNext());
		enumerator.next();
		assertFalse(enumerator.hasNext());
	}
	
}
