package com.jobsity.bowling.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobsity.bowling.business.rules.RollRule;
import com.jobsity.bowling.exceptions.BusinessException;
import com.jobsity.bowling.model.Game;
import com.jobsity.bowling.model.Roll;
import com.jobsity.bowling.model.Score;
import com.jobsity.bowling.model.Frame;

@Service
public class ScoreServiceImpl implements ScoreService {
	
	
	@Autowired
	private RollRule rollRule;
	
	
	public Score formatScore(Map<String, List<Roll>> mapPlayersRolls) throws BusinessException {
		
		
		//Set<Map.Entry<String, List<Roll>>> entries = mapPlayersRolls.entrySet();
		
		//Stream<Map.Entry<String, List<Roll>>> entriesStream = entries.stream();
		
		List<Game> games = new ArrayList<Game>();
		
		mapPlayersRolls.keySet().stream().forEach(key -> {
		    
		   List<Frame> frames = new ArrayList<Frame>();
		    
		   List<Roll> listRolls = mapPlayersRolls.get(key);
		
		   int j = -1;
		   
		   int sumFrame = 0;
		   
		   for(int i = 0; i < 10; i++) {			   
			   			   
			   Roll currentRoll = listRolls.get(j);
			   Roll nextRollAux = listRolls.get(j + 1);
			   
			   if(rollRule.isSpare(currentRoll, nextRollAux)) {
				   
				   Roll nextRoll = listRolls.get(j + 1);
				   Roll nextNextRoll = listRolls.get(j + 2);
				   
				   sumFrame += currentRoll.getScoreValue() + nextRoll.getScoreValue() + nextNextRoll.getScoreValue();
				   
				   Frame frame = new Frame();				   
				   frame.setSum(sumFrame);
				   
				   frames.add(frame);
				   
				   j =+ 2;
				   
			   } else if(rollRule.isStrike(currentRoll)) {
				   
				   Roll nextRoll = listRolls.get(j + 1); 
				   Roll nextNextRoll = listRolls.get(j + 2);
				   
				   sumFrame += currentRoll.getScoreValue() + nextRoll.getScoreValue() + nextNextRoll.getScoreValue();
				   
				   Frame frame = new Frame();				   
				   frame.setSum(sumFrame);
				   
				   frames.add(frame);
				   				   
				   j++;
				   
			   } else {
				   
				   Roll nextRoll = listRolls.get(j + 1); 
				   
				   sumFrame += currentRoll.getScoreValue() + nextRoll.getScoreValue();
				   
				   Frame frame = new Frame();				   
				   frame.setSum(sumFrame);
				   
				   frames.add(frame);
				   
				   j =+ 2;
				   
			   }
			   
		   }
		   
		   Game game = new Game();
		   game.setPlayerName(key);
		   game.setFrames(frames);	
		   
		   games.add(game);
		
		});
		
		Score score = new Score();
		score.setGames(games);
		
		return score;
		
	}

}
