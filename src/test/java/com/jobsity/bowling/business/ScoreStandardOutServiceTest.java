package com.jobsity.bowling.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.jobsity.bowling.model.Frame;
import com.jobsity.bowling.model.Game;
import com.jobsity.bowling.model.Roll;
import com.jobsity.bowling.model.Score;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreStandardOutServiceTest {
	
	private static String HEADER = "Frame\t\t1\t\t2\t\t3\t\t4\t\t5\t\t6\t\t7\t\t8\t\t9\t\t10\n";
	
	private static String SCORE = "Score\t\t";
	
	@InjectMocks
	private ScoreStandardOutServiceImpl scoreStandardOutService;
	
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
	public void testPrintToOutPutAllFoul() {
		
		List<Frame> frames = populateFrameAllFoul();
		
		Game game = new Game();
		game.setFrames(frames);
		game.setPlayerName("Carl");
	
		List<Game> games = new ArrayList<Game>();
		games.add(game);
		
		Score score = new Score();
		score.setGames(games);
		
		String outPut = formatGameAllFoul();
		String outPutPrint = scoreStandardOutService.printToStandardOutput(score);
		
		assertEquals(outPut, outPutPrint);
	}
	
	private List<Frame> populateFrameAllFoul() {
		
		List<Frame> frames = new ArrayList<Frame>();
		
		Roll roll = new Roll(0, true);
		
		for (int i = 0; i < 10; i++) {
			
			Frame frame = new Frame();
			frame.setListRoll(new ArrayList<Roll>());
			frame.getListRoll().add(roll);
			frame.getListRoll().add(roll);
			frame.setSum(0);
			frames.add(frame);
			
		}
		
		return frames;
	}
	
	private String formatGameAllFoul() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(HEADER);
		
		sb.append("Carl\n");
		
		sb.append("Pinfalls");
		
		for (int i = 0; i < 10; i++) {
			
			sb.append("\tF");
			sb.append("\tF");
			
		}
		sb.append("\n");
		
		sb.append(SCORE);
		
		sb.append("0\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0\n");
		
		return sb.toString();
		
	}

}
