package com.jobsity.bowling.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.jobsity.bowling.exceptions.DataException;
import com.jobsity.bowling.model.Roll;

public class DataFileRepositoryTest {
	
	private String ERROR_MESSAGE_READ_FILE = "Error to read File!";
	
	@InjectMocks
	private DataFileRepositoryImpl dataFileRepositoryImpl;
	
	private AutoCloseable closeable;
	
	@BeforeEach
	public void setUp() {
		
		closeable = MockitoAnnotations.openMocks(this);			
		
	}
	
	@AfterEach
    void closeService() throws Exception {
        closeable.close();
    }
	
	@Test
	public void testReadFileAllFoul() throws DataException {
				
		String filePath = "files/allFoul.txt";
		
		Map<String, List<Roll>> mapPlayersRolls = dataFileRepositoryImpl.readFile(filePath);
		
		List<Roll> rollsFromFile = mapPlayersRolls.get("Carl");
		
		for(int i = 0; i < 19; i++) {
			
			assertEquals(rollsFromFile.get(i).getScoreValue(), 0);
			assertEquals(rollsFromFile.get(i).isFoul(), true);
			
		}
	}
	
	@Test
	public void testThrowDataExcpetion() {
		
		DataException thrown = assertThrows(DataException.class, 
				() -> dataFileRepositoryImpl.readFile("wrongPath"), "Expected throw but didn´t");
		
		assertEquals(thrown.getMessage(), ERROR_MESSAGE_READ_FILE);
		
	}

}
