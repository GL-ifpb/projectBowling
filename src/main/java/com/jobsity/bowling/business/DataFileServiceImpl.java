/**
 * @author Giuliano Lins
 * 
 */

package com.jobsity.bowling.business;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobsity.bowling.business.rules.RollRule;
import com.jobsity.bowling.data.DataFileRepository;
import com.jobsity.bowling.exceptions.BusinessException;
import com.jobsity.bowling.exceptions.DataException;
import com.jobsity.bowling.model.Roll;	

@Service
public class DataFileServiceImpl implements DataFileService{
	
	@Autowired
	private DataFileRepository dataFileRepository;
	
	@Autowired
	private RollRule rollRule;
	
	private String ERROR_MESSAGE_INVALID_INPUT = "There is a invalid input caracter. Please, check the input and try again.";
	
	@Override
	public Map<String, List<Roll>> readFile(String path) throws BusinessException{

		try{
			
			Map<String, List<Roll>> mapPlayersRolls = dataFileRepository.readFile(path);
			
			validateRolls(mapPlayersRolls);
			
			populateRolls(mapPlayersRolls);
			
			return mapPlayersRolls;
			
		} catch(DataException dataException){
			
			throw new BusinessException(dataException.getMessage(), dataException);
			
		}
		
	}	
	
	private void validateRolls(Map<String, List<Roll>> mapPlayersRolls) throws BusinessException{
		
		for (Map.Entry<String, List<Roll>> entry : mapPlayersRolls.entrySet()) {
	        
			for(Roll roll : entry.getValue()) {
				
				if(!rollRule.isAValidRoll(roll.getStringValueTemp())) {
					
					throw new BusinessException(ERROR_MESSAGE_INVALID_INPUT);
					
				}
			}
		
	    }

	}
	
	private void populateRolls(Map<String, List<Roll>> mapPlayersRolls) {
		
		for (Map.Entry<String, List<Roll>> entry : mapPlayersRolls.entrySet()) {			
			
			for(Roll roll : entry.getValue()) {
				
				roll.setScoreValue(Integer.parseInt(roll.getStringValueTemp()));
			}
		
	    }
		
	}
}
