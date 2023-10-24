package unittests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import javadriller.DrillingRecord;
import javadriller.DrillingRecordComparator;
import javadriller.IntegerComparator;
import javadriller.ResizableArray;
import javadriller.Sorter;

class SorterTest
{
	@Test
	void testSort_IntegerArray_Odd()
	{
		ArrayList<Integer> integerList = new ArrayList<>(9);
		for(int i = 0; i < 9; i++) integerList.add(i);
		Collections.shuffle(integerList); // shuffle the list
		
		ResizableArray<Integer> integerArray = new ResizableArray<>(integerList.size());
		for(Integer num: integerList) integerArray.add(num); // add all the nums to the array
		
		Sorter.sort(integerArray, new IntegerComparator()); // sort the array
		
		for(int i = 0; i < integerArray.getSize(); i++)
		{
			assertEquals(i, integerArray.get(i)); // confirm the order
		}
	}
	
	@Test
	void testSort_IntegerArray_Even()
	{
		ArrayList<Integer> integerList = new ArrayList<>();
		for(int i = 0; i < 10; i++) integerList.add(i);
		Collections.shuffle(integerList); // shuffle the list
		
		ResizableArray<Integer> integerArray = new ResizableArray<>(integerList.size());
		for(Integer num: integerList) integerArray.add(num); // add all the nums to the array
		
		Sorter.sort(integerArray, new IntegerComparator()); // sort the array
		for(int i = 0; i < integerArray.getSize(); i++)
		{
			assertEquals(i, integerArray.get(i)); // confirm the order
		}
	}
	
	@Test
	void testSort_DrillingRecordArray_Odd()
	{
		// make all the records
		DrillingRecord record1 = new DrillingRecord(); record1.setString("00:00:01", 1);
		DrillingRecord record2 = new DrillingRecord(); record2.setString("00:00:02", 1);
		DrillingRecord record3 = new DrillingRecord(); record3.setString("00:00:03", 1);
		DrillingRecord record4 = new DrillingRecord(); record4.setString("00:00:04", 1);
		DrillingRecord record5 = new DrillingRecord(); record5.setString("00:00:05", 1);
		DrillingRecord record6 = new DrillingRecord(); record6.setString("00:00:06", 1);
		DrillingRecord record7 = new DrillingRecord(); record7.setString("00:00:07", 1);
		DrillingRecord record8 = new DrillingRecord(); record8.setString("00:00:08", 1);
		DrillingRecord record9 = new DrillingRecord(); record9.setString("00:00:09", 1);
		ArrayList<DrillingRecord> drillingRecordList = new ArrayList<>(9);
		drillingRecordList.add(record1); drillingRecordList.add(record2); drillingRecordList.add(record3); // add all records
		drillingRecordList.add(record4); drillingRecordList.add(record5); drillingRecordList.add(record6);
		drillingRecordList.add(record7); drillingRecordList.add(record8); drillingRecordList.add(record9);
		DrillingRecord[] sortedRecords = {record1, record2, record3, record4, record5, record6, record7, record8, record9};
		
		Collections.shuffle(drillingRecordList); // sort the list
		
		ResizableArray<DrillingRecord> DrillingRecordArray = new ResizableArray<>(drillingRecordList.size());
		for(DrillingRecord record: drillingRecordList) DrillingRecordArray.add(record); // add all records to array
		
		Sorter.sort(DrillingRecordArray, new DrillingRecordComparator(1)); // sort the array
		
		for(int i = 0; i < DrillingRecordArray.getSize(); i++)
		{
			assertSame(sortedRecords[i], DrillingRecordArray.get(i)); // confirm the order
		}
	}
	
	@Test
	void testSort_DrillingRecordArray_Even()
	{
		// make all the records
		DrillingRecord record1 = new DrillingRecord(); record1.setString("00:00:01", 1);
		DrillingRecord record2 = new DrillingRecord(); record2.setString("00:00:02", 1);
		DrillingRecord record3 = new DrillingRecord(); record3.setString("00:00:03", 1);
		DrillingRecord record4 = new DrillingRecord(); record4.setString("00:00:04", 1);
		DrillingRecord record5 = new DrillingRecord(); record5.setString("00:00:05", 1);
		DrillingRecord record6 = new DrillingRecord(); record6.setString("00:00:06", 1);
		DrillingRecord record7 = new DrillingRecord(); record7.setString("00:00:07", 1);
		DrillingRecord record8 = new DrillingRecord(); record8.setString("00:00:08", 1);
		DrillingRecord record9 = new DrillingRecord(); record9.setString("00:00:09", 1);
		DrillingRecord record10 = new DrillingRecord(); record10.setString("00:00:10" , 1);
		ArrayList<DrillingRecord> drillingRecordList = new ArrayList<>();
		drillingRecordList.add(record1); drillingRecordList.add(record2); drillingRecordList.add(record3); // add all records
		drillingRecordList.add(record4); drillingRecordList.add(record5); drillingRecordList.add(record6);
		drillingRecordList.add(record7); drillingRecordList.add(record8); drillingRecordList.add(record9);
		drillingRecordList.add(record10);
		DrillingRecord[] sortedRecords = {record1, record2, record3, record4, record5, record6, record7, record8, record9, record10};
		
		Collections.shuffle(drillingRecordList); // sort the list
		
		ResizableArray<DrillingRecord> DrillingRecordArray = new ResizableArray<>(drillingRecordList.size());
		for(DrillingRecord record: drillingRecordList) DrillingRecordArray.add(record); // add all records to array
		
		Sorter.sort(DrillingRecordArray, new DrillingRecordComparator(1)); // sort the array
		
		for(int i = 0; i < DrillingRecordArray.getSize(); i++)
		{
			assertSame(sortedRecords[i], DrillingRecordArray.get(i)); // confirm the order
		}
	}
}
