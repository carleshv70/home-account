package com.chuix.home.account.domain.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScoreboardEntity {

	private List<ElementEntity> elements = new ArrayList<>(); 
}
