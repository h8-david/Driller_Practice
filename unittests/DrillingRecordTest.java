package unittests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.DrillingRecordIndexOutOfRangeException;
import exceptions.IllegalIndexException;
import javadriller.DrillingRecord;

class DrillingRecordTest {
	
	private DrillingRecord record;

	@BeforeEach
	void init()
	{
		record = new DrillingRecord();
	}
	
	@Test
	void testAddAndGetNum()
	{
		for(int index = 0; index < 16; ++index)
		{
			record.addNum((double)index);
		}
		assertThrows(DrillingRecordIndexOutOfRangeException.class, () -> record.addNum(0.0));
		
		assertThrows(DrillingRecordIndexOutOfRangeException.class, () -> record.getNum(16));
		assertThrows(IllegalIndexException.class, () -> record.getNum(-1));
		assertEquals(7.0, record.getNum(7));
	}
	
	@Test
	void testAddAndGetString()
	{
		record.addString("string 0");
		record.addString("string 1");
		assertThrows(DrillingRecordIndexOutOfRangeException.class, () -> record.addString(""));
		
		assertThrows(DrillingRecordIndexOutOfRangeException.class, () -> record.getString(2));
		assertThrows(IllegalIndexException.class, () -> record.getString(-1));
		assertEquals("string 1", record.getString(1));
	}
	
	@Test
	void testSetNum()
	{
		record.setNum(100.0, 3);
		assertEquals(100.0, record.getNum(3));
		
		assertThrows(DrillingRecordIndexOutOfRangeException.class, () -> record.setNum(0.0, 16));
		assertThrows(IllegalIndexException.class, () -> record.setNum(0.0, -1));
	}
	
	@Test
	void testSetString()
	{
		record.setString("string 1", 1);
		assertEquals("string 1", record.getString(1));
		
		assertThrows(DrillingRecordIndexOutOfRangeException.class, () -> record.setString("", 2));
		assertThrows(IllegalIndexException.class, () -> record.setString("", -1));
	}
	
	@Test
	void testToString()
	{
		StringBuilder drillingRecordBuilder1 = new StringBuilder();
		drillingRecordBuilder1.append(" ");
		drillingRecordBuilder1.append(";");
		drillingRecordBuilder1.append(" ");
		for(int ctr = 0; ctr < 16; ++ctr)
		{
			drillingRecordBuilder1.append(";");
			drillingRecordBuilder1.append(0.0);
		}
		assertEquals(drillingRecordBuilder1.toString(), record.toString());
		//---------------------------------------------------------------------
		record.addString("string0");
		record.addString("string1");
		for(int index = 0; index < 16; ++index)
		{
			record.addNum((double)index);
		}
		StringBuilder drillingRecordBuilder2 = new StringBuilder();
		drillingRecordBuilder2.append("string0");
		drillingRecordBuilder2.append(";");
		drillingRecordBuilder2.append("string1");
		for(int ctr = 0; ctr < 16; ++ctr)
		{
			drillingRecordBuilder2.append(";");
			drillingRecordBuilder2.append((double)ctr);
		}
		assertEquals(drillingRecordBuilder2.toString(), record.toString());	
	}

}
