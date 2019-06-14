package com.yash.training.mockito;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.yash.training.mockito.bean.Book;
import com.yash.training.mockito.bean.LibraryRecord;

@RunWith(MockitoJUnitRunner.class)
public class LendingManagerImplTest {

	@InjectMocks
	private LendingManagerImpl lendingManagerImpl;

	@Mock
	private LibraryRecordDAO libraryRecordDAO; 

	@Test(expected = IllegalStateException.class)
	public void shouldThrowIllegalStateExceptionWhenBorrowingBookIsNull(){	

		LibraryRecord libraryRecordEmptyBorrowDate = getObjectDataForTestCases(3L, new Book(), null, new Date());
		List<LibraryRecord> libraryRecordList = createListOflibraryRecord();
		libraryRecordList.add(libraryRecordEmptyBorrowDate);
		Book bookOne = new Book();
		
		when(libraryRecordDAO.findByBook(bookOne)).thenReturn(libraryRecordList);

		lendingManagerImpl.borrowBook(bookOne);
	}

	@Test(expected = IllegalStateException.class)
	public void shouldThrowIllegalStateExceptionWhenMultipleReturningDatesAreEmpty(){	
		
		LibraryRecord libraryRecordEmptyReturnDateOne = getObjectDataForTestCases(1L, new Book(), new Date(), null);
		LibraryRecord libraryRecordEmptyReturnDateTwo = getObjectDataForTestCases(4L, new Book(), new Date(), null);
		Book bookOne = new Book();
		
		List<LibraryRecord> libraryRecordList =createListOflibraryRecord();
		libraryRecordList.add(libraryRecordEmptyReturnDateOne);
		libraryRecordList.add(libraryRecordEmptyReturnDateTwo);

		when(libraryRecordDAO.findByBook(bookOne)).thenReturn(libraryRecordList);

		lendingManagerImpl.borrowBook(bookOne);
	}
	
	@Test(expected = IllegalStateException.class)
	public void shouldThrowIllegalStateExceptionWhenReturningDateIsNull(){	

		List<LibraryRecord> libraryRecordList =createListOflibraryRecord();
		LibraryRecord libraryRecordEmptyReturnDateOne = getObjectDataForTestCases(1L, new Book(), new Date(), null);
		libraryRecordList.add(libraryRecordEmptyReturnDateOne);
		Book bookOne = new Book();
		
		when(libraryRecordDAO.findByBook(bookOne)).thenReturn(libraryRecordList);

		lendingManagerImpl.borrowBook(bookOne);
	}

	@Test(expected = IllegalStateException.class)
	public void shouldReturnFalseAfterSaveLibraryRecordInBorrowBook(){	

		LibraryRecord libraryRecord = getObjectDataForTestCases(2L, new Book(), new Date(), new Date());
		List<LibraryRecord> libraryRecordList = createListOflibraryRecord();
		libraryRecordList.add(libraryRecord);
		Book bookOne = new Book();

		when(libraryRecordDAO.findByBook(bookOne)).thenReturn(libraryRecordList);
		when(libraryRecordDAO.save((LibraryRecord) Mockito.anyObject())).thenReturn(false);

		lendingManagerImpl.borrowBook(bookOne);
	}

	@Test
	public void shouldReturnTrueAfterSaveLibraryRecordInBorrowBook(){	

		List<LibraryRecord> libraryRecordList =createListOflibraryRecord();
		Book bookOne = new Book();

		when(libraryRecordDAO.findByBook(bookOne)).thenReturn(libraryRecordList);
		when(libraryRecordDAO.save((LibraryRecord) Mockito.anyObject())).thenReturn(true);

		LibraryRecord actualLiberaryRecord = lendingManagerImpl.borrowBook(bookOne);

		assertThat(actualLiberaryRecord, instanceOf(LibraryRecord.class));
	}

	@Test(expected = IllegalStateException.class)
	public void shouldThrowIllegalStateExceptionAfterReturningFalseOnSaveInReturnBook(){	

		List<LibraryRecord> libraryRecordList =createListOflibraryRecord();
		LibraryRecord libraryRecordEmptyReturnDateOne = getObjectDataForTestCases(1L, new Book(), new Date(), null);
		libraryRecordList.add(libraryRecordEmptyReturnDateOne);
		Book bookOne = new Book();

		when(libraryRecordDAO.findByBook(bookOne)).thenReturn(libraryRecordList);
		when(libraryRecordDAO.save(libraryRecordEmptyReturnDateOne)).thenReturn(false);

		lendingManagerImpl.returnBook(bookOne);
	}

	@Test
	public void shouldReturnLibraryRecordForReturnBook(){	

		List<LibraryRecord> libraryRecordList =createListOflibraryRecord();
		LibraryRecord libraryRecordEmptyReturnDateOne = getObjectDataForTestCases(1L, new Book(), new Date(), null);
		libraryRecordList.add(libraryRecordEmptyReturnDateOne);
		Book bookOne = new Book();

		when(libraryRecordDAO.findByBook(bookOne)).thenReturn(libraryRecordList);
		when(libraryRecordDAO.save(libraryRecordEmptyReturnDateOne)).thenReturn(true);

		LibraryRecord actualLiberaryRecord = lendingManagerImpl.returnBook(bookOne);
		assertThat(actualLiberaryRecord, instanceOf(LibraryRecord.class));
	}

	@Test(expected = IllegalStateException.class)
	public void shouldThrowIllegalStateExceptionWhenRecordIsEmptyInReturnBook(){	

		List<LibraryRecord> libraryRecordList  = new ArrayList<LibraryRecord>();
		Book bookOne = new Book();

		when(libraryRecordDAO.findByBook(bookOne)).thenReturn(libraryRecordList);

		lendingManagerImpl.returnBook(bookOne);
	}
	
	private LibraryRecord getObjectDataForTestCases(Long id, Book book, Date borrowingDate, Date returningDate) { 

		LibraryRecord libraryRecord = new LibraryRecord();
		libraryRecord.setId(id);
		libraryRecord.setBook(book);
		libraryRecord.setBorrowingDate(borrowingDate);
		libraryRecord.setReturningDate(returningDate); 

		return libraryRecord;
	}
	
	private List<LibraryRecord> createListOflibraryRecord() {
		
		List<LibraryRecord> libraryRecordList = new ArrayList<LibraryRecord>();
		LibraryRecord libraryRecord = getObjectDataForTestCases(2L, new Book(), new Date(), new Date());
		libraryRecordList.add(libraryRecord);
		
		return libraryRecordList;
	}
	
}
