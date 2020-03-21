package com.bhatsom.algo.namescore;

import com.bhatsom.algo.models.Name;

public class ScoringAlgoByFirstName implements INameScoringAlgo {

	@Override
	public int calculateScore(final Name name){
		//System.out.println("getFirstName:" + name.getFirstName());
		int score = 0;
		for (char c : name.getFirstName().toUpperCase().toCharArray()){
			score += ((int) c) - 64;
			//System.out.println("score:" + score);
		}
		return score;
	}

}
