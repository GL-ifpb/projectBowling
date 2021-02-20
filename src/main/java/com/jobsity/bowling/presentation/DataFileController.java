package com.jobsity.bowling.presentation;

import java.util.List;
import java.util.Map;

import com.jobsity.bowling.exceptions.ControllerException;
import com.jobsity.bowling.model.Roll;

public interface DataFileController {
	
	public Map<String, List<Roll>> readFile(String path);

}
