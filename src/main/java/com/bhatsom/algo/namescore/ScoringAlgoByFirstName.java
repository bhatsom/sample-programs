package com.bhatsom.algo.namescore;

import com.bhatsom.algo.models.Name;

public class ScoringAlgoByFirstName implements INameScoringAlgo {

	@Override
	public int calculateScore(final Name name){
		int score = 0;
		for (char c : name.getFirstName().toUpperCase().toCharArray()){
			score += ((int) c) - 64;
		}
		return score;
	}

}
