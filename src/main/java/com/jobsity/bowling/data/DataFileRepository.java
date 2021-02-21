/**
 * @author Giuliano Lins
 * 
 */

package com.jobsity.bowling.data;

import java.util.List;
import java.util.Map;

import com.jobsity.bowling.exceptions.DataException;
import com.jobsity.bowling.model.Roll;

public interface DataFileRepository {

	public Map<String, List<Roll>> readFile(String path) throws DataException;
	
}
