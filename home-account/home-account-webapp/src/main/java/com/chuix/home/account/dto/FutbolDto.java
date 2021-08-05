package com.chuix.home.account.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FutbolDto {

	private String teamAName;
	private String teamBName;
	private Integer teamAScore;
	private Integer teamBScore;

}
