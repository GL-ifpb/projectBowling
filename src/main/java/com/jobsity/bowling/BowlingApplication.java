/**
 * @author Giuliano Lins
 * 
 */

package com.jobsity.bowling;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jobsity.bowling.model.Roll;
import com.jobsity.bowling.model.Score;
import com.jobsity.bowling.presentation.DataFileController;
import com.jobsity.bowling.presentation.ScoreController;
import com.jobsity.bowling.presentation.ScoreStandardOutController;
	
@SpringBootApplication
public class BowlingApplication implements CommandLineRunner {

	@Autowired
	private ScoreController scoreController;
	
	@Autowired
	private DataFileController dataFileController;
	
	@Autowired
	private ScoreStandardOutController scoreStandardOutController;
	
	
	public static void main(String[] args) {
		SpringApplication.run(BowlingApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception  {
		
		String path = args[0];

		Map<String, List<Roll>> mapPlayersRolls = dataFileController.readFile(path);
        
		Score score = scoreController.formatScore(mapPlayersRolls);
		
		System.out.println(scoreStandardOutController.printToStandardOutput(score));
		
	}

}
