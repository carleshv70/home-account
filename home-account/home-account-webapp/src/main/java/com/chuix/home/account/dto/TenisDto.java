package com.chuix.home.account.dto;

import com.chuix.home.account.domain.entity.ScoreboardEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TenisDto {
	
	private String teamAName;
	private String teamBName;
	private String teamAScore;
	private String teamBScore;
	private String teamAGames;
	private String teamBGames;
	
	private boolean teamAServing;
	private boolean teamBServing; 
	private ScoreboardEntity scoreboard;

}
