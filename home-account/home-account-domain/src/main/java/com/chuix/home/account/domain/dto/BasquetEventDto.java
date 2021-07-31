package com.chuix.home.account.domain.dto;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasquetEventDto implements IEventDto {

	public static String TEMPLATE = "^.*\\d*-\\d*.*?rd\\sQuarter$";
	
	private String teamAName;
	private String teamBName;
	private Integer teamAScore;
	private Integer teamBScore;
	private String currentPeriod;
	
	public boolean checkTemplate(String inputString) {
		
		Pattern pat = Pattern.compile(BasquetEventDto.TEMPLATE);
	     Matcher mat = pat.matcher(inputString);                                                                           
	    
	     return mat.matches(); 
	}
	
	
	public void setFromText(String inputString) {
		
		if (!this.checkTemplate(inputString)) {
			throw new IllegalArgumentException("La cadena de entrada no tiene un formato correcto"); 
		}
		
		String[] teams = inputString.split("-");

		
		setTeamAFromText(teams[0]);
		setTeamBFromText(teams[1]);
	}
	
	
	private void setTeamAFromText(String teamA) {
		
		String arr[] = teamA.split(" ");

		int scoreA = Integer.valueOf(arr[arr.length -1]);
		String teamAName = String.join(" ", Arrays.copyOfRange(arr, 0, arr.length - 1));
		
		this.setTeamAScore(scoreA);
		this.setTeamAName(teamAName);
	}
	
	
	//Pittsburgh Steelers 3-7 Minnesota Vikings 3rd Quarter
	private void setTeamBFromText(String teamB) {
		
		String arr[] = teamB.split(" ");

		int scoreB = Integer.valueOf(arr[0]);
		String teamBName = String.join(" ", Arrays.copyOfRange(arr, 1, arr.length - 2));
		
		this.setTeamBScore(scoreB);
		this.setTeamBName(teamBName);
		this.setCurrentPeriod(arr[arr.length - 2]);
	}
	
}
