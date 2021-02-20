/**
 * @author Giuliano Lins
 * 
 */

package com.jobsity.bowling;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jobsity.bowling.presentation.DataFileController;

@SpringBootApplication
public class BowlingApplication implements CommandLineRunner {

	@Autowired
	private DataFileController dataFileController;
	
	
	public static void main(String[] args) {
		SpringApplication.run(BowlingApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception  {
		
		String path = args[0];

		dataFileController.readFile(path);
        
		
	}

}
