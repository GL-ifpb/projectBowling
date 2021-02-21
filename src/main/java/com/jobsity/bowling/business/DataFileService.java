/**
 * @author Giuliano Lins
 * 
 */

package com.jobsity.bowling.business;

import java.util.List;
import java.util.Map;

import com.jobsity.bowling.exceptions.BusinessException;
import com.jobsity.bowling.model.Roll;

public interface DataFileService {

	public Map<String, List<Roll>> readFile(String path) throws BusinessException;
	
}
