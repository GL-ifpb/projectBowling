/**
 * @author Giuliano Lins
 * 
 */

package com.jobsity.bowling.business;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobsity.bowling.data.DataFileRepository;
import com.jobsity.bowling.exceptions.BusinessException;
import com.jobsity.bowling.exceptions.DataException;
import com.jobsity.bowling.model.Roll;

@Service
public class DataFileServiceImpl implements DataFileService{
	
	@Autowired
	private DataFileRepository dataFileRepository;
	
	
	public Map<String, List<Roll>> readFile(String path) throws BusinessException{

		try{
			
			return dataFileRepository.readFile(path);
			
		} catch(DataException dataException){
			
			throw new BusinessException(dataException.getMessage(), dataException);
			
		}
		
	}	

}
