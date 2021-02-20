package com.jobsity.bowling.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;


import com.jobsity.bowling.exceptions.DataException;
import com.jobsity.bowling.model.Roll;

@Service
public class DataFileRepositoryImpl implements DataFileRepository {

	enum POSITION{
		PLAYER_NAME,
		ROLL
	}
	
	public Map<String, List<Roll>> readFile(String path) throws DataException{
	
		Map<String, List<Roll>> mapPlayersRolls = new HashMap<String, List<Roll>>();
		
		try{
			Files.lines(Paths.get(path)).forEach(roll -> {
		
				String[] row = roll.split("\\t");
				
				String playerName = row[POSITION.PLAYER_NAME.ordinal()];	
				
				System.out.println(playerName);
				
				String rollScore = row[POSITION.ROLL.ordinal()];
								
				List<Roll> listRolls = mapPlayersRolls.getOrDefault(playerName, new ArrayList<Roll>());
				
				listRolls.add(new Roll(rollScore));
				mapPlayersRolls.put(playerName, listRolls);
				
			});
		} catch(IOException ioException){
			
			throw new DataException("Error to read File!", ioException);
			
		}
		
		return mapPlayersRolls;
		
	}
	
}
