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
public class TenisEventDto implements IEventDto {

	public static String TEMPLATE = "^.*\\(\\d*\\).*-.*\\(\\d*\\).*$";
	
	private String teamAName;
	private String teamBName;
	private String teamAScore;
	private String teamBScore;
	private String teamAGames;
	private String teamBGames;
	
	private boolean teamAServing;
	private boolean teamBServing; 
	private ScoreboardDto scoreboard;
	
	public boolean checkTemplate(String inputString) {
		
		Pattern pat = Pattern.compile(TenisEventDto.TEMPLATE);
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
		setScoreboardFromText(teams[0], teams[1]);
	}
	
	private void setTeamAFromText(String teamA) {
		
		String arr[] = teamA.split(" ");

		String scoreA = arr[arr.length -1];
		String teamAGames = arr[arr.length -2];
		String teamAName = String.join(" ", Arrays.copyOfRange(arr, 0, arr.length - 3));
		
		if(teamAName.startsWith("*") ) {
			this.setTeamAServing(true);
			teamAName = teamAName.substring(1, teamAName.length() -1);
		}
		
		this.setTeamAScore(scoreA);
		this.setTeamAGames(teamAGames);
		this.setTeamAName(teamAName);
	}
	
	private void setTeamBFromText(String teamB) {
		
		String arr[] = teamB.split(" ");

		String scoreB = arr[0];
		String teamBGames = arr[1];
		String teamBName = String.join(" ", Arrays.copyOfRange(arr, 3, arr.length));
		
		if(teamBName.startsWith("*") ) {
			this.setTeamBServing(true);
			teamBName = teamBName.substring(1, teamBName.length() -1);
		}
		
		this.setTeamBScore(scoreB);
		this.setTeamBGames(teamBGames);
		this.setTeamBName(teamBName);
	}
	
	private void setScoreboardFromText(String teamA, String teamB) {
		String arrTeamA[] = teamA.split(" ");
		String arrTeamB[] = teamB.split(" ");
		
		String scoreboardA = arrTeamA[arrTeamA.length -3];
		String scoreboardB = arrTeamB[2];
		
		scoreboardA = scoreboardA.substring(1, scoreboardA.length()-1);
		scoreboardB = scoreboardB.substring(1, scoreboardB.length()-1);
		
		ElementDto elemen = new ElementDto("Sets", scoreboardA, scoreboardB);
		ScoreboardDto scoreboard = new ScoreboardDto(); 
		scoreboard.getElements().add(elemen);
		this.setScoreboard(scoreboard);
	}

	
}
