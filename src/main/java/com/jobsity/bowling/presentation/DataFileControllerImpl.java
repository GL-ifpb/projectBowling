/**
 * @author Giuliano Lins
 * 
 */

package com.jobsity.bowling.presentation;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobsity.bowling.business.DataFileService;
import com.jobsity.bowling.exceptions.BusinessException;
import com.jobsity.bowling.model.Roll;

@Service
public class DataFileControllerImpl implements DataFileController {
	
	@Autowired
	private DataFileService dataFileService;
	
	private Logger logger = LoggerFactory.getLogger(DataFileControllerImpl.class); 
	
	@Override
	public Map<String, List<Roll>> readFile(String path){

		try{
			
			return dataFileService.readFile(path);
			
		} catch(BusinessException dataException){
			
			logger.info(dataException.getMessage(), dataException);
			
			System.exit(1);
			
		}
		
		return null;
		
	}	

}
