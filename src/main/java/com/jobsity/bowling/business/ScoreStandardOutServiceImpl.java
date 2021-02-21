/**
 * @author Giuliano Lins
 * 
 */

package com.jobsity.bowling.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.jobsity.bowling.model.Frame;
import com.jobsity.bowling.model.Roll;
import com.jobsity.bowling.model.Score;

@Service
public class ScoreStandardOutServiceImpl implements ScoreStandardOutService {
	
	private String sumScore = "";

	private static final String HEADER = "Frame\t\t1\t\t2\t\t3\t\t4\t\t5\t\t6\t\t7\t\t8\t\t9\t\t10\n";
	
	private static final String PINFALLS = "\nPinfalls\t";
	
	private static final String SCORE = "\nScore\t\t";
	
	private static final String STRIKE = "X";
	
	private StringBuilder stringBuilderOutPut = new StringBuilder();

	public String printToStandardOutput(Score score) {
		
		stringBuilderOutPut.append(HEADER);
		
		score.getGames().stream().forEach(game -> {
			
			stringBuilderOutPut.append(game.getPlayerName());
			
			stringBuilderOutPut.append(PINFALLS);	
			
			
			game.getFrames().stream().forEach(frame -> {
				
				List<String> listRolls = formatFouls(frame);
				
				if(frame.isSpare()) {
					
					stringBuilderOutPut.append(formatSpareFrame(listRolls));
					
				} else if (frame.isStrike()){
					
					stringBuilderOutPut.append(formatStrikeFrame(listRolls));
					
				} else {
					
					stringBuilderOutPut.append(formatFrame(listRolls));					
					
				}
				
				sumScore += frame.getSum() + "\t" + "\t";
				
			});
			
			stringBuilderOutPut.delete(stringBuilderOutPut.length() - 1, stringBuilderOutPut.length());
			
			sumScore = sumScore.substring(0, sumScore.length() - 2);
			
			stringBuilderOutPut.append(SCORE);
			
			stringBuilderOutPut.append(sumScore);
			
			sumScore = "";
			
			stringBuilderOutPut.append("\n");
			
		});
		
		return stringBuilderOutPut.toString();
		
	}
	
	private String formatSpareFrame(List<String> listRolls) {
		
		return listRolls.get(0) + "\t" + Roll.SPARE + "\t";
		
	}
	
	private String formatStrikeFrame(List<String> listRolls) {
		
		if(listRolls.size() <= 2) {
			
			return "\t" + Roll.STRIKE + "\t";
		}
		
		return formatFrame(listRolls);
	}
	
	
	private String formatFrame(List<String> listRolls) {
		
		List<String> listRollsAux = new ArrayList<String>();
		
		listRolls.stream().forEach(roll -> {
			
			String scoreValue = roll.equals("10") ? Roll.STRIKE : roll;
			
			listRollsAux.add(scoreValue + "\t");
			
		});
		
		return listRollsAux.stream().collect(Collectors.joining());	
		
	}
	
	private List<String> formatFouls(Frame frame) {
		
		List<String> listRolls = new ArrayList<String>();
		
		frame.getListRoll().stream().forEach(roll -> {
			
			String scoreValue = roll.isFoul() ? Roll.FOUL : ""+roll.getScoreValue();
			
			listRolls.add(scoreValue);
			
		});
		
		return listRolls;
		
	}
}
