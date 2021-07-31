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
public class FutbolEventDto implements IEventDto {

	public static String TEMPLATE = "^.*\\s\\d*-\\d*\\s.*$";
	
	private String teamAName;
	private String teamBName;
	private Integer teamAScore;
	private Integer teamBScore;
	
	public boolean checkTemplate(String inputString) {
		
		Pattern pat = Pattern.compile(FutbolEventDto.TEMPLATE);
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
	
	private void setTeamBFromText(String teamB) {
		
		String arr[] = teamB.split(" ");

		int scoreB = Integer.valueOf(arr[0]);
		String teamBName = String.join(" ", Arrays.copyOfRange(arr, 1, arr.length));
		
		this.setTeamBScore(scoreB);
		this.setTeamBName(teamBName);
	}

	
}
