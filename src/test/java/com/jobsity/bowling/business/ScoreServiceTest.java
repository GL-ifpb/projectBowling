package com.jobsity.bowling.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.jobsity.bowling.business.rules.RollRule;
import com.jobsity.bowling.business.rules.RollRuleImpl;
import com.jobsity.bowling.exceptions.BusinessException;
import com.jobsity.bowling.model.Frame;
import com.jobsity.bowling.model.Game;
import com.jobsity.bowling.model.Roll;
import com.jobsity.bowling.model.Score;

public class ScoreServiceTest {
	
	@InjectMocks
	private ScoreServiceImpl scoreService;
	
	@Spy
	private FrameService frameService = new FrameServiceImpl();
	
	@Spy
	private RollRule rollRule = new RollRuleImpl();
	
	private AutoCloseable closeable;
	
	@BeforeEach
	public void setUp() {
		
		closeable = MockitoAnnotations.openMocks(this);			
		
	}
	
	@AfterEach
    void closeService() throws Exception {
        closeable.close();
    }
	
	@Test
	public void testFormatScoreAllStrike() throws BusinessException {
				
		List<Roll> listRolls = new ArrayList<Roll>();
		
		Roll roll = null;
		
		for(int i = 0; i < 12; i++) {
			roll = new Roll(10, false);
			
			listRolls.add(roll);
		}
		
		HashMap<String, List<Roll>> mapPlayersRolls = new HashMap<String, List<Roll>>();
		
		mapPlayersRolls.put("Carl", listRolls);
		
		//Mockito.when(rollRule.isStrike(new Roll(10, false))).thenReturn(true);
		
		Score score = scoreService.formatScore(mapPlayersRolls);
		
		int sumScoreFrame = 0;
		
		List<Game> games = score.getGames();
		
		for(Frame frame : games.get(0).getFrames()) {
			
			assertEquals(frame.getSum(), sumScoreFrame += 30);
			
		}	
		
	}
	
	@Test
	public void testFormatScoreAllFoul() throws BusinessException {
				
		List<Roll> listRolls = new ArrayList<Roll>();
		
		Roll roll = null;
		
		for(int i = 0; i < 21; i++) {
			roll = new Roll(0, true);
			
			listRolls.add(roll);
		}
		
		HashMap<String, List<Roll>> mapPlayersRolls = new HashMap<String, List<Roll>>();
		
		mapPlayersRolls.put("Carl", listRolls);
		
		//Mockito.when(rollRule.isStrike(new Roll(10, false))).thenReturn(true);
		
		Score score = scoreService.formatScore(mapPlayersRolls);
		
		List<Game> games = score.getGames();
		
		for(Frame frame : games.get(0).getFrames()) {
			
			assertEquals(frame.getSum(), 0);
			
		}	
		
	}
	
	@Test
	public void testFormatScoreCommonGames() throws BusinessException {
		
		Map<String, List<Roll>> mapPlayersRolls = populateCommonGames();
		
		Score score = scoreService.formatScore(mapPlayersRolls);
		
		List<Game> games = score.getGames();
		
		int sumScoreJeff = 0;
		
		for(Frame frame : games.get(0).getFrames()) {
			
			sumScoreJeff += frame.getSum();
			
		}	
		
		assertEquals(sumScoreJeff, 856);
		
	}
	
	private Map<String, List<Roll>> populateCommonGames() {
		
		Map<String, List<Roll>> mapPlayersRolls = new HashMap<String, List<Roll>>();
		List<Roll> listRollsJeff  = new ArrayList<Roll>();
		
		Roll roll = new Roll(10, false);
		listRollsJeff.add(roll);
		
		roll = new Roll(7, false);
		listRollsJeff.add(roll);
		
		roll = new Roll(3, false);
		listRollsJeff.add(roll);
		
		roll = new Roll(9, false);
		listRollsJeff.add(roll);
		
		roll = new Roll(0, false);
		listRollsJeff.add(roll);
		
		roll = new Roll(10, false);
		listRollsJeff.add(roll);
		
		roll = new Roll(0, false);
		listRollsJeff.add(roll);
		
		roll = new Roll(8, false);
		listRollsJeff.add(roll);
		
		roll = new Roll(8, false);
		listRollsJeff.add(roll);
		
		roll = new Roll(2, false);
		listRollsJeff.add(roll);
		
		roll = new Roll(0, true);
		listRollsJeff.add(roll);
		
		roll = new Roll(6, false);
		listRollsJeff.add(roll);
		
		roll = new Roll(10, false);
		listRollsJeff.add(roll);
		
		roll = new Roll(10, false);
		listRollsJeff.add(roll);
		
		roll = new Roll(10, false);
		listRollsJeff.add(roll);
		
		roll = new Roll(8, false);
		listRollsJeff.add(roll);
		
		roll = new Roll(1, false);
		listRollsJeff.add(roll);
		
		mapPlayersRolls.put("Jeff", listRollsJeff);
		
		return mapPlayersRolls;
		
		
	}

}
